package UML_Alpha;

import java.awt.Color;
import java.awt.Graphics;

public class GeneralizationLine extends Line{

	public GeneralizationLine()
	{
		super();
	}

	public GeneralizationLine(int x, int y)
	{
		super(x,y);
	}
	
	public GeneralizationLine(basicObject start, basicObject end)
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
