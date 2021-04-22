package C19409486;

import java.security.PublicKey;

public class Box extends MusicObject{

    private float _size;
    private float _w;
    private float _h;
    private float _d;  

    public Box(AlexVisual av, float size, float w, float h, float d) {
        this._av = av;
        this._size = size;
        this._w = w;
        this._h = h;
        this._d = d;
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        drawBox();
    }

    //Draw box
    public void drawBox() {
        _av.fill(255);
        _av.stroke(255);
        _av.box(_w, _h, _d);
    }
    
}
