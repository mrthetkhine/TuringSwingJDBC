/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebyhand;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author thetkhine
 */
public class FirstForm extends JFrame
{
    FirstForm()
    {
        super("First Form");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        
        JPanel panel  = new JPanel();
        JLabel lblMyLabel = new JLabel("Hello");
        JTextField txtHello = new JTextField(40);
        //txtHello.setSize(300, 50);
                
        JButton btnDemo = new JButton("Demo");
        btnDemo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Button clicked");
                txtHello.setText("How are you");
            }
        });
        
        panel.add(lblMyLabel);
        panel.add(txtHello);
        panel.add(btnDemo);
        
        this.add(panel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[]args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                    new FirstForm();
            }
        });
    }
}
