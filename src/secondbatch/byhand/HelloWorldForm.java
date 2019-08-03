/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondbatch.byhand;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author thetkhine
 */
public class HelloWorldForm extends JFrame
{
    HelloWorldForm()
    {
        super("Hell World by Hand");
        this.setVisible(true);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        JPanel panel = new JPanel();
        JButton btnHelloWorld = new JButton("Hello World");
        
        btnHelloWorld.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null,"Button clicked");
            }
        });
        btnHelloWorld.addActionListener(ae->{
            JOptionPane.showMessageDialog(null,"Button clicked2");
        });
        panel.add(btnHelloWorld);
        JLabel lblHelloWorld = new JLabel("Hello World");
        
        panel.add(lblHelloWorld);
        
        this.add(panel);
    }
    public static void main(String[]args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                HelloWorldForm hf = new HelloWorldForm();
            }
            
        });
    }
}
