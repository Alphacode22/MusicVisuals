package C19409486;

public class Sides extends MusicObject{
    
    
    public Sides(AlexVisual av){
        this._av = av;
    }

    @Override
    public void update() {
        // Iterate over all the elements in the audio buffer
        for (int i = 0; i < _av.getAudioBuffer().size(); i++) {
            float c = _av.map(i, 0, _av.getAudioBuffer().size(), 0, 255);
            _av.stroke(c, 255, 255);
           // _av.getLerpedBuffer()[i] = _av.lerp(_av.getLerpedBuffer()[i], _av.getAudioBuffer().get(i), 0.1f);
            _av.line(0, i * 3, (_av.getLerpedBuffer()[i] * _av.getCy() * 4), i);
            //_av.line(_av.width, i, _av.width - (_av.getLerpedBuffer()[i] * _av.getCy() * 4), i);
           // _av.line(i, 0, i, -(_av.getLerpedBuffer()[i] * _av.width * 4));
            //_av.line(i, _av.height, _av.height - (_av.getLerpedBuffer()[i]* _av.getCy() * 4), i);
        }
    }
}
