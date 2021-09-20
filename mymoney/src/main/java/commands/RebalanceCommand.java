package commands;

import entities.Debt;
import entities.Equity;
import entities.Gold;

import java.util.ArrayList;
import java.util.List;

public class RebalanceCommand implements ICommand{
    private final Equity equity ;
    private final Debt debt ;
    private final Gold gold;
    private int lastrebalancedequity;
    private int lastrebalanceddebt;
    private int lastrebalancedgold;
    private String[] allocation;

    public int getLastrebalancedequity() {
        return lastrebalancedequity;
    }

    public int getLastrebalanceddebt() {
        return lastrebalanceddebt;
    }

    public int getLastrebalancedgold() {
        return lastrebalancedgold;
    }

    public RebalanceCommand(Equity equity, Debt debt, Gold gold , String[] allocation) {
        this.equity = equity;
        this.debt = debt;
        this.gold = gold;
        this.allocation = allocation;
    }


    public void rebalance()
    {

        List<Integer> percentallocation  =  getallocationpercent();
        int currentequity = equity.getCurrentValue();
        int currentdebt = debt.getCurrentValue();
        int currentgold = gold.getCurrentValue();
        int total = currentdebt + currentgold + currentequity;
        currentequity = percentallocation.get(0)*total/100 ;
        currentdebt = percentallocation.get(1)*total/100 ;
        currentgold = percentallocation.get(2)*total/100 ;
        lastrebalancedequity = currentequity;
        lastrebalanceddebt = currentdebt;
        lastrebalancedgold = currentgold;
        equity.setCurrentValue(currentequity);
        debt.setCurrentValue(currentdebt);
        gold.setCurrentValue(currentgold);

    }

    List<Integer> getallocationpercent()
    {
        List<Integer> assestallocationpercent = new ArrayList<>();
        double totalallocation = Double.parseDouble(allocation[1]) + Double.parseDouble(allocation[2]) + Double.parseDouble(allocation[3]);
        int equitypercent = (int) (Double.parseDouble(allocation[1])/totalallocation*100);
        int debtpercent = (int) (Double.parseDouble(allocation[2])/totalallocation*100);
        int goldpercent = (int) (Double.parseDouble(allocation[3])/totalallocation*100);
        assestallocationpercent.add(equitypercent);
        assestallocationpercent.add(debtpercent);
        assestallocationpercent.add(goldpercent);
        return assestallocationpercent;

    }







    @Override
    public void execute() {
        rebalance();
    }
}
