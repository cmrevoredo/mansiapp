package app.mobile.ifpe.edu.br.msiapp.model;

/**
 * Created by revor on 24/08/2016.
 */
public class Alternativa implements Comparable<Alternativa>{
    private int id;
    private String descricao;
    private int valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String toString(){
        return this.getDescricao();
    }

    public int compareTo(Alternativa a){
        if (this.getId()<a.getId()){
            return -1;
        }
        if (this.getId()>a.getId()){
            return 1;
        }
        return 0;
    }
}
