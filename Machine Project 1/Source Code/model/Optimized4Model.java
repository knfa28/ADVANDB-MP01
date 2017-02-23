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
public class Optimized4Model {
//    CREATE INDEX hpq_hh_calam2_hwmny ON hpq_hh(calam2_hwmny);
//    CREATE INDEX hpq_death_mdeady ON hpq_death(mdeady);

    
    public static ArrayList<Query4> getResult(int calamity, int frequency){
        ArrayList<Query4> objectList = new ArrayList<Query4>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT HH.id, HH.calam" + calamity + ", HH.calam" + calamity + "_hwmny, D.mdeady\n" +
                                                            "FROM (SELECT id, calam" + calamity + ",calam" + calamity + "_hwmny from hpq_hh where calam" + calamity + "_hwmny = " + frequency + ") HH, hpq_death D\n" +
                                                            "WHERE HH.id = D.hpq_hh_id;");
            while(rsList.next()) {
                objectList.add(new Query4(rsList.getInt("id"),
                                    rsList.getInt("calam" + calamity),
                                    rsList.getInt("calam" + calamity + "_hwmny"),
                                    rsList.getInt("mdeady")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original4Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectList;
    }
    
    public static long getResultTime(int calamity, int frequency){
        long difference = 0;
        long start = 0;
        long end = 0;
        
        try {
            start = System.currentTimeMillis();
            ResultSet rsList = MySQLConnector.executeQuery("SELECT HH.id, HH.calam" + calamity + ",HH.calam" + calamity + "_hwmny, D.mdeady\n" +
                                                            "FROM (SELECT id, calam" + calamity + ",calam" + calamity + "_hwmny from hpq_hh where calam" + calamity + "_hwmny = " + frequency + ") HH, hpq_death D\n" +
                                                            "WHERE HH.id = D.hpq_hh_id;");
            end = System.currentTimeMillis();
            
            if(rsList.next()) {
                difference = end - start;
                System.out.println("Optimized Query 4 Result Time: " + difference);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Original4Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return difference;
    }
    
    public static ArrayList<Float> getAverage(int calamity, int frequency){
        ArrayList<Float> valueList = new ArrayList<Float>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT numer.count, denom.count, numer.count/denom.count\n" +
                                                            "FROM (SELECT COUNT(*) as count\n" +
                                                            "FROM hpq_hh HH, hpq_death D\n" +
                                                            "WHERE HH.id = D.hpq_hh_id) as denom,\n" +
                                                            "(SELECT COUNT(*) as count\n" +
                                                            "FROM hpq_hh HH, hpq_death D\n" +
                                                            "WHERE HH.calam" + calamity + " = 1\n" +
                                                            "AND HH.calam" + calamity + "_hwmny = " + frequency + "\n" +
                                                            "AND HH.id = D.hpq_hh_id) as numer");
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
