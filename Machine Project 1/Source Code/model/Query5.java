package model;

public class Query5 {
    private int id;
    private int roof;
    private int wall;
    private int aquaCount;
    private int cropCount;

    public Query5(int id, int roof, int wall, int aquaCount, int cropCount) {
        this.id = id;
        this.roof = roof;
        this.wall = wall;
        this.aquaCount = aquaCount;
        this.cropCount = cropCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoof() {
        return roof;
    }

    public void setRoof(int roof) {
        this.roof = roof;
    }

    public int getWall() {
        return wall;
    }

    public void setWall(int wall) {
        this.wall = wall;
    }

    public int getAquaCount() {
        return aquaCount;
    }

    public void setAquaCount(int aquaCount) {
        this.aquaCount = aquaCount;
    }

    public int getCropCount() {
        return cropCount;
    }

    public void setCropCount(int cropCount) {
        this.cropCount = cropCount;
    }
}
