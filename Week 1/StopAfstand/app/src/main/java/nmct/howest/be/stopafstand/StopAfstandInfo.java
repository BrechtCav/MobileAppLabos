package nmct.howest.be.stopafstand;

/**
 * Created by BrechtCaveye on 11/05/2015.
 */
public class StopAfstandInfo {
    public int snelheid;



    public float reactietijd;
    public float stopafstand;
    public Wegtype wegtype;

    public  StopAfstandInfo (int Snelheid, float Reactietijd) {
        this.snelheid = Snelheid;
        this.reactietijd = Reactietijd;
    }
    public float getReactietijd() {
        return reactietijd;
    }

    public void setReactietijd(float reactietijd) {
        this.reactietijd = reactietijd;
    }

    public int getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int snelheid) {
        this.snelheid = snelheid;
    }

    public static float getStopafstand(int currentsnelheid, float currentreactietijd, int remvertraging)
    {
        float speed = (float) (currentsnelheid/3.6);
        float result = (speed * currentreactietijd) + ((speed*speed)/(remvertraging * 2));
        return result;
    }
    public void setStopafstand(float stopafstand) {
        this.stopafstand = stopafstand;
    }

    public enum Wegtype{
        WEGDEK_DROOG,WEGDEK_NAT;
    }
}
