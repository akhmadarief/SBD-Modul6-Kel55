/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul6;

import TabelData.DataPlatform;
import TabelData.TabelPlatform;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class PlatformForm extends javax.swing.JFrame {

    /**
     * Creates new form PlateformForm
     */
    
    private String mf_kodeplatform;
    private String mf_platform;
    private String mf_rilis;
    private String output;
    private TabelPlatform tabelplatform;
    private dbconnections c;
    private Statement script;

    
    private void Tampil(){
        try {
            int row = tabel.getRowCount();
            for(int i=0;i<row;i++){
                tabelplatform.delete(0, row);
            }
            String sql="SELECT * from PLATFORM";
            ResultSet rsShow = c.script.executeQuery(sql);
            while(rsShow.next()){
                DataPlatform d = new DataPlatform();
                d.setKodeplatform(rsShow.getString("KODEPLATFORM"));
                d.setPlatform(rsShow.getString("PLATFORM"));
                d.setRilis(rsShow.getString("RILIS"));
                tabelplatform.add(d);
            }
        }catch(Exception e){
            System.err.print(e);
        }
    } 
        public String showPlatform(DataPlatform dm){
        kodeplatform.setText (dm.getKodeplatform());
        platform.setText (dm.getPlatform());
        rilis.setText (dm.getRilis());
        tambahplatform.setEnabled(false);
        return dm.getKodeplatform();
    }
    private void insertPlatform(){
        //mf_kodeplatform = kodeplatform.getText();
        mf_platform = platform.getText();
        mf_rilis = rilis.getText();
        if(platform!=null&&rilis!=null){
        try{
        String sql = "INSERT INTO PLATFORM (kodeplatform, platform, rilis) values (SEQ_MODUL6.nextval+1,'"+mf_platform+"','"+mf_rilis+"')";
        c.script.executeUpdate(sql);
        }catch(SQLException e){
        System.err.print(e);
        }
        Tampil();
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        clearForm();
        }else{
        JOptionPane.showMessageDialog(null,"Setiap kolom harus diisi!");
        }
    }

        private void deletePlatform(){
    int app;
    mf_kodeplatform = kodeplatform.getText();
    if ((app=JOptionPane.showConfirmDialog(null,"Yakin ingin hapus data?","Hapus Data", JOptionPane.YES_NO_OPTION))==0){
    try {
        String sqlid = "SELECT KODEPLATFORM from PLATFORM where KODEPLATFORM="+mf_kodeplatform+"";
        ResultSet rsShow = c.script.executeQuery(sqlid);
        while (rsShow.next()){
	output = rsShow.getString(1);
        }
        String sql = "DELETE from PLATFORM where kodeplatform ="+mf_kodeplatform+"";
        c.script.executeUpdate(sql);
        Tampil();
        JOptionPane.showMessageDialog (null,"Berhasil dihapus");
        clearForm();
        tampil1();
    }
    catch (SQLException e){
        System.err.print(e);
            }
        }
    }
    private void updatePlatform(String mf_kodeplatform){
        int app;
                       
        if((app = JOptionPane.showConfirmDialog(null, "Yakin ingin update data?","Ubah Data",JOptionPane.YES_NO_OPTION))==0){
        	try{ //Query untuk update pada table database
                    mf_kodeplatform = kodeplatform.getText();	
                    mf_platform = platform.getText();	
                    mf_rilis = rilis.getText();
                             
                    String sqlid = "SELECT KODEPLATFORM from PLATFORM where kodeplatform=" +mf_kodeplatform+ "";
                    ResultSet rsShow = c.script.executeQuery(sqlid);
                    while (rsShow.next()){
                    output = rsShow.getString(1);
                    } 
                        String sql = "UPDATE PLATFORM SET platform='"+mf_platform+"',rilis='"+mf_rilis+"' where kodeplatform="+mf_kodeplatform+"" ;
       			c.script.executeUpdate(sql);
        		Tampil();
                        tampil1();
		//menampilkan message dialog bahwa data telah update
        	JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
        		clearForm();
        	}
        	catch(SQLException ex){
        	System.err.print(ex);
        }
    }}
    
    /**
     * Creates new form MainForm
     */
    public PlatformForm() {
        initComponents();
        c = new dbconnections();
        tabelplatform = new TabelPlatform();
        tabel.setModel(tabelplatform);
        Tampil();

    }
    public void clearForm(){
        kodeplatform.setText (null);
        platform.setText (null);
        rilis.setText(null);
    }
    public void tampil1(){
    	tambahplatform.setEnabled(true);
    	hapusplatform.setEnabled(true);
    	perbaruiplatform.setEnabled(true);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        platform = new javax.swing.JTextField();
        rilis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        kodeplatform = new javax.swing.JLabel();
        tambahplatform = new javax.swing.JButton();
        perbaruiplatform = new javax.swing.JButton();
        hapusplatform = new javax.swing.JButton();
        kembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Platform", "Platform", "Tanggal Rilis"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jLabel1.setText("Platform");

        jLabel2.setText("Tanggal Rilis");

        rilis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rilisKeyTyped(evt);
            }
        });

        jLabel3.setText("Kode Platform:");

        kodeplatform.setText("0");

        tambahplatform.setText("Tambah");
        tambahplatform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahplatformActionPerformed(evt);
            }
        });

        perbaruiplatform.setText("Perbarui");
        perbaruiplatform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perbaruiplatformActionPerformed(evt);
            }
        });

        hapusplatform.setText("Hapus");
        hapusplatform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusplatformActionPerformed(evt);
            }
        });

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(kodeplatform)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(platform)
                                    .addComponent(rilis, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(tambahplatform)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kembali)
                                    .addComponent(perbaruiplatform))
                                .addGap(50, 50, 50)))
                        .addComponent(hapusplatform)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(platform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kodeplatform))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rilis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahplatform)
                    .addComponent(perbaruiplatform)
                    .addComponent(hapusplatform))
                .addGap(20, 20, 20)
                .addComponent(kembali)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void tambahplatformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahplatformActionPerformed
        // TODO add your handling code here:
        insertPlatform();
    }//GEN-LAST:event_tambahplatformActionPerformed

    private void perbaruiplatformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perbaruiplatformActionPerformed
        // TODO add your handling code here:
        mf_kodeplatform = kodeplatform.getText();
        updatePlatform(mf_kodeplatform);
    }//GEN-LAST:event_perbaruiplatformActionPerformed

    private void hapusplatformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusplatformActionPerformed
        // TODO add your handling code here:
        deletePlatform();
    }//GEN-LAST:event_hapusplatformActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
         showPlatform(this.tabelplatform.get(tabel.getSelectedRow()));
         tambahplatform.setEnabled(false);
         hapusplatform.setEnabled(true);
         perbaruiplatform.setEnabled(true);
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void rilisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rilisKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_rilisKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlatformForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlatformForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlatformForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlatformForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlatformForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapusplatform;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel kodeplatform;
    private javax.swing.JButton perbaruiplatform;
    private javax.swing.JTextField platform;
    private javax.swing.JTextField rilis;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambahplatform;
    // End of variables declaration//GEN-END:variables
}
