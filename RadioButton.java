/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */



import java.text.DecimalFormat;

class RadioButton{
    private Frequency type;
    private double station;

    public RadioButton(){
        this.type = null;
        this.station = 0.0;
    }

    /**
     *
     * @return se crean getters and setters de los tipos de precuencias
     * y las estaciones para guardar la estacion en el boton ingresado
     * por el usuario
     */
    public Frequency getType() {
        return type;
    }

    public void setType(Frequency type) {
        this.type = type;
    }

    public double getStation() {
        return station;
    }

    public void setStation(double station) {
        this.station = station;
    }

    /**
     *
     * @return un print el cual nos dice cuales son las estaciones que estan
     * guardadas en los botones y si no tienen nada imprimen "no seteado"
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        double stationC = Double.parseDouble(df.format(this.station));
        return "Boton";
    }

    public boolean isValid(){
        return  this.type != null;
    }
}