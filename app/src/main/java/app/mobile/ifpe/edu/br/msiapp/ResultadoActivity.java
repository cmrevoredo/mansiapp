package app.mobile.ifpe.edu.br.msiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.mobile.ifpe.edu.br.msiapp.model.GMailSender;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();
        final String usuario = intent.getExtras().getString("usuario");
        final int pontuacao = intent.getExtras().getInt("pontuacao");
        final int sequencia = intent.getExtras().getInt("sequencia");

        TextView textViewUsuario = (TextView)findViewById(R.id.textViewUsuario);
        textViewUsuario.setText("Prezado(a) " + usuario);

        TextView textViewPontuacao = (TextView)findViewById(R.id.textViewPontuacao);
        textViewPontuacao.setText("Sua pontuação foi: " + pontuacao);

        TextView textViewAnalise = (TextView)findViewById(R.id.textViewAnalise);
        if (pontuacao < 150){
            textViewAnalise.setText("Treine mais um pouco!");
        }else {
            if (pontuacao < 200) {
                textViewAnalise.setText("Foi legal, mas poderia ser melhor!");
            }else{
                textViewAnalise.setText("Excelente!");
            }
        }

        //sendEmail(usuario, pontuacao);

        Button b = (Button)findViewById(R.id.buttonRefazer);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultadoActivity.this, QuestionarioActivity.class);
                i.putExtra("usuario", usuario);
                i.putExtra("pId", 0);
                i.putExtra("pontuacao", 100);
                i.putExtra("sequencia", 0);
                finish();
                startActivity(i);
            }
        });

        Button b2 = (Button)findViewById(R.id.buttonSair);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultadoActivity.this, MainActivity.class);
                i.putExtra("usuario", usuario);
                finish();
                startActivity(i);
            }
        });
    }

    private void sendEmail(String usuario, int pontuacao){
        AsyncSendEmailTask task = new AsyncSendEmailTask();
        task.execute(usuario, pontuacao+"");
    }
}
