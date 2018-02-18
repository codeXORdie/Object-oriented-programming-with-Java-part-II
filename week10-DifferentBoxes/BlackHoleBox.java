
package boxes;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class BlackHoleBox extends Box {
    
    public BlackHoleBox() {}

    @Override
    public void add(Thing thing) {}

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }    

}
