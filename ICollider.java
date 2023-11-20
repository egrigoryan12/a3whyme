package com.mycompany.a3;

import com.codename1.charts.models.Point;

public interface ICollider {
	public boolean collidesWith(ICollider otherObject);
	public void handleCollision(ICollider otherObject);

}
