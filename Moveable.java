package com.mycompany.a3;


import java.util.Random;

import com.codename1.charts.models.Point;

public abstract class Moveable extends GameObject{
	
	protected int heading;
	protected int speed;
	private int foodLevel = 100;

	
	public Moveable(int size, Point location, int heading, int color) {
		super(size, location, color);
	}

	
	public int getHeading() {
		return heading;
	}
	public void setHeading(int heading) {
		this.heading = heading;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getFoodLevel() {
		
		return foodLevel;
	}

	public void setFoodLevel(int foodLevel) {
		
		this.foodLevel = foodLevel;
	}
	public void move() {
		
		float newX = (float)Math.cos(Math.toRadians(90 - this.getHeading()))*this.speed + this.getLocation().getX();	
		float newY = (float)Math.sin(Math.toRadians(90 - this.getHeading()))*this.speed + this.getLocation().getY();
			this.setLocation(newX, newY);
			//make sure this works 
	        Random random = new Random();
			 int headingUpdates = random.nextInt(11) - 5; 
		     int newHeading = (getHeading() + headingUpdates + 360) % 360;
		     setHeading(newHeading);
	}
	
		public String toString() {
			
			String parentDesc = super.toString();
			String myDesc = " Heading = " + heading + " Speed = " + speed;;
			return parentDesc + myDesc;		
		}
	}
