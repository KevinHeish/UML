package UML_Alpha;

import java.awt.Color;
import java.awt.Graphics;

public class CompositionLine extends Line{

	public CompositionLine()
	{
		super( );
	}
	
	public CompositionLine(int x, int y)
	{
		super(x,y);
	}
	
	public CompositionLine(basicObject start, basicObject end)
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
