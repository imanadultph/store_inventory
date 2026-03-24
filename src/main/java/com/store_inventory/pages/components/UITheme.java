package com.store_inventory.pages.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public final class UITheme {
  public static final Color BACKGROUND = new Color(246, 251, 255);
  public static final Color HEADER_BACKGROUND = new Color(252, 254, 255);
  public static final Color CARD_BACKGROUND = Color.WHITE;
  public static final Color BORDER = new Color(209, 213, 219);
  public static final Color PRIMARY = new Color(120, 179, 226);
  public static final Color PRIMARY_TEXT = new Color(25, 60, 85);
  public static final Color DARK_TEXT = new Color(28, 40, 50);
  public static final Color MUTED_TEXT = new Color(90, 110, 125);

  public static final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 24);
  public static final Font SUBTITLE_FONT =
      new Font("SansSerif", Font.PLAIN, 16);
  public static final Font LABEL_FONT = new Font("SansSerif", Font.PLAIN, 16);

  private UITheme() {}

  public static JPanel cardPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(CARD_BACKGROUND);
    panel.setBorder(new CompoundBorder(new LineBorder(BORDER, 1, true),
                                       new EmptyBorder(12, 12, 12, 12)));
    return panel;
  }

  public static JButton primaryButton(String text) {
    JButton button = new JButton(text);
    button.setBackground(PRIMARY);
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    button.setBorder(new EmptyBorder(6, 16, 6, 16));
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    return button;
  }

  public static JButton secondaryButton(String text) {
    JButton button = new JButton(text);
    button.setBackground(CARD_BACKGROUND);
    button.setForeground(PRIMARY_TEXT);
    button.setBorder(new LineBorder(BORDER, 2, true));
    button.setFocusPainted(false);
    button.setMargin(new Insets(4, 12, 4, 12));
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));

    return button;
  }
}
