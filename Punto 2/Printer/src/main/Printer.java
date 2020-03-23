package main;
import printer.*;

/**
 *
 * @author jespinel
 */
public class Printer {

    public static void main(String[] args) {
        int[] listaPrimos = Generador.obtenerListaPrimos();
        ImpresoraDeDatos oImpresora = new ImpresoraDeDatos(listaPrimos);
        oImpresora.presentar();
    }
}
