package racko;
public class PlayerZain implements Player
{
   public void beginGame(Rack Rack)
   {}
   public int acceptCard(Rack Rack, Card card)
   {
        int x = 0;
        int v = card.value();
        for(int i = 1; i <= 10; i++)
        {
            int d = Rack.get(i - 1).value();
            if(v > (6 * (i - 1)) && v <= (6 * i))
            {
                if(d > (6 * (i - 1)) && d <= (6 * i))
                {    
                    if(v < d)
                    {
                       x = i - 1;      
                    }
                    if(v > d)
                    {
                       x = i + 1;
                    }
                }
                else
                {
                    x = i;
                }
            }
        }       
        return x;     
   }
   public int placeCard(Rack Rack, Card card)
    {
        int x = 0;
        int v = card.value();
        for(int i = 1; i <= 10; i++)
        {
            int d = Rack.get(i - 1).value();
            if(v > (6 * (i - 1)) && v <= (6 * i))
            {
                if(d > (6 * (i - 1)) && d <= (6 * i))
                {    
                    if(v < d)
                    {
                       x = i - 1;      
                    }
                    if(v > d)
                    {
                       x = i + 1;
                    }
                }
                else
                {
                    x = i;
                }
            }
        }       
        return x;     
    }
}
