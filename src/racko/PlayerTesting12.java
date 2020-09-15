package racko;

import java.util.Random;

public class PlayerTesting12 implements Player
{
    Random random = new Random();

    public void beginGame(Rack rack)
    {
    }

    public int acceptCard(Rack rack, Card card)
    {
        int k = 0;
        int v = card.value();

        if(v > 0 && v <= 6)
        {
            k = 1;
        }
        if(v > 6 && v <= 12)
        {
            k = 2;
        }
        if(v > 12 && v <= 18)
        {
            k = 3;
        }
        if(v > 18 && v <= 24)
        {
            k = 4;
        }
        if(v > 24 && v <= 30)
        {
            k = 5;
        }
        if(v > 32 && v <= 36)
        {
            k = 6;
        }
        if(v > 36 && v <= 42)
        {
            k = 7;
        }
        if(v > 42 && v <= 48)
        {
            k = 8;
        }
        if(v > 48 && v <= 54)
        {
            k = 9;
        }
        if(v > 54 && v <= 60)
        {
            k = 10;
        }
        return k;
    }


    public int placeCard(Rack rack, Card card)
    {
        int k = 0;
        int v = card.value();

        if(v > 0 && v <= 6)
        {
            k = 1;
        }
        if(v > 6 && v <= 12)
        {
            k = 2;
        }
        if(v > 12 && v <= 18)
        {
            k = 3;
        }
        if(v > 18 && v <= 24)
        {
            k = 4;
        }
        if(v > 24 && v <= 30)
        {
            k = 5;
        }
        if(v > 32 && v <= 36)
        {
            k = 6;
        }
        if(v > 36 && v <= 42)
        {
            k = 7;
        }
        if(v > 42 && v <= 48)
        {
            k = 8;
        }
        if(v > 48 && v <= 54)
        {
            k = 9;
        }
        if(v > 54 && v <= 60)
        {
            k = 10;
        }
        return k;
    }
}
