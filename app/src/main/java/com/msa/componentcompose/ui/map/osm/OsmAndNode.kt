package com.hoomanholding.jpadistributor.view.component.osm

internal interface OsmAndNode {
    fun onAttached() {}
    fun onRemoved() {}
    fun onCleared() {}
}

internal object OsmNodeRoot : OsmAndNode