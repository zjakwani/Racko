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

public class FormMatch
{
    JFrame mainFrame;
    JPanel mainPanel;

    JPanel scorePanel = new JPanel();
    JLabel[] nameLabels;
    JLabel[] gameLabels;
    JLabel[][] scoreLabels;

    public FormMatch()
    {
        mainFrame = new JFrame();
        mainPanel = new JPanel();

        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setTitle("Racko Match");
        mainFrame.setSize(720, 200);
        //mainFrame.setLocationRelativeTo(null);

        mainPanel.setLayout(null);

        scorePanel = new JPanel();
        scorePanel.setLayout(null);
        scorePanel.setLocation(2, 2);
        scorePanel.setSize(800, 200);

        gameLabels = new JLabel[14];

        for (int k = 1; k <= 14; k++)
        {
            int lx = 38 * k + 90;
            int ly = 10;
            int sx = 36;
            int sy = 30;

            String text = "" + k;

            if (k == 14)
            {
                lx += 20;
                text = "Total";
            }

            JLabel gLabel = new JLabel();
            gLabel.setText(text);
            gLabel.setForeground(Color.black);
            gLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gLabel.setLocation(lx, ly);
            gLabel.setSize(sx, sy);
            // gLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            scorePanel.add(gLabel);
        }

        nameLabels = new JLabel[2];
        scoreLabels = new JLabel[2][14];

        for (int p = 1; p <= 2; p++)
        {
            int lx = 10;
            int ly = 32 * p + 10;
            int sx = 100;
            int sy = 30;

            String text = "*";

            JLabel pName = new JLabel();
            pName.setText(text);
            pName.setForeground(Color.blue);
            pName.setHorizontalAlignment(SwingConstants.LEFT);
            pName.setLocation(lx, ly);
            pName.setSize(sx, sy);
            pName.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            nameLabels[p - 1] = pName;
            scorePanel.add(pName);

            for (int k = 1; k <= 14; k++)
            {
                lx = 38 * k + 90; // was 32
                sx = 36; // was 30
                sy = 30;

                text = "__  ";

                if (k == 14)
                {
                    lx += 20;
                    sx += 10;
                    text = "0  ";
                }

                JLabel sLabel = new JLabel();
                sLabel.setText(text);
                sLabel.setForeground(Color.blue);
                sLabel.setBackground(Color.white);
                sLabel.setOpaque(true);
                sLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                sLabel.setLocation(lx, ly);
                sLabel.setSize(sx, sy);
                sLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                scoreLabels[p - 1][k - 1] = sLabel;
                scorePanel.add(sLabel);
            }
            mainPanel.add(scorePanel);
        }
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

    public void putName(int p, String name)
    {
        nameLabels[p - 1].setText(name);
    }

    public void putTotal(int p, int s)
    {
        scoreLabels[p - 1][13].setText(s + "  ");
    }

    public void putScore(int p, int k, int s, boolean w, boolean q)
    {
        scoreLabels[p - 1][k - 1].setForeground(w ? Color.green : Color.red);
        scoreLabels[p - 1][k - 1].setBackground(q ? Color.yellow : Color.white);
        scoreLabels[p - 1][k - 1].setText(s + "  ");
    }
}
