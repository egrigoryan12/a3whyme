package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Flag extends Fixed {
	private int sequenceNumber;

	public Flag(Point location, int sequenceNumber) {
		
		super(10, location, ColorUtil.BLUE, sequenceNumber);
		this.setSequenceNumber(sequenceNumber);
		this.setColor(0,0,255);
 
	}
	
	public void setColor(int color) {
	
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int px = (int) (getLocation().getX() + pCmpRelPrnt.getX());
		int py = (int) (getLocation().getY() + pCmpRelPrnt.getY());

		int[] xPoints = {1, 3, 2};
		int[] yPoints = {1, 1, 2};
		int nPoints = 3;

		g.setColor(this.getColor()); 
		g.fillPolygon(xPoints, yPoints, nPoints);

	    g.drawString(String.valueOf(sequenceNumber), px - getSize() / 4, py + getSize() / 2);
	}


	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " sequenceNumber = " + sequenceNumber;
		return "Flag:" + parentDesc + myDesc;
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
