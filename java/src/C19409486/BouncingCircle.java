package C19409486;

import java.util.Random;

public class BouncingCircle extends Circle{

    private float gravity=40;

    float ySpeed=0;


    public BouncingCircle(AlexVisual av) {
        super(av);
        _av = av;
        _x = randomiser(0, _av.width);
        _y = _av.getCy();
        _z = 0;
        gravity = 1;
       
       
        //TODO Auto-generated constructor stub
    }

    public void start(){

    }
   
    public void update(){
        drawBouncingCircles();
    }

    void drawBouncingCircles(){

        if(gravity <= 2){
            gravity = 20;
        }
       
        _y *= ySpeed;

        _av.stroke(100, 255, 255);
        _av.strokeWeight(2); 
        _av.fill(0,0,0);
        _av.circle(_x , _y , 50);

        


       

        if(_y >= _av.height){
            ySpeed -= gravity;
            // Random rng= new Random();
            // int heightMax=10;
            // int min=10;
            // int i = rng.nextInt(heightMax - min + 1) + min;
            // for(int i =0; i < _av.getAudioBuffer().size(); i ++){
            //     gravity *= 20* _av.getAudioBuffer().get(i);
            // }
         
        }else {
            ySpeed += 10 ;
        }
    }




    
    int randomiser(int min, int max){
        Random rng = new Random();
        // int min =0;
        // int max = _av.height;

        int heightMax = _av.getCy();
        int widthMax = _av.getCx();

        int randInt=0, randInt2=0, randInt3=0;
        int i;
        randInt = rng.nextInt(heightMax - min + 1) + min;
        randInt2 = rng.nextInt(widthMax - min + 1) + min;
        randInt3 = rng.nextInt(100 - 0 + 1) + 0;
        i = rng.nextInt(_av.getAudioBuffer().size() - min ) + min;//-1

        return randInt;
    }
}
