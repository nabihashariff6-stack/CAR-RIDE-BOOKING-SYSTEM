/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ridetest;
/**
 *
 * @author ASPIRE 3
 */
import javax.swing.*;
import java.awt.*;
public class MyRide extends javax.swing.JFrame {
    String[] points = {"Home" , "Mall" , "University", "School" , "College" , "Supermarket",
                           "Office","Hospital"};

    /**
     * Creates new form MyRide
     */
    public MyRide() {
        initComponents();
        setSize(805, 678); 
        
        txtResult.setRows(15);
        txtResult.setColumns(40);
        cardnametxt.setVisible(false);
        cardnumtxt.setVisible(false);
        cvvtxt.setVisible(false);
        
        cardnamelabel.setVisible(false);
        cardnumlabel.setVisible(false);
        cvvlabel.setVisible(false);
        Paymentcombo.addActionListener(e -> {
    boolean isCard = Paymentcombo.getSelectedItem().equals("Card");

       cardnametxt.setVisible(isCard);
       cardnumtxt.setVisible(isCard);
       cvvtxt.setVisible(isCard);

       cardnamelabel.setVisible(isCard);
       cardnumlabel.setVisible(isCard);
       cvvlabel.setVisible(isCard);
});

        pickupcombo.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Home","Mall","University","School","College","Supermarket","Office","Hospital"}
        ));

        dropcombo.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Home","Mall","University","School","College","Supermarket","Office","Hospital"}
        ));

        comboride.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Car AC","Car Non AC","Bike","Rikshaw"}
        ));

        Paymentcombo.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Cash","Card"}
        ));
        
        updateDrivers();
    btncalc.addActionListener(e -> btncalcActionPerformed(e));
        comboride.addActionListener(e -> updateDrivers());
    }
    
    private void updateDrivers() {

        drivercombo.removeAllItems();

        String ride = (String) comboride.getSelectedItem();

        if (ride == null) return;

        if (ride.equals("Car AC")) {
            drivercombo.addItem("Abdul Majeed");
            drivercombo.addItem("Qasim Khan");
            drivercombo.addItem("Maaz Ahmed");
        } 
        
        else if (ride.equals("Car Non AC")) {
            drivercombo.addItem("Abdullah Ali");
            drivercombo.addItem("Sohaib Ahmed");
            drivercombo.addItem("Shahzaib");
        } 
        else if (ride.equals("Bike")) {
            drivercombo.addItem("Daniyal Ali");
            drivercombo.addItem("Momin Saqib");
            drivercombo.addItem("Bilal Chaudhary");
        } 
        else if (ride.equals("Rikshaw")) {
            drivercombo.addItem("Minhas Khan");
            drivercombo.addItem("Shehroze Ashraf");
        }
    }
    
    private void btncalcActionPerformed(java.awt.event.ActionEvent evt) {
        int num1 =   pickupcombo.getSelectedIndex();
        int num2 =   dropcombo.getSelectedIndex();
        

        String name = txtname.getText();
        String ride = (String) comboride.getSelectedItem();
        String driver = (String) drivercombo.getSelectedItem();
        String payment = (String) Paymentcombo.getSelectedItem();
        String bank = Banktxt.getText();
       

     if (payment.equals("Card")) {

       String cardName = cardnametxt.getText();
       String cardNumber = cardnumtxt.getText();
       String cvv = cvvtxt.getText();

    if (cardName.isEmpty() || cardNumber.isEmpty() || cvv.isEmpty()) {
        txtResult.setText("Error: Please enter card details!");
        return;
    }

    if (cvv.length() != 3) {
        txtResult.setText("Error: CVV must be 3 digits!");
        return;
    }
}
        
        double[] x = {2.1, 3.4 , 1.5 , 4.0 , 3.0 ,5.6 ,7.3,4.7};
        double[] y = {3.2 , 2.0 , 1.5 , 4.3 , 5.1 ,8.0 ,4.4 ,7.8};
        JDialog dialog = new JDialog(this, "Confirm Booking", true);

dialog.setSize(300, 150);
dialog.setLocationRelativeTo(this);
dialog.setLayout(new BorderLayout());

// Header
JPanel header = new JPanel();
header.setBackground(new Color(18, 122, 108));
header.setPreferredSize(new Dimension(300, 35));
JLabel title = new JLabel("  Confirm Booking");
title.setFont(new Font("Segoe UI", Font.BOLD, 14));
title.setForeground(Color.WHITE);
header.add(title);

// Message
JLabel msg = new JLabel("Do you want to confirm your ride booking?");
msg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
msg.setBorder(BorderFactory.createEmptyBorder(12, 12, 8, 12));

// Buttons Panel
JPanel btnPanel = new JPanel();
btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));

JButton noBtn = new JButton("No");
JButton yesBtn = new JButton("Yes, Book");

// Style buttons
noBtn.setBackground(Color.WHITE);
noBtn.setForeground(new Color(200, 60, 50));
noBtn.setBorder(BorderFactory.createLineBorder(new Color(200, 60, 50), 1));
noBtn.setFocusPainted(false);
noBtn.setPreferredSize(new Dimension(80, 30));

yesBtn.setBackground(new Color(18, 122, 108));
yesBtn.setForeground(Color.WHITE);
yesBtn.setBorderPainted(false);
yesBtn.setFocusPainted(false);
yesBtn.setPreferredSize(new Dimension(90, 30));

btnPanel.add(noBtn);
btnPanel.add(yesBtn);

dialog.add(header, BorderLayout.NORTH);
dialog.add(msg, BorderLayout.CENTER);
dialog.add(btnPanel, BorderLayout.SOUTH);

// Action handling
final boolean[] confirmed = {false};

yesBtn.addActionListener(e -> {
    confirmed[0] = true;
    dialog.dispose();
});

noBtn.addActionListener(e -> dialog.dispose());

dialog.setVisible(true);

if (!confirmed[0]) {
    txtResult.setText("Ride cancelled.");
    return;
}
         
        Ride ride1 = null;
        
        if (ride.equals("Car AC")) {
            ride1 = new CarAC(points[num1], points[num2], name);
        }
        else if (ride.equals("Car Non AC")) {
            ride1 = new CarNonAC(points[num1], points[num2], name);
        }
        else if (ride.equals("Bike")) {
            ride1 = new Bike(points[num1], points[num2], name);
        }
        else if (ride.equals("Rikshaw")) {
            ride1 = new Rikshaw(points[num1], points[num2], name);
        }
        
        if (ride1 == null) {
        txtResult.setText("Error: Ride not selected properly");
        return;
    }

        // ---------------- DISTANCE (FROM OOP CLASS) ----------------
        double distance = ride1.CalculateDistance(num1, num2, x, y);
         double fare = ride1.CalculateFare(distance);
         double originalFare = fare;
         double finalFare = fare;
        
         if (payment.equals("Card")) {
            if (bank.equalsIgnoreCase("Bank Al Falah")) fare *= 0.80;
            else if (bank.equalsIgnoreCase("Bank Al Habib")) fare *= 0.65;
            else if (bank.equalsIgnoreCase("Faisal Bank")) fare *= 0.50;
        }
        
        txtResult.setText(
            "===== RIDE RECEIPT =====\n\n" +
            "Name: " + name + "\n" +
            "Ride Type: " + ride + "\n" +
            "Driver: " + driver + "\n" +
            "Payment: " + payment + "\n" +
            "Bank: " + bank + "\n\n" +
            "Distance: " + distance + "\n" +
            "Original Fare: " + originalFare + "\n" +
            "Final Fare : " + fare + "\n\n" +
            "========================"
        );
        finalFare=fare;
        MYRIDEDATABASE db = new MYRIDEDATABASE();

db.insertRide(
    name,
    points[num1],
    points[num2],
    payment,
    ride,
    driver,
    bank,
    distance,
    originalFare,
    finalFare
);
    }
        
    private void comborideActionPerformed(java.awt.event.ActionEvent evt) {
        updateDrivers();
    }


    

   
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pickupcombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dropcombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboride = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        drivercombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Paymentcombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        Banktxt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        btncalc = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        cardnamelabel = new javax.swing.JLabel();
        cardnametxt = new javax.swing.JTextField();
        cardnumlabel = new javax.swing.JLabel();
        cardnumtxt = new javax.swing.JTextField();
        cvvlabel = new javax.swing.JLabel();
        cvvtxt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 122, 108));
        jLabel1.setText("Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txtname.setBackground(new java.awt.Color(203, 255, 249));
        txtname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 290, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(18, 122, 108));
        jLabel2.setText("pickup:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        pickupcombo.setBackground(new java.awt.Color(203, 255, 249));
        pickupcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pickupcombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        pickupcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickupcomboActionPerformed(evt);
            }
        });
        getContentPane().add(pickupcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 110, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 122, 108));
        jLabel3.setText("drop:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, 31));

        dropcombo.setBackground(new java.awt.Color(203, 255, 249));
        dropcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dropcombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        dropcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropcomboActionPerformed(evt);
            }
        });
        getContentPane().add(dropcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(18, 122, 108));
        jLabel4.setText("Ride Type:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        comboride.setBackground(new java.awt.Color(203, 255, 249));
        comboride.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboride.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        getContentPane().add(comboride, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 110, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 122, 108));
        jLabel5.setText("Driver:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        drivercombo.setBackground(new java.awt.Color(203, 255, 249));
        drivercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        drivercombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        getContentPane().add(drivercombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 110, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(18, 122, 108));
        jLabel6.setText("Payment:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        Paymentcombo.setBackground(new java.awt.Color(203, 255, 249));
        Paymentcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Paymentcombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        getContentPane().add(Paymentcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 290, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(18, 122, 108));
        jLabel7.setText("Bank:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 49, -1));

        Banktxt.setBackground(new java.awt.Color(203, 255, 249));
        Banktxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        Banktxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanktxtActionPerformed(evt);
            }
        });
        getContentPane().add(Banktxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 110, 30));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 452, -1, 202));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 511, -1, -1));

        btncalc.setBackground(new java.awt.Color(18, 122, 108));
        btncalc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btncalc.setForeground(new java.awt.Color(255, 255, 255));
        btncalc.setText("BOOK RIDE");
        btncalc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(158, 217, 210)));
        btncalc.setBorderPainted(false);
        btncalc.setOpaque(true);
        getContentPane().add(btncalc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 570, 130, 40));
        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 480, -1, -1));

        txtResult.setBackground(new java.awt.Color(232, 247, 245));
        txtResult.setColumns(20);
        txtResult.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtResult.setForeground(new java.awt.Color(18, 122, 108));
        txtResult.setRows(5);
        txtResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        jScrollPane9.setViewportView(txtResult);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 458, 210));

        cardnamelabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cardnamelabel.setForeground(new java.awt.Color(18, 122, 108));
        cardnamelabel.setText("Card Name:");
        getContentPane().add(cardnamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        cardnametxt.setBackground(new java.awt.Color(203, 255, 249));
        cardnametxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        getContentPane().add(cardnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 110, 30));

        cardnumlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cardnumlabel.setForeground(new java.awt.Color(18, 122, 108));
        cardnumlabel.setText("Card Number:");
        getContentPane().add(cardnumlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        cardnumtxt.setBackground(new java.awt.Color(203, 255, 249));
        cardnumtxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        getContentPane().add(cardnumtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 110, 30));

        cvvlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cvvlabel.setForeground(new java.awt.Color(18, 122, 108));
        cvvlabel.setText("CVV:");
        getContentPane().add(cvvlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, -1, -1));

        cvvtxt.setBackground(new java.awt.Color(203, 255, 249));
        cvvtxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 234, 229)));
        getContentPane().add(cvvtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 110, 30));

        jPanel1.setBackground(new java.awt.Color(0, 137, 123));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("RIDE BOOKING");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SYSTEM");

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("OBJECT ORIENTED PROGRAMMING");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("X X X X");
        jLabel13.setPreferredSize(new java.awt.Dimension(125, 56));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(0, 393, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel10))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 190));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(18, 122, 108));
        jLabel11.setText("RIDE DETAILS");
        jLabel11.setPreferredSize(new java.awt.Dimension(85, 25));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/ridetest/img3.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 810, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dropcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dropcomboActionPerformed

    private void BanktxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanktxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BanktxtActionPerformed

    private void pickupcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickupcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pickupcomboActionPerformed

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
            java.util.logging.Logger.getLogger(MyRide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyRide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyRide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyRide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyRide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Banktxt;
    private javax.swing.JComboBox<String> Paymentcombo;
    private javax.swing.JButton btncalc;
    private javax.swing.JLabel cardnamelabel;
    private javax.swing.JTextField cardnametxt;
    private javax.swing.JLabel cardnumlabel;
    private javax.swing.JTextField cardnumtxt;
    private javax.swing.JComboBox<String> comboride;
    private javax.swing.JLabel cvvlabel;
    private javax.swing.JTextField cvvtxt;
    private javax.swing.JComboBox<String> drivercombo;
    private javax.swing.JComboBox<String> dropcombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JComboBox<String> pickupcombo;
    private javax.swing.JTextArea txtResult;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
