package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Original7Model {
    public static ArrayList<Query7> getResult(){
        ArrayList<Query7> objectList = new ArrayList<Query7>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id, CSHWRK.cshwrkCnt, FUDWRK.fudwrkCnt, FUDSCH.fudschCnt\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'cshwrkID',\n" +
                                                            "COUNT(DISTINCT(CSHWRK.id)) AS 'cshwrkCnt'\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_cshforwrk_mem CSHWRK\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = CSHWRK.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS CSHWRK\n" +
                                                            "ON MEM.id = CSHWRK.cshwrkID\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'fudwrkID',\n" +
                                                            "COUNT(DISTINCT(FUDWRK.id)) AS 'fudwrkCnt'\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_fudforwrk_mem FUDWRK\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = FUDWRK.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS FUDWRK\n" +
                                                            "ON MEM.id = FUDWRK.fudwrkID\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'fudschID',\n" +
                                                            "COUNT(DISTINCT(FUDSCH.id)) AS 'fudschCnt'\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_fudforsch_mem FUDSCH\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = FUDSCH.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS FUDSCH\n" +
                                                            "ON MEM.id = FUDSCH.fudschID\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND !(CSHWRK.cshwrkCnt IS NULL\n" +
                                                            "AND FUDWRK.fudwrkCnt IS NULL\n" +
                                                            "AND FUDSCH.fudschCnt IS NULL)\n" +
                                                            "GROUP BY MAIN.id;");
            while(rsList.next()) {
                objectList.add(new Query7(rsList.getInt("id"),
                                    rsList.getInt("cshwrkCnt"),
                                    rsList.getInt("fudwrkCnt"),
                                    rsList.getInt("fudschCnt")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original7Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static long getResultTime(){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id, CSHWRK.cshwrkCnt, FUDWRK.fudwrkCnt, FUDSCH.fudschCnt\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'cshwrkID',\n" +
                                                            "COUNT(DISTINCT(CSHWRK.id)) AS 'cshwrkCnt'\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_cshforwrk_mem CSHWRK\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = CSHWRK.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS CSHWRK\n" +
                                                            "ON MEM.id = CSHWRK.cshwrkID\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'fudwrkID',\n" +
                                                            "COUNT(DISTINCT(FUDWRK.id)) AS 'fudwrkCnt'\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_fudforwrk_mem FUDWRK\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = FUDWRK.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS FUDWRK\n" +
                                                            "ON MEM.id = FUDWRK.fudwrkID\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'fudschID',\n" +
                                                            "COUNT(DISTINCT(FUDSCH.id)) AS 'fudschCnt'\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_fudforsch_mem FUDSCH\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = FUDSCH.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS FUDSCH\n" +
                                                            "ON MEM.id = FUDSCH.fudschID\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "GROUP BY MAIN.id;");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 7 Result Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original7Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static float getTotal(){
        float value = 0;
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT COUNT(DISTINCT(MAIN.id))\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND (MEM.id IN (SELECT hpq_hh_id FROM hpq_cshforwrk_mem)\n" +
                                                            "OR MEM.id IN (SELECT hpq_hh_id FROM hpq_fudforwrk_mem)\n" +
                                                            "OR MEM.id IN (SELECT hpq_hh_id FROM hpq_fudforsch_mem));");
            if(rsList.next()) {
                value = rsList.getInt("COUNT(DISTINCT(MAIN.id))"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original7Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    public static float getCshWrkSum(){
        float total = 0;
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT COUNT(DISTINCT(MAIN.id))\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_cshforwrk_mem CSHWRK\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = CSHWRK.hpq_hh_id;");
            if(rsList.next()) {
                total = rsList.getInt("COUNT(DISTINCT(MAIN.id))");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original7Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public static float getFudWrkSum(){
        float total = 0;
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT COUNT(DISTINCT(MAIN.id))\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_fudforwrk_mem FUDWRK\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = FUDWRK.hpq_hh_id;");
            if(rsList.next()) {
                total = rsList.getInt("COUNT(DISTINCT(MAIN.id))");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original7Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public static float getFudSchSum(){
        float total = 0;
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT COUNT(DISTINCT(MAIN.id))\n" +
                                                            "FROM hpq_hh MAIN, hpq_mem MEM, hpq_fudforsch_mem FUDSCH\n" +
                                                            "WHERE MAIN.id = MEM.id\n" +
                                                            "AND MEM.id = FUDSCH.hpq_hh_id;");
            if(rsList.next()) {
                total = rsList.getInt("COUNT(DISTINCT(MAIN.id))");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original7Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
}
