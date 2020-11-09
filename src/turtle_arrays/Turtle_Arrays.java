package turtle_arrays;

import java.util.Random;

import tbs.geom.Vec2D;
import tbs.gfx.Turtle;
import tbs.simpleapp.SimpleApp;

public class Turtle_Arrays extends SimpleApp {
	Turtle[] turtles = new Turtle[20];
	//Array to store whether the turtle is alive or not
	//Alive --> True
	//Dead --> False
	boolean[] isAlive = new boolean[20];
	Random random = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Turtle_Arrays();
	}
	
	public void main() 
	{
		//Creating array to store Turtles
		for(int i = 0; i < turtles.length; i += 1) 
		{
			Turtle newTurtle = screen.createTurtle();
			//Creates random number between 0 and 360
			//does not include 360
			int angle = random.nextInt(360); 
			newTurtle.setAngle(angle);
			int color = random.nextInt(0xffffff);
			newTurtle.setColour(color);
			 
			//Set turtle random starting points to avoid collision since start
			int x_coord = random.nextInt(400) - 200;
			int y_coord = random.nextInt(400) - 200;
			newTurtle.setPosition(x_coord,y_coord);
			
			//Store newTurtle in slots of the array at position i
			turtles[i] = newTurtle;
			
			//Sets every turtle true --> alive
			isAlive[i] = true;
		}
	}

	public void onFrame() 
	{
		//Moving the turtles
		for(int i = 0; i < turtles.length; i += 1) 
		{
			//Get turtle from current position
			Turtle currentTurtle = turtles[i];
	
			moveTurtle(currentTurtle,isAlive[i]);
			
			
			//Random num generator to create random direction
			int action = random.nextInt(3);
			if(action==0) {
				//Rotate clockwise
				currentTurtle.rotate(-2);
			}
			if(action==1) {
				//Rotate anti-clockwise
				currentTurtle.rotate(2);
			}			
		}
	}
	
	//Method for moving turtle
	public void moveTurtle(Turtle t, boolean isAlive) 
	//parameter Turtle --> U need to input turtle for this method
	{
		//if turtle is still alive, move it
		if(isAlive)
			t.move(1); 
		
		//Get current position of Turtle
		Vec2D point = t.getPosition();
		
		//When Turtle reaches edges, turn around
		//Since position is in decimal, we can't get exact num
		//-->Give it a range
		if(point.x>200||point.y>200) 
		{
			t.rotate(150);
		}
		if(point.x<-200||point.y<-200) 
		{
			t.rotate(-150);
		}
		
		
		//go through each turtle in the array
		for(int i = 0; i < turtles.length; i += 1) 
		{
			//Get turtle from current position
			Turtle otherTurtle = turtles[i];
				
		/*The same as:
		 * for(Turtle otherTurtle : turtles) 
		*/
		
			Vec2D otherPoint = otherTurtle.getPosition();
			Vec2D difference = otherPoint.sub(point);
			double distance = difference.magnitude();
			
			
			//make sure otherTurtle is different from my turtle
			//because they would have same position if they the same
			//-->avoid crashing itself
			if(otherTurtle != t && distance < 10)
				/*checks it's not the same turtle
				 * if the turtles are less than 10 pixels apart --> to count as collision
				 * because you cannot get exact coord to overlap, as it can be decimal
				 */
			{
				//Set boolean of that turtle to false if they crash into each other --> not alive
				this.isAlive[i] = false;
			}
		}
	}
}
