package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class FoodStation extends Fixed implements ICollider{
	private int capacity;

	public FoodStation(int size, Point location, int capacity) {
		super(size, location, ColorUtil.GREEN, capacity);
		this.setColor(0,255,0);
		setCapacity(size);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}	

	public void setColor(int color) {
		
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
	    int px = (int) (getLocation().getX() + pCmpRelPrnt.getX());
	    int py = (int) (getLocation().getY() + pCmpRelPrnt.getY());

	    int size = getSize();  

	    g.setColor(this.getColor());
	    g.fillRect(px - size / 2, py - size / 2, size, size);

	 
	    g.drawString("Capacity: " + String.valueOf(capacity), px - size / 2, py + size / 2);
	}

	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " Capacity = " + capacity;
		return "FoodStation:" + parentDesc + myDesc;
		}

	  @Override
	    public void handleCollision(ICollider otherObject) {
	        GameObject other = (GameObject) otherObject;

	        if (other instanceof Ant) {
	            this.handleCollisionWithAnt((Ant) other);
	        }
	        // Add additional conditions for other object types if needed
	    }

	    private void handleCollisionWithAnt(Ant ant) {
	        // Increase the health level of the Ant by 2
	        int currentHealth = ant.getHealthLevel();
	        currentHealth += 2;
	        ant.setHealthLevel(currentHealth);

	        System.out.println("Ant has increased Health Level.");

	        // Notify observers and update map
	        setChanged();
	        notifyObservers();
	        map();
	    }

		private void map() {
			// TODO Auto-generated method stub
			
		}

		private void notifyObservers() {
			// TODO Auto-generated method stub
			
		}

		private void setChanged() {
			// TODO Auto-generated method stub
			
		}
	   
		@Override
		public boolean collidesWith(ICollider otherObject) {
			// TODO Auto-generated method stub
			return false;
		}

	}
	
	
