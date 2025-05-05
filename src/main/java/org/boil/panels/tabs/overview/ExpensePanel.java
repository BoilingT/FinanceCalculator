package org.boil.panels.tabs.overview;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExpensePanel extends JPanel implements KeyListener {

    private static JTable table;
    private static JScrollPane scrollPane;
    private static ExpenseGraphPanel graphPanel = new ExpenseGraphPanel();

    private String[] columnNames = { "Fixed Expenses", "Value", "Variable Expenses", "Value"};
    private String[][] data = new String[100][4];
    public ExpensePanel(){

        for (int column = 0; column < 4; column++) {
            for (int row = 0; row < 10; row++) {
                data[row][column] = "" + (row + 1);
            }
        }

        table = new JTable(data, columnNames);
        table.setCellSelectionEnabled(true);
        table.addKeyListener(this);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 0.5f;
        gbc.weightx = 1.0f;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(scrollPane, gbc);
        gbc.gridy = 1;
        this.add(graphPanel, gbc);

        Number[][] graphData = new Integer[][]{
                {0},{0}
        };
        int col = 0;
        for (int i = 1; i < 4; i+=2) {
            int sum = 0;
            for (int row = 0; row < 10; row++){
                Number number = Integer.parseInt(data[row][i]);
                sum += number.intValue();
                System.out.println(number.intValue());
            }
            graphData[col++][0] = sum;
        }
        CategoryDataset dataset = DatasetUtils.createCategoryDataset("S", "C", graphData);
        graphPanel.setDataset(dataset);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            Number[][] graphData = new Integer[][]{
                    {0},{0}
            };
            int col = 0;
            for (int i = 1; i < 4; i+=2) {
                int sum = 0;
                for (int row = 0; row < 10; row++){
                    Number number = Integer.parseInt(data[row][i]);
                    sum += number.intValue();
                    System.out.println(number.intValue());
                }
                graphData[col++][0] = sum;
            }
            CategoryDataset dataset = DatasetUtils.createCategoryDataset("S", "C", graphData);
            graphPanel.setDataset(dataset);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
