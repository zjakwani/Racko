package racko;

import java.util.Random;

public class PlayerKeke implements Player
{
    Random random = new Random();

    public void beginGame(Rack rack)
    {
    }

    public int acceptCard(Rack rack, Card card)
    {
        int k = 0;
        return k;
    }

    public int placeCard(Rack rack, Card card)
    {
        int k = 0;
        int c = card.value();
        
        if (c <= 6)
        {
            int d = rack.get(0).value();
            if (d <= 6)
                {
                    if (d < c) 
                    {
                        k = 2;
                    }
                    else 
                    {
                        k = 1;
                    }
                }
            else
            {
                k = 1;
            }
        }
        else if (c > 6 && c <= 12)
        {
            int d = rack.get(1).value();
            if (d > 6 && d<= 12)
                {
                    if(d < c)
                    {
                        k = 3;
                    }
                    if(d > c)
                    {
                        k = 1;
                    }
                }
            else
            {
                k = 2;
            }
        }
        else if (c > 12 && c <= 18)
        {
            int d = rack.get(2).value();
            if (d > 12 && d<= 18)
                {
                    if (d < c)
                    {
                        k = 4;
                    }
                    if(d > c)
                    {
                        k = 2;
                    }
                }
            else
            {
                k = 3;
            }
        }
        else if (c > 18 && c <= 24)
        {
           int d = rack.get(3).value();
            if (d > 18 && d<= 24)
                {
                    if (d < c)
                    {
                        k = 5;
                    }
                    if(d > c)
                    {
                        k = 3;
                    }
                }
            else
            {
                k = 4;
            }
        }
        else if (c > 24 && c <= 30)
        {
            int d = rack.get(4).value();
            if (d > 24 && d<= 30)
                {
                    if (d < c)
                    {
                        k = 6;
                    }
                    if(d > c)
                    {
                        k = 4;
                    }
                }
            else
            {
                k = 5;
            }
        }
        
        else if (c > 30 && c <= 36)
        {
            int d = rack.get(5).value();
            if (d > 30 && d<= 36)
                {
                    if(d < c)
                    {
                        k = 7;
                    }
                    if(d > c)
                    {
                        k = 5;
                    }
                }
            else
            {
                k = 6;
            }
        }
        
        else if (c > 36 && c <= 42)
        {
            int d = rack.get(6).value();
            if (d > 36 && d<= 42)
                {
                    if(d < c)
                    {
                        k = 8;
                    }
                    if(d > c)
                    {
                        k = 6;
                    }
                }
            else
            {
                k = 7;
            }
        }
        else if (c > 42 && c <= 48)
        {
            int d = rack.get(7).value();
            if (d > 42 && d<= 48)
                {
                    if(d < c)
                    {
                        k = 9;
                    }
                    if(d > c)
                    {
                        k = 7;
                    }
                }
            else
            {
                k = 8;
            }
        }
        else if (c > 48 && c <= 54)
        {
            int d = rack.get(8).value();
            if (d > 48 && d<= 54)
                {
                    if (d < c)
                    {
                        k = 10;
                    }
                    if (d > c)
                    {
                        k = 8;
                    }
                }
            else
            {
                k = 9;
            }
        }
        else if (c > 54 && c <= 60)
        {
            k = 10;
        }
        return k;   
    }
}
