/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */


interface RadioInterface {
    /**
     *
     * @return se crean los elementos que van a tener cada una de las radios
     * con distintas implementaciones pero con los parametros de retorno
     * ya esablecidos en clase para que funcione sin ningun problema
     * cuando lo usemos la interfaz en otra clase radio
     */
    public String estacionActual();
    public boolean estado();
    public void onOff();
    public void cambiarFrecuencia();
    public void avanzar();
    public void guardar(int button);
    public void seleccionarEmisora(int button);
}