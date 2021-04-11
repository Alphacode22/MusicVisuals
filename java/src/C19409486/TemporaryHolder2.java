package C19409486;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import ddf.minim.analysis.FourierTransform;
import example.AudioBandsVisual;
import example.WaveForm;
import ie.tudublin.Main;
import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class TemporaryHolder2 extends Visual{
    int mode=0;
    float cx;
    float cy;
    float offset=0;
    
    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples

    float[] bands;
    float[] smoothedBands;

    Drop[] drops = new Drop[100];
    Star[] stars = new Star[800];
    float speed=0;

    float[] lerpedBuffer;

    float lerpedAverage = 0;
    private float angle = 0;

    float y = 200;
    float lerpedY = y;

    // float[] _bands;
    // float[] _smoothedBands;

    float w = width/ 64;

    FFT fft;


    public void settings() {
        size(800, 800, P3D);
        cx = width / 2;
        cy = height / 2;   
    }

    public void setup(){
        colorMode(HSB);
        noCursor();
        setFrameSize(256);

        minim = new Minim(this);
     
        ap = minim.loadFile("Disfigure.mp3", width);
        ap.play();
        ab = ap.mix; // Connect the buffer to the mp3 file

        colorMode(HSB);
        lerpedBuffer = new float[width];
        
        // _bands = new float[(int) log2(width)];
        // _smoothedBands = new float[bands.length];

        //fft = getFFT();

        //Instance 
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

    public void draw(){
        background(0);
        noStroke(); 
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;

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
            //The Ampitude lines
            case 0:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                }  

                calculateFrequencyBands();

                for(int i = 0; i < ab.size(); i++){
                    stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
                    line(i, halfHeight - (ab.get(i)* halfHeight), i, halfHeight + (ab.get(i) * halfHeight));
                }

                fft.window(FFT.HAMMING);

                break; 
            }
            //Weird vertex
            case 1:
            {
                fill(100, 0, 0);
                rect(0, 0, 200, 200);
                break;
            }
            //Weird vertex
            // case 2:
            // {
            //     background(0, 100, 100);
            //     fill(50, 100, 100);
            //     circle(cx, cy, 400);
            //     fill(180, 100, 100);
            //     triangle(400, 200, 200, 600, 600, 600);
            //     fill(0, 0, 70);
            //     ellipse(cx, cy, 200, 100);
            //     fill(0, 0, 0);
            //     circle(cx, cy, 50);
            //     break;
            // }
            //Cube spawner
            // case 3:
            // {
                // Cube cube= new Cube(Main.av, 0);
                // cube.show();
                // cube.update();
                // break;
            // }
            //Shooting stars
            // case 4:
            // {
            //     //background(0);
            //     for (int i = 0; i < ab.size(); i++) {

            //         float c = map(i, 0, ab.size(), 0, 255);
            //         stroke(c, 255, 255);
            //         lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

            //         line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                  
            //     }  
              
            //     speed = map(mouseX, 0, width, 0, 20);
            //     translate(width/2, height/2);
            //     for(int i=0;i< stars.length; i++){
            //         stars[i].update();
            //         stars[i].show();
            //     }
            //     break;
                
            // }
            // //Raindrops lets
            // case 5: 
            // {
            //     //background(100, 0, 10);
            //     for(int i=0; i<drops.length; i++){
            //         drops[i].show();
            //         drops[i].update();
            //     }
            //     break;
            // }
        }   
    }

    float log2(float f) {
        return log(f) / log(2.0f);
    }

}