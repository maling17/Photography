package com.example.kresna.photography;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder> {
    private DataDummy dataDummy;

    RecylerAdapter(DataDummy dataDummy) {
        this.dataDummy = dataDummy;
    }

    @NonNull
    @Override
    public RecylerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerAdapter.ViewHolder Holder, int position) {
        Holder.txtname.setText(dataDummy.getListDataDummy().get(position));
    }

    @Override
    public int getItemCount() {
        return dataDummy.getListDataDummy().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
        }
    }
}