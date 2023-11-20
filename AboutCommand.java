package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {
    public AboutCommand() {
        super("About");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = "Name: Elina Grigoryan\n Course: CSC 133 T/TH\n Version: 3";
        Dialog.show("About", text, "OK", null);
    }
}
