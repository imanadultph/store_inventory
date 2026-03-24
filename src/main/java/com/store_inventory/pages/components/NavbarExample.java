package com.store_inventory.pages.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        homePanel.add(new JLabel("Welcome to the Home Page"));

        JPanel aboutPanel = new JPanel();
        aboutPanel.add(new JLabel("This is the About Page"));

        JPanel contactPanel = new JPanel();
        contactPanel.add(new JLabel("Contact Page"));

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