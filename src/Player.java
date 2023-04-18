import java.util.ArrayList;

public class Player extends People
{
    private String name;
    private int money = 15000;
    public ArrayList<String> properties = new ArrayList<>();
    private int squareNo = 1;
    private int railRoadNo = 0;
    private boolean goPushed = false;
    private int roundWait = 3;
    private boolean bankrupt = false;
    private boolean parked = false;
    private int ownMoney;

    public Player(String name) {
        this.name = name;
    }

    public int getSquareNo() {
        return squareNo;
    }

    public boolean isBankrupt() {
        return !bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public boolean isParked() {
        return !parked;
    }

    public int getOwnMoney() {
        return ownMoney;
    }

    public void setOwnMoney(int ownMoney) {
        this.ownMoney = ownMoney;
    }

    public void setParked(boolean parked) {
        this.parked = parked;
    }

    public void play(int squareNo) {
        this.squareNo = squareNo + this.squareNo;
        if (this.squareNo > 40)
        {
            this.squareNo -= 40;
            if (goPushed)
            {
                goPushed = false;
            }
            else
            {
                money += 200;
                Banker.money -= 200;
            }
        }
    }

    public int getRailRoadNo() {
        return railRoadNo;
    }
    public boolean waitRound()
    {
        if (roundWait == 3)
        {
            return true;
        }
        else
        {
            roundWait++;
            return false;
        }
    }

    public int getRoundWait() {
        return roundWait;
    }

    public void setSquareNo(int squareNo) {
        this.squareNo = squareNo;
    }

    public void setRoundWait(int roundWait) {
        this.roundWait = roundWait;
    }

    public void setRailRoadNo(int railRoadNo) {
        this.railRoadNo = railRoadNo;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void loseMoney(int money) {
        this.money = this.money - money;
    }

}
