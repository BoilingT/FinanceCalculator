package org.boil.panels.tabs.overview;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtils;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;

public class ExpenseGraphPanel extends JPanel {
    private CategoryDataset dataset;
    private ChartPanel chartPanel;
    private JFreeChart chart;
    private PieDataset pieDataset;

    public ExpenseGraphPanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0f;
        gbc.weighty = 1.0f;

        chartPanel = new ChartPanel(null);
        chartPanel.setMouseZoomable(false);

        this.add(chartPanel, gbc);
        this.setBackground(Color.PINK);
    }

    public void setDataset(CategoryDataset dataset){
        this.dataset = dataset;
        this.pieDataset = DatasetUtils.createPieDatasetForColumn(dataset, 0);
        this.chart = ChartFactory.createPieChart("Bar Chart", pieDataset);
        chartPanel.setChart(chart);
    }
}
