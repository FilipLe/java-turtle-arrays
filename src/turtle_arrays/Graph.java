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
		
		//plot the average point
		drawCross(averagePosts,averageLikes);
		System.out.println("Average Coordinates: ("+averagePosts+","+averageLikes+")");
		
		//Formula for calculating slope of line of best fit:
		//Source: https://www.varsitytutors.com/hotmath/hotmath_help/topics/line-of-best-fit
		
		//				n																 	   
		//				∑((POSTS_PER_DAY[i]-averagePosts)*(LIKES_PER_DAY[i]-averageLikes))  
		//				i																	  
		//m = -------------------------------------------------------------------------------------------------
		//						n
		//						∑((POSTS_PER_DAY[i]-averagePosts)^2)
		//						i
		
		//Calculating Y-intercept
		//averageLikes - m*averagePosts
		
		//Gradient
		double numerator = 0;
		double denominator = 0;
		for(int i = 0; i < InstagramLikes.NUM_DATA; i++) 
		{
			double currentNumerator = (InstagramLikes.POSTS_PER_DAY[i]*10-averagePosts)*(InstagramLikes.LIKES_PER_DAY[i]-averageLikes);
			numerator += currentNumerator;
			
			double currentDenominator = Math.pow((InstagramLikes.POSTS_PER_DAY[i]*10-averagePosts), 2);
			denominator += currentDenominator;
		}
		double gradient = numerator/denominator;
		System.out.println(gradient);
		
		//y-intercept
		double yIntercept = averageLikes - (gradient*averagePosts);
		System.out.println(yIntercept);
		
		//Use expression y = mx + c
		//Try to calculate 2 points that lie on the line and join them
		
		int x1 = -100;
		double y_1 = gradient * x1 + yIntercept;
		int y1 = (int)y_1;
		
		int x2 = 100;
		double y_2 = gradient * x2 + yIntercept;
		int y2 = (int)y_2;
		
		System.out.println("("+x1+","+y1+")");
		System.out.println("("+x2+","+y2+")");
		screen.setColour(0x00ff00);
		screen.drawLine(x1-55, y1, x2-55, y2);
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
