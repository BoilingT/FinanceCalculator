package org.boil.panels.tabs.overview;

import javax.swing.*;
import java.awt.*;

public class OverviewTab extends JPanel {
    private static final IncomePanel incomePanel = new IncomePanel();
    private static final ExpensePanel expensePanel = new ExpensePanel();

    public OverviewTab(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.weightx = 0.0f;
        gbc.weighty = 1.0f;
        this.add(incomePanel, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0.3f;
        this.add(expensePanel, gbc);
    }
}
