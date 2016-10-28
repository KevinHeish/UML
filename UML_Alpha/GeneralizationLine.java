package UML_Alpha;

import java.awt.Color;
import java.awt.Graphics;

public class GeneralizationLine extends Line{

	public GeneralizationLine(int x1 , int y1 , int x2 ,int y2){
		super(x1 ,  y1 ,  x2 , y2);
	}

	
	@Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawLine(initialX, initialY, endX, endY);
    }
}
