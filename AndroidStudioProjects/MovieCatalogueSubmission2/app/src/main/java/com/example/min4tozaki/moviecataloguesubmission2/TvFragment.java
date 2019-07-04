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
public class TvFragment extends Fragment{
    private RecyclerView rvTv;
    private ArrayList<Tvs> list = new ArrayList<>();
    public TvFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        rvTv = view.findViewById(R.id.rv_tv);
        rvTv.setHasFixedSize(true);

        String[] dataNama = getResources().getStringArray(R.array.nama_tv);
        String[] dataDeskripsi = getResources().getStringArray(R.array.deskripsi_tv);
        String[] dataCast = getResources().getStringArray(R.array.cast_tv);
        String[] dataGenre = getResources().getStringArray(R.array.genre_tv);
        @SuppressLint("Recycle") TypedArray dataPoster = getResources().obtainTypedArray(R.array.poster_tv);
        @SuppressLint("Recycle") TypedArray dataiCast1 = getResources().obtainTypedArray(R.array.cast1_tv);
        @SuppressLint("Recycle") TypedArray dataiCast2 = getResources().obtainTypedArray(R.array.cast2_tv);
        @SuppressLint("Recycle") TypedArray dataiCast3 = getResources().obtainTypedArray(R.array.cast3_tv);
        String[] dataTanggal = getResources().getStringArray(R.array.status_tv);
        String[] dataRuntime = getResources().getStringArray(R.array.runtime_tv);
        String[] dataBahasa = getResources().getStringArray(R.array.bahasa_tv);
        String[] dataType = getResources().getStringArray(R.array.type_tv);
        Log.d("panjang", String.valueOf(dataCast.length));
        String[][] dataCas = new String[3][dataCast.length];
        String[][] dataCn = new String[3][dataCast.length];
        String[][] dataCs = new String[3][dataCast.length];
        for(int i = 0; i < dataNama.length; i++) {
            Tvs tvs = new Tvs();

            tvs.setNama(dataNama[i]);
            tvs.setDeskripsi(dataDeskripsi[i]);
            tvs.setGenre(dataGenre[i]);
            tvs.setTanggal(dataTanggal[i]);
            tvs.setRuntime(dataRuntime[i]);
            tvs.setBahasa(dataBahasa[i]);
            tvs.setType(dataType[i]);
            tvs.setTanggal(dataTanggal[i]);

            tvs.setPoster(dataPoster.getResourceId(i, -1));
            tvs.setIcast1(dataiCast1.getResourceId(i, -1));
            tvs.setIcast2(dataiCast2.getResourceId(i, -1));
            tvs.setIcast3(dataiCast3.getResourceId(i, -1));

            String[] delimiter = dataCast[i].split("\\|");

            int k = 0;
            for (int j = 0; j < delimiter.length/3; j++){
                dataCas[j][i] = delimiter[k++];
                dataCn[j][i] = delimiter[k++];
                dataCs[j][i] = delimiter[k++];
            }

            tvs.setCast1(dataCas[0][i]);
            tvs.setCast2(dataCas[1][i]);
            tvs.setCast3(dataCas[2][i]);

            tvs.setCn1(dataCn[0][i]);
            tvs.setCn2(dataCn[1][i]);
            tvs.setCn3(dataCn[2][i]);

            tvs.setCs1(dataCs[0][i]);
            tvs.setCs2(dataCs[1][i]);
            tvs.setCs3(dataCs[2][i]);

            list.add(tvs);
        }
        showRecyclerList();

        ItemClickSupport.addTo(rvTv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int i, View v) {
                Intent detailTV = new Intent(getActivity(), DetailTv.class);
                detailTV.putExtra(DetailTv.EXTRA_PERSON, list.get(i));
                startActivity(detailTV);
            }
        });
    }

    private void showRecyclerList() {
        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListTvAdapter listTvAdapter = new ListTvAdapter(getContext());
        listTvAdapter.setListTvs(list);
        rvTv.setAdapter(listTvAdapter);
    }


}
