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
        int min =0;
        int randInt = randomiser(0, _av.height);
        int randInt2 = randomiser(0, _av.width);
        int randInt3 = randomiser(min, 100);
        int r = randomiser(min, _av.getAudioBuffer().size()-1);

        _av.stroke((int)_av.getAudioBuffer().get(r) * 10, 255, 255);
        _av.strokeWeight(2); 
        _av.fill(0,0,0);
        _av.circle(randInt, randInt2, 20 + (_av.getLerpedAverage() * randInt3));
    }
}
