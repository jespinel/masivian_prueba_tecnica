package printer;

import utilidades.*;

/**
 *
 * @author jespinel
 */
public class ImpresoraDeDatos {

    int PAGENUMBER = 1;
    int PAGEOFFSET = 1;
    int ROWOFFSET;
    int C;

    int[] lista = null;

    public ImpresoraDeDatos(int[] _lista) {
        this.lista = _lista;
    }

    public void presentar() {
        while (PAGEOFFSET <= Parametros.M) {
            imprimirTitulo(PAGENUMBER);
            for (ROWOFFSET = PAGEOFFSET; ROWOFFSET <= PAGEOFFSET + Parametros.RR - 1;
                    ROWOFFSET++) {
                imprimirNumero();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += Parametros.RR * Parametros.CC;
        }
    }

    private void imprimirTitulo(int _pageNumber) {
        StringBuilder titulo = new StringBuilder();
        titulo.append(Constantes.TEXTO_1)
                .append(Integer.toString(Parametros.M))
                .append(Constantes.TEXTO_2)
                .append(Integer.toString(_pageNumber))
                .append("\n");
        System.out.print(titulo.toString());
    }

    private void imprimirNumero() {
        for (C = 0; C <= Parametros.CC - 1; C++) {
            if (ROWOFFSET + C * Parametros.RR <= Parametros.M) {
                System.out.printf("%10d", lista[ROWOFFSET + C * Parametros.RR]);
            }
        }
        System.out.println();
    }

}
