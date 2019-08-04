/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebyhand;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author thetkhine
 */
class SalePanel extends JPanel
{
    SalePanel()
    {
        JButton btn = new JButton("Sale Button");
        this.add(btn);
    }
}
public class TabPaneCode extends JFrame
{
    TabPaneCode()
    {
        super("Tab pane demo");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        
        this.setLayout(new FlowLayout());
        
        JTabbedPane tabPane = new JTabbedPane();
        
        tabPane.addTab("Sale ", new SalePanel());
        
        this.add(tabPane);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
       public static void main(String[]args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                    new TabPaneCode();
            }
        });
    }
}
