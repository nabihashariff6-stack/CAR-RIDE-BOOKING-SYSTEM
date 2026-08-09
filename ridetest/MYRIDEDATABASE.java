package com.mycompany.ridetest;
import java.sql.*;


public class MYRIDEDATABASE {

    Connection conn;

    public MYRIDEDATABASE() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ridetestdata", "root", "AW4321#"  );
            Statement stmt=conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertRide(String name, String pickuppoint, String drop_location,
                           String payment, String ride, String driver,
                           String bank, double distance, double fare, double final_fare) {

        try {
            String sql = "INSERT INTO ridesdetails (name, pickuppoint, droppoint, payment, ride, driver, bank, distance, original_fare, final_fare) VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, pickuppoint);
            pst.setString(3, drop_location);
            pst.setString(4, payment);
            pst.setString(5, ride);
            pst.setString(6, driver);
            pst.setString(7, bank);
            pst.setDouble(8, distance);
            pst.setDouble(9, fare);
            pst.setDouble(10, final_fare);

            pst.executeUpdate();
            System.out.println("ride saved to database !!");

        } catch (Exception e) {
            System.out.println("insert failed !!");
            e.printStackTrace();
        }
    }
}