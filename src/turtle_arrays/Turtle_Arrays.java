package turtle_arrays;

import java.util.Random;

import tbs.geom.Vec2D;
import tbs.gfx.Turtle;
import tbs.simpleapp.SimpleApp;

public class Turtle_Arrays extends SimpleApp {
	Turtle[] turtles = new Turtle[50];
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
			//Store newTurtle in slots of the array at position i
			turtles[i] = newTurtle;
		}
	}

	public void onFrame() 
	{
		//Moving the turtles
		for(int i = 0; i < turtles.length; i += 1) 
		{
			//Get turtle from current position
			Turtle currentTurtle = turtles[i];
			
			//Lift the pen up so there's no trace of their movement
			currentTurtle.setPenDown(false);
			
			moveTurtle(currentTurtle);
			
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
			
			//Get current position of Turtle
			Vec2D point = currentTurtle.getPosition();
			//Since position is in decimal, we can't get exact num
			//-->Give it a range
			if(point.x>200) 
			{
				currentTurtle.rotate(150);
			}
			if(point.x<-200) 
			{
				currentTurtle.rotate(-150);
			}
			if(point.y>200) 
			{
				currentTurtle.rotate(150);
			}
			if(point.y<-200) 
			{				
				currentTurtle.rotate(-150);
			}
		}	
	}
	
	//Method for moving turtle
	public void moveTurtle(Turtle t) 
	//parameter Turtle --> U need to input turtle for this method
	{
		t.move(1);
	}
}
