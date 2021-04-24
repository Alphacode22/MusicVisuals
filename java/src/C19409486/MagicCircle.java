package C19409486;

import java.util.Random;

import ddf.minim.AudioBuffer;
import processing.core.PApplet;

public class MagicCircle extends Circle{

    
    public MagicCircle(AlexVisual av){
        super(av);//?
        _av = av;
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
     
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        drawMagicCircle();
    }
   
    public void drawMagicCircle(){
        Random rng = new Random();
        int min =0;
        int max = _av.height;

        int heightMax = _av.height;
        int widthMax = _av.width;

        int randInt=0, randInt2=0, randInt3=0;
        int i;
        randInt = rng.nextInt(heightMax - min + 1) + min;
        randInt2 = rng.nextInt(widthMax - min + 1) + min;
        randInt3 = rng.nextInt(100 - 0 + 1) + 0;
        i = rng.nextInt(_av.getAudioBuffer().size() - min ) + min;//-1

        _av.stroke((int)_av.getAudioBuffer().get(i) * 10, 255, 255);
        _av.strokeWeight(2); 
        _av.fill(0,0,0);
        _av.circle(randInt, randInt2, 20 + (_av.getLerpedAverage() * randInt3));
    }
}
