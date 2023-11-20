package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public abstract class GameObject implements IDrawable, ICollider{
	protected int size;
	private Point location = new Point(0,0);
	private int color;
	private int heading;

		
	public GameObject(int size, Point location, int heading) {
		this.size = size;
		this.location = location;
		this.setHeading(heading);
	}

	public int getSize() {
		return size;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public void setLocation(float X, float Y) {
		this.location = new Point(X,Y);
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int r, int g, int b) {
		this.color = ColorUtil.rgb(r, g, b);
	}

	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

	public String toString() {
        String myDesc = " Location = (" + Math.round(this.location.getX() * 10.0) / 10.0 + "," + Math.round(this.location.getY() * 10.0)/ 10.0 +
        ") Color = (" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + ")"  +
        " Size = " + this.getSize();
        return myDesc;
    }

	public void draw(Graphics g, Point pCmpRelPrnt) {
		   int px = (int) (getLocation().getX() + pCmpRelPrnt.getX() - getSize() / 2);
	        int py = (int) (getLocation().getY() + pCmpRelPrnt.getY() - getSize() / 2);

	    g.setColor(getColor());
	    g.fillRect(px, py, getSize(), getSize());
        g.drawString("Object", px + getSize() / 4, py + getSize() / 2);

	}


}


