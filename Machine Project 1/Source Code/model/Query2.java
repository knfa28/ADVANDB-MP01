package model;

public class Query2 {
    private int id;
    private int civstat;
    private int age_yr;
    private int jobind;
    private int educind;

    public Query2(int id, int civstat, int age_yr, int jobind, int educind) {
        this.id = id;
        this.civstat = civstat;
        this.age_yr = age_yr;
        this.jobind = jobind;
        this.educind = educind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCivstat() {
        return civstat;
    }

    public void setCivstat(int civstat) {
        this.civstat = civstat;
    }

    public int getAge_yr() {
        return age_yr;
    }

    public void setAge_yr(int age_yr) {
        this.age_yr = age_yr;
    }

    public int getJobind() {
        return jobind;
    }

    public void setJobind(int jobind) {
        this.jobind = jobind;
    }

    public int getEducind() {
        return educind;
    }

    public void setEducind(int educind) {
        this.educind = educind;
    }
}
