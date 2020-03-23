package printer;

import utilidades.Parametros;

/**
 *
 * @author jespinel
 */
public class Generador {

    private static int[] listaPrimos;

    public static int[] obtenerListaPrimos() {

        listaPrimos = new int[Parametros.M + 1];
        listaPrimos[1] = 2;
        
        int J = 1;
        int K = 1;
        boolean JPRIME;
        int ORD = 2;
        int SQUARE= 9;
        int N = 0;
        int MULT[] = new int[Parametros.ORDMAX + 1];
        
        while (K < Parametros.M) {
            do {
                J += 2;
                if (J == SQUARE) {
                    ORD++;
                    SQUARE = listaPrimos[ORD] * listaPrimos[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J) {
                        MULT[N] += listaPrimos[N] + listaPrimos[N];
                    }
                    if (MULT[N] == J) {
                        JPRIME = false;
                    }
                    N++;
                }
            } while (!JPRIME);
            K++;
            listaPrimos[K] = J;
        }
        
        return listaPrimos;
    }
}
