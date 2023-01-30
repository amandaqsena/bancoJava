package banco.java.contas;

import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class ContaPoupanca extends Conta implements ContaSacavel, ContaDepositavel{

    private Map<Integer,BigDecimal> saldoDia = new HashMap();

    public ContaPoupanca(int agencia, int numero) {
        super(agencia, numero);
    }

    public BigDecimal depositar(BigDecimal valor){
        adicionarSaldo(valor);
        somarSaldoDia(valor);
        return this.getSaldo();
    }

    public BigDecimal sacar(BigDecimal valor){
        removerSaldo(valor);
        subtrairSaldoDia(valor);
        return this.getSaldo();
    }

    /*
     * Transfere um valor para outra conta
     * 
     * @param contaDestino conta que vai receber o valor
     * @param valor valor a ser enviado para a outra conta
     */
    public void transferir(Conta contaDestino, BigDecimal valor) {
        this.sacar(valor);
        contaDestino.adicionarSaldo(valor);
    }

    private void somarSaldoDia(BigDecimal valor, Integer dia){
        final BigDecimal saldo = saldoDia.get(dia);
        saldoDia.put(dia, saldo != null ? saldo.add(valor): valor);
    }

    public void somarSaldoDia(BigDecimal montante){
        final int dia = ZonedDateTime.now().getDayOfMonth();
        somarSaldoDia(montante, dia>28? 28:dia);
    }

    private void subtrairSaldoDia(BigDecimal valor, Integer dia){
        BigDecimal saldo = saldoDia.get(dia);
        if (saldo != null) {
            if(saldo.compareTo(valor) >= 0){
                saldoDia.put(dia,saldo.subtract(valor));
            }
            else {
                saldoDia.put(dia,BigDecimal.ZERO);
                subtrairSaldoDia(valor.subtract(saldo),dia ==1?28:dia-1);
            }
            
        }
        else {
            saldoDia.put(dia,BigDecimal.ZERO);
            subtrairSaldoDia(valor.subtract(saldo),dia ==1?28:dia-1);
        }
    }

    public void subtrairSaldoDia(BigDecimal montante){
        final int dia = ZonedDateTime.now().getDayOfMonth();
        subtrairSaldoDia(montante, dia>28? 28:dia);
    }


    public BigDecimal calcularJuro(){
        final int dia = ZonedDateTime.now().getDayOfMonth();
        BigDecimal juro = saldoDia.get(dia).multiply(BigDecimal.valueOf(0.003));
        depositar(juro);
        return getSaldo();
    }
    
}
