package com.mycompany.a3;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {
    private GameWorld gw;
    private CheckBox soundCheckBox;

    public SoundCommand(GameWorld gw, CheckBox soundCheckBox) {
        super("Sound");
        this.gw = gw;
        this.soundCheckBox = soundCheckBox;
        updateSoundCheckBox(); 
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.toggleSound(); 
        updateSoundCheckBox();
    }

    private void updateSoundCheckBox() {
        soundCheckBox.setSelected(gw.isSoundOn());
    }
}
