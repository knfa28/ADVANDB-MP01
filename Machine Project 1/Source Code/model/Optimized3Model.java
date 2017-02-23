package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Optimized3Model {
    public static ArrayList<Query3> getOfwMaids(){
        ArrayList<Query3> objectList = new ArrayList<Query3>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(MAID.id), COUNT(MAID.id)\n" +
                                                            "FROM (SELECT id\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE reln = 8) AS MAID\n" +
                                                            "WHERE MAID.id IN (SELECT id FROM hpq_hh where nofw > 0)\n" +
                                                            "GROUP BY MAID.id;");
            while(rsList.next()) {
                objectList.add(new Query3(rsList.getInt("id"),
                                 rsList.getInt("COUNT(MAID.id)")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original3Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static long getOfwMaidsTime(){
        long difference = 0;
        long start = 0;
        long end = 0;
//        CREATE INDEX hpq_reln_1 ON hpq_mem(reln);
//        CREATE INDEX hpq_nofw_1 ON hpq_hh(nofw);
//        
//        CREATE VIEW hhMaid1 AS
//        SELECT id, reln   
//        FROM hpq_mem;
//
//
//        CREATE VIEW hhMaid2 AS
//        SELECT id, nofw
//        FROM hpq_hh;
   
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(MAID.id), COUNT(MAID.id)\n" +
                                                            "FROM (SELECT id\n" +
                                                            "FROM hhMaid1\n" +
                                                            "WHERE reln = 8) AS MAID\n" +
                                                            "WHERE MAID.id IN (SELECT id FROM hhMaid2 where nofw > 0)\n" +
                                                            "GROUP BY MAID.id;");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 3 Optimized OFW Time(Views + Heuristics + Indeces: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original3Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static ArrayList<Float> getOfwMaidAverage(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT COUNT(*) AS count\n" +
                                                            "FROM db_hpq.hpq_mem mem, hpq_hh hh\n" +
                                                            "WHERE reln = 8 AND mem.id = hh.id) AS denom,\n" +
                                                            "(SELECT COUNT(MAID.id) AS count\n" +
                                                            "FROM (SELECT id\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE reln = 8) AS MAID\n" +
                                                            "WHERE MAID.id IN (SELECT id \n" +
                                                            "FROM hpq_hh \n" +
                                                            "WHERE nofw > 0)) AS numer;");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original3Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
    
    public static ArrayList<Query3> getNonOfwMaids(){
        ArrayList<Query3> objectList = new ArrayList<Query3>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(MAID.id), COUNT(MAID.id)\n" +
                                                            "FROM (SELECT id\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE reln = 8) AS MAID\n" +
                                                            "WHERE MAID.id IN (SELECT id FROM hpq_hh where nofw = 0)\n" +
                                                            "GROUP BY MAID.id;");
            while(rsList.next()) {
                objectList.add(new Query3(rsList.getInt("id"),
                                 rsList.getInt("COUNT(MAID.id)")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original3Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static long getNonOfwMaidsTime(){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(MAID.id), COUNT(MAID.id)\n" +
                                                            "FROM (SELECT id\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE reln = 8) AS MAID\n" +
                                                            "WHERE MAID.id IN (SELECT id FROM hpq_hh where nofw = 0)\n" +
                                                            "GROUP BY MAID.id;");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Query 3 OFW Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original3Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static ArrayList<Float> getNonOfwMaidAverage(){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT COUNT(*) AS count\n" +
                                                            "FROM db_hpq.hpq_mem mem, hpq_hh hh\n" +
                                                            "WHERE reln = 8 AND mem.id = hh.id) AS denom,\n" +
                                                            "(SELECT COUNT(MAID.id) AS count\n" +
                                                            "FROM (SELECT id\n" +
                                                            "FROM hpq_mem\n" +
                                                            "WHERE reln = 8) AS MAID\n" +
                                                            "WHERE MAID.id IN (SELECT id \n" +
                                                            "FROM hpq_hh \n" +
                                                            "WHERE nofw = 0)) AS numer;");
            if(rsList.next()) {
                valueList.add(rsList.getFloat("numer.count"));
                valueList.add(rsList.getFloat("denom.count"));
                valueList.add(rsList.getFloat("numer.count/denom.count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original3Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueList;
    }
}
