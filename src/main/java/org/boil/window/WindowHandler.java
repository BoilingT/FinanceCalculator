package org.boil.window;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

public class WindowHandler extends JFrame {

    public WindowHandler(int width, int height, String title){
        setTitle(title);
        setPreferredSize(new Dimension(width, height));
        setSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        System.out.println("Window Initialized");
    }

    public void Show() {
        setVisible(true);
    }

    public void Close(){
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        System.exit(0);
    }
}
