package banco.modelo;

/**
 * Classe que representa uma pessoa
 *  @author amandasena97@gmail.com
 *  @version 0.1
 */
public abstract class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String cpf;
    private String profissao;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public int compareTo(Pessoa outra){
        return this.getNome().compareTo(outra.getNome());
    }
}
