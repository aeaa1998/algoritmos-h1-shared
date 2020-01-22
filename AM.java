/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */



import java.util.ArrayList;

public class AM extends Frequency{
    /**
     * se crea  un constructor donde se instancia un arrayList
     * con las estaciones  y el constructor de Frecuencia indicando que su nombre o
     * type sera AM
     */
    public AM(){
        super("AM");

        for (double i = 530; i <= 1610; i += 10) {
            stations.add(i);
        }
        setStation(stations.get(0));
    }
}