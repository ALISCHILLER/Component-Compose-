package com.hoomanholding.jpadistributor.view.component.osm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer


//-------------------------------------------------------------------------------------------------- OsmClear
@Composable
@OsmAndroidComposable
fun OsmClear() {
    val applier =
        currentComposer.applier as? MapApplier ?: throw IllegalStateException("Invalid Applier")
    val mapView = applier.mapView
    mapView.overlays.clear()
}
//-------------------------------------------------------------------------------------------------- OsmClear