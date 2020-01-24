/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    private boolean isRunningApp = true;
    private Radio radio = new Radio();
    private Scanner scanner = new Scanner(System.in);

    private ArrayList<String> mainMenu = new ArrayList<String>() {{
        add("Encender Radio");
        add("Cambiar Frecuencia");
        add("Avanzar estacion");
        add("Guardar estacion en boton");
        add("Seleccionar estacion en boton");
        add("Apagar Radio");
        add("Salir");
    }};

    /**
     * menu de opciones
     */
    public void init(){
        while (isRunningApp){
            int c = mainMenu.indexOf(mainMenu());
            switch (c){
                case 0:
                    if (!radio.estado()) radio.onOff();
                    break;
                case 1:
                    radio.cambiarFrecuencia();
                    break;
                case 2:
                    radio.avanzar();
                    break;
                case 3:
                    radio.guardar(selectButton());
                    break;
                case 4:
                    radio.seleccionarEmisora(selectButton());
                    break;
                case 5:
                    if (radio.estado()) radio.onOff();
                    break;
                case 6:
                    isRunningApp = false;
                    break;
            }
        }
    }

    /**
     *
     * @return la opcion que escogio el usuario del menu
     */
    private String mainMenu(){
        ArrayList<String> menuToShow = new ArrayList<>();
        this.mainMenu.forEach((menuItem) -> {
            if (radio.estado()) menuToShow.add(menuItem);
            else {
                int index = mainMenu.indexOf(menuItem);
                if (index == 0 || index == (mainMenu.size() - 1)) menuToShow.add(menuItem);
            }
        });
        int i =  selectOptions(menuToShow,
                "Escoja un numero de opcion valido. (Las opciones variaran dependiendo del estado de la radio)",
                "Escoja una opcion valida");
        return menuToShow.get(i);
    }

    private int selectButton(){
        ArrayList<Integer> buttonInts = new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        return selectOptions(buttonInts, "Escoje un boton", "Escoje un boton valido");


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
            input = this.intInput(text, text2, 0);
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
