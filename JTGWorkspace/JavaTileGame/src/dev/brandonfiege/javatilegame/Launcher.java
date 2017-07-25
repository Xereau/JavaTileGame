package dev.brandonfiege.javatilegame;

import dev.brandonfiege.javatilegame.display.Display;

public class Launcher
{
	public static void main(String[] args)
	{
		//new Display("Title!", 300, 300);		// temporary. testing creation of display JFrame window
		
		Game game = new Game("Tile Game!", 400, 400);
		game.start();
	}
}
