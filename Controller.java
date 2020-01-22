/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */



import java.util.ArrayList;

public class Controller {
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
                    radio.guardar(radio.selectButton());
                    break;
                case 4:
                    radio.seleccionarEmisora(radio.selectButton());
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
        int i =  this.view.selectOptions(menuToShow,
                "Escoja un numero de opcion valido. (Las opciones variaran dependiendo del estado de la radio)",
                "Escoja una opcion valida");
        return menuToShow.get(i);
    }

}
