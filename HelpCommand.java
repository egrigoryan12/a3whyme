package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command {

	  public HelpCommand() {
	        super("Help");
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String text = "Keys:\n a - Accelerate\n b - Brake\n l - Left Turn\n r - Right Turn\n c - Set Food Consumption\n f - Collide with Food Station\n g - Collide with Spider\n t - Tick\n";
	        Dialog.show("Help", text, "OK", null);
	    }
	}
