package racko;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utilities
{
    public static String showInputDialog(String message, String title)
    {
        return showInputDialog(message, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static String showInputDialog(String message, String title, int messageType)
    {
        String res = JOptionPane.showInputDialog(
                tempFrame(),
                message,
                title,
                messageType);
        return res;
    }

    private static JFrame tempFrame()
    {
        return new javax.swing.JFrame()
        {
            public boolean isShowing()
            {
                return true;
            }

            public java.awt.Rectangle getBounds()
            {
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (int) ((dimension.getWidth()) / 2);
                int y = (int) ((dimension.getHeight()) / 2);
                return new java.awt.Rectangle(x - 20, y + 280, 0, 0);
            }
        };
    }

    public static void showMessageDialog(String message)
    {
        JOptionPane.showMessageDialog(
                null, //tempFrame(),
                message,
                "Info Box",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean delay(int milliseconds)
    {
        boolean success = true;
        try
        {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
            success = false;
        }
        return success;
    }
}
