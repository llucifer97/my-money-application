package entities;

import commands.*;

import java.util.List;

public class PortFolio {

    private final List<String> input;

    public PortFolio(List<String> input) {
        this.input = input;
    }

    public void run()
    {
        int n = input.size();

        String[] allocation = input.get(0).split(" ");
        String[] sip = input.get(1).split(" ");

        Equity equity = new Equity(Double.parseDouble(allocation[1]), Double.parseDouble(sip[1]));
        Debt debt = new Debt(Double.parseDouble(allocation[2]), Double.parseDouble(sip[2]));
        Gold gold = new Gold(Double.parseDouble(allocation[3]), Double.parseDouble(sip[3]));
        ICommand rebalanceCommand = new RebalanceCommand(equity, debt, gold , allocation);
        ICommand balanceCommand;
        ICommand changeCommand ;

        ICommand showRebalanceCommand = new ShowRebalanceCommand((RebalanceCommand) rebalanceCommand, equity);

        for(int i = 2 ; i < n ; i++ )
        {
            String[] stringarray = input.get(i).split(" ");
            changeCommand = new ChangeCommand(equity, debt, gold, stringarray);
            balanceCommand = new BalanceCommand(equity, debt, gold , stringarray);

            if(stringarray[0].equals("CHANGE"))
            {

                changeCommand.execute();
                if(stringarray[4].equals("JUNE")  || stringarray[4].equals("DECEMBER")  )
                {

                    rebalanceCommand.execute();
                }

            }
            else if(stringarray[0].equals("BALANCE"))
            {

                balanceCommand.execute();
            }
            else
            {

                showRebalanceCommand.execute();
            }
        }

    }
}

