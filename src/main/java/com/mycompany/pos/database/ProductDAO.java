package com.mycompany.pos.database;

import com.mycompany.pos.database.DBConnection;
import com.mycompany.pos.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        String query = "SELECT * FROM products";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String barcode = rs.getString("barcode");
                String category = rs.getString("category");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");

                Product product = new Product(id, name, barcode, category, price, stock);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
    
    public static boolean updateProduct(Product p) {
    String sql = "UPDATE products SET name = ?, barcode = ?, category = ?, price = ?, stock = ? WHERE id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, p.getName());
        stmt.setString(2, p.getBarcode());
        stmt.setString(3, p.getCategory());
        stmt.setDouble(4, p.getPrice());
        stmt.setInt(5, p.getStock());
        stmt.setInt(6, p.getId());  // use id for WHERE clause

        int rows = stmt.executeUpdate();
        return rows > 0; // true if update successful

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    

    public static boolean addProduct(Product p) {
        String sql = "INSERT INTO products (name, barcode, category, price, stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getName());
            stmt.setString(2, p.getBarcode());
            stmt.setString(3, p.getCategory());
            stmt.setDouble(4, p.getPrice());
            stmt.setInt(5, p.getStock());

            int rows = stmt.executeUpdate();
            return rows > 0; // return true if insert successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteProductById(int productId) {
    String sql = "DELETE FROM products WHERE id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, productId);

        int rows = stmt.executeUpdate();
        return rows > 0; // return true if delete successful

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    
    
    
}



