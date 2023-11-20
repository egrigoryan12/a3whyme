package com.mycompany.a3;
import java.util.Observable;
import java.util.Observer;
import com.codename1.ui.Graphics;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private int height;
	private int width;
	private GameWorld gw;
	
	public MapView(Observable GameWorld) {
		
		this.setHeight(1000);
		this.setWidth(1000);
		this.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(255,0,0)));
		gw = (GameWorld) GameWorld;
	    GameWorld.addObserver(this);
	}
	public void setMapHeight(int h)
	{
		height = h;
	}
	
	public int getMapHeight()
	{
		return height;
	}
	
	public void setMapWidth(int w)
	{
		width = w;
	}
	
	public int getMapWidth()
	{
		return width;
	}
	
	
	public void paint(Graphics g) {
	    super.paint(g);
	    g.setColor(ColorUtil.BLACK);
	    draw(g);
	}
	
private void draw(Graphics g) {
	        Point pCmpRelPrnt = new Point(this.getX(), this.getY()); // Assuming MapView extends Container
	        IIterator iterator = gw.getObjects().getIterator();

	        while (iterator.hasNext()) {
	            GameObject object = (GameObject) iterator.getNext();
	            object.draw(g, pCmpRelPrnt);
	        }
	    }

	@Override
	public void update(Observable observable, Object o) {
	        this.repaint();
	        gw.map();
	    }
	}

