/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crude;

import Data.Select;
import Data.connex;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ANONYME
 */
public final class Entretien extends javax.swing.JInternalFrame {
 Connection conn = null;
     PreparedStatement pst = null;
     ResultSet rs = null;
      static String test2;
      static String tost2;
    /**
     * Creates new form Entretien
     */
    public Entretien() {
        conn = connex.ConnexionDB();
        remove_titre_bar();
        Affichage_Table3();
        initComponents();
    }
    
     void remove_titre_bar(){
     //pour effacer le titre de intrface ListMat et le remplacer par "information materiel"
    putClientProperty("Entretien.isPalette",Boolean.TRUE);
    getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    this.setBorder(null);
    
    }
      public void Affichage_Table3(){
         // 1)String requete="select * from materiel";:pour afficher le table1
         // 2)String requete="select nummat as 'NumMat',design as 'Design',caracteristique as 'Caracteristique' from materiel:permet de modifier le titre
        try{
            String requete=" select nummat as 'NumMateriel',numinter as 'NumIntervenant',date as 'DateIntervation' ,nbhers as 'NombreHeure' from entretien";
            pst=conn.prepareStatement(requete);
            rs=pst.executeQuery();
           Table3.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
           }catch(Exception e)
           {
               System.out.println(e);
                       
           }
    
    }
        public void Deplace(){
        
        try{
            int row = Table3.getSelectedRow();
            this.test2 =(Table3.getModel().getValueAt(row, 0).toString());
            String rqt = "select * from entretien where nummat  = '"+test2+"'";
            pst=conn.prepareStatement(rqt);
            rs=pst.executeQuery();
                if(rs.next()){
                
                 String t1 = rs.getString("nummat");
                 txtmatr.setText(t1);
                 String t2 = rs.getString("numinter");
                 txtintre.setText(t2);
                 String t3 = rs.getString("date");
                 txtdatr.setText(t3);
                 String t4 = rs.getString("nbhers");
                 txtherez.setText(t4);
                 
                }
            
            
           }catch(Exception e)
           {
               System.out.println(e);
                       
           }
    }
    public void efface_donn??e(){
    //prmet d'effacer definitivemant le donn??e dans le tableau
      txtmatr.setText("");
      txtintre.setText("");
      txtdatr.setText("");
      txtherez.setText("");
     
    
    }
      public String res_tabresult1(){
        //pour recuper la valeur dans le tableau
         return test2;
    
    }
     public String res(){
        //pour activer le bouton ajout et modif 
         return tost2;
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxmatra = new javax.swing.JComboBox<>();
        cbxintra = new javax.swing.JComboBox<>();
        txthera = new javax.swing.JTextField();
        txtdatra = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtmatr = new javax.swing.JTextField();
        txtintre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdatr = new javax.swing.JTextField();
        txtherez = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();

        setBorder(null);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setText("TABLE ENTRETIEN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jLabel2.setText("NumInter");

        jLabel3.setText("NumMat");

        jLabel4.setText("Date Intervation");

        jLabel5.setText("Nombre Heure");

        cbxmatra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selectionnez", "Mat01", "Mat02", "Mat03", "Mat04", "Mat05", "Mat06", "Mat07", "Mat08", "Mat09", "Mat010" }));

        cbxintra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selectionnez", "inter01", "inter02", "inter03", "inter04", "inter05", "inter06", "inter07", "inter08", "inter09", "inter10", " ", " " }));

        txtdatra.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setText("DELETE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("UPDATE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxmatra, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxintra, 0, 93, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txthera, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdatra, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(26, 26, 26)
                                .addComponent(jButton8))
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxmatra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxintra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdatra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        Table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table3);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel8.setText("Date Intervation:");

        txtmatr.setBackground(new java.awt.Color(240, 240, 240));
        txtmatr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtmatr.setForeground(new java.awt.Color(255, 0, 0));
        txtmatr.setBorder(null);

        txtintre.setBackground(new java.awt.Color(240, 240, 240));
        txtintre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtintre.setForeground(new java.awt.Color(255, 0, 0));
        txtintre.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel9.setText("Nombre Heure  :");

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel7.setText("NumMat           :");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel6.setText("NumInter          :");

        txtdatr.setBackground(new java.awt.Color(240, 240, 240));
        txtdatr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdatr.setForeground(new java.awt.Color(255, 0, 0));
        txtdatr.setBorder(null);

        txtherez.setBackground(new java.awt.Color(240, 240, 240));
        txtherez.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtherez.setForeground(new java.awt.Color(255, 0, 0));
        txtherez.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdatr, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtherez)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmatr, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(txtintre))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmatr, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtintre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdatr, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtherez, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(585, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String idr = cbxmatra.getSelectedItem().toString()+'-'+cbxintra.getSelectedItem().toString();
        String matra = cbxmatra.getSelectedItem().toString();
        String inz = cbxintra.getSelectedItem().toString();
        String Date = ((JTextField)txtdatra.getDateEditor().getUiComponent()).getText();
        String dar = txthera.getText();
        
         String sql = "insert into entretien (Ident,nummat,numinter,date,nbhers) values(?,?,?,?,?)";
         try{
         if(cbxmatra.getSelectedItem().equals("Selectionnez") || cbxintra.getSelectedItem().equals("Selectionnez") || Date.equals("") || dar.equals(""))
         { 
             JOptionPane.showMessageDialog(null, "Remplissez");
         }else{
         
           pst = conn.prepareStatement(sql);
                  pst.setString(1, idr);
                  pst.setString(2, matra);
                  pst.setString(3, inz);
                  pst.setString(4, Date);
                  pst.setString(5, dar);
                  pst.execute();
                  
                  //pour effacer
                  cbxmatra.setSelectedItem("Selectionnez");
                  cbxintra.setSelectedItem("Selectionnez");
                  txtdatra.setDateFormatString("");
                  txthera.setText("");
                  
                  JOptionPane.showMessageDialog(null, "Ajout reussi");

         }
         }catch(SQLException e)
         {
             e.printStackTrace();
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //effacer
        int line = Table3.getSelectedRow();
         if(line==-1)
         {
            JOptionPane.showMessageDialog(null, "Selectionnez une materiel ou une intrevant"); 
         }else{
        String aio = Table3.getValueAt(line, 0).toString();
        String haio=Table3.getValueAt(line, 1).toString();
        String sql="delete from entretien where nummat='"+aio+"' and numinter='"+haio+"'";
          try{
               pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Supprimer");
                Affichage_Table3();
          efface_donn??e();
          }catch(SQLException e){
              e.printStackTrace();
          }
         }
           
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //imprimer
        Document doc = new Document();
         String sq = "select * from entretien";
       
        
            try {
                 pst = conn.prepareStatement(sq);
                 rs = pst.executeQuery();
            
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\ANONYME\\Documents\\PDF\\Entretien.pdf"));
                doc.open();
                
                Image img = Image.getInstance("C:\\Users\\ANONYME\\Documents\\sary.jpg");
                img.scaleAbsoluteWidth(600);
                img.scaleAbsoluteHeight(92);
                img.setAlignment(Image.ALIGN_CENTER);
                doc.add(img);
                
                
                doc.add(new Paragraph(""));
                doc.add(new Paragraph("Liste Entretien :"));
                doc.add(new Paragraph("------------------------------------"));
                
                PdfPTable table = new PdfPTable(4);
                table.setWidthPercentage(100);
                
                PdfPCell cell;
                
                ////////////////////////////////////////////////////////////////////////
              
                cell= new PdfPCell(new Phrase("NumMat",FontFactory.getFont("Comis Sans MS",12)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
                
                cell= new PdfPCell(new Phrase("NumInter",FontFactory.getFont("Comis Sans MS",12)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
                
                cell= new PdfPCell(new Phrase("DateIntervation",FontFactory.getFont("Comis Sans MS",12)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
                
                cell= new PdfPCell(new Phrase("NombreHeure",FontFactory.getFont("Comis Sans MS",12)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
                
                /////////////////////////////////////////////////////////////////////////////
                while(rs.next()){
                    
                cell= new PdfPCell(new Phrase(rs.getString("nummat"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell= new PdfPCell(new Phrase(rs.getString("numinter"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell= new PdfPCell(new Phrase(rs.getString("date"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell= new PdfPCell(new Phrase(rs.getString("nbhers"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                }
               
                
                ////////////////////////////////////////////////////////////////////////
                
                doc.add(table);
                
                doc.close();
                Desktop.getDesktop().open(new File("C:\\Users\\ANONYME\\Documents\\PDF\\Entretien.pdf"));
           
            } catch (DocumentException | FileNotFoundException ex) {
                Logger.getLogger(Entretien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Entretien.class.getName()).log(Level.SEVERE, null, ex);
            }catch(SQLException el){
            el.printStackTrace();
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        ResultSet rs = Select.getData("select * from entretien");
        DefaultTableModel model = (DefaultTableModel)Table3.getModel();
        model.setRowCount(0);
          try{
              while(rs.next()){
                model.addRow(new Object[]{rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
              }
              rs.close();
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,e);
          }
    }//GEN-LAST:event_formComponentShown

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         String numOrdes=jTextField6.getText();
        ResultSet rs = Select.getData("select * from entretien where nummat like '%"+numOrdes+"%' or numinter like '%"+numOrdes+"%'");
        DefaultTableModel model = (DefaultTableModel)Table3.getModel();
        model.setRowCount(0);
          try{
              while(rs.next()){
                model.addRow(new Object[]{rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
              }
              rs.close();
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,e);
          }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         Affichage_Table3();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table3MouseClicked
        // TODO add your handling code here:
         Deplace();
    }//GEN-LAST:event_Table3MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         Up_Ent1 mat= new Up_Ent1();
        mat.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table3;
    private javax.swing.JComboBox<String> cbxintra;
    private javax.swing.JComboBox<String> cbxmatra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField txtdatr;
    private com.toedter.calendar.JDateChooser txtdatra;
    private javax.swing.JTextField txthera;
    private javax.swing.JTextField txtherez;
    private javax.swing.JTextField txtintre;
    private javax.swing.JTextField txtmatr;
    // End of variables declaration//GEN-END:variables
}
