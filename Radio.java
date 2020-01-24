/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Radio implements RadioInterface {
    private String currentFrquency = "AM";
    private String currentStation = "";
    private boolean state = false;
    private int indexPM = 0;
    private int indexAM = 0;
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, ArrayList<String>> radioStations = new HashMap<>(){{
        put("AM",
                new ArrayList<>(){{
                    for (double i = 530; i <= 1610; i += 10) {
                        DecimalFormat df = new DecimalFormat("#.##");
                        double station = Double.parseDouble(df.format(i));
                        add("" + station);
                    }
                }}
        );
        put("FM",
                new ArrayList<>(){{
                    for (double i =  87.9; i <= 107.9; i += 0.2) {
                        DecimalFormat df = new DecimalFormat("#.##");
                        double station = Double.parseDouble(df.format(i));
                        add("" + station);
                    }
                }}
        );
    }};



    public ArrayList<HashMap<String, String>> radioButtons  = new ArrayList<>(){{
        for (int i = 0; i < 12; i++) {
            add(new HashMap<>(){{ put("" , ""); }});
        }
    }};

    public Radio(){ this.currentStation = this.radioStations.get(this.currentFrquency).get(0); }


    /**
     *
     * @return imprime en que estacion y que tipo de frecuencia esta el usuario
     */
    public String estacionActual(){

        return "Estacion  actual " + this.currentStation + " radio " + this.currentFrquency;
    }

    /**
     * Imprime en que estado se encuentra el radio
     * Tambien cambia su estado
     */
    public void onOff(){
        this.state = !this.state;
        print("El radio se encuentra " + ((this.state) ? "encendido" : "apagado"));
    }


    public boolean estado(){
        return this.state;
    }

    /**
     * Imprime la frecuencia actual en la que esta el usuario
     * crea un arraylist donde se agregan las arraylist de estaciones am y fm
     * se le pide que seleccione que emisoara quiere cambiarse
     */
    public void cambiarFrecuencia(){
        print("Su frecuencia actual es: " + this.currentFrquency);
        ArrayList<String> frequencies = new ArrayList<>();
        frequencies.add("AM");
        frequencies.add("FM");
        int index = selectOptions(frequencies, "Ingrese el número de opción que desea.", "Escoja una opcion valida.");
        this.currentFrquency = frequencies.get(index);
        print("Su frecuencia actual es: " + this.currentFrquency);
    }



    /**
     * Avanza a la siguiente estacion del arraylist donde se encuentra el usuario
     */
    public void avanzar(){
        if (this.currentFrquency.equalsIgnoreCase("AM"))
            indexAM++ ;
        else
            indexPM++;
        indexAM = (indexAM == this.radioStations.get("AM").size()) ? 0 : indexAM;
        indexPM = (indexPM == this.radioStations.get("AM").size()) ? 0 : indexPM;
        int currentI = (this.currentFrquency.equalsIgnoreCase("AM")) ? indexAM : indexPM;
        this.currentStation =  this.radioStations.get(this.currentFrquency).get((currentI));
        print("Frecuencia: " + this.currentFrquency +"\nEstacion Actual: " + this.currentStation);
    }

    /**
     *
     * @param button recibe en que boton se va a guardar la nueva estacion
     */
    public void guardar(int button){
        ArrayList<String> frequencies = new ArrayList<>();
        frequencies.add("AM");
        frequencies.add("FM");
        int index = selectOptions(frequencies, "Ingrese el número de opción que desea como frecuencia para el boton."
                , "Escoja una opcion valida.");
        int stationIndex = selectOptions(this.radioStations.get(frequencies.get(index)),
                "Escoja  el número de opción de estacion",
                "Escoja una opcion valida");
        String frequencyChoosen = frequencies.get(index);
        this.radioButtons.get(button).clear();
        this.radioButtons.get(button).put(frequencyChoosen, this.radioStations.get(frequencyChoosen).get(stationIndex));
    }



    /**
     *
     * @param button recibe el numero de emisoara y frecuencia al que el usuario quiere cambiar
     */
    public void seleccionarEmisora(int button){
        if (this.radioButtons.get(button).containsKey("AM") || radioButtons.get(button).containsKey("FM")){
            HashMap<String, String> botonChoosen = this.radioButtons.get(button);
            this.currentFrquency = (botonChoosen.keySet().toArray()[0].toString());
            this.currentStation = botonChoosen.get(this.currentFrquency);
            print("Su frecuencia actual es: " + this.currentFrquency);
            print("Su estacion actual es: " + this.currentStation);

        }else{
            print("El boton no se encuentra configurado por lo tanto no ha cambiado su frecuencia ni estacion.");
        }

    }
    private void print(String text){
        System.out.println(text);
    }
    public String input(String text){
        this.print(text);
        return scanner.nextLine();
    }
    private int selectOptions(ArrayList<?> arrayList, String text, String text2){
        int input = 0;
        while (input < 1 || input > arrayList.size()){
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getClass().equals(Double.class) || arrayList.get(i).getClass().equals(Integer.class)){
                    DecimalFormat df = new DecimalFormat("#.##");
                    double station = Double.parseDouble(df.format(arrayList.get(i)));
                    System.out.println((i+1) + ") " + station + "\n");
                }else{
                    System.out.println((i+1) + ") " + arrayList.get(i).toString() + "\n");
                }
            }
            input = intInput(text, text2, 0);
            if (input < 1 || input > arrayList.size()){
                System.out.println("Ingrese una opcion valida\n");
            }
        }
        return input - 1;
    }
    private int intInput(String text, String text2, int minimum){
        boolean valid = true;
        int value = 0;
        while (valid)
        {
            System.out.println(text);
            String valueString = scanner.nextLine();
            try{
                value = Integer.parseInt(valueString);
                valid = value <= 0 || value < minimum;
                if (valid) {
                    System.out.println(text2);
                }
            }
            catch (Exception e) {
                System.out.println("Ingrese un valor integer");
            }
        }
        return value;
    }
}
