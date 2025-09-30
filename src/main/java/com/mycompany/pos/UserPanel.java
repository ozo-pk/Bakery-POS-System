/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pos;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

/**
 *
 * @author HP
 */
public class UserPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserPanel
     */
    public UserPanel() {
        initComponents();
        loadUsersIntoTable();
        
        
        btnAddUser4.addActionListener(e -> handleAddUser()); // ✅ CORRECT PLACE
        btnUpdateUser.addActionListener(e -> handleUpdateUser());
        
        
        
tableUsers.getSelectionModel().addListSelectionListener(event -> {
    int row = tableUsers.getSelectedRow();
    if (row >= 0 && row < tableUsers.getRowCount()) {
        Object fullnameObj = tableUsers.getValueAt(row, 0);
        Object usernameObj = tableUsers.getValueAt(row, 1);
        Object passwordObj = tableUsers.getValueAt(row, 2);
        Object roleObj     = tableUsers.getValueAt(row, 3);

        // Check for nulls
        if (fullnameObj != null && usernameObj != null && passwordObj != null && roleObj != null) {
            txtFullName.setText(fullnameObj.toString());
            txtUsername.setText(usernameObj.toString());
            txtPassword.setText(passwordObj.toString());
            comboRole.setSelectedItem(roleObj.toString());

            txtUsername.setEditable(false); // lock username when editing
        }
    }
});

                
           // 🔽 PLACE THIS RIGHT HERE
    txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (Character.isUpperCase(c)) {
                evt.setKeyChar(Character.toLowerCase(c));
            }
        }
    });       
                    
        
        formPanel.setAlignmentY(TOP_ALIGNMENT);
        tablePanel.setAlignmentY(TOP_ALIGNMENT);
        
        // Style table header
tableUsers.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
tableUsers.getTableHeader().setBackground(new Color(46, 74, 98));  // Deep Slate Blue
tableUsers.getTableHeader().setForeground(Color.WHITE);
tableUsers.getTableHeader().setReorderingAllowed(false);  // Disable column drag
tableUsers.getTableHeader().setResizingAllowed(false);    // Disable resize

// Alternate row colors (zebra striping)
tableUsers.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
        
        java.awt.Component c = super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(230, 240, 250));
        }
        return c;
    }
});

// Optional: Set preferred column widths
tableUsers.getColumnModel().getColumn(0).setPreferredWidth(200); // Full Name
tableUsers.getColumnModel().getColumn(1).setPreferredWidth(200); // Username
tableUsers.getColumnModel().getColumn(2).setPreferredWidth(200); // Password
tableUsers.getColumnModel().getColumn(3).setPreferredWidth(150); // RoletableUsers.getColumnModel().getColumn(3).setPreferredWidth(150); // Role
} // <-- This ends the constructor


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        lblFullName = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblRole = new javax.swing.JLabel();
        comboRole = new javax.swing.JComboBox<>();
        btnUpdateUser = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAddUser4 = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        scrollPaneUsers = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1366, 700));

        mainPanel.setMaximumSize(new java.awt.Dimension(1366, 700));
        mainPanel.setMinimumSize(new java.awt.Dimension(1366, 700));
        mainPanel.setPreferredSize(new java.awt.Dimension(1366, 700));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.X_AXIS));

        formPanel.setBackground(new java.awt.Color(190, 208, 219));
        formPanel.setMaximumSize(new java.awt.Dimension(400, 360));
        formPanel.setMinimumSize(new java.awt.Dimension(400, 360));
        formPanel.setPreferredSize(new java.awt.Dimension(400, 360));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFullName.setText("Full Name: ");
        lblFullName.setPreferredSize(new java.awt.Dimension(90, 25));
        formPanel.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFullName.setPreferredSize(new java.awt.Dimension(240, 30));
        formPanel.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        lblUsername.setText("Username:");
        lblUsername.setPreferredSize(new java.awt.Dimension(90, 25));
        formPanel.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtUsername.setPreferredSize(new java.awt.Dimension(240, 30));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        formPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        lblPassword.setText("Password:");
        lblPassword.setMaximumSize(new java.awt.Dimension(90, 25));
        lblPassword.setMinimumSize(new java.awt.Dimension(90, 25));
        lblPassword.setPreferredSize(new java.awt.Dimension(90, 25));
        formPanel.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtPassword.setPreferredSize(new java.awt.Dimension(240, 30));
        formPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        lblRole.setText("Role:");
        lblRole.setPreferredSize(new java.awt.Dimension(90, 25));
        formPanel.add(lblRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        comboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Cashier" }));
        comboRole.setPreferredSize(new java.awt.Dimension(240, 30));
        formPanel.add(comboRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        btnUpdateUser.setBackground(new java.awt.Color(44, 88, 110));
        btnUpdateUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateUser.setText("Update");
        btnUpdateUser.setPreferredSize(new java.awt.Dimension(110, 35));
        formPanel.add(btnUpdateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        btnDelete.setBackground(new java.awt.Color(44, 88, 110));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(110, 35));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        formPanel.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        btnAddUser4.setBackground(new java.awt.Color(44, 88, 110));
        btnAddUser4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddUser4.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser4.setText("Add User");
        btnAddUser4.setPreferredSize(new java.awt.Dimension(110, 35));
        btnAddUser4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUser4ActionPerformed(evt);
            }
        });
        formPanel.add(btnAddUser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        btnClearForm.setBackground(new java.awt.Color(44, 88, 110));
        btnClearForm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearForm.setForeground(new java.awt.Color(255, 255, 255));
        btnClearForm.setText("Clear");
        btnClearForm.setPreferredSize(new java.awt.Dimension(110, 35));
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });
        formPanel.add(btnClearForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        mainPanel.add(formPanel);

        tablePanel.setMaximumSize(new java.awt.Dimension(950, 700));
        tablePanel.setMinimumSize(new java.awt.Dimension(950, 700));
        tablePanel.setPreferredSize(new java.awt.Dimension(950, 700));
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPaneUsers.setBackground(new java.awt.Color(190, 208, 219));
        scrollPaneUsers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 74, 98), 2));
        scrollPaneUsers.setMaximumSize(new java.awt.Dimension(920, 600));
        scrollPaneUsers.setMinimumSize(new java.awt.Dimension(920, 600));
        scrollPaneUsers.setPreferredSize(new java.awt.Dimension(920, 600));

        tableUsers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full Name", "Username", "Password", "Role"
            }
        ));
        tableUsers.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableUsers.setGridColor(new java.awt.Color(180, 180, 180));
        tableUsers.setRowHeight(28);
        tableUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableUsers.setShowHorizontalLines(true);
        scrollPaneUsers.setViewportView(tableUsers);

        tablePanel.add(scrollPaneUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        mainPanel.add(tablePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
         clearFormFields();  // ✅ This clears all fields in the form
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        btnDelete.addActionListener(e -> handleDeleteUser());
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddUser4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUser4ActionPerformed
         
    }//GEN-LAST:event_btnAddUser4ActionPerformed

private void loadUsersIntoTable() {
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tableUsers.getModel();
    model.setRowCount(0); // Clear existing rows

    List<com.mycompany.pos.database.UserDAO.User> users = com.mycompany.pos.database.UserDAO.getAllUsers();

    for (com.mycompany.pos.database.UserDAO.User user : users) {
        model.addRow(new Object[]{user.fullname, user.username, user.password, user.role});
    }
}

private void handleAddUser() {
    String fullname = txtFullName.getText().trim();
    String username = txtUsername.getText().trim();
    String password = new String(txtPassword.getPassword()).trim();
    String role = comboRole.getSelectedItem().toString();

    if (fullname.isEmpty() || username.isEmpty() || password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "All fields are required.");
        return;
    }

    // 🔒 Check if username already exists
    if (com.mycompany.pos.database.UserDAO.usernameExists(username)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Username already exists. Please choose another.");
        return;
    }

    // ✅ Create user and insert
    com.mycompany.pos.database.UserDAO.User user =
        new com.mycompany.pos.database.UserDAO.User(fullname, username, password, role);

    boolean success = com.mycompany.pos.database.UserDAO.addUser(user);

    if (success) {
        javax.swing.JOptionPane.showMessageDialog(this, "User added successfully.");
        loadUsersIntoTable();
        
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Failed to add user.");
    }
}


private void handleUpdateUser() {
    String fullname = txtFullName.getText().trim();
    String username = txtUsername.getText().trim();
    String password = new String(txtPassword.getPassword()).trim();
    String role = comboRole.getSelectedItem().toString();

    if (fullname.isEmpty() || username.isEmpty() || password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "All fields are required.");
        return;
    }

    com.mycompany.pos.database.UserDAO.User user =
        new com.mycompany.pos.database.UserDAO.User(fullname, username, password, role);

    boolean success = com.mycompany.pos.database.UserDAO.updateUser(user);

    if (success) {
        javax.swing.JOptionPane.showMessageDialog(this, "User updated successfully.");
        loadUsersIntoTable();
        
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Failed to update user.");
    }
}

private void handleDeleteUser() {
    int selectedRow = tableUsers.getSelectedRow();

    

    String username = tableUsers.getValueAt(selectedRow, 1).toString();

    int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this user?",
            "Confirm Delete", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        boolean success = com.mycompany.pos.database.UserDAO.deleteUserByUsername(username);
        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "User deleted successfully.");
            loadUsersIntoTable();
            clearFormFields();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to delete user.");
        }
    }
}

private void clearFormFields() {
    txtFullName.setText("");
    txtUsername.setText("");
     txtUsername.setEditable(true); // allow editing username when adding 
    txtPassword.setText("");
    comboRole.setSelectedIndex(0);
}





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser4;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdateUser;
    private javax.swing.JComboBox<String> comboRole;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPaneUsers;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
