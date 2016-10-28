package UML_Alpha;

import java.awt.Color;
import java.awt.Graphics;

public class UseCase extends basicObject{
	private final int offset = 5;
	
	
	public UseCase(int x,int y,int nowDepth)
	{
		super(x,y,nowDepth);
		width = 120;
		height = 80;
	}
	
	public UseCase(int x,int y , int w, int h, int nowDepth)
	{
		super(x,y,w,h,nowDepth);
		width = 120;
		height = 80;
	}
	
	
	@Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.setColor(Color.GRAY);
        g.fillOval(0 , 0 , width, height);
        g.setColor(Color.BLACK);
        g.drawOval(0 , 0 , width, height);
        
        if(selected == true)
        {
        	g.setColor(Color.BLACK);
        	g.fillRect(width/2  , 0 , offset, offset);
        	g.fillRect(width/2   , height - offset , offset,offset);
        	g.fillRect(0 , height / 2 , offset , offset);
        	g.fillRect(width - offset , height/2 , offset ,offset);
        }
    }
}
