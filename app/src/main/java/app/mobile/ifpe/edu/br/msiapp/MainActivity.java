package app.mobile.ifpe.edu.br.msiapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.mobile.ifpe.edu.br.msiapp.db.Repositorio;
import app.mobile.ifpe.edu.br.msiapp.model.Pergunta;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar AB = getSupportActionBar();
        AB.setTitle(R.string.app_name);
        AB.setSubtitle("");
        getWindow().
                getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        final EditText editText = (EditText)findViewById(R.id.editTextUsuario);

        Intent intent = getIntent();
        if (intent!=null && intent.getExtras()!=null) {
            if (intent.getExtras().containsKey("usuario")) {
                String usuario = intent.getExtras().getString("usuario");
                editText.setText(usuario);
            }
        }

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().trim().length()<3) {
                    Toast.makeText(getBaseContext(), "Informe um nome (mínimo 3 caractetes)", Toast.LENGTH_LONG).show();
                    editText.requestFocus();
                }else{
                    Intent i = new Intent(MainActivity.this, QuestionarioActivity.class);
                    i.putExtra("usuario", editText.getText().toString());
                    i.putExtra("pId", 0);
                    i.putExtra("pontuacao", 100);
                    i.putExtra("sequencia", 0);
                    startActivity(i);
                }
            }
        });

        if (!Repositorio.getInstance().getQuestionario().isEmpty()){
            Toast.makeText(getBaseContext(), "Questionário carregado com sucesso!", Toast.LENGTH_SHORT).show();
        }

        ImageButton ib2 = (ImageButton)findViewById(R.id.imageButtonSobre);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SobreActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        MainActivity.this.finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        dialog.dismiss();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja fechar o aplicativo?").setPositiveButton("Sim", dialogClickListener)
                .setNegativeButton("Não", dialogClickListener).show();
    }

}
