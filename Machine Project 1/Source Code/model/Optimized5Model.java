package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Optimized5Model {
    public static ArrayList<Query5> getResult(){
        ArrayList<Query5> objectList = new ArrayList<Query5>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id, MAIN.roof, MAIN.wall,\n" +
                                                            "COUNT(AQUA.hpq_hh_id),\n" +
                                                            "COUNT(CROP.hpq_hh_id)\n" +
                                                            "FROM  hpq_hh MAIN, hpq_aquani AQUA, hpq_crop CROP\n" +
                                                            "WHERE MAIN.id = AQUA.hpq_hh_id\n" +
                                                            "AND MAIN.id = CROP.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id;");
            while(rsList.next()) {
                objectList.add(new Query5(rsList.getInt("id"),
                                    rsList.getInt("roof"),
                                    rsList.getInt("wall"),
                                    rsList.getInt("COUNT(AQUA.hpq_hh_id)"),
                                    rsList.getInt("COUNT(CROP.hpq_hh_id)")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original5Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static long getResultTime(){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id, MAIN.roof, MAIN.wall,\n" +
                                                            "COUNT(AQUA.hpq_hh_id),\n" +
                                                            "COUNT(CROP.hpq_hh_id)\n" +
                                                            "FROM  HHView MAIN, HAView AQUA, HCView CROP\n" +
                                                            "WHERE MAIN.id = AQUA.hpq_hh_id\n" +
                                                            "AND MAIN.id = CROP.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id;");
            end = System.currentTimeMillis();

            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 5 OFW Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original5Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static ArrayList<Float> getStrongAverage(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT count(*) AS count\n" +
                                                            "FROM  db_hpq.hpq_hh\n" +
                                                            "WHERE id IN (SELECT hpq_hh_id\n" +
                                                            "FROM db_hpq.hpq_aquani)\n" +
                                                            "OR id IN (SELECT hpq_hh_id\n" +
                                                            "FROM db_hpq.hpq_crop)) AS denom,\n" +
                                                            "(SELECT count(*) AS count\n" +
                                                            "FROM  db_hpq.hpq_hh\n" +
                                                            "WHERE (roof = 1 OR roof = 4)\n" +
                                                            "AND (wall = 1  OR wall = 4)\n" +
                                                            "AND (id IN (SELECT hpq_hh_id\n" +
                                                            "FROM db_hpq.hpq_aquani)\n" +
                                                            "OR id IN (SELECT hpq_hh_id\n" +
                                                            "FROM db_hpq.hpq_crop))) AS numer");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original5Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
    
    public static ArrayList<Float> getWeakAverage(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT count(*) AS count\n" +
                                                            "FROM  db_hpq.hpq_hh\n" +
                                                            "WHERE id IN (SELECT hpq_hh_id\n" +
                                                            "FROM db_hpq.hpq_aquani)\n" +
                                                            "OR id IN (SELECT hpq_hh_id\n" +
                                                            "FROM db_hpq.hpq_crop)) AS denom,\n" +
                                                            "(SELECT count(*) AS count\n" +
                                                            "FROM  db_hpq.hpq_hh\n" +
                                                            "WHERE (roof = 2 OR roof = 3 OR roof = 5 OR roof = 6 OR roof = 7)\n" +
                                                            "AND (wall = 2  OR wall = 3 OR wall = 5 OR wall = 6 OR wall = 7)\n" +
                                                            "AND (id IN (SELECT hpq_hh_id\n" +
                                                            "FROM db_hpq.hpq_aquani)\n" +
                                                            "OR id IN (SELECT hpq_hh_id\n" +
                                                            "FROM db_hpq.hpq_crop))) AS numer");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original5Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
}
