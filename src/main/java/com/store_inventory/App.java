package com.store_inventory;

import com.store_inventory.pages.AppFrame;
import javax.swing.SwingUtilities;

public class App {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      AppFrame frame = new AppFrame();
      frame.setVisible(true);
    });
  }
}
