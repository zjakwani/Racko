package racko;

public class PlayerHuman implements Player
{
    public void beginGame(Rack rack)
    {
    }

    public int acceptCard(Rack rack, Card card)
    {
        String title = "Human Player";
        String message = "Accept card " + card + " in slot:";
        String res = Utilities.showInputDialog(message, title);
        int k = toSlot(res);
        return k;
    }

    public int placeCard(Rack rack, Card card)
    {
        String title = "Human Player";
        String message = "Place card " + card + " in slot:";
        String res = Utilities.showInputDialog(message, title);
        int k = toSlot(res);
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
