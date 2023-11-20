package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FoodConsumptionCommand extends Command {
    private GameWorld gw; 
    
    public FoodConsumptionCommand(GameWorld gw) {
    	super("Food Consumption Rate");
        this.gw = gw; 
 
}
    @Override
    public void actionPerformed(ActionEvent e) {
        gw.consumptionRate();
    }
}

//hello