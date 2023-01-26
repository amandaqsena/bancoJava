package banco.java;
import java.math.BigDecimal;

public abstract class Conta {


    private int agencia;
    private int numero;
    private Cliente titular;
    public static int total = 0;
    private BigDecimal saldo;
    
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
        Conta.total++;
        System.out.println("O total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = BigDecimal.ZERO;
        System.out.println("Estou criando uma conta " + this.numero);
        
    }

    public BigDecimal getSaldo(){
        return this.saldo;
    }

    public boolean sacar(BigDecimal valor) {
        if(saldo.compareTo(valor) >=0 || (BigDecimal.ZERO.compareTo(valor) <= 0)){
            this.saldo = saldo.subtract(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(BigDecimal valor) {
        if((BigDecimal.ZERO.compareTo(valor) <= 0)){
            this.saldo = saldo.add(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(Conta contaDestino, BigDecimal valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

}
