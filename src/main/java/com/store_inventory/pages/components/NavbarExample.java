package com.store_inventory.pages.components;

import java.awt.*;
import javax.swing.*;

public class NavbarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Navigation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create navigation bar
        JPanel navBar = new JPanel();
        JButton homeBtn = new JButton("Home");
        JButton aboutBtn = new JButton("About");
        JButton contactBtn = new JButton("Contact");

        navBar.add(homeBtn);
        navBar.add(aboutBtn);
        navBar.add(contactBtn);

        frame.add(navBar, BorderLayout.NORTH);

        // Create content panels
        JPanel contentPanel = new JPanel(new CardLayout());
        JPanel homePanel = new JPanel();
        JLabel homeLabel = new JLabel("Welcome to the Home Page");
        UITheme.themeLabel(homeLabel);
        homePanel.add(homeLabel);

        JPanel aboutPanel = new JPanel();
        JLabel aboutLabel = new JLabel("This is the About Page");
        UITheme.themeLabel(aboutLabel);
        aboutPanel.add(aboutLabel);

        JPanel contactPanel = new JPanel();
        JLabel contactLabel = new JLabel("Contact Page");
        UITheme.themeLabel(contactLabel);
        contactPanel.add(contactLabel);

        // Add panels to CardLayout
        contentPanel.add(homePanel, "home");
        contentPanel.add(aboutPanel, "about");
        contentPanel.add(contactPanel, "contact");

        frame.add(contentPanel, BorderLayout.CENTER);

        // Button actions to switch panels
        homeBtn.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentPanel.getLayout();
            cl.show(contentPanel, "home");
        });

        aboutBtn.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentPanel.getLayout();
            cl.show(contentPanel, "about");
        });

        contactBtn.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentPanel.getLayout();
            cl.show(contentPanel, "contact");
        });

        frame.setVisible(true);
    }
}
