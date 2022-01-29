package com.varanegar.supervisor.getTour_fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.varanegar.framework.base.MainVaranegarActivity;
import com.varanegar.framework.base.VaranegarFragment;
import com.varanegar.framework.network.listeners.ApiError;
import com.varanegar.framework.network.listeners.WebCallBack;
import com.varanegar.framework.util.component.cutemessagedialog.CuteMessageDialog;
import com.varanegar.framework.util.component.cutemessagedialog.Icon;
import com.varanegar.supervisor.DataManager;
import com.varanegar.supervisor.IMainPageFragment;
import com.varanegar.supervisor.MainFragment;
import com.varanegar.supervisor.R;
import com.varanegar.supervisor.webapi.SupervisorApi;
import com.varanegar.vaslibrary.base.BackupManager;
import com.varanegar.vaslibrary.manager.UserManager;
import com.varanegar.vaslibrary.manager.sysconfigmanager.ConfigKey;
import com.varanegar.vaslibrary.manager.sysconfigmanager.SysConfigManager;
import com.varanegar.vaslibrary.model.sysconfig.SysConfigModel;
import com.varanegar.vaslibrary.model.user.UserModel;
import com.varanegar.vaslibrary.ui.dialog.TrackingLicenseFragment;
import com.varanegar.vaslibrary.webapi.WebApiErrorBody;

import java.util.UUID;

import okhttp3.Request;
import timber.log.Timber;

public class Get_Tour_Fragment extends VaranegarFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_tour_supervisor, container, false);
        SysConfigManager sysConfigManager = new SysConfigManager(getContext());
        SysConfigModel localServerAddressConfig = sysConfigManager.read(ConfigKey.LocalServerAddress, SysConfigManager.local);
        SysConfigModel validServerAddressConfig = sysConfigManager.read(ConfigKey.ValidServerAddress, SysConfigManager.local);
        if (localServerAddressConfig != null)
            ((TextView) (view.findViewById(R.id.local_ip_text_view))).setText(localServerAddressConfig.Value);
        if (validServerAddressConfig != null)
            ((TextView) (view.findViewById(R.id.ip_text_view))).setText(validServerAddressConfig.Value);

        UserModel userModel = UserManager.readFromFile(getContext());
        if (userModel != null) {
            ((TextView) (view.findViewById(R.id.user_name_text_view))).setText(userModel.UserName);
        }

        ImageView trackingLicenseImageView = view.findViewById(R.id.tracking_license_image_view);
        trackingLicenseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainVaranegarActivity activity = getVaranegarActvity();
                if (activity != null && !activity.isFinishing() && isResumed()) {
                    TrackingLicenseFragment fragment = new TrackingLicenseFragment();
                    activity.pushFragment(fragment);
                }
            }
        });

        view.findViewById(R.id.log_out_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CuteMessageDialog dialog = new CuteMessageDialog(getContext());
                dialog.setTitle(R.string.are_you_sure);
                dialog.setIcon(Icon.Warning);
                dialog.setMessage(R.string.do_you_want_to_log_out);
                dialog.setNegativeButton(R.string.no, null);
                dialog.setPositiveButton(R.string.yes, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getContext().getSharedPreferences("TrackingConfig", Context.MODE_PRIVATE).edit().clear().apply();
                        getContext().getSharedPreferences("TourStatusConfig", Context.MODE_PRIVATE).edit().clear().apply();
                        getContext().getSharedPreferences("ReportConfig", Context.MODE_PRIVATE).edit().clear().apply();
                        UserManager.logout(getVaranegarActvity());
                    }
                });
                dialog.show();
            }
        });


        view.findViewById(R.id.backup_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProgress(getString(R.string.backing_up_database));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BackupManager.exportData(getContext(), true);
                            if (isResumed()) {
                                getVaranegarActvity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        endProgress();
                                        CuteMessageDialog dialog = new CuteMessageDialog(getContext());
                                        dialog.setMessage(R.string.backup_finished_successfully);
                                        dialog.setIcon(Icon.Success);
                                        dialog.setPositiveButton(R.string.close, new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                            }
                                        });
                                        dialog.setNeutralButton(R.string.send_backup, new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                startProgress(getString(R.string.sending_backup));
                                                BackupManager.uploadBackup(getContext()," "," ", new BackupManager.IUploadCallBack() {
                                                    @Override
                                                    public void onSuccess() {
                                                        if (isResumed()) {
                                                            endProgress();
                                                            showMessage(null, getString(com.varanegar.vaslibrary.R.string.backup_sent_successfully));
                                                        }
                                                    }

                                                    @Override
                                                    public void onFailure(String error) {
                                                        if (isResumed()) {
                                                            endProgress();
                                                            showError(getString(com.varanegar.vaslibrary.R.string.sending_backup_failed));
                                                        }
                                                    }
                                                });
                                            }
                                        });
                                        dialog.show();
                                    }
                                });

                            }
                        } catch (Exception e) {
                            Timber.e(e);
                            if (isResumed()) {
                                CuteMessageDialog dialog = new CuteMessageDialog(getContext());
                                dialog.setTitle(R.string.error);
                                dialog.setMessage(R.string.error_saving_request);
                                dialog.setIcon(Icon.Error);
                                dialog.setPositiveButton(R.string.ok, null);
                                dialog.show();
                            }
                        }
                    }
                }).start();

            }
        });

        try {
            String packageName = getContext().getApplicationInfo().packageName;
            String version = getContext().getPackageManager().getPackageInfo(packageName, 0).versionName;
            ((TextView) view.findViewById(R.id.version_text_view)).setText(version);
        } catch (PackageManager.NameNotFoundException e) {
            Timber.e(e);
        }

        view.findViewById(R.id.send_tour).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage(getString(R.string.downloading_data));
                progressDialog.show();
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("SupervisorId", Context.MODE_PRIVATE);
                UUID userModel = UUID.fromString(sharedPreferences.getString("SupervisorIduniqueId", null));
                SupervisorApi supervisorApi=new SupervisorApi(getContext());
                supervisorApi.runWebRequest(supervisorApi.tourreceived(userModel), new WebCallBack<String>() {
                    @Override
                    protected void onFinish() {

                    }

                    @Override
                    protected void onSuccess(String result, Request request) {

                    }

                    @Override
                    protected void onApiFailure(ApiError error, Request request) {
                        String err = WebApiErrorBody.log(error, getContext());
                        showError(err);
                        if (progressDialog != null && progressDialog.isShowing()) {
                            try {
                                progressDialog.dismiss();
                            } catch (Exception ignored) {

                            }
                        }
                    }

                    @Override
                    protected void onNetworkFailure(Throwable t, Request request) {
                        showError(getContext().getString(R.string.error_connecting_to_server));
                        if (progressDialog != null && progressDialog.isShowing()) {
                            try {
                                progressDialog.dismiss();
                            } catch (Exception ignored) {

                            }
                        }
                    }
                });

            }
        });
        view.findViewById(R.id.get_tour_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage(getString(R.string.downloading_data));
                progressDialog.show();
                DataManager.getVisitor(getContext(), new DataManager.Callback() {
                    @Override
                    public void onSuccess() {
                        if (progressDialog != null && progressDialog.isShowing()) {
                            try {
                                progressDialog.dismiss();
                                MainVaranegarActivity activity = getVaranegarActvity();
                                if (activity != null && !activity.isFinishing() && isResumed())
                                    activity.putFragment(new MainFragment());
                            } catch (Exception ignored) {

                            }
                        }
                    }

                    @Override
                    public void onError(String error) {
                        showError(error);
                        if (progressDialog != null && progressDialog.isShowing()) {
                            try {
                                progressDialog.dismiss();
                            } catch (Exception ignored) {

                            }
                        }
                    }
                });

            }
        });
        return view;
    }
    private void endProgress() {
        if (isResumed()) {
            View backupProgressLayout = getView().findViewById(R.id.backup_progress_layout);
            View backupLayout = getView().findViewById(R.id.backup_layout);
            backupProgressLayout.setVisibility(View.GONE);
            backupLayout.setVisibility(View.VISIBLE);
        }
    }

    private void startProgress(String msg) {
        if (isResumed()) {
            View backupProgressLayout = getView().findViewById(R.id.backup_progress_layout);
            View backupLayout = getView().findViewById(R.id.backup_layout);
            backupProgressLayout.setVisibility(View.VISIBLE);
            backupLayout.setVisibility(View.GONE);
            TextView textView = getView().findViewById(R.id.progress_message_text_view);
            textView.setText(msg);
        }
    }

    private void showMessage(String title, String msg) {
        Context context = getContext();
        if (isResumed() && context != null) {
            CuteMessageDialog dialog = new CuteMessageDialog(context);
            dialog.setTitle(title);
            dialog.setMessage(msg);
            dialog.setIcon(Icon.Info);
            dialog.setPositiveButton(R.string.ok, null);
            dialog.show();
        }
    }

    private void showError(String error) {
        Context context = getContext();
        if (isResumed() && context != null) {
            CuteMessageDialog dialog = new CuteMessageDialog(context);
            dialog.setTitle(R.string.error);
            dialog.setMessage(error);
            dialog.setIcon(Icon.Error);
            dialog.setPositiveButton(R.string.ok, null);
            dialog.show();
        }
    }
}