package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer {
    private GameWorld gw;
    private Label timeLabel;
    private Label time;
    private Label livesLabel;
    private Label life;
    private Label flagLabel;
    private Label flag;
    private Label foodLabel;
    private Label food;
    private Label healthLabel;
    private Label health;
    private Label soundLabel;
    private Label sounds;

    public ScoreView(Observable gw) {
        this.gw = (GameWorld) gw; 

        setLayout(new FlowLayout(Component.CENTER));

        labels(); 

        add(timeLabel);
        add(time);
        add(livesLabel);
        add(life);
        add(flagLabel);
        add(flag);
        add(foodLabel);
        add(food);
        add(healthLabel);
        add(health);
        add(soundLabel);
        add(sounds);
    }

    private void labels() {
        timeLabel = new Label("Time: ");
        livesLabel = new Label("Lives Left: ");
        flagLabel = new Label("Last Flag Reached: ");
        foodLabel = new Label("Food Level: ");
        healthLabel = new Label("Health: ");
        soundLabel = new Label("Sound: ");

        time = new Label("");
        life = new Label("");
        flag = new Label("");
        food = new Label("");
        health = new Label("");
        sounds = new Label("");

        timeLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        time.getAllStyles().setFgColor(ColorUtil.BLUE);
        livesLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        life.getAllStyles().setFgColor(ColorUtil.BLUE);
        flagLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        flag.getAllStyles().setFgColor(ColorUtil.BLUE);
        foodLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        food.getAllStyles().setFgColor(ColorUtil.BLUE);
        healthLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        health.getAllStyles().setFgColor(ColorUtil.BLUE);
        soundLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
        sounds.getAllStyles().setFgColor(ColorUtil.BLUE);
    }

    public void updateLabels() {
        time.setText("Time: " + gw.getTime());
        life.setText("Lives Left: " + gw.getLives());
        flag.setText("Last Flag Reached: " + gw.getLastFlagReached());
        food.setText("Food Level: " + gw.getFoodLevel());
        health.setText("Health: " + gw.getHealth());
        sounds.setText("Sound: " + (gw.isSoundOn() ? "ON" : "OFF"));
        time.getParent().revalidate();
    } 

    public void update(Observable observable, Object data) {
        if (observable instanceof GameWorld) {
            this.updateLabels();
        }
    }
}
