package com.mycompany.pos;


import java.awt.*;
import javax.swing.*;

public class AdminDashboard extends javax.swing.JFrame {

    public AdminDashboard() {
        setUndecorated(true);
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        
        contentPanel.setLayout(new CardLayout());
        contentPanel.add(new POSPanel(), "pos");


        contentPanel.add(new InventoryPanel(), "inventory");
        contentPanel.add(new UserPanel(), "users");
        contentPanel.add(new ReportPanel(), "reports");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        backgroundPanel = new JPanel(new BorderLayout());

        // Create and configure sidePanel
        sidePanel = new JPanel(new GridLayout(0, 1)); // vertical layout
        sidePanel.setBackground(new Color(44, 88, 110));
        sidePanel.setPreferredSize(new Dimension(200, 0));

        btnPOS = createSideButton("POS");
        btnInventory = createSideButton("Inventory");
        btnUsers = createSideButton("Users");
        btnReports = createSideButton("Reports");
        btnLogout = createSideButton("Logout");

        sidePanel.add(btnPOS);
        sidePanel.add(btnInventory);
        sidePanel.add(btnUsers);
        sidePanel.add(btnReports);
        sidePanel.add(btnLogout);

        // Add action listeners
        btnPOS.addActionListener(e -> switchCard("pos"));
        btnInventory.addActionListener(e -> switchCard("inventory"));
        btnUsers.addActionListener(e -> switchCard("users"));
        btnReports.addActionListener(e -> switchCard("reports"));
        btnLogout.addActionListener(e -> {
    javax.swing.SwingUtilities.getWindowAncestor(btnLogout).dispose();  // Close current window
    new com.mycompany.pos.LoginPage().setVisible(true);                 // Open login form
});

        // Create content panel
        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBackground(new Color(190, 208, 219));

        // Add to backgroundPanel
        backgroundPanel.add(sidePanel, BorderLayout.WEST);
        backgroundPanel.add(contentPanel, BorderLayout.CENTER);

        getContentPane().add(backgroundPanel);
        pack();
    }

    private JButton createSideButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(44, 88, 110));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        return button;
    }

    private void switchCard(String name) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, name);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new AdminDashboard().setVisible(true));
    }

    private JPanel backgroundPanel;
    private JPanel sidePanel;
    private JPanel contentPanel;
    private JButton btnPOS;
    private JButton btnInventory;
    private JButton btnUsers;
    private JButton btnReports;
    private JButton btnLogout;
}
