package turtle_arrays;

import tbs.gfx.Turtle;
import tbs.simpleapp.SimpleApp;

public class Art extends SimpleApp{
	Turtle t = screen.createTurtle();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Art();
	}
	
	public void main() 
	{
		for(int i = 0; i<300; i+=1) {
			t.setColour((int)(Math.random() * 0x1000000));
			t.move(i);
			t.rotate(98);
		}
	}
}
