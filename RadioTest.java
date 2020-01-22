

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
    public void cambiarFrecuencia() {
        Radio radioTest = new Radio();
        assertEquals(AM.class, radioTest.getFrequency().getClass());
        radioTest.cambiarFrecuencia("FM");
        assertEquals(FM.class, radioTest.getFrequency().getClass());
    }

    @Test
    public void avanzar() {
        Radio radioTest = new Radio();
        AM am = new AM();
        assertEquals(am.getCurrentStation(), radioTest.getFrequency().getCurrentStation(), 0.0);
        assertEquals(530, radioTest.getFrequency().getCurrentStation(), 0.0);
        radioTest.avanzar();
        assertEquals(540, radioTest.getFrequency().getCurrentStation(), 0.0);

    }

}