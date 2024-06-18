package com.msa.componentcompose.ui.map.osm

import android.view.View
import com.msa.componentcompose.ui.map.osm.OsmMapView
import org.osmdroid.views.overlay.infowindow.InfoWindow

class OsmInfoWindow(view: View, mapView: OsmMapView) : InfoWindow(view, mapView) {
    override fun onOpen(item: Any?) {
    }

    override fun onClose() {
    }
}