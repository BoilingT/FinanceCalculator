package org.boil.panels.tabs.overview;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class IncomePanel extends JPanel implements ChangeListener {

    private static final Color backgroundColor = Color.WHITE;

    private static final JPanel topPanel = new JPanel();
    private static final JPanel bottomPanel = new JPanel();

    // Top panel
    private static final JLabel incomeTextFieldLabel = new JLabel("Income: ");
    private static final JSpinner incomeSpinner = new JSpinner();
    private static final JLabel taxTextFieldLabel = new JLabel("Tax: ");
    private static final JSpinner taxSpinner = new JSpinner();
    private static final JLabel allowanceTextFieldLabel = new JLabel("Allowance: ");
    private static final JSpinner allowanceSpinner = new JSpinner();

    private static final String fixedExpensesText = "Fixed Expenses: ";
    private static final String variableExpensesText = "Variable Expenses: ";

    private static final JLabel fixedExpensesTextFieldLabel = new JLabel(fixedExpensesText);
    private static final JLabel variableExpensesTextFieldLabel = new JLabel(variableExpensesText);

    public IncomePanel(){

        incomeSpinner.addChangeListener(this);
        taxSpinner.addChangeListener(this);
        allowanceSpinner.addChangeListener(this);

        this.setLayout(new GridBagLayout());
        topPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbcTextFields = new GridBagConstraints();

        gbcTextFields.gridx = 0;
        gbcTextFields.gridy = 0;
        gbcTextFields.weightx = 0.5f;
        gbcTextFields.weighty = 0.3f;
        gbcTextFields.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(incomeTextFieldLabel, gbcTextFields);
        gbcTextFields.gridx = 1;
        topPanel.add(incomeSpinner, gbcTextFields);

        gbcTextFields.gridx = 0;
        gbcTextFields.gridy = 1;
        topPanel.add(taxTextFieldLabel, gbcTextFields);
        gbcTextFields.gridx = 1;
        topPanel.add(taxSpinner, gbcTextFields);

        gbcTextFields.gridx = 0;
        gbcTextFields.gridy = 2;
        topPanel.add(allowanceTextFieldLabel, gbcTextFields);
        gbcTextFields.gridx = 1;
        topPanel.add(allowanceSpinner, gbcTextFields);

        gbcTextFields.gridx = 0;
        gbcTextFields.gridy = 3;
        topPanel.add(fixedExpensesTextFieldLabel, gbcTextFields);

        gbcTextFields.gridx = 0;
        gbcTextFields.gridy = 4;
        topPanel.add(variableExpensesTextFieldLabel, gbcTextFields);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0f;
        gbc.weighty = 0.2f;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(topPanel, gbc);
        gbc.weighty = 0.8f;
        gbc.gridy = 1;
        this.add(bottomPanel, gbc);
        this.setBackground(backgroundColor);
        topPanel.setBackground(backgroundColor);
        bottomPanel.setBackground(backgroundColor);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner source = (JSpinner) e.getSource();

        if((int) source.getValue() < 0) source.setValue(0);
    }
}
