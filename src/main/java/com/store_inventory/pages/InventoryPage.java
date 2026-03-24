package com.store_inventory.pages;

import com.store_inventory.pages.components.UITheme;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InventoryPage extends JPanel {
  public InventoryPage() {
    setLayout(new BorderLayout());
    setBackground(UITheme.BACKGROUND);

    JPanel content = new JPanel(new BorderLayout(0, 16));
    content.setOpaque(false);
    content.setBorder(new EmptyBorder(20, 20, 20, 20));

    JPanel stats = new JPanel(new GridLayout(1, 4, 12, 12));
    stats.setOpaque(false);
    stats.add(statCard("Total Products", "152"));
    stats.add(statCard("In Stock", "96"));
    stats.add(statCard("Low Stock", "18"));
    stats.add(statCard("Out of Stock", "5"));

    JPanel stockLevels = UITheme.cardPanel();
    stockLevels.setLayout(new BoxLayout(stockLevels, BoxLayout.Y_AXIS));

    JLabel title = new JLabel("Stock Levels");
    title.setFont(UITheme.LABEL_FONT.deriveFont(Font.BOLD));
    title.setAlignmentX(Component.LEFT_ALIGNMENT);
    stockLevels.add(title);
    stockLevels.add(Box.createVerticalStrut(10));

    stockLevels.add(stockRow("Wireless Mouse", "12 units", "Aisle 3"));
    stockLevels.add(Box.createVerticalStrut(8));
    stockLevels.add(stockRow("USB-C Cable", "48 units", "Aisle 2"));
    stockLevels.add(Box.createVerticalStrut(8));
    stockLevels.add(stockRow("Laptop Stand", "7 units", "Aisle 5"));
    stockLevels.add(Box.createVerticalStrut(8));
    stockLevels.add(stockRow("Smart Bulb", "3 units", "Aisle 1"));

    content.add(stats, BorderLayout.NORTH);
    content.add(stockLevels, BorderLayout.CENTER);

    add(content, BorderLayout.CENTER);
  }

  private JPanel statCard(String label, String value) {
    JPanel card = UITheme.cardPanel();
    card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
    JLabel valueLabel = new JLabel(value);
    valueLabel.setFont(UITheme.TITLE_FONT);
    valueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    JLabel labelLabel = new JLabel(label);
    labelLabel.setFont(UITheme.SUBTITLE_FONT);
    labelLabel.setForeground(UITheme.MUTED_TEXT);
    labelLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    card.add(valueLabel);
    card.add(Box.createVerticalStrut(6));
    card.add(labelLabel);
    return card;
  }

  private JPanel stockRow(String name, String qty, String location) {
    JPanel row = new JPanel(new BorderLayout());
    row.setOpaque(false);
    JLabel left = new JLabel(name + " - " + qty);
    left.setFont(UITheme.LABEL_FONT);
    JLabel right = new JLabel(location);
    right.setFont(UITheme.SUBTITLE_FONT);
    right.setForeground(UITheme.MUTED_TEXT);
    row.add(left, BorderLayout.WEST);
    row.add(right, BorderLayout.EAST);
    return row;
  }
}
