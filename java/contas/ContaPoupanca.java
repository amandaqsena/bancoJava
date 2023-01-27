package banco.java.contas;

import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import banco.java.*;
public class ContaPoupanca extends Conta{

    private Map<Integer,BigDecimal> saldoDia = new HashMap();

    private void atualizarSaldoDia(BigDecimal valor, Integer dia){
        final BigDecimal saldo = saldoDia.get(dia);
        saldoDia.put(dia, saldo != null ? saldo.add(montante): montante);
    }

    public ContaPoupanca(int agencia, int numero) {
        super(agencia, numero);
    }

    public void atualizarSaldoDia(BigDecimal montante){
        final int dia = ZonedDateTime.now().getDayOfMonth();
        atualizarSaldoDia(montante, dia>28? 28:dia);
    }

    public BigDecimal calcularJuro(){
        final int dia = ZonedDateTime.now().getDayOfMonth();
        BigDecimal juro = saldoDia.get(dia).multiply(BigDecimal.valueOf(0.003));
        depositar(juro);
        return getSaldo();
    }
    
}
