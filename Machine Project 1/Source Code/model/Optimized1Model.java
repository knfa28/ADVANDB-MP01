package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class    Optimized1Model {
    public static ArrayList<Query1> getAllOfw(){
        ArrayList<Query1> objectList = new ArrayList<Query1>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT id, nofw, roof, wall\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw > 0; ");
            while(rsList.next()) {
                objectList.add(new Query1(rsList.getInt("id"),
                                 rsList.getInt("nofw"),
                                 rsList.getInt("roof"),
                                 rsList.getInt("wall")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original1Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static Long getAllOfwTime(){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT id, nofw, roof, wall\n" +
                                                            "FROM (SELECT id,nofw,roof,wall FROM hpq_hh) temp\n" +
                                                            "WHERE nofw > 0; ");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 1 OFW Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original1Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static ArrayList<Float> getStrongOfwAverage(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        long difference = 0;
        long start = 0;
        long end = 0;
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT NUMER.count, DENOM.count, NUMER.count/DENOM.count\n" +
                                                            "FROM (SELECT count(id) as count FROM nOFWView WHERE nofw > 0) DENOM ,\n" +
                                                            "(SELECT count(id) as count FROM (SELECT id,nofw FROM nOFWView WHERE (roof = 1 or roof = 4)\n" +
"                                                           and (wall = 1 or wall = 4) ) temp WHERE nofw > 0) NUMER\n"
                                                         );
            end = System.currentTimeMillis();
            if(rsList.next()) {
                valueList.add(rsList.getFloat("NUMER.count"));
                valueList.add(rsList.getFloat("DENOM.count"));
                valueList.add(rsList.getFloat("NUMER.count/DENOM.count"));
                
            }
             difference = end - start;
             System.out.println("Query 1 Optimized OFW Average Time Using (Indices and Heuristics): " + difference);
            
        } catch (SQLException ex) {
            Logger.getLogger(Original1Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
    
    public static ArrayList<Float> getWeakOfwAverage(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT COUNT(*) AS count\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw > 0) AS denom,\n" +
                                                            "(SELECT count(*) AS count\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw > 0\n" +
                                                            "AND (roof = 2 OR roof = 3 OR roof = 5 OR roof = 6 OR roof = 7)\n" +
                                                            "AND (wall = 2 OR wall = 3 OR wall = 5 OR wall = 6 OR wall = 7)) AS numer;");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original1Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
    
    public static ArrayList<Query1> getAllNonOfw(){
        ArrayList<Query1> objectList = new ArrayList<Query1>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT id, nofw, roof, wall\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw = 0;");
            while(rsList.next()) {
                objectList.add(new Query1(rsList.getInt("id"),
                                 rsList.getInt("nofw"),
                                 rsList.getInt("roof"),
                                 rsList.getInt("wall")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original1Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static Long getAllNonOfwTime(){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT id, nofw, roof, wall\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw = 0; ");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 1 Non-OFW Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original1Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static ArrayList<Float> getStrongNonOfwAverage(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT COUNT(*) AS count\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw = 0) AS denom,\n" +
                                                            "(SELECT count(*) AS count\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw = 0\n" +
                                                            "AND (roof = 1 OR roof = 4)\n" +
                                                            "AND (wall = 1 OR wall = 4)) AS numer;");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original1Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
    
    public static ArrayList<Float> getWeakNonOfwAverage(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT COUNT(*) AS count\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw = 0) AS denom,\n" +
                                                            "(SELECT count(*) AS count\n" +
                                                            "FROM hpq_hh\n" +
                                                            "WHERE nofw = 0\n" +
                                                            "AND (roof = 2 OR roof = 3 OR roof = 5 OR roof = 6 OR roof = 7)\n" +
                                                            "AND (wall = 2 OR wall = 3 OR wall = 5 OR wall = 6 OR wall = 7)) AS numer;");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original1Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
}
