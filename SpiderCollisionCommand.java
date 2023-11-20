
package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpiderCollisionCommand extends Command {
    private GameWorld gw; 
    
    public SpiderCollisionCommand(GameWorld gw) {
    	super("Collide with Spider");
        this.gw = gw; 
 
}
    @Override
    public void actionPerformed(ActionEvent e) {
        gw.handleCollisionWithSpider();
    }
}