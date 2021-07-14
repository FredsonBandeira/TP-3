package todolist;

//import java.util.Date;
import java.sql.Date;


public class Alunos {
    int id;
    String nome;
    Date data_nasc;
    int nif;
    String bi;
    int telefone;



    String profissao;
    String categoria;

    public Alunos(int id, String nome, Date data_nasc, int nif, String bi, int telefone, String profissao, String categoria) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.nif = nif;
        this.bi = bi;
        this.telefone = telefone;
        this.profissao = profissao;
        this.categoria = categoria;
    }

   /* public Alunos(int id, String nome, Date data_nasc, String nif, String bi, String telefone, String profissao, String categoria) {

    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public int getNif() {
        return nif;
    }

    public String getBi() {
        return bi;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getCategoria() {
        return categoria;
    }
}
