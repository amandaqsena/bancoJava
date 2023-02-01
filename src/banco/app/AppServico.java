package banco.app;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import banco.modelo.contas.*;
public class AppServico {

    public static void main(String[] args){

    }

    private List<Conta> contas = new ArrayList<>();

    public Conta abrirConta(){
        ContaCorrente c = new ContaCorrente(0, 0);
        contas.add(c);
        return c;
    }
    public BigDecimal deposito(ContaDepositavel contaDepositavel, BigDecimal valor){
        contaDepositavel.depositar(valor);
        return valor;        
    }



}
