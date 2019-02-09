package com.example.kresna.photography;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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
    private OnPhotoClickListener listener;

    RecylerAdapter(List<PhotoItem> data, OnPhotoClickListener listener) {
        this.photoItemList = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecylerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerAdapter.ViewHolder Holder, int position) {
        Holder.bind(listener);
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

    public interface OnPhotoClickListener {
        void OnClick(int id);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname, txttype, txturl;
        ImageView img_photo;
        CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
            txttype = itemView.findViewById(R.id.txttype);
            txturl = itemView.findViewById(R.id.txturl);
            img_photo = itemView.findViewById(R.id.img_photo);
            cardView = itemView.findViewById(R.id.cardview);
        }

        private void bind(final OnPhotoClickListener listener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(photoItemList.get(getAdapterPosition()).getId());
                }
            });
        }
    }
}
