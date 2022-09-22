package com.varanegar.vaslibrary.webapi;

import androidx.annotation.NonNull;

import com.varanegar.vaslibrary.manager.sysconfigmanager.OwnerKeysNotFoundException;
import com.varanegar.vaslibrary.manager.sysconfigmanager.OwnerKeysWrapper;
import com.varanegar.vaslibrary.model.dealerdivision.DealerDivisionModel;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by atp on 6/7/2017.
 */

public class HeaderInterceptor implements Interceptor {
    private String token;
    private OwnerKeysWrapper ownerKeys;
    private DealerDivisionModel dealerDivisionModel;

    public HeaderInterceptor(@NonNull OwnerKeysWrapper ownerKeys, String token, DealerDivisionModel dealerDivisionModel) {
        this.token = token;
        this.ownerKeys = ownerKeys;
        this.dealerDivisionModel = dealerDivisionModel;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (ownerKeys == null) {
            throw new OwnerKeysNotFoundException();
        } else {
            if (ownerKeys.OwnerKey == null || ownerKeys.DataOwnerKey == null || ownerKeys.DataOwnerCenterKey == null)
                throw new OwnerKeysNotFoundException();
            else {
                Request.Builder builder = originalRequest.newBuilder()
                        .header("OwnerKey", ownerKeys.OwnerKey)
                        .header("DataOwnerKey", ownerKeys.DataOwnerKey)
                        .header("DataOwnerCenterKey", ownerKeys.DataOwnerCenterKey)
                        .header("Accept", " application/json")
                        .header("http.keepAlive", "false")
                        .header("SubSystemTypeId",ownerKeys.subsystemtypeid)
                        .header("Version",ownerKeys.Version);
                if (dealerDivisionModel != null) {
                    builder.addHeader("DivisionCenterKey", dealerDivisionModel.DivisionCenterKey.toString());
                    builder.addHeader("DivisionBackOfficeCode", dealerDivisionModel.DivisionBackOfficeCode);
                    builder.addHeader("DivisionSalesOrg", dealerDivisionModel.DivisionSalesOrg);
                    builder.addHeader("DivisionDisChanel", dealerDivisionModel.DivisionDisChanel);
                    builder.addHeader("DivisionCode", dealerDivisionModel.DivisionCode);
                }
                if (token != null)
                    builder = builder.header("Authorization", "Bearer " + token);
                return chain.proceed(builder.build());
            }

        }

    }
}
