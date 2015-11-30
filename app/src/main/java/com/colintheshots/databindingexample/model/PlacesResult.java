package com.colintheshots.databindingexample.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by colin on 11/29/15.
 */
public class PlacesResult {
    @Expose
    public
    List<Prediction> predictions;

    @Expose
    String status;
}
