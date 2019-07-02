package com.example.min4tozaki.moviecataloguesubmission2;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private RecyclerView rvMovies;
    private ArrayList<Movies> list = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //memilih rv_category sebagai id untuk rvCategory
        rvMovies = view.findViewById(R.id.rv_category);

        rvMovies.setHasFixedSize(true);

        list.addAll(MoviesData.getListData());
        showRecyclerList();



    }
    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListMoviesAdapter listMoviesAdapter = new ListMoviesAdapter(getContext());
        listMoviesAdapter.setListMovies(list);
        rvMovies.setAdapter(listMoviesAdapter);
    }


}
