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
	private MenuItem group , ungroup , changeObjName;
	private String[] iconName = {"mouse.png", "line1.png", "line2.png",
								 "line3.png", "obj1.png" , "obj2.png"};
	private int currentDepth;
	private ArrayList<basicObject> objectList;
	private ArrayList<Line> lineList;
	private ArrayList<basicObject> selectResult;
	private ArrayList<ArrayList<basicObject>> groupLevel;
	private basicObject currentObj;
	
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
		changeObjName = new MenuItem("Change Object Name.");
		mouseAction = new Mouse();
		objectList = new ArrayList<basicObject>();
		lineList = new ArrayList<Line>();
		selectResult = new ArrayList<basicObject>();
		groupLevel = new ArrayList<ArrayList<basicObject>>();
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
		edit.add(changeObjName);
		
		this.setMenuBar(menuBar);
		this.add(buttonPanel, BorderLayout.WEST);
		buttonPanel.setLayout(new GridLayout(6,1));
		this.add(displayPanel, BorderLayout.CENTER);
		
		displayPanel.addMouseListener(mouseAction);
		displayPanel.setBackground(Color.WHITE);
		
		group.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				 if(!selectResult.isEmpty())
				 {
					 groupLevel.add(selectResult);
					 selectResult.clear();
					 System.out.println("Grouped");
				 }
			}
		});
		
		ungroup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				 if(!groupLevel.isEmpty())
				 {
					 groupLevel.remove(groupLevel.size()-1);
					 System.out.println("unGrouped");
				 }
			}
		});
		
		changeObjName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				 
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
				  
				  for(int i = 0 ; i < 6 ; i++)
					  buttonList[i].setEnabled(true);
				  
				  buttonList[0].setEnabled(false);
			  }
		});
		
		buttonList[1].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.ASSOCIATION_LINE);
				  System.out.println("ButtonState = " + mouseAction.getState());
				  
				  for(int i = 0 ; i < 6 ; i++)
					  buttonList[i].setEnabled(true);
				  
				  buttonList[1].setEnabled(false);
			  }
		});
		
		buttonList[2].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.GENERALIZATION_LINE);
				  System.out.println("ButtonState = " + mouseAction.getState());
				  
				  for(int i = 0 ; i < 6 ; i++)
					  buttonList[i].setEnabled(true);
				  
				  buttonList[2].setEnabled(false);
			  }
		});
		
		buttonList[3].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.COMPOSITION_LINE);
				  System.out.println("ButtonState = " + mouseAction.getState());
				  
				  for(int i = 0 ; i < 6 ; i++)
					  buttonList[i].setEnabled(true);
				  
				  buttonList[3].setEnabled(false);
			  }
		});
		
		buttonList[4].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.CLASS);
				  System.out.println("ButtonState = " + mouseAction.getState());
				  
				  for(int i = 0 ; i < 6 ; i++)
					  buttonList[i].setEnabled(true);
				  
				  buttonList[4].setEnabled(false);
			  }
		});
		
		buttonList[5].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  mouseAction.setState(ButtonState.USE_CASE);
				  System.out.println("ButtonState = " + mouseAction.getState());
				  
				  for(int i = 0 ; i < 6 ; i++)
					  buttonList[i].setEnabled(true);
				  
				  buttonList[5].setEnabled(false);
			  }
		});
		
	}
	
	
	public class Mouse extends MouseAdapter{
		 private ButtonState currentState;
		 private int x1 ,  y1 ,pCount = 0 , p1;
		 
		 public Mouse()
		 {
			 currentState = ButtonState.SELECT;
		 }
		
		 public basicObject selectObj(int posX, int posY)
		 {
			 ArrayList<basicObject> selectAll = new ArrayList<basicObject>();
    		 basicObject selectedObject = null;
    		 
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
    				 selectedObject = selectAll.get(i);
    			 }
    		 }
    		 
    		 return selectedObject;
		 }
		 
		 public ArrayList<basicObject> selectMultiple(int x2, int y2)
		 {
			 ArrayList<basicObject> selectAll = new ArrayList<basicObject>();
			 
			 if(x1 > x2){
				 int temp = x2;
				 x2 = x1;
				 x1 = temp;
			 }
			 if(y1 > y2){
				 int temp = y2;
				 y2 = y1;
				 y1 = temp;
			 }
			 
			 for(int i = 0; i < objectList.size(); i++)
    		 {
				 objectList.get(i).setSelected(false);
				 
    			 if(objectList.get(i).getX() >= x1 && 
   					objectList.get(i).getY() >=y1 && 
   					objectList.get(i).getX() + objectList.get(i).getWidth() <=x2 &&
   					objectList.get(i).getY() + objectList.get(i).getHeight() <= y2
    				)
    			 {
    				 objectList.get(i).setSelected(true);
    				 selectAll.add(objectList.get(i));
    			 }
    		 }
			 
			 return selectAll;
		 }
	 
		 public void mousePressed(MouseEvent e){			 
			 if(currentState == ButtonState.SELECT)
			 {
				 x1 = e.getX();
				 y1 = e.getY();
				 currentObj = selectObj (x1,y1);
			 }
			 
			 
			 if(currentState == ButtonState.ASSOCIATION_LINE || 
				currentState == ButtonState.GENERALIZATION_LINE || 
				currentState == ButtonState.COMPOSITION_LINE)
			 {
				System.out.print("Mouse pressed\n");
				int mouseX = e.getX();
				int mouseY = e.getY();
				
				
				basicObject objectOne = selectObj(mouseX , mouseY);
				
				if(objectOne!=null)
				{
					int min = 9999;
					
					for(int i = 0 ; i < 4 ;i++){
						int distance = Math.abs(mouseX - objectOne.getPortX(i)) 
										+ Math.abs(mouseY - objectOne.getPortY(i));
						if(min > distance)
						{
							min = distance;
							x1 =  objectOne.getPortX(i);
							y1 =  objectOne.getPortY(i);
							p1 = i;
						}
					}
					
					
					currentObj = objectOne;
					System.out.println("x : y  " + x1 +" " + y1);		
					pCount++;
				}
				else{
					System.out.println("No object here.");
					pCount = 0;
				}
	    	 }
			 
			 
	     }
		 
		 public void mouseDragged(MouseEvent e){
			 
		 }
		 
	     public void mouseClicked(MouseEvent e) {
	    	 
	    	 if(currentState == ButtonState.SELECT){
	    		 int posX = e.getX();
	    		 int posY = e.getY();
	    		 basicObject object;
	    		 
	    		 
	    		 object = selectObj(posX,posY);
	    		 if(object==null){
	    			 System.out.println("No obj here.");
	    			 return;
	    		 }
	    		 
	    		 displayPanel.remove(object);
	    		 object.setDepth(currentDepth++);
	    		 object.setSelected(true);
	    		 displayPanel.add(object,0);
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
	    	 
	    	 
	    	 displayPanel.revalidate();
	    	 displayPanel.repaint();
	     }
	     
	     
	     public void mouseEntered(MouseEvent e) {

	     }
	     
	     public void mouseExited(MouseEvent e) {

	     }
	     
	     public void mouseReleased(MouseEvent e){
			 if(currentState == ButtonState.SELECT)
			 {
				 
				 if(currentObj != null)
				 {
					if(Math.abs(e.getX() - x1) > 1 && Math.abs(e.getY() - y1) > 1){
						currentObj.setX(e.getX());
						currentObj.setY(e.getY());
						currentObj.portCalculate();
						
						for(int i = 0 ; i < lineList.size(); i++)
						{
							lineList.get(i).upDate();
						}
					}
				 }
				 else
					 selectResult = selectMultiple(e.getX() , e.getY()); 
			 }
	    	 
			 else if(currentState == ButtonState.ASSOCIATION_LINE || 
					 currentState == ButtonState.GENERALIZATION_LINE || 
					 currentState == ButtonState.COMPOSITION_LINE)
	 		 {
	 				System.out.print("Mouse release\n");
	 				
	 				int mouseX = e.getX();
					int mouseY = e.getY();
					int x2 = 0, y2 = 0;
					
					
					basicObject objectOne = selectObj(mouseX , mouseY);
					
					if(objectOne!=null)
					{
						int min = 9999;
						int p2 = 0;
						
						
						for(int i = 0 ; i < 4 ;i++){
							int distance = Math.abs(mouseX - objectOne.getPortX(i)) 
											+ Math.abs(mouseY - objectOne.getPortY(i));
							if(min > distance)
							{
								min = distance;
								x2 = objectOne.getPortX(i);
								y2 = objectOne.getPortY(i);
								p2 = i;
							}
						}
						
						Line createLine = new AssociationLine();
						
						if(pCount==1){
							createLine.setPoint1(x1, y1);
							createLine.setPoint2(x2, y2);
							createLine.setLineBounds();
							createLine.setStartObj(currentObj);
							createLine.setEndObj(objectOne);
							createLine.setInPort(p1);
							createLine.setOutPort(p2);
							
							
							displayPanel.add(createLine,0);
							lineList.add(createLine);
							
							System.out.println("ini x : y  " + createLine.initialX +" " + createLine.initialY );
							System.out.println("end x : y  " + createLine.endX +" " + createLine.endY );
							pCount = 0;
						}
					}
					else{
						System.out.println("No object here.");
						pCount = 0;
					}
	 	     }
			 
			 
			 displayPanel.revalidate();
			 displayPanel.repaint();
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
