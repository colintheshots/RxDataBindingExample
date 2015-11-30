package com.colintheshots.databindingexample.adapter;

import com.colintheshots.databindingexample.BR;
import com.colintheshots.databindingexample.R;
import com.colintheshots.databindingexample.model.PlacesDetail;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colin on 11/29/15.
 */
public class PlacesAdapter
        extends RecyclerView.Adapter<PlacesAdapter.BindingHolder> {

    private List<PlacesDetail> mPlacesDetails;

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public PlacesAdapter() {
        mPlacesDetails = new ArrayList<>();
    }

    public PlacesAdapter(List<PlacesDetail> placesDetails) {
         mPlacesDetails = placesDetails;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_place, parent, false);
        return new BindingHolder(v);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final PlacesDetail placeDetail = mPlacesDetails.get(position);
        holder.getBinding().setVariable(BR.placeDetail, placeDetail);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mPlacesDetails.size();
    }

    public void addItem(PlacesDetail placesDetail) {
        mPlacesDetails.add(placesDetail);
        notifyDataSetChanged();
    }

    public void clear() {
        mPlacesDetails.clear();
        notifyDataSetChanged();
    }

}
