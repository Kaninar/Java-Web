package com.main.hw.models;

public class CallPrices
{
    public Float withinNetwork;
    public Float withoutNetwork;
    public Float landlines;

    public CallPrices(Float landlines, Float withoutNetwork, Float withinNetwork) {
        this.landlines = landlines;
        this.withoutNetwork = withoutNetwork;
        this.withinNetwork = withinNetwork;
    }

    public Float getWithinNetwork() {
        return withinNetwork;
    }

    public void setWithinNetwork(Float withinNetwork) {
        this.withinNetwork = withinNetwork;
    }

    public Float getWithoutNetwork() {
        return withoutNetwork;
    }

    public void setWithoutNetwork(Float withoutNetwork) {
        this.withoutNetwork = withoutNetwork;
    }

    public Float getLandlines() {
        return landlines;
    }

    public void setLandlines(Float landlines) {
        this.landlines = landlines;
    }
}
