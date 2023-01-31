package app;
import java.math.BigDecimal;

import modelo.CalculadorDeImposto;
import modelo.SeguroDeVida;
import modelo.contas.ContaCorrente;
import modelo.contas.ContaPoupanca;

public class App {

    public static void main(String[] args) {
        final ContaCorrente cc = new ContaCorrente(1,111);
        final ContaPoupanca cp = new ContaPoupanca(1,222);
        System.out.println(cc.getSaldo());
        cc.depositar(new BigDecimal("100"));
        System.out.println(cc.getSaldo());
        cc.transferir(cp, new BigDecimal("50"));
        System.out.println(cc.getSaldo());
        System.out.println(cp.getSaldo());

        final SeguroDeVida seguro = new SeguroDeVida();

        final CalculadorDeImposto calc = new CalculadorDeImposto();
        calc.registra(cc);
        System.out.println(calc.getTotalImposto());
        calc.registra(seguro);
        System.out.println(calc.getTotalImposto());

    }
    
}
