public class Chance extends Square {
    private static int cardNo2 = 1;
    public Chance(int id) {
        super(id);
    }

    @Override
    public void play(Player player, int dice) {
        CommandReader.outputStr = player.getName() + " draw " + ListJsonReader.chanceL.get(cardNo2 - 1);
        switch (cardNo2)
        {
            case 1:
                player.setSquareNo(1);
                take(player,200);
                break;
            case 2:
                if (player.getSquareNo() > 27)
                {
                    take(player, 200);
                }
                player.setSquareNo(27);
                Square square = Square.objFinder(player.getSquareNo());
                square.play(player, dice);
                CommandReader.outputStr = player.getName() + " draw " + ListJsonReader.chanceL.get(cardNo2 - 1) +" " + CommandReader.outputStr;
                break;
            case 3:
                player.setSquareNo(player.getSquareNo() - 3);
                Square square2 = Square.objFinder(player.getSquareNo());
                square2.play(player, dice);
                CommandReader.outputStr = player.getName() + " draw " + ListJsonReader.chanceL.get(cardNo2 - 1) +" " + CommandReader.outputStr;
                break;
            case 4:
                pay(player,15);
                break;
            case 5:
                take(player,150);
                break;
            case 6:
                take(player,150);
                break;

        }
        cardNo2++;
    }
}
