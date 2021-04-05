package ie.tudublin;

import C19409486.AlexVisual;
import example.CubeVisual;
import example.CubeVisual1;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	
	public static AlexVisual av = new AlexVisual();
	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public void myUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, av);		
	}
	
	public void cubeVisual(){
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual1());	
	}

	public void rotatingAudioBands() {
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());	
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.myUI();			
	}

	
}