package dev.brandonfiege.javatilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.brandonfiege.javatilegame.display.Display;

public class Game implements Runnable  			// "implements runnable" allows this class to run in its own thread
												// be sure to add a public void run() method in your class. 
{
	// this class holds all the base code for the game.
	
	private Display display;	
	public String title;
	public int width, height;
	
	private boolean running = false;	// is the game loop running? 
	private Thread thread; 				// this is the new thread that this will run on. 
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		
		
	}
	
	private void init()
	{
		display = new Display(title, width, height);
	}
	
	
	private void tick()
	{
		
	}
	
	private void render()
	{	// BUFFER STRATEGY: The way that the computer can draw things to the screen. 
		// A BUFFER is a group of memory for holding an image that is moved to the canvas within the JFrame
		 bs = display.getCanvas().getBufferStrategy();	
		 if(bs == null)
		 {
			 display.getCanvas().createBufferStrategy(3);
			 return;
		 }
		 
		 g = bs.getDrawGraphics(); // graphics object allows us to draw things to the canvas. It is getting the image from the buffer strategy object.
		 
		 //TEMP: Draw here!
		 
		 g.fillRect(0, 0, width, height);
		 
		 //TEMP: End Here!
		 
		 bs.show();
		 g.dispose();
	}
	
	
	public void run()
	{
		init();			// run method MUST call init();
		
		// Then we need to run the game loop... 
		// This updates all variables and positions of objects... 
		// then renders and draws everything to the screen. 
		// We use a while loop for this.
		
		while (running)
		{
			tick();
			render();
		}
		
		stop();
		
	}
	
	
	// you basically only use the keyword "SYNCHRONIZED" when working with threads directly.
	public synchronized void start()		// starts the thread
	{
		if(running)
			return;
		
		running = true;
		 // must initialize the new thread
		thread = new Thread(this);
		thread.start();						// thread.start() calls the run method above
	}
	
	public synchronized void stop()			// stops the thread
	{
		if(!running)
			return;
		
		running = false;
		try
		{
			thread.join(); 					// this joins the processing back to the main thread (even though it's stopped). Must be in a try/catch statement
		}
		catch (InterruptedException e)
		{
			// TODO: Auto-generated catch block
			e.printStackTrace();
		}
								
	}
}
