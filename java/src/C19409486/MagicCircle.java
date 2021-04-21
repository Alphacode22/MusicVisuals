package C19409486;

import java.util.Random;

import ddf.minim.AudioBuffer;
import processing.core.PApplet;

public class MagicCircle extends Circle{
    AlexVisual _av;
    
    public MagicCircle(AlexVisual av){
        super(av);//?
        _av = av;
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        super.start();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        super.update();
        magicCircle();
    }
   
    public void magicCircle(){
        Random rng = new Random();
        int min =0;
        int max = _av.height;
        int randInt=0, randInt2=0, randInt3=0, randInt4=0;
        int i;
        randInt = rng.nextInt(max - min + 1) + min;
        randInt2 = rng.nextInt(max - min + 1) + min;
        randInt3 = rng.nextInt(100 - 0 + 1) + 0;
        i = rng.nextInt(_av.getAudioBuffer().size() - min + 1) + min;
        _av.stroke((int)_av.getAudioBuffer().get(i) * 10, 100, 100);
        _av.strokeWeight(2); 
        _av.fill(0,0,0);
        _av.ellipse(randInt, randInt2, 20 + (_av.getLerpedAverage() * randInt3), 20 + (_av.getLerpedAverage() * randInt3));
    }
}
