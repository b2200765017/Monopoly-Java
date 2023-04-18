public class Land extends Properties {
    private final int cost;
    private Player owner;
    private boolean bsold = false;
    private String name;


    public Land(int id, int cost, String name) {
        super(id);
        this.cost = cost;
        this.name = name;
    }

    public void getProperties(Player player) {
        if (player.getMoney() >= cost) {
            Banker.money += cost;
            player.loseMoney(cost);
            owner = player;
            bsold = true;
            CommandReader.outputStr = player.getName() + " bought " + name;
            player.properties.add(name);
        }
        else
        {
            player.setBankrupt(true);
            CommandReader.outputStr = player.getName() + " goes bankrupt";
        }
    }

    public boolean getOwner() {
        return !bsold;
    }

    public void rent(Player player, int dice) {
        if (cost > 0 & cost <= 2000) {
            player.loseMoney(cost * 40 / 100);
            owner.setMoney(owner.getMoney() + cost * 40 / 100);
        } else if (cost > 2000 & cost <= 3000) {
            player.loseMoney(cost * 30 / 100);
            owner.setMoney(owner.getMoney() + cost * 30 / 100);
        } else {
            player.loseMoney(cost * 35 / 100);
            owner.setMoney(owner.getMoney() + cost * 35 / 100);
        }
        if (player.getMoney() < 0)
        {
            player.setBankrupt(true);
        }
    }
    @Override
    public void play(Player player, int dice) {
        if (getOwner())
        {
            getProperties(player);
        }
        else
        {
            if (owner == player)
            {
                CommandReader.outputStr = player.getName() + " has " + name;
            }
            else
            {
                rent(player, dice);
                CommandReader.outputStr = player.getName() + " paid rent for " + name;
            }
        }
    }
}
