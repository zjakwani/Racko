package racko;

public class Rack extends Deck
{
    public static final int LEN = 10;

    public Rack()
    {
    }

    public Rack(Rack that)
    {
        for (int i = 0; i < LEN; i++)
        {
            add(new Card(that.get(i)));
        }
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < LEN; i++)
        {
            if (i > 0)
            {
                s += ",";
            }
            if (s.length() > 60)
            {
                s += "+";
                break;
            }
            s += get(i).value();
        }
        return "[" + s + "]";
    }
    
    public int value(int slot)
    {
        return get(slot - 1).value();
    }

    public boolean isSorted()
    {
        boolean b = true;
        int i = 1;
        while (i < LEN)
        {
            if (get(i).compareTo(get(i - 1)) < 0)
            {
                b = false;
                break;
            }
            i++;
        }
        return b;
    }

    public int numSorted()
    {
        int i = 1;
        while (i < LEN)
        {
            if (get(i).compareTo(get(i - 1)) < 0)
            {
                break;
            }
            i++;
        }
        return i;
    }

    public int numSequence()
    {
        int i = 1;
        int c = 1;
        int t = 0;
        while (i < LEN)
        {
            if (get(i).value() - get(i - 1).value() == 1)
            {
                if (++c >= 3 && c > t)
                {
                    t = c;
                }
            } else
            {
                c = 1;
            }
            i++;
        }
        return t;
    }

    public int score()
    {
        int sor = numSorted();
        int seq = numSequence();
        int tot = sor * 5;

        if (sor >= 10)
        {
            tot += 25;
            if (seq == 3) tot += 50;
            if (seq == 4) tot += 100;
            if (seq == 5) tot += 200;
            if (seq >= 6) tot += 400;
        }
        
        return tot;
    }

    public boolean isBetween(int i)
    {
        boolean b = false;
        if (i >= 1 && i <= LEN - 2)
        {
            int v1 = get(i - 1).value();
            int v2 = get(i).value();
            int v3 = get(i + 1).value();
            b = (v1 < v2 && v2 < v3);
        }
        return b;
    }

    public void show()
    {
        String line = "    -------------------------------------------------------------";
        System.out.println(line);
        for (int i = LEN - 1; i >= 0; i--)
        {
            int v = get(i).value();
            String format = "%2d  %" + v + "d\n%s\n";
            System.out.printf(format, i + 1, v, line);
        }
    }

    public int gap(int i)
    {
        return gap(i, i + 1);
    }

    public int gap(int i, int j)
    {
        int g = 0;
        if (i >= 0 && j < LEN)
        {
            g = get(j).value() - get(i).value();
        }
        return g;
    }
}
