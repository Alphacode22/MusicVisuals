package example;

import C19409486.AlexVisual;
import processing.core.*;

// This is an example of a visual that uses the audio bands
public class AudioBandsVisual
{
    AlexVisual mv;

    public AudioBandsVisual(AlexVisual alexVisual)
    {
        this.mv = alexVisual; 
    }

    public void render()
    {
        float gap = mv.width / (float) mv.getBands().length;
        mv.noStroke();
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 255, 0), 255, 255);
            mv.rect(i * gap, mv.height, gap,-mv.getSmoothedBands()[i] * 0.2f); 
        }
    }
}