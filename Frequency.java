/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 *
 * @class Frequency clase que se encarga de tener el comportamiento de una frecuencia de radio ya que ambas tienen
 * el mismo funcionamiento
 */
public class Frequency {
    private String type;
    protected ArrayList<Double> stations = new ArrayList<>();
    private double currentStation = 0;
    private int stationIndex = 0;
    private View view = new View();
    public Frequency(String type, ArrayList<Double> stations){
        this.type = type;
        this.stations = stations;
        this.currentStation = stations.get(this.stationIndex);
    }

    /**
     *
     * @param type se crean instancias del constructor
     */
    public Frequency(String type){
        this.type = type;

    }

    /**
     * Getters
     * @return el tipo de frecuencia, retorna un array con las estaciones
     * retorna en cual estacion esta el usuario actualmente
     */
    public String getType() {
        return type;
    }

    public ArrayList<Double> getStations() {
        return stations;
    }

    double getCurrentStation() {
        DecimalFormat df = new DecimalFormat("#.##");
        double station = Double.parseDouble(df.format(this.currentStation));
        return station;
    }

    /**
     * este metodo nos sirve para mover al usuario hacia la siguiente estacion
     * tomando en ultimo index de la estacion
     */
    void forwardStation(){
        this.stationIndex++;
        if (this.stationIndex == this.stations.size()) this.stationIndex = 0;
        this.currentStation = this.stations.get(this.stationIndex);
        DecimalFormat df = new DecimalFormat("#.##");
        double station = Double.parseDouble(df.format(this.currentStation));
        view.print("A avanzado a la estacion " + station + " " + this.type);
    }

    public String toString() {
        return "Radio: " + this.type;
    }

    /**
     *
     * @param station recibe un valor de estacion para setear [this.currentStation] y guarda
     * tambien trackea cual es su index correspondiente para poder tener la siguiente estacion cuando
     * se necesite
     */
    public void setStation(Double station){
        this.currentStation = station;
        this.stationIndex = stations.indexOf(station);
    }



}