package model;

public class Query7 {
    private int id;
    private int cshWrkCount;
    private int fudWrkCount;
    private int fudSchCount;

    public Query7(int id, int cshWrkCount, int fudWrkCount, int fudSchCount) {
        this.id = id;
        this.cshWrkCount = cshWrkCount;
        this.fudWrkCount = fudWrkCount;
        this.fudSchCount = fudSchCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCshWrkCount() {
        return cshWrkCount;
    }

    public void setCshWrkCount(int cshWrkCount) {
        this.cshWrkCount = cshWrkCount;
    }

    public int getFudWrkCount() {
        return fudWrkCount;
    }

    public void setFudWrkCount(int fudWrkCount) {
        this.fudWrkCount = fudWrkCount;
    }

    public int getFudSchCount() {
        return fudSchCount;
    }

    public void setFudSchCount(int fudSchCount) {
        this.fudSchCount = fudSchCount;
    }
}
