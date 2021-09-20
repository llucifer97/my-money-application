package commands;

import entities.Debt;
import entities.Equity;
import entities.Gold;

public class ChangeCommand implements ICommand{


    private Equity equity ;
    private Debt debt ;
    private Gold gold;
    private String[] stringarray;

    public void setStringarray(String[] stringarray) {
        this.stringarray = stringarray;
    }

    public ChangeCommand(Equity equity, Debt debt, Gold gold, String[] stringarray) {
        this.equity = equity;
        this.debt = debt;
        this.gold = gold;
        this.stringarray = stringarray;
    }



    public void marketChangeupdation( String[] stringarray)
    {
        stringarray = this.stringarray;
        equity.updateMarketChange(stringarray[1] ,stringarray[4]);
        debt.updateMarketChange(stringarray[2]   ,stringarray[4]);
        gold.updateMarketChange(stringarray[3]   ,stringarray[4]);

    }


    @Override
    public void execute() {
        marketChangeupdation(stringarray);
    }
}
