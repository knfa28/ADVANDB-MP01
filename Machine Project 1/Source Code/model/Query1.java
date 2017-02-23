package model;

public class Query1 {
    private int id;
    private int nofw;
    private int roof;
    private int wall;
    
    public Query1(int id, int nofw, int roof, int wall) {
        this.id = id;
        this.nofw = nofw;
        this.roof = roof;
        this.wall = wall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNofw() {
        return nofw;
    }

    public void setNofw(int nofw) {
        this.nofw = nofw;
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
}
