package com.colintheshots.databindingexample.model;

import com.google.gson.annotations.Expose;

import com.colintheshots.databindingexample.Secrets;

import android.content.res.Resources;
import android.util.Log;

import java.util.List;

/**
 * Created by colin on 11/29/15.
 */
public class PlacesDetail {

    @Expose
    Result result;

    public Result getResult() {
        return result;
    }

    public String getName() {
        if (result != null) {
            return result.getName();
        } else {
            return "";
        }
    }

    public String getPhotoUrl() {
        if (result != null) {
            return result.getPhotoUrl();
        } else {
            return "";
        }
    }

    public class Result {

        public class Photo {
            @Expose
            String photo_reference;
        }

        @Expose
        String name;

        @Expose
        List<Photo> photos;

        public String getName() {
            return name;
        }

        public String getPhotoUrl() {
            if (photos != null && photos.size() > 0) {
                String photoUrl = "https://maps.googleapis.com/maps/api/place/photo?key="
                        + Secrets.API_KEY +
                        "&photoreference="
                        + photos.get(0).photo_reference
                        + "&maxwidth=300&maxheight=300";
                Log.d("PlacesDetail",
                        "Photo Url for " + getName() + " was " + photoUrl);
                return photoUrl;
            } else {
                Log.d("PlacesDetail", "Photo Url was null in " + getName());
                return "";
            }
        }
    }
}
