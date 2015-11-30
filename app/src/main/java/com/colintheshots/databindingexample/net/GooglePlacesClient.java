package com.colintheshots.databindingexample.net;

import com.colintheshots.databindingexample.model.PlacesDetail;
import com.colintheshots.databindingexample.model.PlacesResult;

import android.graphics.Bitmap;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by colin on 11/29/15.
 */
public interface GooglePlacesClient {

    @GET("/maps/api/place/autocomplete/json")
    Observable<PlacesResult> autocomplete(
            @Query("key") String key,
            @Query("input") String input
    );

    @GET("/maps/api/place/details/json")
    Observable<PlacesDetail> getDetail(
            @Query("key") String key,
            @Query("placeid") String placeId
    );

}
