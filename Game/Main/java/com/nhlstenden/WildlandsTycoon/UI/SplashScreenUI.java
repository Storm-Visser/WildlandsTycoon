package com.nhlstenden.WildlandsTycoon.UI;

import javax.swing.*;
import java.awt.*;
public class SplashScreenUI extends JWindow {

    /***
     * Creates splashscreen
     */
    public SplashScreenUI()
        {
            JWindow j=new JWindow();

            Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

            ImageIcon img= new ImageIcon(new ImageIcon("Game/Assets/Background.png").getImage().getScaledInstance(722, 501, Image.SCALE_SMOOTH));
            JLabel label = new JLabel(img);
            j.getContentPane().add(label);
            j.setBounds(((int)d.getWidth()-722)/2,((int)d.getHeight()-722)/2,722,501);
            j.setVisible(true);
            try
            {
                Thread.sleep(6000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            j.setVisible(false);

        }
}
