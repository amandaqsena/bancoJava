package banco;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        Conta cc = new ContaCorrente(1,111);
        Conta cp = new ContaPoupanca(1,222);
        System.out.println(cc.getSaldo());
        cc.depositar(new BigDecimal("100"));
        System.out.println(cc.getSaldo());
        cc.transfere(cp, new BigDecimal("50"));
        System.out.println(cc.getSaldo());
        System.out.println(cp.getSaldo());
    }
    
}
