package banco.java.contas;

import banco.java.*;
import java.math.BigDecimal;

public abstract class Conta {


    private int agencia;
    private int numero;
    private Cliente titular;
    public static int total = 0;
    protected BigDecimal saldo;
    
    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    
    
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

    public BigDecimal adicionarSaldo(BigDecimal valor) {
        if((BigDecimal.ZERO.compareTo(valor) >= 0)){
            throw new IllegalArgumentException("Montante deve ser positivo");
        }
        this.saldo = saldo.add(valor);
        return this.saldo;
    }
}
