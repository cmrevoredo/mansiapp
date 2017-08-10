package app.mobile.ifpe.edu.br.msiapp.model;

import java.util.List;

/**
 * Created by revor on 24/08/2016.
 */
public class Pergunta {
    private int id;
    private String problema;
    private List<Alternativa> alternativas;
    private String dica;
    private String sucesso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getSucesso() {
        return sucesso;
    }

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }

    public Alternativa getRespostaCorreta(){
        Alternativa resposta = null;
        for (Alternativa a : this.getAlternativas()){
            if (a.getValor()==10){
                resposta = a;
                break;
            }
        }
        return resposta;
    }
}
