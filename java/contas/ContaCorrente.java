package banco.java.contas;
import banco.java.*;
import java.math.BigDecimal;

public class ContaCorrente extends Conta implements Tributavel{
    public ContaCorrente(int agencia, int numero){
        super(agencia, numero);
    }

    @Override
    public BigDecimal getValorImposto(){
        BigDecimal taxa = new BigDecimal("0.01");
        return super.saldo.multiply(taxa);
    }
}
