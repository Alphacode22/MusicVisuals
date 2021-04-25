package C19409486;



public class Orbit extends MusicObject {
    float radius;
    float angle;
    float distance;
    Orbit[] orbits = new Orbit[3];
    float orbitSpeed;

    Orbit(AlexVisual av, float r, float d, float o){
        _av = av;
        radius = r;
        distance = d;
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
            float d = _av.random(50, 150);
            float o = _av.random(0.02f, 0.1f);
            orbits[i] = new Orbit(_av, r, d/level, o);
            if(level < 2){
                int num = (int)(_av.random(0,4));
                orbits[i].spawnSmallerOrbits(num, level +1);
            }
          
        }
    }

    public void start(){
        _av.pushMatrix();
        _av.translate(distance,0);
        _av.rotate(angle);
        _av.translate(distance, 0);
        _av.fill(255);
        _av.ellipse(0, 0, radius*2, radius*2);

        if(orbits[0] != null){
            for(int i =0; i < orbits.length; i++){
                orbits[i].start();
            }
        }
        _av.popMatrix();
    }//20:41 / 3

    public void update(){
        this.spawnSmallerOrbits(5, 2);
        this.orbit();
    }
}