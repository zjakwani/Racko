package racko;

public class Card implements Comparable<Card>
{
    public static final int MIN = 1;
    public static final int MAX = 60;
    private static final int bad = 0;
    private int val = bad;

    public Card()
    {
        val = bad;
    }

    public Card(int num)
    {
        if (num >= MIN && num <= MAX)
        {
            val = num;
        }
    }

    public Card(Card that)
    {
        this.val = that.val;
    }

    public String toString()
    {
        return "[" + val + "]";
    }

    public boolean equals(Card that)
    {
        return this.val == that.val;
    }

    public int compareTo(Card that)
    {
        if (this.val < that.val)
        {
            return -1;
        }
        if (this.val > that.val)
        {
            return 1;
        }

        return 0;
    }

    public int value()
    {
        return val;
    }
}
