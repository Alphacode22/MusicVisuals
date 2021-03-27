package ie.tudublin;

import C19409486.AlexVisual;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public static AlexVisual myUI()
	{
		AlexVisual av = new AlexVisual();
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, av);	
		return av;	
	}
	

	public static void main(String[] args)
	{
		//Main main = new Main();
		Main.myUI();			
	}
}