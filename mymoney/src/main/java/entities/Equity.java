package entities;

import java.util.HashMap;
import java.util.Map;

public class Equity {

     private final Double allocation;
     private final Double sip;
     private int currentValue;
     private final Map<String , Integer> dataStore = new HashMap<>();


    private void initizialize() {
        this.currentValue = (int) Math.floor(allocation);
    }

    public Equity(double allocation, double sip) {
        this.allocation = allocation;
        this.sip = sip;
        initizialize();
    }


    public  int getCurrentValue(){
        return currentValue;
    }

    public void updateMarketChange(String marketChangePercent , String month)
    {

        boolean profit = true;
        double percentchange ;
        if(marketChangePercent.charAt(0) == '-')
        {
            profit = false;
            percentchange = Double.parseDouble(marketChangePercent.substring(1,marketChangePercent.length() - 1));
        }
        else
        {
            percentchange = Double.parseDouble(marketChangePercent.substring(0,marketChangePercent.length() - 1));
        }

        if(!month.equals("JANUARY")){
            currentValue = (int) (currentValue + sip);
        }

        double valueChange = percentchange*currentValue/100;

        if(profit)
        {
            valueChange = currentValue +valueChange;
        }
        else
        {
            valueChange = currentValue - valueChange;
        }


       this.currentValue = (int) valueChange;
        dataStore.put(month,currentValue);

    }

    public int getDataByMonth(String month) {
        return dataStore.get(month);
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public boolean canRebalance()
    {
        return dataStore.size() >= 6;
    }
}
