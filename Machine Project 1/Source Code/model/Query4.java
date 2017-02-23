package model;

public class Query4 {
    private int id;
    private int calamity;
    private int frequency;
    private int deathReason;

    public Query4(int id, int calamity, int frequency, int deathReason) {
        this.id = id;
        this.calamity = calamity;
        this.frequency = frequency;
        this.deathReason = deathReason;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCalamity() {
        return calamity;
    }

    public void setCalamity(int calamity) {
        this.calamity = calamity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getDeathReason() {
        return deathReason;
    }

    public void setDeathReason(int deathReason) {
        this.deathReason = deathReason;
    }
}
