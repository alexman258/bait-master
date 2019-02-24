package com.mygdx.game.utils.data;

public class FishData {
    public double direction;
    public long delay;
    public double x;
    public double y;
    public int ownerID;
    public String fishType;

    public FishData(){
        direction = 0;
        delay = 0;
        x = 0;
        y = 0;
        ownerID = -1;
        fishType = "none";
    }

    public FishData(double direction, long delay, double x, double y, int ownerID, String fishType){
        this.direction = direction;
        this. delay = delay;
        this.x = x;
        this.y = y;
        this.ownerID = ownerID;
        this.fishType = fishType;
    }
}
