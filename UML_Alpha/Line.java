package UML_Alpha;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Line extends JPanel{
	protected int initialX, initialY , endX , endY;
	protected basicObject startObj , endObj;
	protected int width , height , drawX, drawY , offX , offY;
	protected int inPort , outPort;
	
	public Line()
	{
		offX = offY = drawX = drawY = initialX = initialY = endX = endY = -1;
		width = height = 0;
		setOpaque(false);
	}
	
	public Line(int x , int y)
	{
		initialX = x;
		initialY = y;
		width = height = 0;
		setOpaque(false);
	}
	
	public void setInPort(int p)
	{
		inPort = p;
	}
	
	public void setOutPort(int p)
	{
		outPort = p;
	}
	
	public Line(basicObject start, basicObject end)
	{
		startObj = start;
		endObj = end;
		setOpaque(false);
	}
	
	public void setPoint1(int x , int y )
	{
		initialX = x ;
		initialY = y ;
	}
	
	public void setStartObj(basicObject start)
	{
		startObj = start;
	}
	
	public void setEndObj(basicObject end)
	{
		endObj = end;
	}
	
	public void setPoint2(int x , int y )
	{
		endX = x ;
		endY = y ;
	}
	
	public void upDate()
	{
		initialX = startObj.getPortX(inPort);
		initialY = startObj.getPortY(inPort);
		
		endX = endObj.getPortX(outPort);
		endY = endObj.getPortY(outPort);
		
		setLineBounds();
	}
	
	public void setLineBounds()
	{
		int diffX = endX - initialX;
		int diffY = endY - initialY;
		
		width = Math.abs(diffX);
		height = Math.abs(diffY);
		
		if(diffY*diffX < 0){	
			if(diffX < 0){
				drawX = width;
				drawY = 0;
				initialX -= width;
				offX = width;
				offY = 0;
			}
			else{
				drawX = 0;
				drawY = height;
				initialY -= height;
				offX = 0;
				offY = height;
			}
		}
		else{
			if(diffX > 0){
				offX = offY = drawX = drawY = 0;
			}
			else{
				initialX -= width;
				initialY -= height;
				drawX = width;
				drawY = height;
				offX = width;
				offY = height;
			}
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width+1, height+1);
    }
	
	
	public void setStart(basicObject start)
	{
		startObj = start;
	}
	
	public void setEnd(basicObject end)
	{
		endObj = end;
	}
	
	public int getX(){
		return initialX;
	}
	
	public int getY(){
		return initialY;
	}
	
}
