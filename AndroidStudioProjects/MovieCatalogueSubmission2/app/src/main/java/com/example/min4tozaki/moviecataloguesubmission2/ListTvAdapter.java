package com.example.min4tozaki.moviecataloguesubmission2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListTvAdapter extends RecyclerView.Adapter<ListTvAdapter.CategoryViewHolder>  {
    private Context context;


    public ArrayList<Tvs> getListTvs() {
        return listTvs;
    }

    public void setListTvs(ArrayList<Tvs> listTvs) {
        this.listTvs = listTvs;
    }

    private ArrayList<Tvs> listTvs;

    public ListTvAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTvAdapter.CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvNama.setText(getListTvs().get(i).getNama());
        categoryViewHolder.tvDeskripsi.setText(getListTvs().get(i).getDeskripsi());
        categoryViewHolder.imgPoster.setImageResource(getListTvs().get(i).getPoster());
        categoryViewHolder.tvGenre.setText(getListTvs().get(i).getGenre());

    }

    @Override
    public int getItemCount() {
        return getListTvs().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvDeskripsi;
        TextView tvGenre;
        ImageView imgPoster;
        RecyclerView rvCategory;
        CategoryViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvDeskripsi = itemView.findViewById(R.id.tv_item_deskripsi);
            tvGenre = itemView.findViewById(R.id.tv_item_genre);
            imgPoster = itemView.findViewById(R.id.img_item_poster);
            rvCategory = itemView.findViewById(R.id.rv_movies);

        }
    }
}
