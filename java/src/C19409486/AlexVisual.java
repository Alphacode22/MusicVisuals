package C19409486;

import example.AudioBandsVisual;
import example.WaveForm;
import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class AlexVisual extends Visual{
    int mode=0;
    float cx;
    float cy;
    float offset=0;
    Drop[] drops = new Drop[100];

    // WaveForm wf;
    // AudioBandsVisual abv;

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

        startMinim();
        for(int i=0; i<drops.length; i++){
            drops[i]= new Drop();
            //System.out.println("Reloading");
        }
        loadAudio("heroplanet.mp3");

        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);
    }

    public void keyPressed(){
        if (key == ' '){
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
        System.out.println(keyCode);
    }

    //float wave1 =0;
    public void draw(){
        background(0);
        noStroke();
        switch (mode)
        {
            case 0:
            {
                // try {
                //     calculateFFT();
                // } catch (VisualException e) {
                //     // TODO Auto-generated catch block
                //     e.printStackTrace();
                // } 
                // calculateFrequencyBands(); 
                // calculateAverageAmplitude();        
                // wf.render();
                // abv.render();
                break;
            }
            case 1: 
            {
                background(100, 0, 10);
                for(int i=0; i<drops.length; i++){
                    drops[i].show();
                    drops[i].fall();
                    //System.out.println("Shoot");
                }
                break;
            }
          
        }
    }
  
  
}
 