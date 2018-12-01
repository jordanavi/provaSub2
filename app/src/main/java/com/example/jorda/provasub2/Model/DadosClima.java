package com.example.jorda.provasub2.Model;

public class DadosClima {

    private double latitude;
    private double longitude;
    private String clima;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
    public String getClima() {
        return clima;
    }
}
