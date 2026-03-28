package com.store_inventory.pages;

import com.store_inventory.pages.components.UITheme;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ProductsPage extends JPanel {
  public ProductsPage() {
    setLayout(new BorderLayout());
    setBackground(UITheme.BACKGROUND);

    JPanel content = new JPanel(new BorderLayout(0, 24));
    content.setOpaque(false);
    content.setBorder(new EmptyBorder(40, 20, 40, 20));

    JPanel topRow = new JPanel(new BorderLayout());
    topRow.setOpaque(false);

    JPanel headerText = new JPanel();
    headerText.setOpaque(false);
    headerText.setLayout(new BoxLayout(headerText, BoxLayout.Y_AXIS));

    JLabel title = new JLabel("Manage Products");
    title.setFont(
        UITheme.customFont(UITheme.FONT_FAMILY, UITheme.FONT_WEIGHT_TITLE, 32));
    JLabel description =
        new JLabel("Add, edit, and remove products from the inventory.");
    description.setFont(UITheme.SUBTITLE_FONT);
    description.setForeground(UITheme.MUTED_TEXT);

    headerText.add(title);
    headerText.add(Box.createVerticalStrut(6));
    headerText.add(description);
    topRow.add(headerText, BorderLayout.WEST);

    JButton addProduct = UITheme.primaryButton("Add Product");
    Border line = UITheme.roundedBorder(UITheme.BORDER, 1, 12);
    Border padding = new EmptyBorder(12, 16, 12, 16);
    addProduct.setBorder(new CompoundBorder(line, padding));

    JPanel buttonWrapper = new JPanel(new GridBagLayout());
    buttonWrapper.setOpaque(false);
    buttonWrapper.add(addProduct);

    topRow.add(buttonWrapper, BorderLayout.EAST);

    JPanel tableCard = UITheme.cardPanel();
    tableCard.setLayout(new BoxLayout(tableCard, BoxLayout.Y_AXIS));

    tableCard.add(tableHeader());
    tableCard.add(Box.createVerticalStrut(8));
    tableCard.add(
        tableRow("Wireless Earbuds", "101", "PHP 799", "32", "Audio"));
    tableCard.add(Box.createVerticalStrut(6));
    tableCard.add(
        tableRow("Bluetooth Speaker", "102", "PHP 1,299", "12", "Audio"));
    tableCard.add(Box.createVerticalStrut(6));
    tableCard.add(
        tableRow("Phone Case", "103", "PHP 249", "68", "Accessories"));
    tableCard.add(Box.createVerticalStrut(6));
    tableCard.add(
        tableRow("USB-C Charger", "104", "PHP 399", "45", "Accessories"));

    content.add(topRow, BorderLayout.NORTH);
    content.add(Box.createVerticalStrut(20));
    content.add(tableCard, BorderLayout.CENTER);

    JScrollPane scroll = new JScrollPane(content);
    scroll.setBorder(null);
    scroll.setOpaque(false);
    scroll.getViewport().setOpaque(false);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.getVerticalScrollBar().setUnitIncrement(16);

    add(scroll, BorderLayout.CENTER);
  }

  private JPanel tableHeader() {
    JPanel row = new JPanel(new GridLayout(1, 6, 8, 0));
    row.setOpaque(false);
    row.add(headerLabel("Name"));
    row.add(headerLabel("ID"));
    row.add(headerLabel("Price"));
    row.add(headerLabel("Quantity"));
    row.add(headerLabel("Category"));
    row.add(headerLabel("Actions"));
    return row;
  }

  private JPanel tableRow(String name, String id, String price, String stock,
                          String category) {
    JPanel row = new JPanel(new GridLayout(1, 6, 8, 0));
    row.setOpaque(false);
    row.add(cellLabel(name));
    row.add(cellLabel(id));
    row.add(cellLabel(price));
    row.add(cellLabel(stock));
    row.add(cellLabel(category));

    JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
    actions.setOpaque(false);
    actions.add(UITheme.secondaryButton("Edit"));
    actions.add(UITheme.secondaryButton("Delete"));

    JPanel actionsWrapper = new JPanel(new GridBagLayout());
    actionsWrapper.setOpaque(false);
    actionsWrapper.add(actions, new GridBagConstraints());
    row.add(actionsWrapper);

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
