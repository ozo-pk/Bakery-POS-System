package com.mycompany.pos.database;

import com.mycompany.pos.database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDAO {

    public static void insertSale(String itemName, int quantity, double rate, double amount) {
        String sql = "INSERT INTO sales (item_name, quantity, rate, amount) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, itemName);
            stmt.setInt(2, quantity);
            stmt.setDouble(3, rate);
            stmt.setDouble(4, amount);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // You can show dialog here
        }
    }
}
