package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Original2Model {
    public static ArrayList<Query2> getResult(int age, int educind, int jobind){
        ArrayList<Query2> objectList = new ArrayList<Query2>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT id, civstat, age_yr, jobind, educind\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE age_yr <= " + age + "\n" +
                                                            "AND civstat = 2\n" +
                                                            "AND educind = " + educind + "\n" +
                                                            "AND jobind = " + jobind + ";");
            while(rsList.next()) {
                objectList.add(new Query2(rsList.getInt("id"),
                                 rsList.getInt("civstat"),
                                 rsList.getInt("age_yr"),
                                 rsList.getInt("jobind"),
                                 rsList.getInt("educind")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original2Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static long getResultTime(int age, int educind, int jobind){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT id, civstat, age_yr, jobind, educind\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE age_yr <= " + age + "\n" +
                                                            "AND civstat = 2\n" +
                                                            "AND educind = " + educind + "\n" +
                                                            "AND jobind = " + jobind + ";");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 2 Result Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original2Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static ArrayList<Float> getAverage(int age, int educind, int jobind){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT COUNT(id) AS count\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE age_yr <= " + age + " AND civstat = 2) AS denom,\n" +
                                                            "(SELECT COUNT(id) AS count\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE age_yr <= " + age + "\n" +
                                                            "AND civstat = 2\n" +
                                                            "AND educind = " + educind + "\n" +
                                                            "AND jobind = " + jobind + ") AS numer;");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original2Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
}
