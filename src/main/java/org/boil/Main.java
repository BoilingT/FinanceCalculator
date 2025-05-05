package org.boil;

import org.boil.panels.ITabChangedEvent;
import org.boil.panels.tabs.overview.ExpensePanel;
import org.boil.panels.tabs.overview.IncomePanel;
import org.boil.panels.TabPanel;
import org.boil.panels.tabs.overview.OverviewTab;
import org.boil.window.WindowHandler;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final WindowHandler window = new WindowHandler(1400, 900, "Finance Calculator");
    private static final JPanel container = new JPanel();
    private static final TabPanel tabPanel = new TabPanel();
    private static final OverviewTab overviewTab = new OverviewTab();
    private static JMenuBar bar;

    public static void main(String[] args) {
        bar = new JMenuBar();
        bar.setBackground(Color.WHITE);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(helpMenu);

        fileMenu.add(new JMenuItem("Save"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Export"));

        editMenu.add(new JMenuItem("Find"));
        editMenu.add(new JMenuItem("Replace"));

        helpMenu.add(new JMenuItem("Credit"));

        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0.0f;
        gbc.weighty = 1.0f;
        container.add(tabPanel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0f;
        gbc.weighty = 1.0f;
        gbc.fill = GridBagConstraints.BOTH;
        container.add(overviewTab, gbc);

        window.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.weightx = 1.0f;
        gbc.weighty = 0.0f;
        window.add(bar, gbc);
        gbc.gridy = 1;
        gbc.weighty = 1.0f;
        gbc.weightx = 1.0f;
        gbc.fill = GridBagConstraints.BOTH;
        window.add(container, gbc);
        window.Show();

        tabPanel.addTabChangedListener(() -> System.out.println("Tab changed"));
    }
}
