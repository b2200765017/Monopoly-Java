public class Square
{
    private final int id;
    public Square(int id) {
        this.id = id;
    }
    public static Square objFinder(int id)
    {
        for (int i = 0; i < PropertyJsonReader.squares.size(); i++)
        {
            Square tempSquare = PropertyJsonReader.squares.get(i);
            if (tempSquare.id == id)
                return tempSquare;
        }
        return null;
    }
    public void pay(Player player, int money)
    {
        player.loseMoney(money);
        Banker.money += money;
    }
    public void take(Player player, int money)
    {
        player.setMoney(player.getMoney() + money);
        Banker.money -= money;
    }

    public void play(Player player, int dice) {
        
    }
}
