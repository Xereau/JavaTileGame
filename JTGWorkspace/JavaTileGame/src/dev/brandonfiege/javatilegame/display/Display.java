package dev.brandonfiege.javatilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display 
{
	private JFrame frame;	// JFrames are windows we can use to display things
	private Canvas canvas;	// Canvas is what we use to draw graphics in a JFrame. This gets drawn to a canvas, then added to the JFrame.
	
	private String title;	
	private int width;		// in pixels
	private int height; 	// in pixels
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
		
	}
	
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// makes sure that the window closes down properly
																	// This closes the entire program when this window is closed,
																	// as opposed to just closing the display window. 
		
		frame.setResizable(false);									// We do not want this window to be resizable
		frame.setLocationRelativeTo(null);							// We want this to appear in the center of the screen
		frame.setVisible(true);										// JFrames are not visible by default
		
		// YOU CAN TYPE "frame." and see a bunch of other parameters you can set, but we'll stop here.
		
		// Create new canvas to put graphics into
		
		canvas = new Canvas();		// initialize the canvas object, and make sure it always stays at width and height we give it.
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		// add to the JFrame
		frame.add(canvas);
		frame.pack();		// resize window to see the full canvas. 

	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}
