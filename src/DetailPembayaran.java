/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DetailPembayaran extends javax.swing.JFrame {

    /**
     * Creates new form DetailPembayaran
     */
    public Connection connection;
    public PreparedStatement pstm;
    public Statement statement;
    public ResultSet rs = null;
    public DetailPembayaran() {
        initComponents();
        this.setLocationRelativeTo(null);
        pembayaran();
        koneksi();
    }
    
    public void koneksi(){
        if(connection == null){
            try{
                String url = "jdbc:mysql://localhost:3306/serbatopup";                
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, "root", "");
                java.sql.Statement st = connection.createStatement();
                //JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
            } catch(ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal");
                e.printStackTrace();
            }
        }        
    }
    
    public static String ubahKeRupiah(int parm) {
        String mataUang = String.format(Locale.US, "%,d", parm);
        mataUang = mataUang.replaceAll(",",".");
        mataUang = "Rp " + mataUang;
        return mataUang;
    }

    public void pembayaran(){
        try {
                String url = "jdbc:mysql://localhost:3306/serbatopup";
                String sql = "SELECT * FROM ordertopup";
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(url, "root", "");
                }
                statement = connection.createStatement();
                rs = statement.executeQuery(sql);
                while (rs.next()) {
                    nama.setText(rs.getString("nama"));
                    noHp.setText(rs.getString("handpone"));
                    pesanan.setText(rs.getString("pesanan"));
                    nominal.setText(ubahKeRupiah(rs.getInt("harga")));
                    diskon.setText(ubahKeRupiah(rs.getInt("diskon")));
                    kode.setText(rs.getString("kode_pesanan"));
                    total.setText(ubahKeRupiah(rs.getInt("total_harga")));
                }
      
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTMetodePembayaran16 = new javax.swing.JLabel();
        jTMetodePembayaran17 = new javax.swing.JLabel();
        jTMetodePembayaran18 = new javax.swing.JLabel();
        jTMetodePembayaran19 = new javax.swing.JLabel();
        jTMetodePembayaran20 = new javax.swing.JLabel();
        jTMetodePembayaran21 = new javax.swing.JLabel();
        jTMetodePembayaran22 = new javax.swing.JLabel();
        jTMetodePembayaran23 = new javax.swing.JLabel();
        jTMetodePembayaran24 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        noHp = new javax.swing.JLabel();
        pesanan = new javax.swing.JLabel();
        nominal = new javax.swing.JLabel();
        diskon = new javax.swing.JLabel();
        kode = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTMetodePembayaran16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTMetodePembayaran16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTMetodePembayaran16.setText("DETAIL PEMBAYARAN");
        jPanel3.add(jTMetodePembayaran16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 400, -1));

        jTMetodePembayaran17.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jTMetodePembayaran17.setText("Nama                            :");
        jPanel3.add(jTMetodePembayaran17, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 82, -1, -1));

        jTMetodePembayaran18.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jTMetodePembayaran18.setText("ID/No Hp                     :");
        jPanel3.add(jTMetodePembayaran18, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 120, -1, -1));

        jTMetodePembayaran19.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jTMetodePembayaran19.setText("Jenis Top-Up                :");
        jPanel3.add(jTMetodePembayaran19, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 158, -1, -1));

        jTMetodePembayaran20.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jTMetodePembayaran20.setText("Nominal/Jenis Item     :");
        jPanel3.add(jTMetodePembayaran20, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 196, -1, -1));

        jTMetodePembayaran21.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jTMetodePembayaran21.setText("Diskon                           :");
        jPanel3.add(jTMetodePembayaran21, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 234, -1, -1));

        jTMetodePembayaran22.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jTMetodePembayaran22.setText("No/Kode Pembayaran  :");
        jPanel3.add(jTMetodePembayaran22, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 272, -1, -1));

        jTMetodePembayaran23.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jTMetodePembayaran23.setText("Total                              :");
        jPanel3.add(jTMetodePembayaran23, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 310, -1, -1));

        jTMetodePembayaran24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTMetodePembayaran24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTMetodePembayaran24.setText("TERIMAKASIH");
        jPanel3.add(jTMetodePembayaran24, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 370, 394, -1));

        nama.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        nama.setText("Umam");
        jPanel3.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        noHp.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        noHp.setText("08975329224");
        jPanel3.add(noHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        pesanan.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        pesanan.setText("Pulsa");
        jPanel3.add(pesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 155, -1, 30));

        nominal.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        nominal.setText("Rp 10.000");
        jPanel3.add(nominal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 195, -1, 30));

        diskon.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        diskon.setText("Rp 240");
        jPanel3.add(diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, 30));

        kode.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        kode.setText("08975329224");
        jPanel3.add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        total.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        total.setText("Rp 10.000");
        jPanel3.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DetailPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel diskon;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jTMetodePembayaran16;
    private javax.swing.JLabel jTMetodePembayaran17;
    private javax.swing.JLabel jTMetodePembayaran18;
    private javax.swing.JLabel jTMetodePembayaran19;
    private javax.swing.JLabel jTMetodePembayaran20;
    private javax.swing.JLabel jTMetodePembayaran21;
    private javax.swing.JLabel jTMetodePembayaran22;
    private javax.swing.JLabel jTMetodePembayaran23;
    private javax.swing.JLabel jTMetodePembayaran24;
    private javax.swing.JLabel kode;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel noHp;
    private javax.swing.JLabel nominal;
    private javax.swing.JLabel pesanan;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
