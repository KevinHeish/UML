package UML_Alpha;

import java.awt.Color;
import java.awt.Graphics;

public class AssociationLine extends Line{
	
	
	public AssociationLine()
	{
		super();
	}

	public AssociationLine(int x, int y)
	{
		super(x,y);
	}
	
	public AssociationLine(basicObject start, basicObject end)
	{
		super(start,end);
	}
	
	

	@Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        
        g.setColor(Color.BLACK);
        g.drawLine(drawX, drawY , width - offX, height - offY);
        
    }
}
