package com.hoomanholding.jpadistributor.view.component.osm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import org.osmdroid.util.GeoPoint


//-------------------------------------------------------------------------------------------------- OsmCircle
@Composable
@OsmAndroidComposable
fun OsmCircle(
    geoPoint: GeoPoint,
    radius: Float
) {
    val circle = CircleOverlay(geoPoint, radius)
    val applier =
        currentComposer.applier as? MapApplier ?: throw IllegalStateException("Invalid Applier")
    val mapView = applier.mapView
    mapView.overlays.clear()
    mapView.overlays.add(circle)
}
//-------------------------------------------------------------------------------------------------- OsmCircle