package com.example.infocovid_19.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infocovid_19.R;
import com.example.infocovid_19.databinding.CoronaListItemBinding;
import com.example.infocovid_19.models.CoronaCase;

import java.util.ArrayList;
import java.util.List;

public class CoronaCaseAdapter extends RecyclerView.Adapter<CoronaCaseAdapter.CoronaCaseViewHolder> {
    private ArrayList<CoronaCase> coronaCases;

    public CoronaCaseAdapter(List<CoronaCase> coronaCase) {
    }

    @NonNull
    @Override
    public CoronaCaseAdapter.CoronaCaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        CoronaListItemBinding coronaListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.corona_list_item, viewGroup, false);
        return new CoronaCaseViewHolder(coronaListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaCaseAdapter.CoronaCaseViewHolder holder, int position) {
        CoronaCase c = coronaCases.get(position);
        holder.coronaListItemBinding.setCorona(c);
    }

    @Override
    public int getItemCount() {
        if (coronaCases != null) {
            Log.e("corona size",  ""+coronaCases.size() );
            return coronaCases.size();
        } else {
            return 0;
        }
    }

    public void setCoronaList(ArrayList<CoronaCase> corona) {
        this.coronaCases = corona;
        notifyDataSetChanged();
    }
    static class CoronaCaseViewHolder extends RecyclerView.ViewHolder {
        private CoronaListItemBinding coronaListItemBinding;
        CoronaCaseViewHolder(@NonNull CoronaListItemBinding coronaListItemBinding) {
            super(coronaListItemBinding.getRoot());
            this.coronaListItemBinding = coronaListItemBinding;
        }
    }
}
