package UML_Alpha;

import java.awt.Graphics;

public class AssociationLine extends Line{
	
	
	public AssociationLine(int x1, int y1, int x2, int y2)
	{
		super(x1, y1, x2, y2);
	}

	@Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawLine(initialX, initialY, endX, endY);
        
    }
}
