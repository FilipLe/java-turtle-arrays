package turtle_arrays;

import tbs.datasets.InstagramLikes;
import tbs.simpleapp.SimpleApp;

public class Graph extends SimpleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Graph();
	}
	
	public void main() 
	{
		//Draw Vertical Line Grids
		screen.setColour(0x696969);//gray grid lines
		for(int x = -200; x < 200; x += 10) 
		{
			screen.drawLine(x, -200, x, 200);
		}
		
		//Draw Horizontal Line Grids
		screen.setColour(0x696969);//gray grid lines
		for(int y = -200; y < 200; y += 10) 
		{
			screen.drawLine(-200, y, 200, y);
		}
		
		
		//drawCross(0,0);
		//Draw a cross at position (0,0) --> centre of screen
		
		//Plotting the data 
		screen.setColour(0xffffff);//make the crosses white 
		
		//Initialize variable to store sum of number of posts
		int sumPosts = 0;
				
		//Initialize variable to store sum of number of likes
		int sumLikes = 0;
		
		//for loop to go through each element in the array
		for(int index = 0; index < InstagramLikes.NUM_DATA; index += 1) 
		{
			//Gets number of posts per day stored in position 'index' in the array InstagramLikes
			int posts = InstagramLikes.POSTS_PER_DAY[index]*10;
			//we multiply by 10 so that it wouldn't be too close to each other on the graph
			//-->axis a bit larger
			
			//add the num of posts to variable sumPosts
			sumPosts += posts;
			
			//Gets number of likes  per day stored in position 'index' in the array InstagramLikes
			int likes = InstagramLikes.LIKES_PER_DAY[index];
			
			//add the num of likes to variable sumLikes
			sumLikes += likes;
			
			//Posts on x-axis, likes on y-axis 
			//Draws a cross at position (posts,likes)
			drawCross(posts,likes);
		}
		
		//Plotting average
		//set color red
		screen.setColour(0xff0000);
		//Find average amount of posts
		int averagePosts = Math.round(sumPosts/InstagramLikes.NUM_DATA);
		
		//Find average amount of likes
		int averageLikes = Math.round(sumLikes/InstagramLikes.NUM_DATA);
		
		//plot the average
		drawCross(averagePosts,averageLikes);
		
	}
	
	//Method to plot crosses/points  on a graph
	public void drawCross(int x, int y) 
	{
		//Since origin is in the very middle, we need to shift the graph down left
		x -= 200;
		y -= 200;
		
		screen.drawLine(x-3, y-3, x+3, y+3);
		//Go from (x-3,y-3) to (x+3,y+3)
		//Bottom left corner to top right corner of the line
		
		screen.drawLine(x+3, y-3, x-3, y+3);
		//Go from (x+3,y-3) to (x-3,y+3)
		//Bottom right corner to top left corner
	}
}