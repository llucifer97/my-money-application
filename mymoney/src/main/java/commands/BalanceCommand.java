package commands;


import entities.Debt;
import entities.Equity;
import entities.Gold;



public class BalanceCommand implements ICommand {

    private Equity equity ;
    private Debt debt ;
    private Gold gold;
    private String[] stringarray;

    public BalanceCommand(Equity equity, Debt debt, Gold gold , String[] stringarray) {
        this.equity = equity;
        this.debt = debt;
        this.gold = gold;
        this.stringarray = stringarray;
    }

    public void showBalance(String[] stringarray)
    {
        int equitybymonth = equity.getDataByMonth(stringarray[1]);
        int debtbymonth   = debt.getDataByMonth(stringarray[1]);
        int goldbymonth   = gold.getDataByMonth(stringarray[1]);


        System.out.println(equitybymonth + " " + debtbymonth + " " + goldbymonth );

    }


    @Override
    public void execute() {
        showBalance(stringarray);
    }
}
