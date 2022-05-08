package com.varanegar.vaslibrary.webapi.apiNew;

import android.content.Context;

import com.varanegar.vaslibrary.ui.fragment.news_fragment.model.NewsData_Model;
import com.varanegar.vaslibrary.webapi.BaseApi;
import com.varanegar.vaslibrary.webapi.TokenType;
import com.varanegar.vaslibrary.webapi.apiNew.modelNew.PinRequestViewModel;
import com.varanegar.vaslibrary.webapi.apiNew.modelNew.RoleCodeCustomerRequestViewModel;
import com.varanegar.vaslibrary.webapi.apiNew.modelNew.RoleCodeViewModel;
import com.varanegar.vaslibrary.webapi.apiNew.modelNew.customer_not_allowed_product.CustomerNotAllowProductModel;
import com.varanegar.vaslibrary.webapi.customer.ICustomerApi;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;

public class ApiNew extends BaseApi implements InApiNew {
    public ApiNew(Context context) {
        super(context);
    }

    @Override
    public Call<String> sendPinCode(PinRequestViewModel pinRequestViewModel) {
        InApiNew api = getRetrofitBuilder(TokenType.UserToken)
                .build().create(InApiNew.class);
        return api.sendPinCode(pinRequestViewModel);
    }

    @Override
    public Call<List<NewsData_Model>> getNewsData() {
        InApiNew api = getRetrofitBuilder(TokenType.UserToken)
                .build().create(InApiNew.class);
        return api.getNewsData();
    }

    @Override
    public Call<List<RoleCodeViewModel>> getCodeNaghsh(RoleCodeCustomerRequestViewModel roleCodeCustomerViewModel) {
        InApiNew api = getRetrofitBuilder(TokenType.UserToken)
                .build().create(InApiNew.class);
        return api.getCodeNaghsh(roleCodeCustomerViewModel);
    }

    @Override
    public Call<List<CustomerNotAllowProductModel>> getProductNotAllowed(List<String> customerId) {
        InApiNew api = getRetrofitBuilder(TokenType.UserToken)
                .build().create(InApiNew.class);
        return api.getProductNotAllowed(customerId);
    }
}