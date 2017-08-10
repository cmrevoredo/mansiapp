package app.mobile.ifpe.edu.br.msiapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.mobile.ifpe.edu.br.msiapp.db.Repositorio;
import app.mobile.ifpe.edu.br.msiapp.model.Alternativa;
import app.mobile.ifpe.edu.br.msiapp.model.Pergunta;

public class QuestionarioActivity extends AppCompatActivity {

    private RadioButton rbA;
    private RadioButton rbB;
    private RadioButton rbC;
    private RadioButton rbD;
    private RadioButton rbE;
    private Alternativa resposta;
    private RadioButton opcaoSelecionada;
    private String usuario;
    private int pId;
    private int pontuacao;
    private int sequencia;
    private android.support.v7.app.ActionBar AB;
    private boolean errou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionario);

        Intent intent = getIntent();
        usuario = intent.getExtras().getString("usuario");
        pId = intent.getExtras().getInt("pId");
        pontuacao = intent.getExtras().getInt("pontuacao");
        sequencia = intent.getExtras().getInt("sequencia");

        errou = false;

        AB = getSupportActionBar();
        AB.setTitle(usuario);
        AB.setSubtitle("Sua pontuação: " + pontuacao);
        getWindow().
                getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        final Pergunta p = Repositorio.getInstance().getPergunta(pId);

        TextView textViewPergunta = (TextView)findViewById(R.id.textViewPergunta);
        textViewPergunta.setText(pId+1+ ") " + p.getProblema());

        final List<Integer> sorteados = Randomizador.gerarAleatorio(5);

        rbA = (RadioButton)findViewById(R.id.rb_opcA);
        rbA.requestFocus();
        rbA.setText("a) " + p.getAlternativas().get(sorteados.get(0)).getDescricao());
        rbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //resposta(p, (RadioButton)view, sorteados.get(0));
                selecionarAlternativa((RadioButton)view, p.getAlternativas().get(sorteados.get(0)));
            }
        });

        rbB = (RadioButton)findViewById(R.id.rb_opcB);
        rbB.setText("b) " + p.getAlternativas().get(sorteados.get(1)).getDescricao());
        rbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecionarAlternativa((RadioButton)view, p.getAlternativas().get(sorteados.get(1)));
            }
        });

        rbC = (RadioButton)findViewById(R.id.rb_opcC);
        rbC.setText("c) " + p.getAlternativas().get(sorteados.get(2)).getDescricao());
        rbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecionarAlternativa((RadioButton)view, p.getAlternativas().get(sorteados.get(2)));
            }
        });

        rbD = (RadioButton)findViewById(R.id.rb_opcD);
        rbD.setText("d) " + p.getAlternativas().get(sorteados.get(3)).getDescricao());
        rbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecionarAlternativa((RadioButton)view, p.getAlternativas().get(sorteados.get(3)));
            }
        });

        rbE = (RadioButton)findViewById(R.id.rb_opcE);
        rbE.setText("e) " + p.getAlternativas().get(sorteados.get(4)).getDescricao());
        rbE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecionarAlternativa((RadioButton)view, p.getAlternativas().get(sorteados.get(4)));
            }
        });

        final TextView textViewDica = (TextView)findViewById(R.id.textViewDica);
        textViewDica.setText("Clique na lâmpada e revele a dica.");
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewDica.getText().equals("Clique na lâmpada e revele a dica.")) {
                    ((ImageButton)view).setImageResource(R.drawable.tip_icon_on);
                    textViewDica.setText(p.getDica());
                }else{
                    ((ImageButton)view).setImageResource(R.drawable.tip_icon_off);
                    textViewDica.setText("Clique na lâmpada e revele a dica.");
                }
                //Toast.makeText(QuestionarioActivity.this, p.getDica(), Toast.LENGTH_LONG).show();
            }
        });

        Button button = (Button)findViewById(R.id.buttonDica);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                responder();
            }
        });


        //getWindow().getDecorView().setSystemUiVisibility(
          //      View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

    }

    private void selecionarAlternativa(RadioButton rb, Alternativa a){
        if (rb.isEnabled()) {
            resposta = a;
            opcaoSelecionada = rb;
        }
    }

    private void responder(){
        if (resposta==null){
            Toast.makeText(QuestionarioActivity.this, "Selecione uma das alternativas!", Toast.LENGTH_LONG).show();
        }else{
            validarResposta();
        }
    }

    private void validarResposta(){
        switch (resposta.getValor()){
            case -10:
                opcaoSelecionada.setChecked(false);
                opcaoSelecionada.setEnabled(false);
                errou = true;
                sequencia = 0;
                pontuacao = pontuacao - 10;
                AB.setSubtitle("Sua pontuação: " + pontuacao);
                Toast.makeText(QuestionarioActivity.this, "ERÔÔÔÔU!!!", Toast.LENGTH_SHORT).show();
                resposta = null;
                opcaoSelecionada = null;
                break;
            case 0:
                opcaoSelecionada.setChecked(false);
                opcaoSelecionada.setEnabled(false);
                errou = true;
                sequencia = 0;
                Toast.makeText(QuestionarioActivity.this, "QUASE!", Toast.LENGTH_SHORT).show();
                resposta = null;
                opcaoSelecionada = null;
                break;
            case 10:
                if (errou==false) {
                    sequencia = sequencia + 1;
                }
                pontuacao = pontuacao + 10;
                AB.setSubtitle("Sua pontuação: " + pontuacao);
                Intent i = new Intent(this, AcertoActivity.class);
                i.putExtra("usuario", usuario);
                i.putExtra("pontuacao", pontuacao);
                i.putExtra("sequencia", sequencia);
                i.putExtra("pId", pId + 1);
                finish();
                startActivity(i);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        QuestionarioActivity.this.finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        dialog.dismiss();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja abandonar o questionário?").setPositiveButton("Sim", dialogClickListener)
                .setNegativeButton("Não", dialogClickListener).show();
    }

}