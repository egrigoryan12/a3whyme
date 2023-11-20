package com.mycompany.a3;

import java.util.Random;
import java.util.Observer;

import com.codename1.charts.models.Point;
import java.util.Vector;
import java.util.Observable;
import java.util.Random;

public class GameWorld extends Observable{
	private int width = 1000;
	private int height = 1000;
	private int lives;
	private int clock;
	Ant PlayerAnt;
	Random random = new Random();	
	private boolean Sound = false;
    private GameObjectCollection objects; 
    private int flagNumber = 1;

  
   public GameWorld() {
	   objects = new GameObjectCollection();
   }
	public void init() {
		lives = 3;
		clock = 0;
		PlayerAnt = new Ant(new Point(55f, 50f), 20);
		PlayerAnt.setHealthLevel(10);
		objects.add(PlayerAnt);
		addfoodStationNum();
		addSpiderNum();
		addFlagNum();

	}
 
	public void Sound() {
	    Sound = !Sound;
	}
		public void addFlagNum() {
			
			Point position1 = new Point(10, 25);
			Point position2 = new Point(50, 100);
			Point position3 = new Point(150, 200);
			Point position4 = new Point(250, 450);
			
			objects.add(new Flag(position1, 1));
			objects.add(new Flag(position2, 2));
			objects.add(new Flag(position3, 3));
			objects.add(new Flag(position4, 4));
		}
		
		public void addSpiderNum() {
			
			Point LocationSpider = new Point(random.nextInt(1000), random.nextInt(1000));		
			int sizeSpider = random.nextInt(49) + 10;
			int heading = random.nextInt(349) + 0;

			objects.add(new Spider(sizeSpider, LocationSpider, heading));
			objects.add(new Spider(sizeSpider, LocationSpider, heading));

	}

		public void addfoodStationNum() {
			
			Point locationFoodStation = new Point(random.nextInt(1000), random.nextInt(1000));

			int sizeFoodStation = random.nextInt(49) + 10;
			int capacity = sizeFoodStation;

			objects.add(new FoodStation(sizeFoodStation, locationFoodStation, capacity));
			objects.add(new FoodStation(sizeFoodStation, locationFoodStation, capacity));

		}		
	
	public void accelerate() {
		
		int accelerate = 10;
		PlayerAnt.setSpeed(PlayerAnt.getSpeed() + accelerate);
		System.out.println("Ant speed was increased.");
		setChanged();
	    notifyObservers();
	    map();
	}
	
	public void brake() {
		
		int brake = -10;
		PlayerAnt.setSpeed(PlayerAnt.getSpeed() + brake);
		System.out.println("Ant speed was decreased.");
		setChanged();
	    notifyObservers();
	    map();

	}
	
	public void l() {
		int turnLeft = -5;
		PlayerAnt.setHeading(PlayerAnt.getHeading() + turnLeft);
		PlayerAnt.updateHeading();
		System.out.println("Ant turned left.");
		setChanged();
	    notifyObservers();
	    map();

	}

	public void r() { 
		
		int turnRight = 5;
		PlayerAnt.setHeading(PlayerAnt.getHeading() + turnRight);
		PlayerAnt.updateHeading();
		System.out.println("Ant turned right.");
		setChanged();
	    notifyObservers();
	    map();

	}

	public void consumptionRate() {
		
		int setConsumptionRate = 10;
		System.out.println("The Ant consumption rate is " + setConsumptionRate);

	}
	
	public void handleCollisionWithFlag(int flagNumber) {
		
		PlayerAnt.collideFlag(flagNumber);
		System.out.println("The Ant collided with flag:" + flagNumber);
		setChanged();
	    notifyObservers();
	    map();

	}
	
	public void handleCollisionWithFoodStation() {
		
		PlayerAnt.setHealthLevel(PlayerAnt.getHealthLevel());
		int currentHealth = PlayerAnt.getHealthLevel();
	    currentHealth += 2;
	    PlayerAnt.setHealthLevel(currentHealth);
		System.out.println("Ant has increased Health Level.");
		setChanged();
	    notifyObservers();
	    map();

	}
	
	public void handleCollisionWithSpider() {
		
		PlayerAnt.spicollideAnt();
		 if (PlayerAnt.getHealthLevel() > 0) {
		        PlayerAnt.reduceHealth(2);
		    }
		 if (PlayerAnt.getHealthLevel() <= 0) {
		        PlayerAnt.setSpeed(1); 
		    }
		System.out.println("Ant hit a spider.");

		setChanged();
		notifyObservers();
	    map();

	}
	
	public void tick() {
	    clock++;
	    death();

	    IIterator iterator = objects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject object = (GameObject) iterator.getNext();
	        if (object instanceof Moveable) {
	            Moveable moveableObject = (Moveable) object;
	            moveableObject.move();
	        }
	        if (object instanceof ICollider) {
	            ICollider colliderObject = (ICollider) object;
	            IIterator collisionIterator = objects.getIterator();
	            while (collisionIterator.hasNext()) {
	                GameObject otherObject = (GameObject) collisionIterator.getNext();
	                if (otherObject != object && otherObject instanceof ICollider) {
	                    ICollider otherCollider = (ICollider) otherObject;
	                    if (colliderObject.collidesWith(otherObject)) {
	                        // Collision detected, handle the collision
	                        colliderObject.handleCollision(otherObject);
	                    }
	                }
	            }
	    }

	    setChanged();
	    notifyObservers();
	    map();

	    PlayerAnt.myTick();

	    if (PlayerAnt.getHealthLevel() <= 0 || PlayerAnt.getFoodLevel() <= 0) {
	        System.out.println("You lost.");
	        lives--;
	        map();
	    if (lives > 0) {
	    	objects.clear(); 
	        init();
	    }
	    }
	    }
	    
	    

	}

	public void display() {
		System.out.println("The number of lives left are: " + lives);
		System.out.println("The current clock value is: " + clock);
		System.out.println("The highest flag reached is: " + PlayerAnt.getLastFlagReached());
		System.out.println("The current food level is : " + PlayerAnt.getFoodLevel());
		System.out.println("The health level is: " + PlayerAnt.getHealthLevel());
	}
	
	public void map() {
	    System.out.println();
	    IIterator elements = objects.getIterator(); 
	    while (elements.hasNext()) {
	        GameObject game = (GameObject) elements.getNext();
	        System.out.println(game.toString());
	    }
	}

	public void death() {
		if(lives <= 0) {
			System.out.println("Game Over, you failed!");
			exit();
		}
	}
	
	public void exit() {
		System.exit(0);
	}

	public void turnLeft() {
	}

	public void turnRight() {
	}
    public void addObserver(MapView mv) {
        addObserver((Observer) mv);
    }

    public void addObserver(ScoreView sv) {
        addObserver((Observer) sv);
    }

	public void printMap() {		
	}

	public boolean isSoundOn() {
		return false;
	}

	public Object toggleSound() {
		return null;
	}

	public String getTime() {
		return null;
	}

	public String getLastFlagReached() {
		return null;
	}

	public String getLives() {
		return null;
	}

	public String getFoodLevel() {
		return null;
	}


	public String getHealth() {
		return null;
	}
	public int getNextFlagNumber() {
		return flagNumber++;
	}
	public GameObjectCollection  getObjects() {
		return objects;
	}
	public boolean getPosition() {
		return false;
	}
	public GameObjectCollection getGameObjectCollection() {
		return null;
	}
	public boolean getIsPaused() {
		return false;
	}

}
