package com.store_inventory.pages;

import com.store_inventory.pages.components.UITheme;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HomePage extends JPanel {
  public HomePage() {
    setLayout(new BorderLayout());
    setBackground(UITheme.BACKGROUND);

    JPanel content = new JPanel(new GridLayout(1, 2, 16, 16));
    content.setOpaque(false);
    content.setBorder(new EmptyBorder(20, 20, 20, 20));

    JPanel left = new JPanel();
    left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
    left.setBackground(UITheme.BACKGROUND);

    JLabel welcome = new JLabel("Welcome to the System");
    welcome.setFont(UITheme.TITLE_FONT);
    welcome.setAlignmentX(Component.LEFT_ALIGNMENT);

    JLabel hint = new JLabel("Here is a quick overview of your store.");
    hint.setFont(UITheme.SUBTITLE_FONT);
    hint.setForeground(UITheme.MUTED_TEXT);
    hint.setAlignmentX(Component.LEFT_ALIGNMENT);

    left.add(welcome);
    left.add(Box.createVerticalStrut(8));
    left.add(hint);
    left.add(Box.createVerticalStrut(12));

    JPanel statsPanel = UITheme.cardPanel();
    statsPanel.setOpaque(false);
    statsPanel.setBorder(null);
    statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
    statsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    statsPanel.add(new JLabel("Total Products: 120"));
    statsPanel.add(Box.createVerticalStrut(6));
    statsPanel.add(new JLabel("Total Inventory: 450"));
    statsPanel.add(Box.createVerticalStrut(6));
    statsPanel.add(new JLabel("Total Sales: $15,000"));
    left.add(statsPanel);
    left.add(Box.createVerticalStrut(12));

    JPanel right = UITheme.cardPanel();
    right.setLayout(new BorderLayout());
    ImageIcon icon = new ImageIcon(getClass().getResource("/assets/image.png"));
    Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);

    JLabel imageLabel = new JLabel(new ImageIcon(img));
    right.add(imageLabel, BorderLayout.CENTER);

    content.add(left);
    content.add(right);

    add(content, BorderLayout.CENTER);
  }
}
