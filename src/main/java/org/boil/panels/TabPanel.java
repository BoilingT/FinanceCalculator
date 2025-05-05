package org.boil.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TabPanel extends JPanel implements ActionListener {
    ArrayList<JButton> btns = new ArrayList<>();
    ITabChangedEvent tabChangedEvent;

    public TabPanel(){

        btns.add(new JButton("Budget"));
        btns.add(new JButton("Expenses"));
        btns.add(new JButton("Savings"));
        btns.add(new JButton("Other"));

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 1.f/btns.size();
        gbc.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < btns.size(); i++){
            JButton btn = btns.get(i);
            btn.setBackground(Color.GRAY);
            btn.addActionListener(this);
            btn.setFocusable(false);
            btn.setBorder(null);
            gbc.gridy = i;
            this.add(btn, gbc);
        }
        btns.getFirst().setBackground(Color.WHITE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        source.setBackground(Color.WHITE);
        for (JButton btn : btns){
            if(!btn.equals(source)) btn.setBackground(Color.GRAY);
        }

        tabChangedEvent.tabChanged();

    }

    public void addTabChangedListener(ITabChangedEvent event) {
        this.tabChangedEvent = event;
    }
}
