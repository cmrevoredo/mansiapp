package app.mobile.ifpe.edu.br.msiapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by revor on 14/09/2016.
 */
public final class Randomizador {

    private int total;
    private int[] opcoes;

    public static List<Integer> gerarAleatorio(int total){
        List<Integer> opcoes = new ArrayList<Integer>();
        for (int i=0;i<total;i++) {
            while (true) {
                int gerado = new Random().nextInt(total);
                if (!opcoes.contains(gerado)) {
                    opcoes.add(gerado);
                    break;
                }
            }
        }
        return opcoes;
    }
}
