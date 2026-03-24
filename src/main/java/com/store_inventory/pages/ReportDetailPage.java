package com.store_inventory.pages;

import com.store_inventory.pages.components.UITheme;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ReportDetailPage extends JPanel {
  public ReportDetailPage() {
    setLayout(new BorderLayout());
    setBackground(UITheme.BACKGROUND);

    JPanel content = new JPanel();
    content.setOpaque(false);
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    content.setBorder(new EmptyBorder(20, 20, 20, 20));

    content.add(sectionHeader("Product List Report", "Save as"));
    content.add(Box.createVerticalStrut(8));
    content.add(tableSection(new String[] {"Product", "Stock", "Category",
                                           "Quantity", "Price"},
                             new String[][] {
                                 {"Wireless Earbuds", "In Stock", "Audio",
                                  "32", "PHP 799"},
                                 {"Bluetooth Speaker", "Low", "Audio", "8",
                                  "PHP 1,299"},
                                 {"Phone Case", "In Stock", "Accessories",
                                  "68", "PHP 249"},
                             }));
    content.add(Box.createVerticalStrut(16));
    content.add(sectionHeader("Sales Report", "Save as"));
    content.add(Box.createVerticalStrut(8));
    content.add(tableSection(
        new String[] {"Date", "Product", "Quantity", "Unit Price", "Total"},
        new String[][] {
            {"2026-03-19", "Wireless Mouse", "2", "PHP 799", "PHP 1,598"},
            {"2026-03-20", "USB-C Cable", "5", "PHP 199", "PHP 995"},
        }));
    content.add(Box.createVerticalStrut(16));
    content.add(sectionHeader("Inventory Report", "Save as"));
    content.add(Box.createVerticalStrut(8));
    content.add(tableSection(new String[] {"Item", "Qty", "Value"},
                             new String[][] {
                                 {"Laptop Stand", "7", "PHP 8,393"},
                                 {"Smart Bulb", "3", "PHP 1,497"},
                             }));

    add(content, BorderLayout.NORTH);
  }

  private JPanel sectionHeader(String title, String actionText) {
    JPanel row = new JPanel(new BorderLayout());
    row.setOpaque(false);
    JLabel label = new JLabel(title);
    label.setFont(UITheme.LABEL_FONT.deriveFont(Font.BOLD));
    JButton action = UITheme.secondaryButton(actionText);
    row.add(label, BorderLayout.WEST);
    row.add(action, BorderLayout.EAST);
    return row;
  }

  private JPanel tableSection(String[] headers, String[][] rows) {
    JPanel card = UITheme.cardPanel();
    card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

    JPanel headerRow = new JPanel(new GridLayout(1, headers.length, 8, 0));
    headerRow.setOpaque(false);
    for (String header : headers) {
      JLabel label = new JLabel(header);
      label.setFont(UITheme.LABEL_FONT.deriveFont(Font.BOLD));
      label.setForeground(UITheme.DARK_TEXT);
      headerRow.add(label);
    }
    card.add(headerRow);
    card.add(Box.createVerticalStrut(6));

    for (String[] row : rows) {
      JPanel rowPanel = new JPanel(new GridLayout(1, headers.length, 8, 0));
      rowPanel.setOpaque(false);
      for (String cell : row) {
        JLabel label = new JLabel(cell);
        label.setFont(UITheme.LABEL_FONT);
        label.setForeground(UITheme.MUTED_TEXT);
        rowPanel.add(label);
      }
      card.add(rowPanel);
      card.add(Box.createVerticalStrut(4));
    }
    return card;
  }
}
