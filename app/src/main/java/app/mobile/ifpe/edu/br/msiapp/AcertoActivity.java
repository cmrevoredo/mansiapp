package app.mobile.ifpe.edu.br.msiapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.mobile.ifpe.edu.br.msiapp.db.Repositorio;
import app.mobile.ifpe.edu.br.msiapp.model.Pergunta;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class AcertoActivity extends AppCompatActivity {

    private android.support.v7.app.ActionBar AB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_acerto);

        Intent intent = getIntent();
        final String usuario = intent.getExtras().getString("usuario");
        final int pId = intent.getExtras().getInt("pId");
        final int pontuacao = intent.getExtras().getInt("pontuacao");
        final int sequencia = intent.getExtras().getInt("sequencia");

        AB = getSupportActionBar();
        AB.setTitle(usuario);
        AB.setSubtitle("Sua pontuação: " + pontuacao);
        getWindow().
                getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        Pergunta p = Repositorio.getInstance().getPergunta(pId-1);
        TextView textViewComentario = (TextView)findViewById(R.id.textViewComentario);
        textViewComentario.setText(p.getSucesso());

        TextView textViewResposta = (TextView)findViewById(R.id.textViewResposta);
        textViewResposta.setText("Resposta correta: " + p.getRespostaCorreta().getDescricao());

        final Button dummy = (Button)findViewById(R.id.dummy_button);
        final boolean finalizar = pId == Repositorio.getInstance().getQuestionario().size();
        if (finalizar){
            dummy.setText("<< Finalizar Questionário >>");
        }else{
            dummy.setText("Próxima Pergunta >>");
        }
        dummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalizar){
                    Intent i = new Intent(AcertoActivity.this, ResultadoActivity.class);
                    i.putExtra("usuario", usuario);
                    i.putExtra("pontuacao", pontuacao);
                    i.putExtra("sequencia", sequencia);
                    finish();
                    startActivity(i);
                }else {
                    Intent i = new Intent(AcertoActivity.this, QuestionarioActivity.class);
                    i.putExtra("usuario", usuario);
                    i.putExtra("pId", pId);
                    i.putExtra("pontuacao", pontuacao);
                    i.putExtra("sequencia", sequencia);
                    finish();
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

}
