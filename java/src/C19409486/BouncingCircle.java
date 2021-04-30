package C19409486;

import java.util.Random;

public class BouncingCircle extends Circle{

    private float gravity=20;
    private float ySpeed=-1;

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

        _y += ySpeed; 

        if(_y > _av.height || _y <0){
    
            ySpeed *=  -1;
        }else{
            ySpeed += gravity;
        }

        _av.stroke(100, 255, 255);
        _av.strokeWeight(2); 
        _av.fill(0,0,0);
        _av.circle(_x , _y , 50);
    }
}
