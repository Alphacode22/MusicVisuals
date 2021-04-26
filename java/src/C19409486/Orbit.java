package C19409486;

import peasy.PeasyCam;
import processing.core.PVector;

class Orbit {
    float _size;
    float _distance;
    Orbit[] _orbitObjects;
    float _angle;
    float _orbitSpeed;
    PVector _v = new PVector();
    AlexVisual _av;
    
    //First constructor
    public Orbit(AlexVisual av, float size, float distance, float orbitSpeed) {
      this._av = av;
      //Random Vector
      _v = PVector.random3D();
      //The size of the box
      _size = size;
      //The distance away from the main orbiting object
      _distance = distance;
      //Move some distance away from the main object
      _v.mult(_distance);
      //Give the seconday orbit object a random angle
      _angle = _av.random(_av.TWO_PI);
      //Give it some speed
      _orbitSpeed = orbitSpeed;
    }

    //Second constructor
    public Orbit(AlexVisual av, PVector pv, float radius, float distance, float orbitSpeed) {
      this._av = av;
      this._v.set(500, 500, 0);
      _size = radius;
      _distance = distance;
      _v.mult(_distance);
      _angle = _av.random(_av.TWO_PI);
      _orbitSpeed = orbitSpeed;
    }
  
  
    void orbit() {
      // Change the angle
      _angle += _orbitSpeed;
      //If we have any secondary orbit objects
      if (_orbitObjects != null) {
        //Make them orbit
        for (int i = 0; i < _orbitObjects.length; i++) {
          _orbitObjects[i].orbit();
        }
      }
    }
  
    //Create smaller orbits
    void spawnOrbitObjects(int total, int level) {
      _orbitObjects = new Orbit[total];
      for (int i = 0; i < _orbitObjects.length; i++) {
        //float radius = _radius/(level*2);

        //Create orbit objects using those parameter   
        float size = _size;
        float distance = _av.random((_size + size), (_size+size)*2);
        float orbitSpeed = _av.random(-0.1f, 0.1f);
        _orbitObjects[i] = new Orbit(_av, size, distance, orbitSpeed);

        //The levels of orbiting objects needed
        if (level < 2) {
          //Get a random amount
          int num = (int)_av.random(0, 3);
          _orbitObjects[i].spawnOrbitObjects(num, level+1);
        }
      }
    }
  
    void update() {
     // System.out.println(_v);

      _av.pushMatrix();
      //_av.camera();
      _av.noStroke();

      //PVector v2 = new PVector(1, 0, 1);
      
      PVector v2 = new PVector(_av.height, _av.width, 10);

      //Gets cross product which is the pendicular line that the orbiter object rotate around
      PVector p = _v.cross(v2);

      //Rotate with the pendicular line
      _av.rotate(_angle, p.x, p.y, p.z);
      //_av.stroke(255);

     // _av.line(0, 0, 0, v.x, v.y, v.z);
      //_av.line(0, 0, 0, p.x, p.y, p.z);
      //_av.translate(500, 500, 0);

      //Move with the pendicular line
      _av.translate(_v.x, _v.y, _v.z);
     // System.out.println(_v.x + " " + _v.y + " " + _v.z);

      _av.noStroke();
      _av.fill(100, 255, 255);
      //_av.sphere(_radius);
      _av.box(_size);
      //ellipse(0, 0, radius*2, radius*2);

       //If we have any secondary orbit objects
      if (_orbitObjects != null) {
        for (int i = 0; i < _orbitObjects.length; i++) {
            //Make them orbit
          _orbitObjects[i].update();
        }
      }
      _av.popMatrix();
    }
  }