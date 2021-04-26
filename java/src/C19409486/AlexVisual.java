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
import peasy.PeasyCam;
import processing.core.PApplet;
import processing.core.PVector;

public class AlexVisual extends Visual{

    private int mode;
    private int cx, cy;

    private float lerpedAverage;
    private float[] lerpedBuffer;

    private float halfHeight;
    private float speed;

    boolean[] on;
  

    MusicObject aw, fw, c, mc, cube, b;
    MusicObject sphere;

    MusicObject[] sbArray, sArray, bbArray;


   
    boolean isDestroying=false;

    ArrayList<MusicObject> moList, cubesList;

    
    int frameTarget;
    //private PApplet orbits;

    PeasyCam cam;
    private Orbit rightOrbit;
    //Terrain t;
    private Orbit leftOrbit;


    public void settings()
    {
        //Other sizes
        //size(800, 800, P3D);
        //size(1920 , 800);
     
        // Use this to make fullscreen
        //fullScreen(2);

        // Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, 2); 
    }

    public void setup()
    {
        cx = width/2;
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

        moList = new ArrayList<MusicObject>();

        cubesList = new ArrayList<MusicObject>();

        sbArray = new SecurityBeams[800];
        on = new boolean[10];

        lerpedBuffer = new float[width]; 

        aw = new AmpWave(this);
        fw = new FreqWave(this);
        c = new Circle(this);

       

        mc = new MagicCircle(this);

    

        bbArray = new BouncingCircle[5];

        sArray = new Star[200];


    
        reinstantiation();

        sphere = new Sphere(this);
        sphere.start();

        rightOrbit = new Orbit(this, 50, 0, 0);

        rightOrbit.spawnOrbitObjects(4, 1);
     
        // pushMatrix();
        
        // PVector vect1 = new PVector(this.width, 0, 0);
        // leftOrbit = new Orbit(this, vect1, 50, 0, 0);
     
        // popMatrix();

        coolCube = new CoolCubes(this);
    }

    //Instantiates mutiple objects
    public void reinstantiation(){
        //Cubes
        for(int i=0; i< 5; i++){
            cubesList.add(new Cube(this, 0));
        }
        //Stars
        for(int i=0; i<sArray.length; i++){
            sArray[i] = new Star(this);
        }
        //Security Beam
        for(int i=0; i<sbArray.length; i++){
            sbArray[i] = new SecurityBeams(this);
        }
        //Magic Circle
        for(int i=0; i<10; i++){
            moList.add(new MagicCircle(this));
        }
        //bouncing Circle
        for(int i=0; i<bbArray.length; i++){
            bbArray[i] = new BouncingCircle(this);
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

    //Draw the objects
    boolean haveOne = false;
    private CoolCubes coolCube;
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
        if(on[3]){
            for(int i=0;i< sbArray.length; i++){
                sbArray[i].update();
                sbArray[i].start();
            }
        }
        //Magic Circles Random appear and disappear?
        if(on[4]){
            for(int i=0; i < moList.size()-1; i++){
                MusicObject temp= moList.get(i);
                temp.update();
            }
        }
        //Circle Bouncing
        if(on[5]){
            for(int i=0; i < bbArray.length; i++){
                bbArray[i].update();
            }
        }
        //Cube Field
        if(on[6]){
            for(int i=0; i<cubesList.size(); i++){
                cubesList.get(i).update();
            }
        }
        //Sphere
        if(on[7]){
            sphere.update();
        }
        //Orbit
        if(on[8]){
            rightOrbit.update();
            rightOrbit.orbit();
        }
        //Weird Cubes
        if(on[9]){
          
            coolCube.update();
            
            //t.update();
        }
    }

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


