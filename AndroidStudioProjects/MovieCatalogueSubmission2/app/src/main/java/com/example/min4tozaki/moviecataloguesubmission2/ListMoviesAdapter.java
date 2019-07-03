package com.example.min4tozaki.moviecataloguesubmission2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMoviesAdapter extends RecyclerView.Adapter<ListMoviesAdapter.CategoryViewHolder> {
    private Context context;


    public ArrayList<Movies> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    private ArrayList<Movies> listMovies;

    public ListMoviesAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvNama.setText(getListMovies().get(i).getNama());
        categoryViewHolder.tvDeskripsi.setText(getListMovies().get(i).getDeskripsi());
        categoryViewHolder.imgPoster.setImageResource(getListMovies().get(i).getPoster());
        categoryViewHolder.tvGenre.setText(getListMovies().get(i).getGenre());

    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
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
            rvCategory = itemView.findViewById(R.id.rv_category);

        }
    }
}
