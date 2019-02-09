package com.example.kresna.photography;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kresna.photography.api.PhotoItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder> {
    private List<PhotoItem> photoItemList;

    RecylerAdapter(List<PhotoItem> data) {
        this.photoItemList = data;
    }

    @NonNull
    @Override
    public RecylerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerAdapter.ViewHolder Holder, int position) {
        Holder.txtname.setText(photoItemList.get(position).getAuthor());
        Holder.txttype.setText(photoItemList.get(position).getFormat());
        Holder.txturl.setText(photoItemList.get(position).getPost_url());

        String url = "https://picsum.photos/2007?image=" + photoItemList.get(position).getId();
        Picasso.get().load(url).into(Holder.img_photo);
    }

    @Override
    public int getItemCount() {
        return photoItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname, txttype, txturl;
        ImageView img_photo;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
            txttype = itemView.findViewById(R.id.txttype);
            txturl = itemView.findViewById(R.id.txturl);
            img_photo = itemView.findViewById(R.id.img_photo);
        }
    }
}
