package commands;


import entities.Equity;

public class ShowRebalanceCommand implements ICommand{

    private final RebalanceCommand rebalanceCommand;
    private final Equity equity;

    public ShowRebalanceCommand(RebalanceCommand rebalanceCommand , Equity equity) {
       this.equity  = equity;
       this.rebalanceCommand = rebalanceCommand;
    }

    public void ShowLastRebalancedamount()
    {

        if(!equity.canRebalance())
        {
            System.out.println("CANNOT_REBALANCE");
            return;
        }
        System.out.println(rebalanceCommand.getLastrebalancedequity() + " " + rebalanceCommand.getLastrebalanceddebt() + " " + rebalanceCommand.getLastrebalancedgold());
    }

    @Override
    public void execute() {
        ShowLastRebalancedamount();
    }
}
