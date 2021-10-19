package com.varanegar.vaslibrary.manager.picture;

import android.content.Context;
import androidx.annotation.NonNull;

import com.varanegar.framework.database.BaseManager;
import com.varanegar.framework.database.DbException;
import com.varanegar.framework.network.listeners.ApiError;
import com.varanegar.framework.network.listeners.WebCallBack;
import com.varanegar.framework.util.datetime.DateFormat;
import com.varanegar.framework.util.datetime.DateHelper;
import com.varanegar.framework.validation.ValidationException;
import com.varanegar.vaslibrary.R;
import com.varanegar.vaslibrary.manager.updatemanager.UpdateCall;
import com.varanegar.vaslibrary.manager.updatemanager.UpdateManager;
import com.varanegar.vaslibrary.model.UpdateKey;
import com.varanegar.vaslibrary.model.picturesubject.PictureSubjectModel;
import com.varanegar.vaslibrary.model.picturesubject.PictureSubjectModelRepository;
import com.varanegar.vaslibrary.webapi.WebApiErrorBody;
import com.varanegar.vaslibrary.webapi.picturesubject.PictureSubjectApi;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.Request;
import timber.log.Timber;

/**
 * Created by A.Torabi on 7/5/2017.
 */

public class PictureSubjectManager extends BaseManager<PictureSubjectModel> {
    public PictureSubjectManager(@NonNull Context context) {
        super(context, new PictureSubjectModelRepository());
    }

    public void sync(final UpdateCall call) {
        UpdateManager updateManager = new UpdateManager(getContext());
        //Date date = updateManager.getLog(UpdateKey.PictureSubject);
        Date date = UpdateManager.MIN_DATE;
        final String dateString = DateHelper.toString(date, DateFormat.MicrosoftDateTime, Locale.US);
        try {
            deleteAll();
            PictureSubjectApi api = new PictureSubjectApi(getContext());
            api.runWebRequest(api.getPictureSubjects(dateString), new WebCallBack<List<PictureSubjectModel>>() {
                @Override
                protected void onFinish() {

                }

                @Override
                protected void onSuccess(List<PictureSubjectModel> result, Request request) {
                    if (result != null && result.size() > 0) {
                        try {
                            insert(result);
                            Timber.i("List of picture subjects updated");
                            call.success();
                            new UpdateManager(getContext()).addLog(UpdateKey.PictureSubject);
                        } catch (ValidationException e) {
                            Timber.e(e);
                            call.failure(getContext().getString(R.string.data_validation_failed));
                        } catch (DbException e) {
                            Timber.e(e);
                            call.failure(getContext().getString(R.string.data_error));
                        }
                    } else {
                        Timber.i("List of picture subjects was empty");
                        call.success();
                    }

                }

                @Override
                protected void onApiFailure(ApiError error, Request request) {
                    String err = WebApiErrorBody.log(error, getContext());
                    call.failure(err);
                }

                @Override
                protected void onNetworkFailure(Throwable t, Request request) {
                    Timber.e(t);
                    call.failure(getContext().getString(R.string.network_error));
                }
            });
        } catch (DbException e) {
            Timber.e(e);
            call.failure(getContext().getString(R.string.error_deleting_old_data));
        }

    }
}
