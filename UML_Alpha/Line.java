package UML_Alpha;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Line extends JPanel{
	protected int initialX, initialY , endX , endY;
	protected basicObject startObj , endObj;
	
	public Line(int x1 , int y1 , int x2 ,int y2)
	{
		initialX = x1;
		initialY = y1;
		
		endX = x2;
		endY = y2;
	}
	
	public void connected(basicObject firstObject , basicObject secondObject)
	{
		startObj = firstObject;
		endObj = secondObject;
	}
	
	
}
