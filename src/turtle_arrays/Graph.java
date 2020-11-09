package turtle_arrays;

import tbs.simpleapp.SimpleApp;

public class Graph extends SimpleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Graph();
	}
	
	public void main() 
	{
		drawCross(0,0);
	}
	
	public void drawCross(int x, int y) 
	{
		screen.drawLine(x-3, y-3, x+3, y+3);
		//Go from (x-3,y-3) to (x+3,y+3)
	}
}
