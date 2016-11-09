
package UML_Alpha;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

public  class basicObject extends JPanel{
	protected int xPosition , yPosition;
	protected int depth;
	protected int width , height;
	protected boolean selected = false;
	protected int[] connectedPort;
	
	public basicObject()
	{
		this.xPosition = 0;
		this.yPosition = 0;
		this.depth = 0;
		this.width = 120;
		this.height = 120;
		connectedPort = new int[8];

		setOpaque(false);
	}
	
	public basicObject(int x , int y,int nowDepth)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.depth = nowDepth;
		this.width = 120;
		this.height = 120;
		connectedPort = new int[8];
		setOpaque(false);
	}
	
	public basicObject(int x , int y, int w ,int h,int nowDepth)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.depth = nowDepth;
		this.width = w;
		this.height = h;
		connectedPort = new int[8];
		setOpaque(false);
	}
	
	public int getX(){
		return xPosition;
	}
	
	public int getY(){
		return yPosition;
	}
	
	public int getDepth()
	{
		return this.depth;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	public void setX(int x){
		this.xPosition = x;
	}
	
	public void setY(int y){
		this.yPosition = y;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(width+1, height+1);
    }
	
	public void setSelected(boolean selection)
	{
		selected = selection;
	}
	
	public boolean getSelected()
	{
		return selected;
	}
	
	public boolean checkRange(int x , int y)
	{
		if( x >= xPosition && x<=xPosition + width)
		{
			if(y >= yPosition && y <= yPosition + height)
				return true;
			else 
				return false;
		}
		else
			return false;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	
	public int getPortX(int port)
	{
		return connectedPort[port];
	}
	
	public int getPortY(int port)
	{
		return connectedPort[port+4];
	}
	
	public void portCalculate()
	{
		
	}
	
	
}
