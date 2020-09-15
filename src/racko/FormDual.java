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

public class FormDual
{
    JFrame mainFrame;
    JPanel mainPanel;
    JPanel[] rackPanels;
    JLabel[][] slotLabels;
    JLabel playerLabel;
    JLabel counterLabel;
    JLabel discardLabel;

    public FormDual()
    {
        mainFrame = new JFrame();
        mainPanel = new JPanel();

        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setTitle("Racko");
        mainFrame.setSize(600, 500);
        mainFrame.setLocationRelativeTo(null);

        mainPanel.setLayout(null);

        rackPanels = new JPanel[2];
        slotLabels = new JLabel[2][10];

        for (int p = 1; p <= 2; p++)
        {
            JPanel panel = new JPanel();

            panel.setBorder(BorderFactory.createTitledBorder("Rack " + p));
            panel.setLayout(null);
            panel.setLocation((p - 1) * 290 + 5, 10);
            panel.setSize(280, 400);
            rackPanels[p - 1] = panel;

            for (int k = 1; k <= 10; k++)
            {
                JLabel nLabel = new JLabel();
                nLabel.setText("" + k);
                nLabel.setForeground(Color.red);
                nLabel.setHorizontalAlignment(SwingConstants.CENTER);
                nLabel.setLocation(5, 35 * (10 - k) + 33);
                nLabel.setSize(30, 30);
                nLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                panel.add(nLabel);

                JLabel sLabel = new JLabel();
                sLabel.setLocation(40, 35 * (10 - k) + 30);
                sLabel.setSize(220, 36);
                sLabel.setBorder(BorderFactory.createLoweredBevelBorder());
                panel.add(sLabel);

                JLabel cLabel = new JLabel();
                panel.add(cLabel);
                slotLabels[p - 1][k - 1] = cLabel;
            }
            mainPanel.add(panel);
        }

        playerLabel = new JLabel();
        playerLabel.setLocation(100, 415);
        playerLabel.setSize(100, 20);

        counterLabel = new JLabel();
        counterLabel.setLocation(100, 435);
        counterLabel.setSize(100, 20);

        discardLabel = new JLabel();
        discardLabel.setForeground(Color.magenta);
        discardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        discardLabel.setLocation(290, 420);
        discardLabel.setSize(30, 30);
        discardLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        mainPanel.add(playerLabel);
        mainPanel.add(counterLabel);
        mainPanel.add(discardLabel);

        mainPanel.setOpaque(true);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    public void close()
    {
        mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    public JFrame getFrame()
    {
        return mainFrame;
    }

    public void setName(int p, String name)
    {
        rackPanels[p - 1].setBorder(BorderFactory.createTitledBorder(name));
    }

    public void setSlot(int p, int k, int v)
    {
        if (p >= 1 && p <= 2 && k >= 1 && k <= 10 && v >= 1 && v <= 60)
        {
            JLabel cLabel = slotLabels[p - 1][k - 1];
            cLabel.setText("" + v);
            cLabel.setForeground(Color.blue);
            cLabel.setHorizontalAlignment(SwingConstants.CENTER);
            cLabel.setLocation(3 * v + 43, 35 * (10 - k) + 33);
            cLabel.setSize(30, 30);
            cLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }

    public void setLabels(int p, int c, int v)
    {
        if (p >= 1 && p <= 2)
        {
            playerLabel.setText("Player: " + p);
        }
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
