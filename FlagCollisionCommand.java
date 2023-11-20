package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FlagCollisionCommand extends Command {
    private GameWorld gw;

    public FlagCollisionCommand(GameWorld gw) {
        super("Collide with Flag");
        this.gw = gw;
    }

	@Override
    public void actionPerformed(ActionEvent e) {
        int number = gw.getNextFlagNumber();
        gw.handleCollisionWithFlag(number);
    }
}