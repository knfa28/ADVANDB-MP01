package model;

public class Query6 {
    private int id;
    private int nofw;
    private int cropCount;

    public Query6(int id, int nofw, int cropCount) {
        this.id = id;
        this.nofw = nofw;
        this.cropCount = cropCount;
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

    public int getCropCount() {
        return cropCount;
    }

    public void setCropCount(int cropCount) {
        this.cropCount = cropCount;
    }
}
