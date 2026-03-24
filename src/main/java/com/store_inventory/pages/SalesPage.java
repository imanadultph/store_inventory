package com.store_inventory.pages;

import com.store_inventory.pages.components.UITheme;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SalesPage extends JPanel {
  public SalesPage() {
    setLayout(new BorderLayout());
    setBackground(UITheme.BACKGROUND);

    JPanel content = new JPanel(new BorderLayout(0, 16));
    content.setOpaque(false);
    content.setBorder(new EmptyBorder(20, 20, 20, 20));

    JPanel stats = new JPanel(new GridLayout(1, 3, 12, 12));
    stats.setOpaque(false);
    stats.add(statCard("Total Sales", "PHP 42,580"));
    stats.add(statCard("Total Revenue", "PHP 58,900"));
    stats.add(statCard("Units Sold", "420"));

    JPanel tableCard = UITheme.cardPanel();
    tableCard.setLayout(new BoxLayout(tableCard, BoxLayout.Y_AXIS));

    tableCard.add(tableHeader());
    tableCard.add(Box.createVerticalStrut(8));
    tableCard.add(tableRow("2026-03-19", "Wireless Mouse", "2", "PHP 799",
                            "PHP 1,598"));
    tableCard.add(Box.createVerticalStrut(6));
    tableCard.add(tableRow("2026-03-19", "Laptop Stand", "1", "PHP 1,199",
                            "PHP 1,199"));
    tableCard.add(Box.createVerticalStrut(6));
    tableCard.add(tableRow("2026-03-20", "USB-C Cable", "5", "PHP 199",
                            "PHP 995"));

    content.add(stats, BorderLayout.NORTH);
    content.add(tableCard, BorderLayout.CENTER);

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

  private JPanel tableHeader() {
    JPanel row = new JPanel(new GridLayout(1, 5, 8, 0));
    row.setOpaque(false);
    row.add(headerLabel("Date"));
    row.add(headerLabel("Product"));
    row.add(headerLabel("Qty"));
    row.add(headerLabel("Unit Price"));
    row.add(headerLabel("Total"));
    return row;
  }

  private JPanel tableRow(String date, String product, String qty,
                          String unit, String total) {
    JPanel row = new JPanel(new GridLayout(1, 5, 8, 0));
    row.setOpaque(false);
    row.add(cellLabel(date));
    row.add(cellLabel(product));
    row.add(cellLabel(qty));
    row.add(cellLabel(unit));
    row.add(cellLabel(total));
    return row;
  }

  private JLabel headerLabel(String text) {
    JLabel label = new JLabel(text);
    label.setFont(UITheme.LABEL_FONT.deriveFont(Font.BOLD));
    label.setForeground(UITheme.DARK_TEXT);
    return label;
  }

  private JLabel cellLabel(String text) {
    JLabel label = new JLabel(text);
    label.setFont(UITheme.LABEL_FONT);
    label.setForeground(UITheme.MUTED_TEXT);
    return label;
  }
}
