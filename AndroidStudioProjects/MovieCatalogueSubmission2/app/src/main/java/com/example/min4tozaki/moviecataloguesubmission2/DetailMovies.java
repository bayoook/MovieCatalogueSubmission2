package com.example.min4tozaki.moviecataloguesubmission2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailMovies extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    ImageView iPoster, iCast1, iCast2, iCast3;
    TextView tvNama, tvTanggal, tvBudget, tvRuntime, tvBahasa;
    TextView tvCast1, tvCast2, tvCast3, tvDeskripsi;
    TextView tvCn1, tvCn2, tvCn3, tvGenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_film);

        tvNama = findViewById(R.id.tv_nama);
        tvTanggal = findViewById(R.id.tv_rilis);
        tvBahasa = findViewById(R.id.tv_language);
        tvBudget = findViewById(R.id.tv_budget);
        tvRuntime = findViewById(R.id.tv_runtime);

        tvCast1 = findViewById(R.id.tv_cast1);
        tvCast2 = findViewById(R.id.tv_cast2);
        tvCast3 = findViewById(R.id.tv_cast3);

        tvDeskripsi = findViewById(R.id.tv_deskripsi);

        tvCn1 = findViewById(R.id.tv_cn1);
        tvCn2 = findViewById(R.id.tv_cn2);
        tvCn3 = findViewById(R.id.tv_cn3);

        tvGenre = findViewById(R.id.tv_genre);

        iPoster = findViewById(R.id.img_poster);
        iCast1 = findViewById(R.id.cast_1);
        iCast2 = findViewById(R.id.cast_2);
        iCast3 = findViewById(R.id.cast_3);


        Movies movies = getIntent().getParcelableExtra(EXTRA_PERSON);

        tvNama.setText(movies.getNama());
        tvTanggal.setText(movies.getTanggal());
        tvBudget.setText(movies.getBudget());
        tvBahasa.setText(movies.getBahasa());
        tvRuntime.setText(movies.getRuntime());

        tvCast1.setText(movies.getCast1());
        tvCast2.setText(movies.getCast2());
        tvCast3.setText(movies.getCast3());

        tvDeskripsi.setText(movies.getDeskripsi());

        tvCn1.setText(movies.getCn1());
        tvCn2.setText(movies.getCn2());
        tvCn3.setText(movies.getCn3());

        tvGenre.setText(movies.getGenre());

        iPoster.setImageResource(movies.getPoster());
        iCast1.setImageResource(movies.getIcast1());
        iCast2.setImageResource(movies.getIcast2());
        iCast3.setImageResource(movies.getIcast3());
    }
}
