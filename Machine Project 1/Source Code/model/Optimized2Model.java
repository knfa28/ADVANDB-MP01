package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltSets.difference;
import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Optimized2Model {
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
         long end;
        long start;
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("CALL civQuery(2,"+educind+","+jobind+","+age+")");
            end = System.currentTimeMillis();
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("Numer.count/denom.count"));
            }
            long difference = end - start;
            System.out.println("Query 2 Optimized Average Time Using (Prepared statement + Views + Indeces): " + difference);
            
        } catch (SQLException ex) {
            Logger.getLogger(Original2Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return valueList;
    }
}
