package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Ant extends Moveable implements IFoodie{
	
	private int maximumSpeed = 30;
	private int foodConsumptionRate = 10;
	private int healthLevel = 10;
	private int lastFlagReached = 1;
	private int foodLevel = 100;
	private int death;
	private int red = 225;
	private GameWorld gameWorld; 
	
	
	public Ant(Point location, int heading) {
		
		super(20, location, heading, ColorUtil.red(0));
		this.setSpeed(15);
		this.setHeading(0);
		this.setColor(255,0,0);
	}

	public int getMaximumSpeed() {
		
		return maximumSpeed;
	
	}
	public void setSpeed() {
		if (speed <= maximumSpeed) {
			this.speed = speed;
		} else {
            this.speed = maximumSpeed;
		}
	}
	public void setMaximumSpeed(int maximumSpeed) {
		
		this.maximumSpeed = maximumSpeed;
	}
	public int getFoodLevel() {
		
		return foodLevel;
	}

	
	public void setFoodLevel(int foodLevel) {
		
		this.foodLevel = foodLevel;
	}
	public int getFoodConsumptionRate() {
		
		return foodConsumptionRate;
	}

	public void setFoodConsumptionRate(int foodConsumptionRate) {
		
		this.foodConsumptionRate = foodConsumptionRate;
	}

	public int getHealthLevel() {
		
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		
		this.healthLevel = healthLevel;
	} 
	
	public void setHealth() {
		
		if (healthLevel == 10) {
			this.speed = 0;
		}
	}

	public int getLastFlagReached() {
		
		return lastFlagReached;
	}

	public void setLastFlagReached(int lastFlagReached) {
		
		this.lastFlagReached = lastFlagReached;
	}
	 public void reduceHealth(int amount) {
	        healthLevel -= amount;
	    }

	public void updateHeading() {
		
        int updateHeading = getHeading();
        
        if (updateHeading < 0) {
            this.setHeading(updateHeading + 360);
        }
        else if (updateHeading > 360) {
            this.setHeading(updateHeading - 360);
        }
        else {
            this.setHeading(updateHeading);
        }
	}
	@Override
	public int setFoodConsumption() {
		return 0;
	}

	
	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}


	public void collideFlag(int number) {
	    gameWorld.handleCollisionWithFlag(number);

	}

	public void spicollideAnt() {
		  gameWorld.handleCollisionWithSpider();
	}
	
	public void collideFoodStat() {
		gameWorld.handleCollisionWithFoodStation();
    }
	
	
	public void turnLeft(int i) {
		
	}

	public void turnRight(int i) {
		
	}

	public int myTick() {
		
		int fLevel = getFoodLevel() - foodConsumptionRate;
		setFoodLevel(fLevel);
		return fLevel;
		
		
	}
	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	 
	 @Override
	 public void draw(Graphics g, Point pCmpRelPrnt) {
	     int px = (int) (getLocation().getX() + pCmpRelPrnt.getX());
	     int py = (int) (getLocation().getY() + pCmpRelPrnt.getY());

	     int radius = getSize() / 2; 
	     g.setColor(this.getColor());
	     int r = radius;
	     
	     g.fillArc(px - r, py - r, 2 * r, 2 * r, 0, 360);


	     g.drawString("Ant", px - r / 2, py + r / 2);
	 }
	 
	 
	 
	 


	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " maxSpeed = " + maximumSpeed +  " foodLevel = " + getFoodLevel() + " healthLevel =" + getHealthLevel() + " foodConsumptionRate = " + foodConsumptionRate; 
		return "Ant:" + parentDesc + myDesc;
	}

	@Override
	public boolean collidesWith(ICollider otherObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		
	}








	
}
