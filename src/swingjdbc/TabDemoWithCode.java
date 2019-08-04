/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingjdbc;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import secondbatch.byhand.HelloWorldForm;

/**
 *
 * @author thetkhine
 */
class SaleTab extends JPanel
{
    SaleTab()
    {
        JButton btnSale = new JButton("Sale");
        this.add(btnSale);
        this.setSize(300, 200);
    }
}
public class TabDemoWithCode extends JFrame
{
    TabDemoWithCode()
    {
        super("Tabpane");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        
        this.setLayout(new FlowLayout());
        JTabbedPane tabPane = new JTabbedPane();
        tabPane.setSize(300, 200);
        tabPane.addTab("Sale", new SaleTab());
        
        this.add(tabPane);
    }
    public static void main(String[]args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                TabDemoWithCode hf = new TabDemoWithCode();
            }
            
        });
    }
}
