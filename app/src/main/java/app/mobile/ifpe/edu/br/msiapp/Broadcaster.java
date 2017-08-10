package app.mobile.ifpe.edu.br.msiapp;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by revor on 14/09/2016.
 */
public class Broadcaster {
    public static void classificarSequencia(int sequencia, Activity activity){
        switch (sequencia){
            case 3:
                Toast.makeText(activity, "Killing spree!", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(activity, "Enfurecido!", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(activity, "Implacável!", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(activity, "Dominando!", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(activity, "Invencível!", Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(activity, "Lendário!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
