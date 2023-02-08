package banco.modelo.contas;

import java.math.BigDecimal;

import banco.modelo.Cliente;

/**
 * Classe que representa a moldura de uma conta
 * 
 *  @author amandasena97@gmail.com
 *  @version 0.1
 */
public abstract class Conta {


    private final int agencia;
    private final int numero;
    private Cliente titular;
    public static int total = 0;
    protected BigDecimal saldo;
    
    public int getAgencia() {
        return this.agencia;
    }


    public int getNumero() {
        return this.numero;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    
    /**
     * Construtor para inicializar o objeto conta a partir da agência e número
     * @param agencia
     * @param numero
     */
    public Conta(int agencia, int numero){
        if(agencia < 1) {
            throw new IllegalArgumentException("Agencia inválida");
        }

        if(numero < 1) {
            throw new IllegalArgumentException("Numero da conta inválido");
        }
        Conta.total++;
        System.out.println("O total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = BigDecimal.ZERO;
        System.out.println("Estou criando a conta " + this.numero);
        
    }

    public BigDecimal getSaldo(){
        return this.saldo;
    }


    public BigDecimal removerSaldo(BigDecimal valor) {
        if((BigDecimal.ZERO.compareTo(valor) >= 0)){
            throw new IllegalArgumentException("Montante deve ser positivo");
        }

        if(saldo.compareTo(valor) <= 0){
            throw new IllegalArgumentException("Saldo: " + this.saldo + ", Valor " + valor);
        }
        this.saldo = saldo.subtract(valor);
        return this.saldo;
        
    }

    /**
     * 
     * @param valor
     * @return saldo
     */
    public BigDecimal adicionarSaldo(BigDecimal valor) {
        if((BigDecimal.ZERO.compareTo(valor) >= 0)){
            throw new IllegalArgumentException("Montante deve ser positivo");
        }
        this.saldo = saldo.add(valor);
        return this.saldo;
    }


    @Override
    public String toString() {
        return "{" +
            " agencia='" + getAgencia() + "'" +
            ", numero='" + getNumero() + "'" +
            ", titular='" + getTitular() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object ref){
        Conta outraConta = (Conta) ref;

        if(this.agencia != outraConta.agencia){
            return false;
        }

        if(this.numero != outraConta.numero){
            return false;
        }
        return true;
    }

}
