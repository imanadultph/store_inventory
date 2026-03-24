package com.store_inventory.pages;

import com.store_inventory.pages.components.Header;
import com.store_inventory.pages.components.UITheme;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class AppFrame extends JFrame implements NavigationHandler {
  private final CardLayout rootLayout = new CardLayout();
  private final CardLayout pageLayout = new CardLayout();
  private final JPanel rootPanel = new JPanel(rootLayout);
  private final JPanel pagePanel = new JPanel(pageLayout);
  private final LoginPage loginPage = new LoginPage();
  private final Header header;
  private final Map<String, String> titles = new HashMap<>();

  public AppFrame() {
    setTitle("Store Inventory");
    setSize(1100, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    titles.put(Navigation.HOME, "Home Page");
    titles.put(Navigation.PRODUCTS, "Products Page");
    titles.put(Navigation.INVENTORY, "Inventory Page");
    titles.put(Navigation.SALES, "Sales Page");
    titles.put(Navigation.REPORTS, "Reports Page");
    titles.put(Navigation.REPORT_DETAIL, "Product Report");

    header = new Header("Home Page", "", this);

    buildRoot();
    add(rootPanel);

    loginPage.getLoginButton().addActionListener(e -> {
      if (loginPage.authenticate()) {
        header.setUser(loginPage.getUsername());
        showApp();
      } else {
        JOptionPane.showMessageDialog(this, "Invalid name or password", "Error",
                                      JOptionPane.ERROR_MESSAGE);
      }
    });
  }

  private void buildRoot() {
    rootPanel.add(loginPage, Navigation.LOGIN);

    JPanel appPanel = new JPanel(new BorderLayout());
    appPanel.setBackground(UITheme.BACKGROUND);
    appPanel.add(header, BorderLayout.NORTH);

    pagePanel.setBackground(UITheme.BACKGROUND);
    pagePanel.add(new HomePage(), Navigation.HOME);
    pagePanel.add(new ProductsPage(), Navigation.PRODUCTS);
    pagePanel.add(new InventoryPage(), Navigation.INVENTORY);
    pagePanel.add(new SalesPage(), Navigation.SALES);
    pagePanel.add(new ReportsPage(this), Navigation.REPORTS);
    pagePanel.add(new ReportDetailPage(), Navigation.REPORT_DETAIL);

    appPanel.add(pagePanel, BorderLayout.CENTER);

    rootPanel.add(appPanel, Navigation.APP);
    rootLayout.show(rootPanel, Navigation.LOGIN);
  }

  private void showApp() {
    rootLayout.show(rootPanel, Navigation.APP);
    navigate(Navigation.HOME);
  }

  @Override
  public void navigate(String destination) {
    pageLayout.show(pagePanel, destination);
    String title = titles.getOrDefault(destination, "Page");
    header.setTitle(title);
  }

  @Override
  public void logout() {
    loginPage.clearFields();
    rootLayout.show(rootPanel, Navigation.LOGIN);
  }
}
