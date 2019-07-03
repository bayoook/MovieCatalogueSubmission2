package com.example.min4tozaki.moviecataloguesubmission2;


import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.AdapterView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment implements View.OnClickListener{
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

        rvMovies = view.findViewById(R.id.rv_category);
        rvMovies.setHasFixedSize(true);

        String[] dataNama = getResources().getStringArray(R.array.nama);
        String[] dataDeskripsi = getResources().getStringArray(R.array.deskripsi);
        String[] dataCast = getResources().getStringArray(R.array.cast);
        String[] dataGenre = getResources().getStringArray(R.array.genre);
        @SuppressLint("Recycle") TypedArray dataPoster = getResources().obtainTypedArray(R.array.poster);
        @SuppressLint("Recycle") TypedArray dataiCast1 = getResources().obtainTypedArray(R.array.cast1);
        @SuppressLint("Recycle") TypedArray dataiCast2 = getResources().obtainTypedArray(R.array.cast2);
        @SuppressLint("Recycle") TypedArray dataiCast3 = getResources().obtainTypedArray(R.array.cast3);
        String[] dataTanggal = getResources().getStringArray(R.array.status);
        String[] dataRuntime = getResources().getStringArray(R.array.runtime);
        String[] dataBahasa = getResources().getStringArray(R.array.bahasa);
        String[] dataBudget = getResources().getStringArray(R.array.budget);
        Log.d("panjang", String.valueOf(dataCast.length));
        String[][] dataCas = new String[3][dataCast.length];
        String[][] dataCn = new String[3][dataCast.length];
        for(int i = 0; i < dataNama.length; i++) {
            Movies movies = new Movies();
            movies.setNama(dataNama[i]);
            movies.setDeskripsi(dataDeskripsi[i]);
            movies.setGenre(dataGenre[i]);
            movies.setTanggal(dataTanggal[i]);
            movies.setRuntime(dataRuntime[i]);
            movies.setBahasa(dataBahasa[i]);
            movies.setBudget(dataBudget[i]);
            movies.setTanggal(dataTanggal[i]);

            movies.setPoster(dataPoster.getResourceId(i, -1));
            movies.setIcast1(dataiCast1.getResourceId(i, -1));
            movies.setIcast2(dataiCast2.getResourceId(i, -1));
            movies.setIcast3(dataiCast3.getResourceId(i, -1));
            String[] delimiter = dataCast[i].split("\\|");
            int k = 0;
            for (int j = 0; j < delimiter.length/2; j++){
                dataCas[j][i] = delimiter[k++];
                dataCn[j][i] = delimiter[k++];
            }
            movies.setCast1(dataCas[0][i]);
            movies.setCast2(dataCas[1][i]);
            movies.setCast3(dataCas[2][i]);
            movies.setCn1(dataCn[0][i]);
            movies.setCn2(dataCn[1][i]);
            movies.setCn3(dataCn[2][i]);

            list.add(movies);
        }
        showRecyclerList();

        ItemClickSupport.addTo(rvMovies).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int i, View v) {
                Intent detailMovies = new Intent(getActivity(), DetailMovies.class);
                detailMovies.putExtra(DetailMovies.EXTRA_PERSON, list.get(i));
                startActivity(detailMovies);
            }
        });
    }

    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListMoviesAdapter listMoviesAdapter = new ListMoviesAdapter(getContext());
        listMoviesAdapter.setListMovies(list);
        rvMovies.setAdapter(listMoviesAdapter);


    }


    @Override
    public void onClick(View v) {


    }
}
