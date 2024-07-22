package com.msa.componentcompose.ui.map.osm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer


//-------------------------------------------------------------------------------------------------- OsmClear
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
@OsmAndroidComposable
fun OsmClear() {
    val applier =
        currentComposer.applier as? MapApplier ?: throw IllegalStateException("Invalid Applier")
    val mapView = applier.mapView
    mapView.overlays.clear()
}
//-------------------------------------------------------------------------------------------------- OsmClear