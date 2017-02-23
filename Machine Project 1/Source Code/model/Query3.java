package model;

public class Query3 {
    private int id;
    private int maidCount;

    public Query3(int id, int maidCount) {
        this.id = id;
        this.maidCount = maidCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaidCount() {
        return maidCount;
    }

    public void setMaidCount(int maidCount) {
        this.maidCount = maidCount;
    }
}
