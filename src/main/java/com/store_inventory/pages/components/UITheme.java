package com.store_inventory.pages.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.AbstractBorder;
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

  // FONT WEIGHTS
  public static final int FONT_WEIGHT_TITLE = Font.BOLD;
  public static final int FONT_WEIGHT_SUBTITLE = Font.PLAIN;
  public static final int FONT_WEIGHT_LABEL = Font.PLAIN;

  // FONT FAMILY
  public static final String FONT_FAMILY = "SansSerif";

  public static final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 24);
  public static final Font SUBTITLE_FONT =
      new Font("SansSerif", Font.PLAIN, 16);
  public static final Font LABEL_FONT = new Font("SansSerif", Font.PLAIN, 16);

  // font with custom font_family, weight, and size
  public static Font customFont(String family, int weight, int size) {
    return new Font(family, weight, size);
  }

  private UITheme() {}

  public static JPanel cardPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(CARD_BACKGROUND);
    panel.setBorder(new CompoundBorder(new LineBorder(BORDER, 1, true),
                                       new EmptyBorder(12, 12, 12, 12)));
    return panel;
  }

  public static JButton primaryButton(String text) {
    JButton button = new JButton(text) {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
        g2.dispose();
        super.paintComponent(g);
      }
    };
    button.setBackground(PRIMARY);
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    Border line = roundedBorder(BORDER, 2, 12);
    Border padding = new EmptyBorder(6, 16, 6, 16);
    button.setBorder(new CompoundBorder(line, padding));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    return button;
  }

  public static JButton secondaryButton(String text) {
    JButton button = new JButton(text) {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
        g2.dispose();
        super.paintComponent(g);
      }
    };
    button.setBackground(CARD_BACKGROUND);
    button.setForeground(PRIMARY_TEXT);
    button.setFocusPainted(false);
    Border line = roundedBorder(BORDER, 2, 12);
    Border padding = new EmptyBorder(6, 16, 6, 16);
    button.setBorder(new CompoundBorder(line, padding));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));

    return button;
  }

  public static Border roundedBorder(Color color, int thickness, int radius) {
    return new RoundedBorder(color, thickness, radius);
  }

  private static final class RoundedBorder extends AbstractBorder {
    private final Color color;
    private final int thickness;
    private final int radius;

    private RoundedBorder(Color color, int thickness, int radius) {
      this.color = color;
      this.thickness = thickness;
      this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width,
                            int height) {
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                          RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(color);
      g2.setStroke(new BasicStroke(thickness));
      int offset = thickness / 2;
      int w = width - thickness;
      int h = height - thickness;
      g2.drawRoundRect(x + offset, y + offset, w, h, radius, radius);
      g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
      return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
      insets.left = thickness;
      insets.right = thickness;
      insets.top = thickness;
      insets.bottom = thickness;
      return insets;
    }
  }
}
