public class RailRoad extends Properties {
    private final int cost;
    private Player owner;
    private boolean bsold = false;
    private final String name;

    public RailRoad(int id, int cost, String name) {
        super(id);
        this.cost = cost;
        this.name = name;
    }

    public void getProperties(Player player) {
        if (player.getMoney() >= cost) {
            player.loseMoney(cost);
            Banker.money += cost;
            owner = player;
            bsold = true;
            owner.setRailRoadNo(owner.getRailRoadNo() + 1);
            CommandReader.outputStr = player.getName() + " bought " + name;
            player.properties.add(name);
        }
        else
        {
            player.setBankrupt(true);
        }
    }

    public boolean getOwner() {
        return !bsold;
    }

    public void rent(Player player, int dice) {
        player.loseMoney(owner.getRailRoadNo() * 25);
        owner.setMoney(owner.getMoney() + owner.getRailRoadNo() * 25);
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