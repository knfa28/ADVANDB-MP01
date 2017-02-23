package view;

import controller.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.Query1;
import model.Query2;
import model.Query3;
import model.Query4;
import model.Query5;
import model.Query6;
import model.Query7;

public class OriginalView extends javax.swing.JFrame {
    private OriginalController control;
    private DefaultTableModel query1OfwModel, query1NonOfwModel,
                              query2Model,
                              query3OfwModel, query3NonOfwModel,
                              query4Model,
                              query5Model,
                              query6OfwModel, query6NonOfwModel,
                              query7Model;
    
    public OriginalView(OriginalController control) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}
        this.control = control;
        initComponents();
        
        query1OfwTable.setAutoCreateRowSorter(true);
        query1NonOfwTable.setAutoCreateRowSorter(true);
        query1OfwModel = (DefaultTableModel) query1OfwTable.getModel();
        query1NonOfwModel = (DefaultTableModel) query1NonOfwTable.getModel();
        
        query2Table.setAutoCreateRowSorter(true);
        query2Model = (DefaultTableModel) query2Table.getModel();
        
        query3OfwTable.setAutoCreateRowSorter(true);
        query3NonOfwTable.setAutoCreateRowSorter(true);
        query3OfwModel = (DefaultTableModel) query3OfwTable.getModel();
        query3NonOfwModel = (DefaultTableModel) query3NonOfwTable.getModel();
        
        query4Table.setAutoCreateRowSorter(true);
        query4Model = (DefaultTableModel) query4Table.getModel();
        
        query5Table.setAutoCreateRowSorter(true);
        query5Model = (DefaultTableModel) query5Table.getModel();
        
        query6OfwTable.setAutoCreateRowSorter(true);
        query6NonOfwTable.setAutoCreateRowSorter(true);
        query6OfwModel = (DefaultTableModel) query6OfwTable.getModel();
        query6NonOfwModel = (DefaultTableModel) query6NonOfwTable.getModel();
        
        query7Table.setAutoCreateRowSorter(true);
        query7Model = (DefaultTableModel) query7Table.getModel();
        
        this.setResizable(false);
        setLocationRelativeTo(null);  
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void updateQuery1Details(long time1, long time2,
                                    ArrayList<Float> detail1, ArrayList<Float> detail2,
                                    ArrayList<Float> detail3, ArrayList<Float> detail4){
        query1OfwTime.setText(Long.toString(time1) + "ms");
        query1TotalOfw.setText(Float.toString(detail1.get(1)));
        query1StrongOfw.setText(Float.toString(detail1.get(0)) + "/" + Float.toString(detail1.get(2) * 100) + "%") ;
        query1WeakOfw.setText(Float.toString(detail2.get(0)) + "/" + Float.toString(detail2.get(2) * 100) + "%") ;
        
        query1NonOfwTime.setText(Long.toString(time2) + "ms");
        query1TotalNonOfw.setText(Float.toString(detail3.get(1)));
        query1StrongNonOfw.setText(Float.toString(detail3.get(0)) + "/" + Float.toString(detail3.get(2) * 100) + "%") ;
        query1WeakNonOfw.setText(Float.toString(detail4.get(0)) + "/" + Float.toString(detail4.get(2) * 100) + "%") ;
    }
    
    public void updateQuery1Tables(ArrayList<Query1> ofw, ArrayList<Query1> nonOfw){
        Object temp[];
        
        query1OfwModel.getDataVector().removeAllElements();
        query1NonOfwModel.getDataVector().removeAllElements();
        query1OfwModel.fireTableDataChanged();
        query1NonOfwModel.fireTableDataChanged();
        
        for(int i = 0; i < ofw.size(); i++) {
            temp = new Object[]{ofw.get(i).getId(),
                                ofw.get(i).getNofw(),
                                ofw.get(i).getRoof(),
                                ofw.get(i).getWall()};
            
            query1OfwModel.addRow(temp);
        }
        
        for(int i = 0; i < nonOfw.size(); i++) {
            temp = new Object[]{nonOfw.get(i).getId(),
                                nonOfw.get(i).getNofw(),
                                nonOfw.get(i).getRoof(),
                                nonOfw.get(i).getWall()};
            
            query1NonOfwModel.addRow(temp);
        }
    }
    
    public void updateQuery2Details(long time1,
                                    ArrayList<Float> detail1,
                                    ArrayList<Float> detail2,
                                    ArrayList<Float> detail3){
        query2ResultTime.setText(Long.toString(time1) + "ms");
        query2TotalMarried.setText(Float.toString(detail1.get(1)));
        query2EmpAvg.setText(Float.toString(detail1.get(0)) + "/" + Float.toString(detail1.get(2) * 100) + "%") ;
        query2EducAvg.setText(Float.toString(detail2.get(0)) + "/" + Float.toString(detail2.get(2) * 100) + "%") ;
        query2NeitherAvg.setText(Float.toString(detail3.get(0)) + "/" + Float.toString(detail3.get(2) * 100) + "%") ;
    }
    
    public void updateQuery2Tables(ArrayList<Query2> res){
        Object temp[];
        
        query2Model.getDataVector().removeAllElements();
        query2Model.fireTableDataChanged();
        
        for(int i = 0; i < res.size(); i++) {
            temp = new Object[]{res.get(i).getId(),
                                res.get(i).getCivstat(),
                                res.get(i).getAge_yr(),
                                res.get(i).getJobind(),
                                res.get(i).getEducind()};
            
            query2Model.addRow(temp);
        }
    }
    
    public void updateQuery3Details(long time1, long time2,
                                    ArrayList<Float> detail1, ArrayList<Float> detail2){
        query3OfwTime.setText(Long.toString(time1) + "ms");
        query3TotalMaids1.setText(Float.toString(detail1.get(1)));
        query3OfwMaidsAvg.setText(Float.toString(detail1.get(0)) + "/" + Float.toString(detail1.get(2) * 100) + "%") ;
        
        query3NonOfwTime.setText(Long.toString(time2) + "ms");
        query3TotalMaids2.setText(Float.toString(detail1.get(1)));
        query3NonOfwMaidsAvg.setText(Float.toString(detail2.get(0)) + "/" + Float.toString(detail2.get(2) * 100) + "%") ;
    }
    
    public void updateQuery3Tables(ArrayList<Query3> ofw, ArrayList<Query3> non){
        Object temp[];
        
        query3OfwModel.getDataVector().removeAllElements();
        query3NonOfwModel.getDataVector().removeAllElements();
        query3OfwModel.fireTableDataChanged();
        query3NonOfwModel.fireTableDataChanged();
        
        for(int i = 0; i < ofw.size(); i++) {
            temp = new Object[]{ofw.get(i).getId(),
                                ofw.get(i).getMaidCount()};
            
            query3OfwModel.addRow(temp);
        }
        
        for(int i = 0; i < non.size(); i++) {
            temp = new Object[]{non.get(i).getId(),
                                non.get(i).getMaidCount()};
            
            query3NonOfwModel.addRow(temp);
        }
    }
    
    public void updateQuery4Details(long time1, ArrayList<Float> detail1){
        query4ResultTime.setText(Long.toString(time1) + "ms");
        query4TotalDeath.setText(Float.toString(detail1.get(1)));
        query4DeathAvg.setText(Float.toString(detail1.get(0)) + "/" + Float.toString(detail1.get(2) * 100) + "%") ;       
    }
    
    public void updateQuery4Tables(ArrayList<Query4> res){
        Object temp[];
        
        query4Model.getDataVector().removeAllElements();
        query4Model.fireTableDataChanged();
        
        for(int i = 0; i < res.size(); i++) {
            temp = new Object[]{res.get(i).getId(),
                                res.get(i).getCalamity(),
                                res.get(i).getFrequency(),
                                res.get(i).getDeathReason()};
            
            query4Model.addRow(temp);
        }
    }
    
    public void updateQuery5Details(long time1, ArrayList<Float> detail1, ArrayList<Float> detail2){
        query5ResultTime.setText(Long.toString(time1) + "ms");
        query5Total.setText(Float.toString(detail1.get(1)));
        query5StrongAvg.setText(Float.toString(detail1.get(0)) + "/" + Float.toString(detail1.get(2) * 100) + "%") ;
        query5WeakAvg.setText(Float.toString(detail2.get(0)) + "/" + Float.toString(detail2.get(2) * 100) + "%") ; 
    }
    
    public void updateQuery5Tables(ArrayList<Query5> res){
        Object temp[];
        
        query5Model.getDataVector().removeAllElements();
        query5Model.fireTableDataChanged();
        
        for(int i = 0; i < res.size(); i++) {
            temp = new Object[]{res.get(i).getId(),
                                res.get(i).getRoof(),
                                res.get(i).getWall(),
                                res.get(i).getAquaCount(),
                                res.get(i).getCropCount()};
            
            query5Model.addRow(temp);
        }
    }
    
    public void updateQuery6Details(long time1, long time2,
                                    ArrayList<Float> detail1, ArrayList<Float> detail2){
        query6OfwTime.setText(Long.toString(time1) + "ms");
        query6Total1.setText(Float.toString(detail1.get(1)));
        query6OfwAvg.setText(Float.toString(detail1.get(0)) + "/" + Float.toString(detail1.get(2) * 100) + "%") ;
        
        query6NonOfwTime.setText(Long.toString(time2) + "ms");
        query6Total2.setText(Float.toString(detail1.get(1)));
        query6NonOfwAvg.setText(Float.toString(detail2.get(0)) + "/" + Float.toString(detail2.get(2) * 100) + "%") ;
    }
    
    public void updateQuery6Tables(ArrayList<Query6> ofw, ArrayList<Query6> nonOfw){
        Object temp[];
        
        query6OfwModel.getDataVector().removeAllElements();
        query6NonOfwModel.getDataVector().removeAllElements();
        query6OfwModel.fireTableDataChanged();
        query6NonOfwModel.fireTableDataChanged();
        
        for(int i = 0; i < ofw.size(); i++) {
            temp = new Object[]{ofw.get(i).getId(),
                                ofw.get(i).getNofw(),
                                ofw.get(i).getCropCount()};
            
            query6OfwModel.addRow(temp);
        }
        
        for(int i = 0; i < nonOfw.size(); i++) {
            temp = new Object[]{nonOfw.get(i).getId(),
                                nonOfw.get(i).getNofw(),
                                nonOfw.get(i).getCropCount()};
            
            query6NonOfwModel.addRow(temp);
        }
    }
    
    public void updateQuery7Details(long time1, float total, float cshwrk, float fudwrk, float fudsch){
        query7ResultTime.setText(Long.toString(time1) + "ms");
        query7Total.setText(Float.toString(total));
        query7CshWrkAvg.setText(Float.toString(cshwrk) + "/" + Float.toString((cshwrk/total) * 100) + "%" );
        query7FudWrkAvg.setText(Float.toString(fudwrk) + "/" + Float.toString((fudwrk/total) * 100) + "%" );
        query7FudSchAvg.setText(Float.toString(fudsch) + "/" + Float.toString((fudsch/total) * 100) + "%" );      
    }
    
    public void updateQuery7Tables(ArrayList<Query7> res){
        Object temp[];
        
        query7Model.getDataVector().removeAllElements();
        query7Model.fireTableDataChanged();
        
        for(int i = 0; i < res.size(); i++) {
            temp = new Object[]{res.get(i).getId(),
                                res.get(i).getCshWrkCount(),
                                res.get(i).getFudWrkCount(),
                                res.get(i).getFudSchCount()};
            
            query7Model.addRow(temp);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JTabbedPane();
        query1Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane9 = new javax.swing.JScrollPane();
        query1NonOfwTable = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        query1OfwTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        query1StrongOfw = new javax.swing.JLabel();
        query1WeakOfw = new javax.swing.JLabel();
        query1TotalOfw = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        query1WeakNonOfw = new javax.swing.JLabel();
        query1StrongNonOfw = new javax.swing.JLabel();
        query1TotalNonOfw = new javax.swing.JLabel();
        query1Execute = new javax.swing.JButton();
        query1OfwTime = new javax.swing.JLabel();
        query1NonOfwTime = new javax.swing.JLabel();
        query2Panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        query2EmpAvg = new javax.swing.JLabel();
        query2NeitherAvg = new javax.swing.JLabel();
        query2EducAvg = new javax.swing.JLabel();
        query2TotalMarried = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        query2Table = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        query2ResultTime = new javax.swing.JLabel();
        query2EmployBox = new javax.swing.JComboBox();
        query2EducBox = new javax.swing.JComboBox();
        query2AgeBox = new javax.swing.JTextField();
        query2Execute = new javax.swing.JButton();
        query3Panel = new javax.swing.JPanel();
        query3TotalMaids1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        query3NonOfwTable = new javax.swing.JTable();
        query3OfwTime = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        query3OfwTable = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        query3NonOfwMaidsAvg = new javax.swing.JLabel();
        query3NonOfwTime = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        query3TotalMaids2 = new javax.swing.JLabel();
        query3Execute = new javax.swing.JButton();
        query3OfwMaidsAvg = new javax.swing.JLabel();
        query4panel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        query4Table = new javax.swing.JTable();
        query4FrequencyBox = new javax.swing.JTextField();
        query4CalamityBox = new javax.swing.JComboBox();
        query4ResultTime = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        query4DeathAvg = new javax.swing.JLabel();
        query4TotalDeath = new javax.swing.JLabel();
        query4Execute = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        query5Panel = new javax.swing.JPanel();
        query5ResultTime = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        query5Execute = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        query5Table = new javax.swing.JTable();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        query5WeakAvg = new javax.swing.JLabel();
        query5StrongAvg = new javax.swing.JLabel();
        query5Total = new javax.swing.JLabel();
        query6Panel = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        query6Execute = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        query6NonOfwAvg = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        query6NonOfwTime = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        query6NonOfwTable = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        query6Total2 = new javax.swing.JLabel();
        query6OfwTime = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        query6OfwAvg = new javax.swing.JLabel();
        query6Total1 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        query6OfwTable = new javax.swing.JTable();
        query7Panel = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        query7FudSchAvg = new javax.swing.JLabel();
        query7FudWrkAvg = new javax.swing.JLabel();
        query7CshWrkAvg = new javax.swing.JLabel();
        query7Execute = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        query7Table = new javax.swing.JTable();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        query7Total = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        query7ResultTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Original Queries");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Average House Materials of Households with OFWs");

        query1NonOfwTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
            },
            new String [] {
                "id", "nofw", "roof", "wall"

            }){
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }}
            );
            jScrollPane9.setViewportView(query1NonOfwTable);

            query1OfwTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String [] {
                    "id", "nofw", "roof", "wall"
                }){
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }}
                );
                jScrollPane10.setViewportView(query1OfwTable);

                jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                jLabel3.setText("OFW Households:");

                jLabel4.setText("Total: ");

                jLabel2.setText("Strong Construction:");

                jLabel5.setText("Weak Construction:");

                query1StrongOfw.setText("value");

                query1WeakOfw.setText("value");

                query1TotalOfw.setText("value");

                jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                jLabel9.setText("Non-OFW Households:");

                jLabel10.setText("Total: ");

                jLabel11.setText("Strong Construction:");

                jLabel12.setText("Weak Construction:");

                query1WeakNonOfw.setText("value");

                query1StrongNonOfw.setText("value");

                query1TotalNonOfw.setText("value");

                query1Execute.setText("Execute");
                query1Execute.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        query1ExecuteActionPerformed(evt);
                    }
                });

                query1OfwTime.setText("value");

                query1NonOfwTime.setText("value");

                javax.swing.GroupLayout query1PanelLayout = new javax.swing.GroupLayout(query1Panel);
                query1Panel.setLayout(query1PanelLayout);
                query1PanelLayout.setHorizontalGroup(
                    query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(query1PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(query1PanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(query1Execute))
                            .addGroup(query1PanelLayout.createSequentialGroup()
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(query1PanelLayout.createSequentialGroup()
                                        .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(query1PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(query1WeakOfw))
                                            .addGroup(query1PanelLayout.createSequentialGroup()
                                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(query1OfwTime)
                                                    .addComponent(query1TotalOfw)
                                                    .addComponent(query1StrongOfw))))
                                        .addGap(18, 18, 18)
                                        .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(query1PanelLayout.createSequentialGroup()
                                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(query1TotalNonOfw)
                                                    .addComponent(query1StrongNonOfw)))
                                            .addGroup(query1PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(query1NonOfwTime))
                                            .addGroup(query1PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(query1WeakNonOfw))
                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                query1PanelLayout.setVerticalGroup(
                    query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, query1PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(query1Execute))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(query1PanelLayout.createSequentialGroup()
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(query1OfwTime))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(query1TotalOfw))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(query1StrongOfw))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(query1WeakOfw)))
                            .addGroup(query1PanelLayout.createSequentialGroup()
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(query1NonOfwTime))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(query1TotalNonOfw))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(query1StrongNonOfw))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(query1WeakNonOfw))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(query1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                );

                mainPanel.addTab("Query 1", query1Panel);

                jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                jLabel6.setText("Average Educational/Work Status of Married People in a Certain Age");

                jLabel8.setText("Total: ");

                jLabel13.setText("In education:");

                jLabel14.setText("In employment:");

                query2EmpAvg.setText("value");

                query2NeitherAvg.setText("value");

                query2EducAvg.setText("value");

                query2TotalMarried.setText("value");

                query2Table.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                    },
                    new String [] {
                        "id", "civstat", "age_yr", "jobind", "educind"
                    }){
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return false;
                        }}
                    );
                    jScrollPane11.setViewportView(query2Table);

                    jLabel15.setText("Neither:");

                    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    jLabel7.setText("Result Time:");

                    jLabel16.setText("Age:");

                    jLabel17.setText("Employed:");

                    jLabel18.setText("Education:");

                    query2ResultTime.setText("value");

                    query2EmployBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No"}));

                    query2EducBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

                    query2Execute.setText("Execute");
                    query2Execute.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            query2ExecuteActionPerformed(evt);
                        }
                    });

                    javax.swing.GroupLayout query2PanelLayout = new javax.swing.GroupLayout(query2Panel);
                    query2Panel.setLayout(query2PanelLayout);
                    query2PanelLayout.setHorizontalGroup(
                        query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(query2PanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(query2PanelLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(query2ResultTime))
                                .addGroup(query2PanelLayout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(16, 16, 16)
                                    .addComponent(query2EducBox, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(query2PanelLayout.createSequentialGroup()
                                    .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel16))
                                    .addGap(17, 17, 17)
                                    .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(query2EmployBox, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(query2AgeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(query2EmpAvg)
                                .addComponent(query2NeitherAvg)
                                .addComponent(query2TotalMarried)
                                .addComponent(query2EducAvg))
                            .addContainerGap(284, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, query2PanelLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(query2Execute)
                            .addContainerGap())
                        .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(query2PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane11)
                                    .addGroup(query2PanelLayout.createSequentialGroup()
                                        .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator2)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 82, Short.MAX_VALUE)))
                                .addContainerGap()))
                    );
                    query2PanelLayout.setVerticalGroup(
                        query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(query2PanelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(query2Execute)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(query2TotalMarried)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(query2ResultTime))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(query2EducAvg)
                                .addComponent(jLabel13)
                                .addComponent(jLabel16)
                                .addComponent(query2AgeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(query2EmpAvg)
                                .addComponent(jLabel14)
                                .addComponent(jLabel17)
                                .addComponent(query2EmployBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(query2NeitherAvg)
                                .addComponent(jLabel15)
                                .addComponent(jLabel18)
                                .addComponent(query2EducBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(347, Short.MAX_VALUE))
                        .addGroup(query2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(query2PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()))
                    );

                    mainPanel.addTab("Query 2", query2Panel);

                    query3TotalMaids1.setText("value");

                    jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    jLabel19.setText("Non-OFW Households:");

                    jLabel20.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                    jLabel20.setText("Average Number of Maids Hired by OFWs vs Non-OFWS");

                    jLabel21.setText("Total: ");

                    jLabel22.setText("Hired by non-OFW households:");

                    query3NonOfwTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null},
                            {null, null},
                            {null, null},
                            {null, null},
                        },
                        new String [] {
                            "DISTINCT(MAID.id)", " COUNT(MAID.id)"
                        }){
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }}
                        );
                        jScrollPane12.setViewportView(query3NonOfwTable);

                        query3OfwTime.setText("value");

                        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                        jLabel24.setText("OFW Households:");

                        query3OfwTable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {
                                {null, null},
                                {null, null},
                                {null, null},
                                {null, null},
                            },
                            new String [] {
                                "DISTINCT(MAID.id)", "COUNT(MAID.id)"
                            }){
                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return false;
                                }}
                            );
                            jScrollPane13.setViewportView(query3OfwTable);

                            jLabel25.setText("Total: ");

                            query3NonOfwMaidsAvg.setText("value");

                            query3NonOfwTime.setText("value");

                            jLabel26.setText("Hired by OFW households:");

                            query3TotalMaids2.setText("value");

                            query3Execute.setText("Execute");
                            query3Execute.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    query3ExecuteActionPerformed(evt);
                                }
                            });

                            query3OfwMaidsAvg.setText("value");

                            javax.swing.GroupLayout query3PanelLayout = new javax.swing.GroupLayout(query3Panel);
                            query3Panel.setLayout(query3PanelLayout);
                            query3PanelLayout.setHorizontalGroup(
                                query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(query3PanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(query3PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(99, 99, 99)
                                                .addComponent(query3Execute))
                                            .addGroup(query3PanelLayout.createSequentialGroup()
                                                .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(query3PanelLayout.createSequentialGroup()
                                                        .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel26)
                                                            .addComponent(jLabel25)
                                                            .addComponent(jLabel24))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(query3OfwTime)
                                                            .addComponent(query3TotalMaids1)
                                                            .addComponent(query3OfwMaidsAvg))))
                                                .addGap(18, 18, 18)
                                                .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(query3PanelLayout.createSequentialGroup()
                                                        .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel22)
                                                            .addComponent(jLabel21)
                                                            .addComponent(jLabel19))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(query3NonOfwTime)
                                                            .addComponent(query3TotalMaids2)
                                                            .addComponent(query3NonOfwMaidsAvg)))))))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            query3PanelLayout.setVerticalGroup(
                                query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, query3PanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(query3Execute))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(query3PanelLayout.createSequentialGroup()
                                            .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel24)
                                                .addComponent(query3OfwTime))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel25)
                                                .addComponent(query3TotalMaids1))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel26)
                                                .addComponent(query3OfwMaidsAvg)))
                                        .addGroup(query3PanelLayout.createSequentialGroup()
                                            .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel19)
                                                .addComponent(query3NonOfwTime))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel21)
                                                .addComponent(query3TotalMaids2))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel22)
                                                .addComponent(query3NonOfwMaidsAvg))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(query3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addContainerGap())
                            );

                            mainPanel.addTab("Query 3", query3Panel);

                            query4panel.setPreferredSize(new java.awt.Dimension(542, 480));

                            jLabel23.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                            jLabel23.setText("Total Number of Deaths Caused by a Calamity Given its Frequency ");

                            jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jLabel31.setText("Result Time:");

                            jLabel33.setText("Calamity:");

                            jLabel32.setText("Frequency:");

                            query4Table.setModel(new javax.swing.table.DefaultTableModel(
                                new Object [][] {
                                    {null, null, null, null},
                                    {null, null, null, null},
                                    {null, null, null, null},
                                    {null, null, null, null},
                                },
                                new String [] {
                                    "id", "calamity", "frequency", "mdeady"
                                }){
                                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                                        return false;
                                    }}
                                );
                                jScrollPane14.setViewportView(query4Table);

                                query4CalamityBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bagyo", "Baha", "Tagtuyot", "Lindol", "Pagsabog ng Bulcan", "Landslide", "Tsunami", "Sunog", "Forest Fire", "Armadong Digmaan"}));

                                query4ResultTime.setText("value");

                                jLabel27.setText("Total: ");

                                jLabel28.setText("Average deaths:");

                                query4DeathAvg.setText("value");

                                query4TotalDeath.setText("value");

                                query4Execute.setText("Execute");
                                query4Execute.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        query4ExecuteActionPerformed(evt);
                                    }
                                });

                                javax.swing.GroupLayout query4panelLayout = new javax.swing.GroupLayout(query4panel);
                                query4panel.setLayout(query4panelLayout);
                                query4panelLayout.setHorizontalGroup(
                                    query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(query4panelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(query4panelLayout.createSequentialGroup()
                                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(query4panelLayout.createSequentialGroup()
                                                .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(query4panelLayout.createSequentialGroup()
                                                        .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(query4panelLayout.createSequentialGroup()
                                                                .addComponent(jLabel31)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                            .addGroup(query4panelLayout.createSequentialGroup()
                                                                .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel32)
                                                                    .addComponent(jLabel33))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(query4CalamityBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 121, Short.MAX_VALUE)
                                                            .addComponent(query4FrequencyBox, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(query4ResultTime, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(query4panelLayout.createSequentialGroup()
                                                                .addComponent(jLabel28)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(query4DeathAvg))
                                                            .addGroup(query4panelLayout.createSequentialGroup()
                                                                .addComponent(jLabel27)
                                                                .addGap(57, 57, 57)
                                                                .addComponent(query4TotalDeath)))
                                                        .addGap(167, 198, Short.MAX_VALUE))
                                                    .addGroup(query4panelLayout.createSequentialGroup()
                                                        .addComponent(jLabel23)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(query4Execute))
                                                    .addComponent(jScrollPane14))
                                                .addContainerGap())))
                                );
                                query4panelLayout.setVerticalGroup(
                                    query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(query4panelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel23)
                                            .addComponent(query4Execute))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addGroup(query4panelLayout.createSequentialGroup()
                                                .addComponent(query4ResultTime)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(query4CalamityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel33)
                                                    .addComponent(jLabel27)
                                                    .addComponent(query4TotalDeath))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(query4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(query4FrequencyBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel32)
                                                    .addComponent(jLabel28)
                                                    .addComponent(query4DeathAvg))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(13, Short.MAX_VALUE))
                                );

                                mainPanel.addTab("Query 4", query4panel);

                                query5ResultTime.setText("value");

                                jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                                jLabel30.setText(" House Materials of Households Focusing on Agricultural Livelihood");

                                jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                                jLabel35.setText("Result Time:");

                                query5Execute.setText("Execute");
                                query5Execute.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        query5ExecuteActionPerformed(evt);
                                    }
                                });

                                query5Table.setModel(new javax.swing.table.DefaultTableModel(
                                    new Object [][] {
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                    },
                                    new String [] {
                                        "id", "roof", "wall", "COUNT(AQUA.hpq_hh_id)", "COUNT(CROP.hpq_hh_id)"
                                    }){
                                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                            return false;
                                        }}
                                    );
                                    jScrollPane15.setViewportView(query5Table);

                                    jLabel38.setText("Total: ");

                                    jLabel39.setText("Weak Construction:");

                                    jLabel40.setText("Strong Construction:");

                                    query5WeakAvg.setText("value");

                                    query5StrongAvg.setText("value");

                                    query5Total.setText("value");

                                    javax.swing.GroupLayout query5PanelLayout = new javax.swing.GroupLayout(query5Panel);
                                    query5Panel.setLayout(query5PanelLayout);
                                    query5PanelLayout.setHorizontalGroup(
                                        query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(query5PanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(query5PanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel30)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                                    .addComponent(query5Execute))
                                                .addComponent(jScrollPane15)
                                                .addGroup(query5PanelLayout.createSequentialGroup()
                                                    .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(query5PanelLayout.createSequentialGroup()
                                                            .addComponent(jLabel39)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(query5WeakAvg))
                                                        .addGroup(query5PanelLayout.createSequentialGroup()
                                                            .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel40)
                                                                .addComponent(jLabel38)
                                                                .addComponent(jLabel35))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(query5ResultTime)
                                                                .addComponent(query5Total)
                                                                .addComponent(query5StrongAvg))))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addContainerGap())
                                    );
                                    query5PanelLayout.setVerticalGroup(
                                        query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(query5PanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel30)
                                                .addComponent(query5Execute))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel35)
                                                .addComponent(query5ResultTime))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel38)
                                                .addComponent(query5Total))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel40)
                                                .addComponent(query5StrongAvg))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(query5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel39)
                                                .addComponent(query5WeakAvg))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    );

                                    mainPanel.addTab("Query 5", query5Panel);

                                    jLabel34.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                                    jLabel34.setText("Average Number of Crop Types of OFW and Non-OFW ARCDP Mems");

                                    query6Execute.setText("Execute");
                                    query6Execute.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            query6ExecuteActionPerformed(evt);
                                        }
                                    });

                                    jLabel29.setText("Total ARCDP Members: ");

                                    jLabel36.setText("Total ARCDP Members: ");

                                    query6NonOfwAvg.setText("value");

                                    jLabel37.setText("Average Non-OFW Crop Count:");

                                    query6NonOfwTime.setText("value");

                                    query6NonOfwTable.setModel(new javax.swing.table.DefaultTableModel(
                                        new Object [][] {
                                            {null, null, null},
                                            {null, null, null},
                                            {null, null, null},
                                            {null, null, null},
                                        },
                                        new String [] {
                                            "id", "nofw", "COUNT(DISTINCT(CROP.croptype))"
                                        }){
                                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                return false;
                                            }}
                                        );
                                        jScrollPane16.setViewportView(query6NonOfwTable);

                                        jLabel41.setText("Average OFW Crop Count:");

                                        query6Total2.setText("value");

                                        query6OfwTime.setText("value");

                                        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                                        jLabel42.setText("OFW ARCDP Members:");

                                        query6OfwAvg.setText("value");

                                        query6Total1.setText("value");

                                        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                                        jLabel43.setText("Non-OFW ARCDP Members:");

                                        query6OfwTable.setModel(new javax.swing.table.DefaultTableModel(
                                            new Object [][] {
                                                {null, null, null},
                                                {null, null, null},
                                                {null, null, null},
                                                {null, null, null},
                                            },
                                            new String [] {
                                                "id", "nofw", "COUNT(DISTINCT(CROP.croptype))"
                                            }){
                                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                    return false;
                                                }}
                                            );
                                            jScrollPane17.setViewportView(query6OfwTable);

                                            javax.swing.GroupLayout query6PanelLayout = new javax.swing.GroupLayout(query6Panel);
                                            query6Panel.setLayout(query6PanelLayout);
                                            query6PanelLayout.setHorizontalGroup(
                                                query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(query6PanelLayout.createSequentialGroup()
                                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, query6PanelLayout.createSequentialGroup()
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(query6PanelLayout.createSequentialGroup()
                                                                    .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel41)
                                                                        .addComponent(jLabel36)
                                                                        .addComponent(jLabel42))
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(query6OfwTime)
                                                                        .addComponent(query6Total1)
                                                                        .addComponent(query6OfwAvg))))
                                                            .addGap(18, 18, 18)
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(query6PanelLayout.createSequentialGroup()
                                                                    .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel37)
                                                                        .addComponent(jLabel29)
                                                                        .addComponent(jLabel43))
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(query6NonOfwTime)
                                                                        .addComponent(query6Total2)
                                                                        .addComponent(query6NonOfwAvg)))))
                                                        .addGroup(query6PanelLayout.createSequentialGroup()
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(query6Execute)))
                                                    .addContainerGap())
                                            );
                                            query6PanelLayout.setVerticalGroup(
                                                query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(query6PanelLayout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel34)
                                                        .addComponent(query6Execute))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(query6PanelLayout.createSequentialGroup()
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel42)
                                                                .addComponent(query6OfwTime))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel36)
                                                                .addComponent(query6Total1))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel41)
                                                                .addComponent(query6OfwAvg)))
                                                        .addGroup(query6PanelLayout.createSequentialGroup()
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel43)
                                                                .addComponent(query6NonOfwTime))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel29)
                                                                .addComponent(query6Total2))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel37)
                                                                .addComponent(query6NonOfwAvg))))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(query6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                    .addContainerGap())
                                            );

                                            mainPanel.addTab("Query 6", query6Panel);

                                            jLabel44.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                                            jLabel44.setText("Average Type of Beneficiaries Joined per Household");

                                            jLabel45.setText("Average cash for work joined: ");

                                            jLabel46.setText("Average food for school joined:");

                                            jLabel47.setText("Average food for work joined:");

                                            query7FudSchAvg.setText("value");

                                            query7FudWrkAvg.setText("value");

                                            query7CshWrkAvg.setText("value");

                                            query7Execute.setText("Execute");
                                            query7Execute.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    query7ExecuteActionPerformed(evt);
                                                }
                                            });

                                            query7Table.setModel(new javax.swing.table.DefaultTableModel(
                                                new Object [][] {
                                                    {null, null, null},
                                                    {null, null, null},
                                                    {null, null, null},
                                                    {null, null, null},
                                                },
                                                new String [] {
                                                    "id", "cshforwrk", "fudforwrk", "fudforsch"
                                                }){
                                                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                        return false;
                                                    }}
                                                );
                                                jScrollPane18.setViewportView(query7Table);

                                                jLabel49.setText("Total number of households joined in at least 1 beneficiary:");

                                                query7Total.setText("value");

                                                jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                                                jLabel48.setText("Result Time:");

                                                query7ResultTime.setText("value");

                                                javax.swing.GroupLayout query7PanelLayout = new javax.swing.GroupLayout(query7Panel);
                                                query7Panel.setLayout(query7PanelLayout);
                                                query7PanelLayout.setHorizontalGroup(
                                                    query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(query7PanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(query7PanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel44)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                                                .addComponent(query7Execute))
                                                            .addComponent(jScrollPane18)
                                                            .addGroup(query7PanelLayout.createSequentialGroup()
                                                                .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGroup(query7PanelLayout.createSequentialGroup()
                                                                        .addComponent(jLabel49)
                                                                        .addGap(14, 14, 14)
                                                                        .addComponent(query7Total))
                                                                    .addGroup(query7PanelLayout.createSequentialGroup()
                                                                        .addComponent(jLabel48)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(query7ResultTime))
                                                                    .addGroup(query7PanelLayout.createSequentialGroup()
                                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel47)
                                                                            .addComponent(jLabel45)
                                                                            .addComponent(jLabel46))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(query7FudSchAvg)
                                                                            .addComponent(query7FudWrkAvg)
                                                                            .addComponent(query7CshWrkAvg))))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                        .addContainerGap())
                                                );
                                                query7PanelLayout.setVerticalGroup(
                                                    query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(query7PanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel44)
                                                            .addComponent(query7Execute))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel48)
                                                            .addComponent(query7ResultTime))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel49)
                                                            .addComponent(query7Total))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel45)
                                                            .addComponent(query7CshWrkAvg))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel47)
                                                            .addComponent(query7FudWrkAvg))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(query7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel46)
                                                            .addComponent(query7FudSchAvg))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                );

                                                mainPanel.addTab("Query 7", query7Panel);

                                                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                                                getContentPane().setLayout(layout);
                                                layout.setHorizontalGroup(
                                                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(mainPanel)
                                                );
                                                layout.setVerticalGroup(
                                                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(mainPanel)
                                                );

                                                pack();
                                            }// </editor-fold>//GEN-END:initComponents

    private void query1ExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query1ExecuteActionPerformed
        control.updateQuery1Tables();
        control.updateQuery1Details();
    }//GEN-LAST:event_query1ExecuteActionPerformed

    private void query2ExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query2ExecuteActionPerformed
        int educ = 0;
        int job = 0;
        
        if(query2EducBox.getSelectedItem().toString() == "Yes")
            educ = 1;
        else educ = 2;
        
        if(query2EmployBox.getSelectedItem().toString() == "Yes")
            job = 1;
        else job = 2;
        
        if(query2AgeBox.getText() == ""){
            JOptionPane.showMessageDialog(null, "Please input a valid age!", "Message", JOptionPane.ERROR_MESSAGE);
        } else{
            control.updateQuery2Tables(Integer.parseInt(query2AgeBox.getText()), educ, job);
            control.updateQuery2Details(Integer.parseInt(query2AgeBox.getText()), educ, job);
        }
    }//GEN-LAST:event_query2ExecuteActionPerformed

    private void query3ExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query3ExecuteActionPerformed
        control.updateQuery3Tables();
        control.updateQuery3Details();
    }//GEN-LAST:event_query3ExecuteActionPerformed

    private void query4ExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query4ExecuteActionPerformed
       int calam = 0;
        
       if(query4CalamityBox.getSelectedItem().toString() == "Bagyo")
           calam = 1;
       else if(query4CalamityBox.getSelectedItem().toString() == "Baha")
           calam = 2;
       else if(query4CalamityBox.getSelectedItem().toString() == "Tagtuyot")
           calam = 3;
       else if(query4CalamityBox.getSelectedItem().toString() == "Lindol")
           calam = 4;
       else if(query4CalamityBox.getSelectedItem().toString() == "Pagsabog ng Bulcan")
           calam = 5;
       else if(query4CalamityBox.getSelectedItem().toString() == "Landslide")
           calam = 6;
       else if(query4CalamityBox.getSelectedItem().toString() == "Tsunami")
           calam = 7;
       else if(query4CalamityBox.getSelectedItem().toString() == "Sunog")
           calam = 8;
       else if(query4CalamityBox.getSelectedItem().toString() == "Forest Fire")
           calam = 9;
       else if(query4CalamityBox.getSelectedItem().toString() == "Armadong Digmaan")
           calam = 10;
        
        if(query4FrequencyBox.getText() == ""){
            JOptionPane.showMessageDialog(null, "Please input a valid number!", "Message", JOptionPane.ERROR_MESSAGE);
        } else{
            control.updateQuery4Tables(calam, Integer.parseInt(query4FrequencyBox.getText()));
            control.updateQuery4Details(calam, Integer.parseInt(query4FrequencyBox.getText()));
        }
    }//GEN-LAST:event_query4ExecuteActionPerformed

    private void query5ExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query5ExecuteActionPerformed
        control.updateQuery5Tables();
        control.updateQuery5Details();
    }//GEN-LAST:event_query5ExecuteActionPerformed

    private void query6ExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query6ExecuteActionPerformed
        control.updateQuery6Tables();
        control.updateQuery6Details();
    }//GEN-LAST:event_query6ExecuteActionPerformed

    private void query7ExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query7ExecuteActionPerformed
        control.updateQuery7Tables();
        control.updateQuery7Details();
    }//GEN-LAST:event_query7ExecuteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JButton query1Execute;
    private javax.swing.JTable query1NonOfwTable;
    private javax.swing.JLabel query1NonOfwTime;
    private javax.swing.JTable query1OfwTable;
    private javax.swing.JLabel query1OfwTime;
    private javax.swing.JPanel query1Panel;
    private javax.swing.JLabel query1StrongNonOfw;
    private javax.swing.JLabel query1StrongOfw;
    private javax.swing.JLabel query1TotalNonOfw;
    private javax.swing.JLabel query1TotalOfw;
    private javax.swing.JLabel query1WeakNonOfw;
    private javax.swing.JLabel query1WeakOfw;
    private javax.swing.JTextField query2AgeBox;
    private javax.swing.JLabel query2EducAvg;
    private javax.swing.JComboBox query2EducBox;
    private javax.swing.JLabel query2EmpAvg;
    private javax.swing.JComboBox query2EmployBox;
    private javax.swing.JButton query2Execute;
    private javax.swing.JLabel query2NeitherAvg;
    private javax.swing.JPanel query2Panel;
    private javax.swing.JLabel query2ResultTime;
    private javax.swing.JTable query2Table;
    private javax.swing.JLabel query2TotalMarried;
    private javax.swing.JButton query3Execute;
    private javax.swing.JLabel query3NonOfwMaidsAvg;
    private javax.swing.JTable query3NonOfwTable;
    private javax.swing.JLabel query3NonOfwTime;
    private javax.swing.JLabel query3OfwMaidsAvg;
    private javax.swing.JTable query3OfwTable;
    private javax.swing.JLabel query3OfwTime;
    private javax.swing.JPanel query3Panel;
    private javax.swing.JLabel query3TotalMaids1;
    private javax.swing.JLabel query3TotalMaids2;
    private javax.swing.JComboBox query4CalamityBox;
    private javax.swing.JLabel query4DeathAvg;
    private javax.swing.JButton query4Execute;
    private javax.swing.JTextField query4FrequencyBox;
    private javax.swing.JLabel query4ResultTime;
    private javax.swing.JTable query4Table;
    private javax.swing.JLabel query4TotalDeath;
    private javax.swing.JPanel query4panel;
    private javax.swing.JButton query5Execute;
    private javax.swing.JPanel query5Panel;
    private javax.swing.JLabel query5ResultTime;
    private javax.swing.JLabel query5StrongAvg;
    private javax.swing.JTable query5Table;
    private javax.swing.JLabel query5Total;
    private javax.swing.JLabel query5WeakAvg;
    private javax.swing.JButton query6Execute;
    private javax.swing.JLabel query6NonOfwAvg;
    private javax.swing.JTable query6NonOfwTable;
    private javax.swing.JLabel query6NonOfwTime;
    private javax.swing.JLabel query6OfwAvg;
    private javax.swing.JTable query6OfwTable;
    private javax.swing.JLabel query6OfwTime;
    private javax.swing.JPanel query6Panel;
    private javax.swing.JLabel query6Total1;
    private javax.swing.JLabel query6Total2;
    private javax.swing.JLabel query7CshWrkAvg;
    private javax.swing.JButton query7Execute;
    private javax.swing.JLabel query7FudSchAvg;
    private javax.swing.JLabel query7FudWrkAvg;
    private javax.swing.JPanel query7Panel;
    private javax.swing.JLabel query7ResultTime;
    private javax.swing.JTable query7Table;
    private javax.swing.JLabel query7Total;
    // End of variables declaration//GEN-END:variables
}
