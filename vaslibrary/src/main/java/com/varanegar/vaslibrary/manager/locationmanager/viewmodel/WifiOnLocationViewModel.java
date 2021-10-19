package com.varanegar.vaslibrary.manager.locationmanager.viewmodel;

import com.varanegar.vaslibrary.webapi.tracking.TrackingRequestModel;

/**
 * Created by A.Jafarzadeh on 11/8/2017.
 */

public class WifiOnLocationViewModel extends BaseEventLocationViewModel {

    public DeviceEventViewModel eventData;

    @Override
    public void prepareForTracking(TrackingRequestModel trackingRequestModel) {
        trackingRequestModel.pointEvent.add(this);
        PersonnelDailyActivityEventTypeId = EventTypeId.WifiOn;
    }

    @Override
    public boolean IsImportant() {
        return true;
    }
}
