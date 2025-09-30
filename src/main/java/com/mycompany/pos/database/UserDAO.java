package com.mycompany.pos.database;

import static com.mycompany.pos.database.DBConnection.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Nested class to represent a User
    public static class User {
        public String fullname;
        public String username;
        public String password;
        public String role;

        public User(String fullname, String username, String password, String role) {
            this.fullname = fullname;
            this.username = username;
            this.password = password;
            this.role = role;
        }
    }

    // ✅ Get All Users from DB
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT fullname, username, password, role FROM users")) {

            while (rs.next()) {
                String fullname = rs.getString("fullname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");

                users.add(new User(fullname, username, password, role));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public static boolean usernameExists(String username) {
    try (Connection con = getConnection();
         PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?")) {
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

    
    
    
    
    
    
    
    // ✅ Add a new user
    public static boolean addUser(User user) {
        String sql = "INSERT INTO users (fullname, username, password, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.fullname);
            stmt.setString(2, user.username);
            stmt.setString(3, user.password);
            stmt.setString(4, user.role);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ✅ Update existing user
    public static boolean updateUser(User user) {
        String sql = "UPDATE users SET fullname = ?, password = ?, role = ? WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.fullname);
            stmt.setString(2, user.password);
            stmt.setString(3, user.role);
            stmt.setString(4, user.username);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean deleteUserByUsername(String username) {
    String sql = "DELETE FROM users WHERE username = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, username);
        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
