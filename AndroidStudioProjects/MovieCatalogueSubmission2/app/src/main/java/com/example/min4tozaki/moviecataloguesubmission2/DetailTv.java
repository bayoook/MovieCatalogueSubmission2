package com.example.min4tozaki.moviecataloguesubmission2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailTv extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";
    ImageView iPoster, iCast1, iCast2, iCast3;
    TextView tvNama, tvTanggal, tvType, tvRuntime, tvBahasa;
    TextView tvCast1, tvCast2, tvCast3, tvDeskripsi;
    TextView tvCn1, tvCn2, tvCn3, tvGenre;
    TextView tvCs1, tvCs2, tvCs3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_tv);

        tvNama = findViewById(R.id.tv_nama);
        tvTanggal = findViewById(R.id.tv_rilis);
        tvBahasa = findViewById(R.id.tv_language);
        tvType = findViewById(R.id.tv_type);
        tvRuntime = findViewById(R.id.tv_runtime);

        tvCast1 = findViewById(R.id.tv_cast1);
        tvCast2 = findViewById(R.id.tv_cast2);
        tvCast3 = findViewById(R.id.tv_cast3);

        tvDeskripsi = findViewById(R.id.tv_deskripsi);

        tvCn1 = findViewById(R.id.tv_cn1);
        tvCn2 = findViewById(R.id.tv_cn2);
        tvCn3 = findViewById(R.id.tv_cn3);

        tvCs1 = findViewById(R.id.tv_cs1);
        tvCs2 = findViewById(R.id.tv_cs2);
        tvCs3 = findViewById(R.id.tv_cs3);

        tvGenre = findViewById(R.id.tv_genre);

        iPoster = findViewById(R.id.img_poster);
        iCast1 = findViewById(R.id.cast_1);
        iCast2 = findViewById(R.id.cast_2);
        iCast3 = findViewById(R.id.cast_3);


        Tvs tvs= getIntent().getParcelableExtra(EXTRA_PERSON);

        tvNama.setText(tvs.getNama());
        tvTanggal.setText(tvs.getTanggal());
        tvType.setText(tvs.getType());
        tvBahasa.setText(tvs.getBahasa());
        tvRuntime.setText(tvs.getRuntime());

        tvCast1.setText(tvs.getCast1());
        tvCast2.setText(tvs.getCast2());
        tvCast3.setText(tvs.getCast3());

        tvDeskripsi.setText(tvs.getDeskripsi());

        tvCn1.setText(tvs.getCn1());
        tvCn2.setText(tvs.getCn2());
        tvCn3.setText(tvs.getCn3());

        tvCs1.setText(tvs.getCs1());
        tvCs2.setText(tvs.getCs2());
        tvCs3.setText(tvs.getCs3());

        tvGenre.setText(tvs.getGenre());

        iPoster.setImageResource(tvs.getPoster());
        iCast1.setImageResource(tvs.getIcast1());
        iCast2.setImageResource(tvs.getIcast2());
        iCast3.setImageResource(tvs.getIcast3());
    }
}
