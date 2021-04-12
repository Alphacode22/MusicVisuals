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

public class AlexVisual extends Visual{

    int mode;


    float lerpedAverage = 0;


    float[] lerpedBuffer;


    public void settings()
    {
        size(800, 800);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
       
    }

    public void setup()
    {
        colorMode(HSB);
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Disfigure.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening();
        lerpedBuffer = new float[width]; 
    }

    public void keyPressed()
    {
      
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
        if (keyCode == ' ') {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().rewind();
                getAudioPlayer().play();
            }
        }
    }

    public void draw()
    {
        background(0);
        noStroke(); 
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        
        // Calculate the average of the buffer
        for (int i = 0; i < getAudioBuffer().size(); i ++)
        {
            sum += abs(getAudioBuffer().get(i));
        }
        average = sum / getAudioBuffer().size();

        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (mode)
        {
            //The Ampitude lines
            case 0:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < getAudioBuffer().size(); i++) {

                    float c = map(i, 0, getAudioBuffer().size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], getAudioBuffer().get(i), 0.1f);

                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                }  

                calculateFrequencyBands();

                for(int i = 0; i < getAudioBuffer().size(); i++){
                    stroke(map(i, 0, getAudioBuffer().size(), 0, 255), 255, 255);
                    line(i, halfHeight - (getAudioBuffer().get(i)* halfHeight), i, halfHeight + (getAudioBuffer().get(i) * halfHeight));
                }

                //calculateFFT();
                for(int i=0; i < fft.specSize(); i++){
                    stroke(map(i, 0 , getAudioBuffer().size(), 0 ,255), 255, 255);
                    line(i, 0, i, fft.getBand(i) * halfHeight);
                }

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
}


