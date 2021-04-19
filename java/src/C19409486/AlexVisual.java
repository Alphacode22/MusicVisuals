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

    private int mode;
    private int cx, cy;


    private float lerpedAverage = 0;
    private float[] lerpedBuffer;

    private float halfHeight = height/2;
    private float speed=0;


            
    Star[] stars = new Star[800];
    SecurityBeams[] sb = new SecurityBeams[800];


    boolean[] on = new boolean[9];

    AmpWave aw;
    FreqWave fw;
    Circle c;


    public void settings()
    {
        size(800, 800, P3D);
        //size(1200, 800);
        cx = width /2;
        cy = height/2;
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 

        //Use P3D
       
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



        for(int i=0; i<stars.length; i++){
            stars[i] = new Star();
        }
        for(int i=0; i<stars.length; i++){
            sb[i] = new SecurityBeams();
        }
        aw = new AmpWave(this);
        fw = new FreqWave(this);
        c = new Circle(this);
    }

    public void keyPressed()
    {
      
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
            on[mode] = !on[mode];

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
        // fill(0);
        // rect(0,0,width,height);
        noStroke();
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

       
        //The Amplitude lines
        if(on[1]){
            aw.update();
        }
        //Weird vertex
        if(on[2]){
            fw.update();
        } 
        if(on[3]){
            c.update();
        }
        if(on[4]){
            speed = map(mouseX, 0, width, 0, 20);
            translate(width/2, height/2);


            for(int i=0;i< stars.length; i++){
                sb[i].update();
                sb[i].start();
            }
            
        }
    }

    // public void draw()
    // {
    //     //background(0);
    //     fill(0);
    //     rect(0,0,width,height);
    //     noStroke();
    //     float average = 0;
    //     float sum = 0;

    //     try
    //     {
    //         // Call this if you want to use FFT data
    //         calculateFFT(); 
    //     }
    //     catch(VisualException e)
    //     {
    //         e.printStackTrace();
    //     }
    //     // Call this is you want to use frequency bands
    //     calculateFrequencyBands(); 

    //     // Call this is you want to get the average amplitude
    //     calculateAverageAmplitude();
        
    //     // Calculate the average of the buffer
    //     for (int i = 0; i < getAudioBuffer().size(); i ++)
    //     {
    //         sum += abs(getAudioBuffer().get(i));
    //     }
    //     average = sum / getAudioBuffer().size();

    //     // Move lerpedAverage 10% closer to average every frame
    //     lerpedAverage = lerp(lerpedAverage, average, 0.1f);

    //     switch (mode)
    //     {
    //         //The Amplitude lines
    //         case 0:
    //         {
    //             // Iterate over all the elements in the audio buffer
    //             // for (int i = 0; i < getAudioBuffer().size(); i++) {

    //             //     float c = map(i, 0, getAudioBuffer().size(), 0, 255);
    //             //     stroke(c, 255, 255);
    //             //     lerpedBuffer[i] = lerp(lerpedBuffer[i], getAudioBuffer().get(i), 0.1f);

    //             //     line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
    //             // }  

    //             calculateAverageAmplitude();
    //             calculateFrequencyBands();

               


    //             aw.update();
    //             fw.update();
    //             c.update();

          
               

            
    //         }
    //         //Weird vertex
    //         case 1:
    //         {
    //             // fill(100, 0, 0);
    //             // rect(0, 0, 200, 200);
    //             // for(int i=0;i< stars.length; i++){
    //             //     stars[i].update();
    //             //     stars[i].start();
    //             // }
    //             // break;
    //         }
    //         case 2:
    //         {
    //             speed = map(mouseX, 0, width, 0, 20);
    //             translate(width/2, height/2);


    //             for(int i=0;i< stars.length; i++){
    //                 sb[i].update();
    //                 sb[i].start();
    //             }
    //             break;
    //         }
    //         //Weird vertex
    //         // case 3:
    //         // {
    //         //     background(0, 100, 100);
    //         //     fill(50, 100, 100);
    //         //     circle(cx, cy, 400);
    //         //     fill(180, 100, 100);
    //         //     triangle(400, 200, 200, 600, 600, 600);
    //         //     fill(0, 0, 70);
    //         //     ellipse(cx, cy, 200, 100);
    //         //     fill(0, 0, 0);
    //         //     circle(cx, cy, 50);
    //         //     break;
    //         // }
    //         //Cube spawner
    //         // case 3:
    //         // {
    //             // Cube cube= new Cube(Main.av, 0);
    //             // cube.show();
    //             // cube.update();
    //             // break;
    //         // }
    //         //Shooting stars
    //         // case 4:
    //         // {
    //         //     //background(0);
    //         //     for (int i = 0; i < ab.size(); i++) {

    //         //         float c = map(i, 0, ab.size(), 0, 255);
    //         //         stroke(c, 255, 255);
    //         //         lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

    //         //         line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                  
    //         //     }  
              
    //         //     speed = map(mouseX, 0, width, 0, 20);
    //         //     translate(width/2, height/2);
    //         //     for(int i=0;i< stars.length; i++){
    //         //         stars[i].update();
    //         //         stars[i].show();
    //         //     }
    //         //     break;
                
    //         // }
    //         // //Raindrops lets
    //         // case 5: 
    //         // {
    //         //     //background(100, 0, 10);
    //         //     for(int i=0; i<drops.length; i++){
    //         //         drops[i].show();
    //         //         drops[i].update();
    //         //     }
    //         //     break;
    //         // }
    //     }   
    // }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public float getLerpedAverage() {
        return lerpedAverage;
    }

    public void setLerpedAverage(float lerpedAverage) {
        this.lerpedAverage = lerpedAverage;
    }

    public float[] getLerpedBuffer() {
        return lerpedBuffer;
    }

    public void setLerpedBuffer(float[] lerpedBuffer) {
        this.lerpedBuffer = lerpedBuffer;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

    public void setHalfHeight(float halfHeight) {
        this.halfHeight = halfHeight;
    }
}


