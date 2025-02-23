package com.main.hw.models;

public class Parameters
{
    public String FavoriteNumber;
    public Float Tariffication;
    public Float ConnectionPrice;

    public Parameters(String favoriteNumber, Float tariffication, Float connectionPrice) {
        FavoriteNumber = favoriteNumber;
        Tariffication = tariffication;
        ConnectionPrice = connectionPrice;
    }

    public String getFavoriteNumber() {
        return FavoriteNumber;
    }

    public void setFavoriteNumber(String favoriteNumber) {
        FavoriteNumber = favoriteNumber;
    }

    public Float getTariffication() {
        return Tariffication;
    }

    public void setTariffication(Float tariffication) {
        Tariffication = tariffication;
    }

    public Float getConnectionPrice() {
        return ConnectionPrice;
    }

    public void setConnectionPrice(Float connectionPrice) {
        ConnectionPrice = connectionPrice;
    }
}
