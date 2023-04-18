public class CommunityChest extends Square{
    private static int cardNo = 1;
    public CommunityChest(int id) {
        super(id);
    }

    public static int getCardNo() {
        return cardNo;
    }

    @Override
    public void play(Player player, int dice) {
        switch (cardNo)
        {
            case 1:
                player.setSquareNo(1);
                take(player,200);
                break;
            case 2:
                take(player,75);
                break;
            case 3:
                pay(player,50);
                break;
            case 4:
                player.setOwnMoney(10);
                break;
            case 5:
                player.setOwnMoney(50);
                break;
            case 6:
                take(player, 20);
                break;
            case 7:
                take(player,100);
                break;
            case 8:
                pay(player, 100);
                break;
            case 9:
                pay(player, 50);
                break;
            case 10:
                take(player, 100);
                break;
            case 11:
                take(player, 50);
                break;
        }
        CommandReader.outputStr = player.getName() + " draw " + ListJsonReader.communityList.get(cardNo - 1);
        cardNo++;
    }
}
