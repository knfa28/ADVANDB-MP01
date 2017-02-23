package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Original6Model {
    public static ArrayList<Query6> getOfwCrops(){
        ArrayList<Query6> objectList = new ArrayList<Query6>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id, MAIN.nofw,\n" +
                                                            "COUNT(DISTINCT(CROP.croptype))\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM,\n" +
                                                            "hpq_arcdp_mem ARCDP, hpq_crop CROP\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = ARCDP.hpq_hh_id\n" +
                                                            "AND ARCDP.hpq_hh_id = CROP.hpq_hh_id\n" +
                                                            "AND MAIN.nofw > 0\n" +
                                                            "GROUP BY MAIN.id;");
            while(rsList.next()) {
                objectList.add(new Query6(rsList.getInt("id"),
                                    rsList.getInt("nofw"),
                                    rsList.getInt("COUNT(DISTINCT(CROP.croptype))")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original6Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static long getOfwCropsTime(){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id, MAIN.nofw,\n" +
                                                            "COUNT(DISTINCT(CROP.croptype))\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM,\n" +
                                                            "hpq_arcdp_mem ARCDP, hpq_crop CROP\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = ARCDP.hpq_hh_id\n" +
                                                            "AND ARCDP.hpq_hh_id = CROP.hpq_hh_id\n" +
                                                            "AND MAIN.nofw > 0\n" +
                                                            "GROUP BY MAIN.id;");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 6 OFW Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original6Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
     public static ArrayList<Float> getOfwAvg(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM\n" +
                                                            "(SELECT COUNT(DISTINCT(CROP.hpq_hh_id)) AS COUNT\n" +
                                                            "FROM hpq_crop CROP, hpq_arcdp_mem ARCDP\n" +
                                                            "WHERE CROP.hpq_hh_id = ARCDP.hpq_hh_id) AS denom,\n" +
                                                            "(SELECT COUNT(DISTINCT(CROP.hpq_hh_id)) AS COUNT\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_crop CROP, hpq_arcdp_mem ARCDP\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = ARCDP.hpq_hh_id\n" +
                                                            "AND ARCDP.hpq_hh_id = CROP.hpq_hh_id\n" +
                                                            "AND MAIN.nofw > 0) AS numer");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original6Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
    
    public static ArrayList<Query6> getNonOfwCrops(){
        ArrayList<Query6> objectList = new ArrayList<Query6>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id, MAIN.nofw,\n" +
                                                            "COUNT(DISTINCT(CROP.croptype))\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM,\n" +
                                                            "hpq_arcdp_mem ARCDP, hpq_crop CROP\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = ARCDP.hpq_hh_id\n" +
                                                            "AND ARCDP.hpq_hh_id = CROP.hpq_hh_id\n" +
                                                            "AND MAIN.nofw = 0\n" +
                                                            "GROUP BY MAIN.id;");
            while(rsList.next()) {
                objectList.add(new Query6(rsList.getInt("id"),
                                    rsList.getInt("nofw"),
                                    rsList.getInt("COUNT(DISTINCT(CROP.croptype))")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original6Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static long getNonOfwCropsTime(){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id, MAIN.nofw,\n" +
                                                            "COUNT(DISTINCT(CROP.croptype))\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM,\n" +
                                                            "hpq_arcdp_mem ARCDP, hpq_crop CROP\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = ARCDP.hpq_hh_id\n" +
                                                            "AND ARCDP.hpq_hh_id = CROP.hpq_hh_id\n" +
                                                            "AND MAIN.nofw = 0\n" +
                                                            "GROUP BY MAIN.id;");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 6 Non-OFW Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original6Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static ArrayList<Float> getNonOfwAvg(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM\n" +
                                                            "(SELECT COUNT(DISTINCT(CROP.hpq_hh_id)) AS COUNT\n" +
                                                            "FROM hpq_crop CROP, hpq_arcdp_mem ARCDP\n" +
                                                            "WHERE CROP.hpq_hh_id = ARCDP.hpq_hh_id) AS denom,\n" +
                                                            "(SELECT COUNT(DISTINCT(CROP.hpq_hh_id)) AS COUNT\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_crop CROP, hpq_arcdp_mem ARCDP\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = ARCDP.hpq_hh_id\n" +
                                                            "AND ARCDP.hpq_hh_id = CROP.hpq_hh_id\n" +
                                                            "AND MAIN.nofw = 0) AS numer");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original6Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
}
