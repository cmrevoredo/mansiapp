package app.mobile.ifpe.edu.br.msiapp;

import android.os.AsyncTask;
import android.util.Log;

import app.mobile.ifpe.edu.br.msiapp.model.GMailSender;

/**
 * Created by revor on 05/09/2016.
 */
public class AsyncSendEmailTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        try {
            GMailSender sender = new GMailSender("", "");
            sender.sendMail("Resultado de " + strings[0],
                    strings[0] + " obteve uma pontuação = " + strings[1],
                    "",
                    "");
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
        return null;
    }
}
