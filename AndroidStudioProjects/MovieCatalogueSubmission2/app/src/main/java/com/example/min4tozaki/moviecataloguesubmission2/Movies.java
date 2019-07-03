package com.example.min4tozaki.moviecataloguesubmission2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    private String nama, cast1, cast2, cast3, cn1, cn2, cn3;
    private String deskripsi, budget, runtime, bahasa, tanggal;
    private String genre;
    private int poster, icast1, icast2, icast3;

    public int getIcast1() {
        return icast1;
    }

    public void setIcast1(int icast1) {
        this.icast1 = icast1;
    }

    public static Creator<Movies> getCREATOR() {
        return CREATOR;
    }


    protected Movies(Parcel in) {
        nama = in.readString();
        cast1 = in.readString();
        cast2 = in.readString();
        cast3 = in.readString();
        cn1 = in.readString();
        cn2 = in.readString();
        cn3 = in.readString();
        deskripsi = in.readString();
        budget = in.readString();
        runtime = in.readString();
        bahasa = in.readString();
        tanggal = in.readString();
        genre = in.readString();
        poster = in.readInt();
        icast1 = in.readInt();
        icast2 = in.readInt();
        icast3 = in.readInt();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public Movies() {

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getCast1() {
        return cast1;
    }

    public void setCast1(String cast1) {
        this.cast1 = cast1;
    }

    public String getCast2() {
        return cast2;
    }

    public void setCast2(String cast2) {
        this.cast2 = cast2;
    }

    public String getCast3() {
        return cast3;
    }

    public void setCast3(String cast3) {
        this.cast3 = cast3;
    }

    public String getCn1() {
        return cn1;
    }

    public void setCn1(String cn1) {
        this.cn1 = cn1;
    }

    public String getCn2() {
        return cn2;
    }

    public void setCn2(String cn2) {
        this.cn2 = cn2;
    }

    public String getCn3() {
        return cn3;
    }

    public void setCn3(String cn3) {
        this.cn3 = cn3;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(cast1);
        dest.writeString(cast2);
        dest.writeString(cast3);
        dest.writeString(cn1);
        dest.writeString(cn2);
        dest.writeString(cn3);
        dest.writeString(deskripsi);
        dest.writeString(budget);
        dest.writeString(runtime);
        dest.writeString(bahasa);
        dest.writeString(tanggal);
        dest.writeString(genre);
        dest.writeInt(poster);
        dest.writeInt(icast1);
        dest.writeInt(icast2);
        dest.writeInt(icast3);
    }

    public int getIcast2() {
        return icast2;
    }

    public void setIcast2(int icast2) {
        this.icast2 = icast2;
    }

    public int getIcast3() {
        return icast3;
    }

    public void setIcast3(int icast3) {
        this.icast3 = icast3;
    }
}
