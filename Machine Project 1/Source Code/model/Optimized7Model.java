/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seaver
 */
public class Optimized7Model {
    public static ArrayList<Query7> getResult(){
//        CREATE INDEX hpq_mem_id ON hpq_mem(id);
//        CREATE INDEX hpq_hh_id  ON hpq_hh(id);

        ArrayList<Query7> objectList = new ArrayList<Query7>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id,\n" +
                                                            "CSHWRK.cshwrkCnt,\n" +
                                                            "FUDWRK.fudwrkCnt,\n" +
                                                            "FUDSCH.fudschCnt\n" +
                                                            "FROM 	(SELECT mem.id from hpq_hh MAIN, hpq_mem MEM where mem.id = main.id) MAIN\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'cshwrkID',\n" +
                                                            "COUNT(DISTINCT(CSHWRK.id)) AS 'cshwrkCnt'\n" +
                                                            "FROM 	(SELECT mem.id from hpq_hh MAIN, hpq_mem MEM where mem.id = main.id) MAIN,\n" +
                                                            "hpq_cshforwrk_mem CSHWRK\n" +
                                                            "WHERE MAIN.id = CSHWRK.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS CSHWRK\n" +
                                                            "ON MAIN.id = CSHWRK.cshwrkID\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'fudwrkID',\n" +
                                                            "COUNT(DISTINCT(FUDWRK.id)) AS 'fudwrkCnt'\n" +
                                                            "FROM (SELECT mem.id from hpq_hh MAIN, hpq_mem MEM where mem.id = main.id) MAIN,\n" +
                                                            "hpq_fudforwrk_mem FUDWRK\n" +
                                                            "WHERE MAIN.id = FUDWRK.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS FUDWRK\n" +
                                                            "ON MAIN.id = FUDWRK.fudwrkID\n" +
                                                            "LEFT JOIN (SELECT MAIN.id AS 'fudschID',\n" +
                                                            "COUNT(DISTINCT(FUDSCH.id)) AS 'fudschCnt'\n" +
                                                            "FROM (SELECT mem.id from hpq_hh MAIN, hpq_mem MEM where mem.id = main.id) MAIN,\n" +
                                                            "hpq_fudforsch_mem FUDSCH\n" +
                                                            "WHERE MAIN.id = FUDSCH.hpq_hh_id\n" +
                                                            "GROUP BY MAIN.id) AS FUDSCH\n" +
                                                            "ON MAIN.id = FUDSCH.fudschID\n" +
                                                            "WHERE !(CSHWRK.cshwrkCnt is null AND FUDWRK.fudwrkCnt is null AND FUDSCH.fudschCnt is null)\n" +
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
            ResultSet rsList = MySQLConnector.executeQuery("SELECT MAIN.id,\n" +
                                                                "CSHWRK.cshwrkCnt,\n" +
                                                                "FUDWRK.fudwrkCnt,\n" +
                                                                "FUDSCH.fudschCnt\n" +
                                                                "FROM 	(SELECT mem.id from hpq_hh MAIN, hpq_mem MEM where mem.id = main.id) MAIN\n" +
                                                                "LEFT JOIN (SELECT MAIN.id AS 'cshwrkID',\n" +
                                                                "COUNT(DISTINCT(CSHWRK.id)) AS 'cshwrkCnt'\n" +
                                                                "FROM 	(SELECT mem.id from hpq_hh MAIN, hpq_mem MEM where mem.id = main.id) MAIN,\n" +
                                                                "hpq_cshforwrk_mem CSHWRK\n" +
                                                                "WHERE MAIN.id = CSHWRK.hpq_hh_id\n" +
                                                                "GROUP BY MAIN.id) AS CSHWRK\n" +
                                                                "ON MAIN.id = CSHWRK.cshwrkID\n" +
                                                                "LEFT JOIN (SELECT MAIN.id AS 'fudwrkID',\n" +
                                                                "COUNT(DISTINCT(FUDWRK.id)) AS 'fudwrkCnt'\n" +
                                                                "FROM 	(SELECT mem.id from hpq_hh MAIN, hpq_mem MEM where mem.id = main.id) MAIN,\n" +
                                                                "hpq_fudforwrk_mem FUDWRK\n" +
                                                                "WHERE MAIN.id = FUDWRK.hpq_hh_id\n" +
                                                                "GROUP BY MAIN.id) AS FUDWRK\n" +
                                                                "ON MAIN.id = FUDWRK.fudwrkID\n" +
                                                                "LEFT JOIN (SELECT MAIN.id AS 'fudschID',\n" +
                                                                "COUNT(DISTINCT(FUDSCH.id)) AS 'fudschCnt'\n" +
                                                                "FROM 	(SELECT mem.id from hpq_hh MAIN, hpq_mem MEM where mem.id = main.id) MAIN,\n" +
                                                                "hpq_fudforsch_mem FUDSCH\n" +
                                                                "WHERE MAIN.id = FUDSCH.hpq_hh_id\n" +
                                                                "GROUP BY MAIN.id) AS FUDSCH\n" +
                                                                "ON MAIN.id = FUDSCH.fudschID\n" +
                                                                "WHERE !(CSHWRK.cshwrkCnt is null AND FUDWRK.fudwrkCnt is null AND FUDSCH.fudschCnt is null)\n" +
                                                                "GROUP BY MAIN.id;");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Optimized Query 7 Result Time: " + difference);
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
