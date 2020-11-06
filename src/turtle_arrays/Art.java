package turtle_arrays;

import tbs.gfx.Turtle;
import tbs.simpleapp.SimpleApp;
import java.util.Random;

public class Art extends SimpleApp{

	Turtle t = screen.createTurtle();
	Random random = new Random();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Art();
	}
	
	public void main() 
	{
		for(int i = 0; i<300; i+=1) {
			int color = random.nextInt(0xffffff);
			t.setColour(color);
			t.move(i);
			t.rotate(98);
		}
	}
}
