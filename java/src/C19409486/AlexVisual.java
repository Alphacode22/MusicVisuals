package C19409486;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import example.AudioBandsVisual;
import example.WaveForm;
import ie.tudublin.Main;
import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class AlexVisual extends Visual{
    int mode=0;
    float cx;
    float cy;
    float offset=0;
    
    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples

    Drop[] drops = new Drop[100];
    Star[] stars = new Star[800];
    float speed=0;

    // WaveForm wf;
    // AudioBandsVisual abv;
    float[] lerpedBuffer;

    public void settings() {
        size(800, 800, P3D);
        //println("CWD: " + System.getProperty("user.dir"));
        cx = width / 2;
        cy = height / 2;   
        //fullScreen(P3D, SPAN);
    }

    public void setup(){
        colorMode(HSB);
        noCursor();
        setFrameSize(256);

        minim = new Minim(this);
     
        ap = minim.loadFile("Disfigure.mp3", width);
        ap.play();
        ab = ap.mix; // Connect the buffer to the mp3 file

        //ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        //ab = ai.mix; 

        colorMode(HSB);
        lerpedBuffer = new float[width];

        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);

        for(int i=0; i<drops.length; i++){
            drops[i]= new Drop();
        }
        for(int i=0; i<stars.length; i++){
            stars[i] = new Star();
        }
    }

    public void keyPressed(){
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
 
    }

    float lerpedAverage = 0;
    private float angle = 0;

    float y = 200;
    float lerpedY = y;

    //int which = 0;

    //float wave1 =0;
    public void draw(){
        background(0);
        noStroke(); 
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;

        float myX=0;
        float myY=0;

        // Calculate the average of the buffer
        for (int i = 0; i < ab.size(); i ++)
        {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();

        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (mode)
        {
            case 0:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                }  
                break;      
            }
            case 1:
            {
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

                    ellipse(i,  halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                } 
                break; 
            }
            case 2:
            {
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

                    ellipse(i,  halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                } 
                break; 
            }
            // case 2:
            // {
           
            //     fill(100); 
            //     stroke(255);
            //     line(cx, cy,myX ,myY);
                
            //     break; 
            // }
            // case 3:
            // {
            //     background(0);
            //     calculateAverageAmplitude();
            //     stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            //     strokeWeight(5);
            //     noFill();
            //     lights();
            //     pushMatrix();
            //     //
            //     camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
            //     translate(0, 0, -200);
            //     rotateX(angle);
            //     rotateZ(angle);       
            //     float boxSize = 50 + (200 * getSmoothedAmplitude()); 
            //     box(boxSize);   
            //     popMatrix();
            //     angle += 0.01f;
            // }
            // case 6:
            // {
            //     for (int i = 0; i < ab.size(); i++) {

            //         float c = map(i, 0, ab.size(), 0, 255);
            //         stroke(c, 255, 255);
            //         lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

            //         ellipse(i,  halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
            //     } 
            //     break; 
            // }
            case 7:
            {
                Cube cube= new Cube(Main.av, 0);
                cube.show();
                cube.update();
                break;
            }
            case 8:
            {
                //background(0);
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                  
                }  
              
                speed = map(mouseX, 0, width, 0, 20);
                translate(width/2, height/2);
                for(int i=0;i< stars.length; i++){
                    stars[i].update();
                    stars[i].show();
                }
                break;
                
            }
            case 9: 
            {
                //background(100, 0, 10);
                for(int i=0; i<drops.length; i++){
                    drops[i].show();
                    drops[i].fall();
                }
                break;
            }
        }
    }
}
 