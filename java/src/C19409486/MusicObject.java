package C19409486;

import java.util.Random;

import ddf.minim.AudioBuffer;

public abstract class MusicObject implements IUnityLike{

    AlexVisual _av;
    float _x;
    float _y;
    float _z;

    // //This is the function that will start and display the object first
    public void start(){

    }
    // //This will update object every frame
    public void update(){
        
    }

    //This will create our buffer
    public float[] generateLerp(AudioBuffer inBuffer, AlexVisual av){
        float[] outBuffer = new float[inBuffer.size()];

        for(int i=0; i<inBuffer.size(); i++){
            outBuffer[i] = av.lerp(outBuffer[i], inBuffer.get(i), 0.8f);
        }

        return outBuffer;
    }

    int randomiser(int min, int max){
        int randInt =0;
        Random rng = new Random();

        randInt = rng.nextInt(max - min + 1) + min;
        return randInt;
    }
   

}


