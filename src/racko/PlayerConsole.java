package racko;

import java.util.Scanner;

public class PlayerConsole implements Player
{
    public void beginGame(Rack rack)
    {
    }

    public int acceptCard(Rack rack, Card card)
    {
        int k = 0;

        rack.show();

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Accept %s slot: ", card);
        String s = scanner.next();
        k = toSlot(s);
        return k;
    }

    public int placeCard(Rack rack, Card card)
    {
        int k = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Place %s slot: ", card);
        String s = scanner.next();
        k = toSlot(s);
        return k;
    }

    public static int toSlot(String s)
    {
        int k = 0;
        try
        {
            k = Integer.parseInt(s);
            if (k < 1 || k > 10)
            {
                k = 0;
            }
        } catch (Exception ex)
        {
        }
        return k;
    }
}
