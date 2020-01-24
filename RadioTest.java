

import org.junit.Test;

import static org.junit.Assert.*;

public class RadioTest {

    @Test
    public void estacionActual() {
        Radio radioTest = new Radio();

        assertEquals("Estacion  actual 530.0 radio AM", radioTest.estacionActual());
    }

    @Test
    public void onOff() {
        Radio radioTest = new Radio();
        assertFalse(radioTest.estado());
        radioTest.onOff();
        assertTrue(radioTest.estado());
        radioTest.onOff();
        assertFalse(radioTest.estado());
    }




    @Test
    public void avanzar() {
        Radio radioTest = new Radio();

        assertEquals("Estacion  actual 530.0 radio AM", radioTest.estacionActual());
        radioTest.avanzar();
        assertEquals("Estacion  actual 540.0 radio AM", radioTest.estacionActual());

    }

}