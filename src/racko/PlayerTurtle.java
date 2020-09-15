package racko;

import java.util.Random;

public class PlayerTurtle implements Player
{
    Random random = new Random();
    private int turn = 0;
    private int zero = 0;

    public void beginGame(Rack rack)
    {
        turn = 0;
        zero = 0;
    }

    public int acceptCard(Rack rack, Card card)
    {
        return 0;
    }

    public int placeCard(Rack rack, Card card)
    {
        int k = 0;
        int m = Rack.LEN;
        int v = card.value();
        int f = turn++ % 2;

        if (k < 1 && v < rack.get(0).value())
        {
            k = 1;
        }
        if (k < 1 && v > rack.get(m - 1).value())
        {
            k = m;
        }

        if (k < 1 && f == 0)
        {
            for (int i = 1; i < m - 1; i++)
            {
                int v1 = rack.get(i - 1).value();
                int v2 = rack.get(i).value();
                int v3 = rack.get(i + 1).value();
                if (isBetween(v1, v, v3) && !isBetween(v1, v2, v3))
                {
                    k = i + 1;
                    break;
                }
            }
        }
        if (k < 1 && f == 1)
        {
            for (int i = m - 2; i > 0; i--)
            {
                int v1 = rack.get(i - 1).value();
                int v2 = rack.get(i).value();
                int v3 = rack.get(i + 1).value();
                if (isBetween(v1, v, v3) && !isBetween(v1, v2, v3))
                {
                    k = i + 1;
                    break;
                }
            }
        }
        if (k < 1 && f == 0)
        {
            for (int i = 1; i < m - 1; i++)
            {
                int v1 = rack.get(i - 1).value();
                int v2 = rack.get(i).value();
                int v3 = rack.get(i + 1).value();
                if (isBetween(v1, v, v3) && v < v2)
                {
                    k = i + 1;
                    break;
                }
            }
        }
        if (k < 1 && f == 1)
        {
            for (int i = m - 2; i > 0; i--)
            {
                int v1 = rack.get(i - 1).value();
                int v2 = rack.get(i).value();
                int v3 = rack.get(i + 1).value();
                if (isBetween(v1, v, v3) && v > v2)
                {
                    k = i + 1;
                    break;
                }
            }
        }
        if (k < 1 && f == 0)
        {
            for (int i = 1; i < m - 1; i++)
            {
                int v1 = rack.get(i - 1).value();
                int v2 = rack.get(i).value();
                if (v1 < v2 && v1 < v && v < v2)
                {
                    k = i + 1;
                    break;
                }
            }
        }
        if (k < 1 && f == 1)
        {
            for (int i = m - 2; i > 0; i--)
            {
                int v2 = rack.get(i).value();
                int v3 = rack.get(i + 1).value();
                if (v3 > v2 && v3 > v && v > v2)
                {
                    k = i + 1;
                    break;
                }
            }
        }
        if (k < 1)
        {
            k = 0;
            if (++zero % 100 == 0)
            {
                k = random.nextInt(10) + 1;
            }
        }
        return k;
    }

    public static boolean isBetween(int a, int b, int c)
    {
        return (a < b && b < c);
    }
}
