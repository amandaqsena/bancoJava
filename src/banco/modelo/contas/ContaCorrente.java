package banco.modelo.contas;

import java.math.BigDecimal;

import banco.modelo.Tributavel;


public class ContaCorrente extends Conta implements Tributavel, ContaSacavel {
    public ContaCorrente(int agencia, int numero){
        super(agencia, numero);
    }

    public BigDecimal depositar(BigDecimal valor){
        adicionarSaldo(valor);
        return this.getSaldo();
    }

    public BigDecimal sacar(BigDecimal valor){
        removerSaldo(valor);
        return this.getSaldo();
    }

    public void transferir(Conta contaDestino, BigDecimal valor) {
        this.sacar(valor);
        contaDestino.adicionarSaldo(valor);
    }

    @Override
    public BigDecimal getValorImposto(){
        BigDecimal taxa = new BigDecimal("0.01");
        return super.saldo.multiply(taxa);
    }
}
