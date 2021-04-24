package C19409486;

import java.util.ArrayList;

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


 //yasc.bullets.remove(this);
public class AlexVisual extends Visual{

    private int mode;
    private int cx, cy;

    private float lerpedAverage;
    private float[] lerpedBuffer;

    private float halfHeight;
    private float speed;

    boolean[] on;
  
    //Star[] stars;
    MusicObject[] sb;

    MusicObject[] s;
    
   

    MusicObject aw, fw, c, mc, cube, b;
    // AmpWave aw;
    // FreqWave fw;
    // Circle c, mc;
    // Cube cube;
    // Box b;

    boolean isDestroying=false;

    ArrayList<MusicObject> mo = new ArrayList<MusicObject>();

    ArrayList<MusicObject> cubes = new ArrayList<MusicObject>();

    int frameTarget;


    public void settings()
    {
       
        //size(800, 800, P3D);
        //size(1920 , 800);
     
        
        // Use this to make fullscreen
        //fullScreen(2);
        //fullScreen(2);

        // Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, 2); //span
    
        
        //fullScreen(2); //span
    }

    public void setup()
    {
        cx = width /2;
        cy = height/2;
        println("cx: " + cx);
        println(cy);
        colorMode(HSB);
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Disfigure.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening();

        lerpedAverage=0;

        halfHeight = height/2;
        speed=0;

        speed = map(mouseX, 0, width, 0, 20);
        translate(width/2, height/2);

        //stars = new Star[800];
        sb = new SecurityBeams[800];
        on = new boolean[10];

        lerpedBuffer = new float[width]; 

        aw = new AmpWave(this);
        fw = new FreqWave(this);
        c = new Circle(this);



        mc = new MagicCircle(this);


       
      
        //b = new Box(this, 200, 200 ,0, halfHeight);//Poor values
        s = new Star[200];
        reinstantiation();
    }

    //Instantiates mutiple objects
    public void reinstantiation(){
        for(int i=0; i< 5; i++){
            cubes.add(new Cube(this, 0, 50));
        }
        //Stars
        for(int i=0; i<s.length; i++){
            s[i] = new Star(this);
        }
        //Security Beam
        for(int i=0; i<sb.length; i++){
            sb[i] = new SecurityBeams(this);
        }
        //Magic Circle
        for(int i=0; i<10; i++){
            mo.add(new MagicCircle(this));
        }
    }

    //Key pressed
    public void keyPressed()
    {
        //Between 0 and 9 keys
        if (keyCode >= '0' && keyCode <= '9'){
            mode = keyCode - '0';
            on[mode] = !on[mode];
        }
        //Space bar
        else if (keyCode == ' ') {
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
        drawObjects();
    }

    public void timedDestroying(){
        if(isDestroying){
            for(int i=mo.size(); i > 0; i--){
                mo.remove(i);
            }
        }else{
            if(frameCount < frameTarget+30){
                
            } else {
                isDestroying = false;
            }
        }
    }

    //Draw the objects
    public void drawObjects(){
        background(0);
        noStroke();
        float average = 0;
        float sum = 0;

        try
        {
            //Use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Get frequency bands
        calculateFrequencyBands(); 

        // Get the average amplitude
        calculateAverageAmplitude();
        
        // Calculate the average of the buffer
        for (int i = 0; i < getAudioBuffer().size(); i ++)
        {
            sum += abs(getAudioBuffer().get(i));
        }
        average = sum / getAudioBuffer().size();

        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        //Display the modes
        for(int i=0; i < on.length; i++){
            fill(255);
            textAlign(CENTER, CENTER);
            textSize(20);
            String temp;
            temp = on[i] == true ? "on": "off";
            text(i + " : " + temp, 20 + 20, (i * 30) + 20);
        }

        //Center circle
        if(on[0]){
           c.update();
        }
        //The Amplitude lines
        if(on[1]){
            aw.update();
        }
        //The frequency lines
        if(on[2]){
            fw.update();
        } 
        //The security beams
        if(on[3]){//Problem
            for(int i=0;i< sb.length; i++){
                sb[i].update();
                sb[i].start();
            }
        }
        //Magic Circles Random appear and disappear?
        if(on[4]){//prob
            for(int i=0; i < mo.size()-1; i++){
                MusicObject temp= mo.get(i);
                temp.update();
            }
        }
        //Circle Bouncing
        if(on[5]){//prob
            
        }
        //Cube Field
        if(on[6]){
            for(int i=0; i<cubes.size(); i++){
            cubes.get(i).update();
            }
        }
        //Cube orbit
        if(on[7]){
            //
        }
        //Collusion Circles
        if(on[8]){
            // isDestroying = true;
            // frameTarget= frameCount;
            for(int i=0;i< s.length; i++){
                s[i].update();
                s[i].start();
            }
        }
        if(on[9]){
            
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


