package C19409486;

import processing.core.PVector;

public class Orbit {
    float radius;
    float angle;
    float distance;
    Orbit[] orbits = new Orbit[3];
    float orbitSpeed;
    PVector v;
    AlexVisual _av;

    Orbit(AlexVisual av, float r, float d, float o){
        _av= av;
        v= PVector.random3D();
        radius = r;
        distance = d;
        v.mult(distance);
        angle =_av.random(_av.TWO_PI);
        orbitSpeed = o;
    }

    void orbit(){
        angle = angle + orbitSpeed;
        if(orbits[0] != null){
            for(int i =0; i < orbits.length; i++){
                orbits[i].orbit();
            }
        }
    }

    public void spawnSmallerOrbits(int total, int level){
        orbits = new Orbit[total];
        for(int i=0; i < orbits.length; i++){
            float r = radius / (level * 1.2f);
            float d = radius + r;
            float o = _av.random((radius + r), (radius + r) * 2);
            orbits[i] = new Orbit(_av, r, d, o);
            if(level < 2){
                int num =1;
                orbits[i].spawnSmallerOrbits(num, level +1);
            }
          
        }
    }

    public void start(){
        _av.pushMatrix();
        _av.noStroke();
        _av.fill(255);
       // _av.translate(distance,0);
        //_av.rotate(angle);
        _av.camera();

        PVector v2 = new PVector(1,0, 1);
        PVector p = v.cross(v2);
        _av.rotate(angle, p.x, p.y, p.z);
        
        _av.translate(v.x, v.y, v.z);
       // _av.fill(255);
        //_av.ellipse(0, 0, radius*2, radius*2);
      
        _av.box(100);

        if(orbits[0] != null){
            for(int i =0; i < orbits.length; i++){
                orbits[i].start();
            }
        }
        _av.popMatrix();
    }

    public void update(){
        this.spawnSmallerOrbits(5, 2);
        this.orbit();
    }
}