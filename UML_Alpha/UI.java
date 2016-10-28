package UML_Alpha;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;


public class UI extends JFrame{
	private Mouse mouseAction;
	private JPanel buttonPanel , displayPanel;
	private JButton[] buttonList;
	private int height , width;
	private MenuBar menuBar;
	private Menu file , edit;
	private MenuItem group , ungroup;
	private String[] iconName = {"mouse.png", "line1.png", "line2.png",
								 "line3.png", "obj1.png" , "obj2.png"};
	private int currentDepth;
	private ArrayList<basicObject> objectList;
	
	
	public UI(int w , int h)
	{
		buttonPanel = new JPanel();
		displayPanel = new JPanel();
		menuBar = new MenuBar();
		file = new Menu("File");
		edit = new Menu("Edit");
		buttonList = new JButton[6];
		group = new MenuItem("Group");
		ungroup = new MenuItem("UnGroup");
		mouseAction = new Mouse();
		objectList = new ArrayList<basicObject>();
		currentDepth = 0;
		height = h;
		width = w;
		
		setUpFrame();
		setButtonAction();
	}
	
	
	public void setUpFrame()
	{
		int buttonNum = 6;
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("UML_Maker");
		this.setSize(width , height);
		this.setVisible(true);
		this.setResizable(false);
		
		menuBar.add(file);
		menuBar.add(edit);
		edit.add(group);
		edit.add(ungroup);
		
		this.setMenuBar(menuBar);
		this.add(buttonPanel, BorderLayout.WEST);
		buttonPanel.setLayout(new GridLayout(6,1));
		this.add(displayPanel, BorderLayout.CENTER);
		
		displayPanel.addMouseListener(mouseAction);
		displayPanel.setBackground(Color.WHITE);
		
		group.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				 System.out.println("還沒做按三小");
			}
		});
		
		
		for(int i = 0 ; i < buttonNum ; i++){
			String path = "C:\\Users\\kennen\\workspace\\OO_UML\\src\\UML_Alpha\\icon\\";
			
			path += iconName[i];
			buttonList[i] = new JButton();
			buttonList[i].setIcon(new ImageIcon(path));
			buttonPanel.add(buttonList[i]);
		}
		
		revalidate();
		repaint();
	}
	
	
	public void setButtonAction()
	{
		
		buttonList[0].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.SELECT);
				  System.out.println("ButtonState = " + mouseAction.getState());
			  }
		});
		
		buttonList[1].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.ASSOCIATION_LINE);
				  System.out.println("ButtonState = " + mouseAction.getState());
			  }
		});
		
		buttonList[2].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.GENERALIZATION_LINE);
				  System.out.println("ButtonState = " + mouseAction.getState());
			  }
		});
		
		buttonList[3].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.COMPOSITION_LINE);
				  System.out.println("ButtonState = " + mouseAction.getState());
			  }
		});
		
		buttonList[4].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.CLASS);
				  System.out.println("ButtonState = " + mouseAction.getState());
				  
			  }
		});
		
		buttonList[5].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.USE_CASE);
				  System.out.println("ButtonState = " + mouseAction.getState());
			  }
		});
		
	}
	
	
	public class Mouse extends MouseAdapter{
		 private ButtonState currentState;  
		 
		 public Mouse()
		 {
			 currentState = ButtonState.SELECT;
		 }
		
		 public void mousePressed(MouseEvent e){
	         
	     }
	     public void mouseClicked(MouseEvent e) {
	    	 if(currentState == ButtonState.SELECT){
	    		 int posX = e.getX();
	    		 int posY = e.getY();
	    		 ArrayList<basicObject> selectAll = new ArrayList<basicObject>();
	    		 basicObject topObject = new basicObject();
	    		 
	    		 for(int i = 0; i < objectList.size(); i++)
	    		 {
	    			 if(objectList.get(i).checkRange(posX, posY)==true)
	    			 	selectAll.add(objectList.get(i));
	    		 }
	    		 
	    		 for(int i = 0; i < objectList.size(); i++)
	    		 {
	    			 objectList.get(i).setSelected(false);
	    		 }
	    		 
	    		 for(int i = 0 ; i < selectAll.size() ; i++ )
	    		 {
	    			 int maxDepth = -1;
	    			 
	    			 
	    			 if(maxDepth < selectAll.get(i).getDepth()){
	    				 maxDepth = selectAll.get(i).getDepth();
	    				 topObject = selectAll.get(i);
	    			 }
	    		 }
	    		 
	    		 topObject.setSelected(true);
	    	 }
	    	 
	    	 else if(currentState == ButtonState.CLASS ){
	    		 ClassObject classObj = new ClassObject(e.getX(),e.getY(),currentDepth);
	    		 
	    		 objectList.add(classObj);
	    		 displayPanel.add(classObj,0);
	    		 currentDepth++;
	    		 
	    		 System.out.println("Current object count : " + objectList.size());
	    	 }
	    	 
	    	 else if(currentState == ButtonState.USE_CASE){
	    		 UseCase caseObj = new UseCase(e.getX(),e.getY(),currentDepth);
	    		 
	    		 objectList.add(caseObj);
	    		 displayPanel.add(caseObj,0);
	    		 currentDepth++;
	    		 
	    		 System.out.println("Current object count : " + objectList.size());
	    	 }
	    	 
	    	 else if(currentState == ButtonState.ASSOCIATION_LINE){
	    		 int posX = e.getX();
	    		 int posY = e.getY();
	    		 
	    		 
	    		 
	    	 }
	    	 
	    	 else if(currentState == ButtonState.GENERALIZATION_LINE){
	    		 
	    	 }
	    	 
	    	 else if(currentState == ButtonState.COMPOSITION_LINE){
	    		 
	    	 }
	    	 
	    	 displayPanel.revalidate();
	    	 displayPanel.repaint();
	    	 
	     }
	     
	     public void mouseEntered(MouseEvent e) {

	     }
	     
	     public void mouseExited(MouseEvent e) {

	     }
	     
	     public void mouseReleased(MouseEvent e) {

	     }
	     
	     public void setState(ButtonState inputState)
	     {
	    	 currentState = inputState;
	    	 System.out.println(" current : " + currentState);
	     }
	     
	     public ButtonState getState()
	     {
	    	 return currentState;
	     }
	     
	}
}
