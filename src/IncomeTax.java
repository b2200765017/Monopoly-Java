public class IncomeTax extends Square{
    public IncomeTax(int id) {
        super(id);
    }

    @Override
    public void play(Player player, int dice) {
        Banker.money += 100;
        player.loseMoney(100);
        CommandReader.outputStr = player.getName() + " paid Tax";
    }
}
