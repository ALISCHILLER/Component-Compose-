package com.hoomanholding.jpadistributor.view.component.osm

import android.view.View
import com.hoomanholding.jpadistributor.view.component.osm.OsmMapView
import org.osmdroid.views.overlay.infowindow.InfoWindow

class OsmInfoWindow(view: View, mapView: OsmMapView) : InfoWindow(view, mapView) {
    override fun onOpen(item: Any?) {
    }

    override fun onClose() {
    }
}