package DoorApp;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoorJFrame extends javax.swing.JFrame {

    private String rename;
    protected String ok="0";

    public DoorJFrame() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        record = new javax.swing.JButton();
        add = new javax.swing.JButton();
        cardNumber = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        goBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        showPass = new javax.swing.JLabel();
        pass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        record.setText("紀錄");
        record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordActionPerformed(evt);
            }
        });

        add.setText("新增");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        cardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberActionPerformed(evt);
            }
        });

        delete.setText("刪除");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        goBack.setText("返回登入頁面");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });

        jLabel1.setText("管理用戶");

        pass.setText("開門");
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goBack)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(pass)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cardNumber)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(record, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goBack)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(record, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordActionPerformed
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/doorcontrol";
        String user = "root", passwd = "0000";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, passwd);

            Statement st = con.createStatement();
            String s = " SELECT * FROM record";
            PreparedStatement ps = con.prepareStatement(s);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String time = rs.getString("time");
                System.out.println("ID: " + name + "  Time: " + time);
            }
            System.out.println("-----------------------------------");
            con.close();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_recordActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        new AddFrame().setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_goBackActionPerformed

    private void cardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberActionPerformed

    }//GEN-LAST:event_cardNumberActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/doorcontrol";
        String user = "root", passwd = "0000";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, passwd);
            Statement st = con.createStatement();

            if (!cardNumber.getText().equals("")) {
                String s = " SELECT * FROM member";
                PreparedStatement ps = con.prepareStatement(s);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (cardNumber.getText().equals(rs.getString("card"))) {
                        ok = "1";
                        rename = rs.getString("name");
                        cardNumber.setText("");
                        showPass.setForeground(Color.BLUE);
                        showPass.setText("門已開啟!!");
                        break;
                    }
                }
                if (ok.equals("1")) {
                    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                    Date date = new Date();
                    String strDate = sdFormat.format(date);
                    String s2 = "INSERT INTO record (name,time) VALUES(?,?)";
                    PreparedStatement ps2 = con.prepareStatement(s2);
                    ps2.setString(1, rename);
                    ps2.setString(2, strDate);
                    ps2.executeUpdate();
                } else {
                    cardNumber.setText("");
                    showPass.setForeground(Color.RED);
                    showPass.setText("此卡尚未登記!!");
                }
            }
            con.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_passActionPerformed

    public static void main(String args[]) {
        DoorJFrame df = new DoorJFrame();
        df.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField cardNumber;
    private javax.swing.JButton delete;
    private javax.swing.JButton goBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton pass;
    private javax.swing.JButton record;
    private javax.swing.JLabel showPass;
    // End of variables declaration//GEN-END:variables
}
