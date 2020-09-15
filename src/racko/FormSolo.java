package racko;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormSolo
{
    JFrame mainFrame;
    JPanel mainPanel;
    JPanel rackPanel;
    JLabel[] slotLabels;
    JLabel playerLabel;
    JLabel counterLabel;
    JLabel discardLabel;

    public FormSolo()
    {
        mainFrame = new JFrame();
        mainPanel = new JPanel();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Racko");
        mainFrame.setSize(320, 500);
        mainFrame.setLocationRelativeTo(null);

        mainPanel.setLayout(null);

        rackPanel = new JPanel();
        slotLabels = new JLabel[10];

        rackPanel.setBorder(BorderFactory.createTitledBorder("Rack"));
        rackPanel.setLayout(null);
        rackPanel.setLocation(5, 10);
        rackPanel.setSize(280, 400);

        for (int k = 1; k <= 10; k++)
        {
            JLabel nLabel = new JLabel();
            nLabel.setText("" + k);
            nLabel.setForeground(Color.red);
            nLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nLabel.setLocation(5, 35 * (10 - k) + 33);
            nLabel.setSize(30, 30);
            nLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            rackPanel.add(nLabel);

            JLabel sLabel = new JLabel();
            sLabel.setLocation(40, 35 * (10 - k) + 30);
            sLabel.setSize(220, 36);
            sLabel.setBorder(BorderFactory.createLoweredBevelBorder());
            rackPanel.add(sLabel);

            JLabel cLabel = new JLabel();
            rackPanel.add(cLabel);
            slotLabels[k - 1] = cLabel;
        }

        mainPanel.add(rackPanel);

        counterLabel = new JLabel();
        counterLabel.setLocation(50, 435);
        counterLabel.setSize(80, 20);

        discardLabel = new JLabel();
        discardLabel.setForeground(Color.magenta);
        discardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        discardLabel.setLocation(150, 420);
        discardLabel.setSize(30, 30);
        discardLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        mainPanel.add(counterLabel);
        mainPanel.add(discardLabel);

        mainPanel.setOpaque(true);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    public void close()
    {
        //mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING)); 
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    public JFrame getFrame()
    {
        return mainFrame;
    }

    public void setSlot(int k, int v)
    {
        if (k >= 1 && k <= 10 && v >= 1 && v <= 60)
        {
            JLabel cLabel = slotLabels[k - 1];
            cLabel.setText("" + v);
            cLabel.setForeground(Color.blue);
            cLabel.setHorizontalAlignment(SwingConstants.CENTER);
            cLabel.setLocation(3 * v + 43, 35 * (10 - k) + 33);
            cLabel.setSize(30, 30);
            cLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }

    public void setLabels(int c, int v)
    {
        if (c >= 1)
        {
            counterLabel.setText("Counter: " + c);
        }
        if (v >= 1 && v <= 60)
        {
            discardLabel.setText("" + v);
        }
    }
}
