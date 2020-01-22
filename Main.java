/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */



import java.util.ArrayList;

public class Main {
    private boolean isRunningApp = true;
    private Radio radio = new Radio();
    private View view = new View();
    private ArrayList<String> mainMenu = new ArrayList<String>() {{
        add("Encender Radio");
        add("Cambiar Frecuencia");
        add("Avanzar estacion");
        add("Guardar estacion en boton");
        add("Seleccionar estacion en boton");
        add("Apagar Radio");
        add("Salir");
    }};

    public static void main(String[] args) {
        Radio radio = new Radio();
        View view = new View();
        ArrayList<String> mainMenu = new ArrayList<>() {{
            add("Encender Radio");
            add("Cambiar Frecuencia");
            add("Avanzar estacion");
            add("Guardar estacion en boton");
            add("Seleccionar estacion en boton");
            add("Apagar Radio");
            add("Salir");
        }};
         ArrayList<RadioButton> buttons  = new ArrayList<>(){{
            for (int i = 0; i < 12; i++) {
                add(new RadioButton());
            }
        }};
	    init(mainMenu, radio, view, buttons);
    }

    public static void init(ArrayList<String> mainMenu, Radio radio, View view, ArrayList<RadioButton> buttons){
        boolean isRunningApp = true;
        while (isRunningApp){
            int c = mainMenu.indexOf(mainMenu(mainMenu, radio, view));
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
                    radio.guardar(selectButton(view, radio));
                    break;
                case 4:
                    radio.seleccionarEmisora(selectButton(view, radio));
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
    private static String mainMenu(ArrayList<String> mainMenu, Radio radio, View view){
        ArrayList<String> menuToShow = new ArrayList<>();
        mainMenu.forEach((menuItem) -> {
            if (radio.estado()) menuToShow.add(menuItem);
            else {
                int index = mainMenu.indexOf(menuItem);
                if (index == 0 || index == (mainMenu.size() - 1)) menuToShow.add(menuItem);
            }
        });
        int i =  view.selectOptions(menuToShow,
                "Escoja un numero de opcion valido. (Las opciones variaran dependiendo del estado de la radio)",
                "Escoja una opcion valida");
        return menuToShow.get(i);
    }
    /**
     *
     * @return el numero que de boton donde el usuario quiere escuchar la emisora guarddda
     */
    public static int selectButton(View view, Radio radio, ArrayList<RadioButton> buttons){
        return view.selectOptions(buttons, "Escoja el numero de boton.", "Escoja una opcion valida");
    }
}
