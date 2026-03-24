package com.store_inventory.pages;

import com.store_inventory.pages.components.UITheme;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ReportsPage extends JPanel {
  private final NavigationHandler handler;

  public ReportsPage(NavigationHandler handler) {
    this.handler = handler;
    setLayout(new BorderLayout());
    setBackground(UITheme.BACKGROUND);

    JPanel content = new JPanel();
    content.setOpaque(false);
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    content.setBorder(new EmptyBorder(20, 20, 20, 20));

    content.add(reportCard("Product Report",
                           "View all product listings and pricing.",
                           "View Report"));
    content.add(Box.createVerticalStrut(12));
    content.add(reportCard("Sales Report",
                           "Review revenue, sales totals, and trends.",
                           "View Report"));
    content.add(Box.createVerticalStrut(12));
    content.add(reportCard("Inventory Report",
                           "Monitor stock levels, low stock, and value.",
                           "View Report"));

    add(content, BorderLayout.NORTH);
  }

  private JPanel reportCard(String title, String description, String action) {
    JPanel card = UITheme.cardPanel();
    card.setLayout(new BorderLayout(12, 0));

    JPanel left = new JPanel();
    left.setOpaque(false);
    left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
    JLabel titleLabel = new JLabel(title);
    titleLabel.setFont(UITheme.LABEL_FONT.deriveFont(Font.BOLD));
    JLabel descLabel = new JLabel(description);
    descLabel.setFont(UITheme.SUBTITLE_FONT);
    descLabel.setForeground(UITheme.MUTED_TEXT);
    left.add(titleLabel);
    left.add(Box.createVerticalStrut(4));
    left.add(descLabel);

    JButton view = UITheme.secondaryButton(action);
    view.addActionListener(e -> handler.navigate(Navigation.REPORT_DETAIL));

    card.add(left, BorderLayout.CENTER);
    card.add(view, BorderLayout.EAST);
    return card;
  }
}
