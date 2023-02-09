package banco.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import banco.modelo.Cliente;
import banco.modelo.contas.Conta;
import banco.modelo.contas.ContaCorrente;
import banco.modelo.contas.ContaPoupanca;

//Código omitido

public class TesteComparator {
    public static void main(String[] args){
        //Código omitido
        ContaCorrente cc1 = new ContaCorrente(22, 33);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1);
        cc1.depositar(new BigDecimal("333.0"));

        ContaPoupanca cc2 = new ContaPoupanca(22, 44);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.depositar(new BigDecimal("444.0"));

        ContaCorrente cc3 = new ContaCorrente(22, 11);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.depositar(new BigDecimal("333.0"));

        ContaPoupanca cc4 = new ContaPoupanca(22, 22);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.depositar(new BigDecimal("222.0"));


        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);
        for (Conta conta : lista) {
            System.out.println(conta);
    }

    lista.sort(new NumeroDaContaComparator());

    System.out.println("---------");

    for (Conta conta : lista) {
            System.out.println(conta + ", " + conta.getTitular().getNome());
    }

    lista.sort(new TitularDaContaComparator());

    System.out.println("---------");

    for (Conta conta : lista) {
            System.out.println(conta + ", " + conta.getTitular().getNome());
    }
    }
    
    
    }
    
    class TitularDaContaComparator implements Comparator<Conta> {
    
            @Override
            public int compare(Conta c1, Conta c2) {
    
                    String nomeC1 = c1.getTitular().getNome();
                    String nomeC2 = c2.getTitular().getNome();
                    return nomeC1.compareTo(nomeC2);
            }
    }
    
    class NumeroDaContaComparator implements Comparator<Conta> {
    
            @Override
            public int compare(Conta c1, Conta c2) {
                return Integer.compare(c1.getNumero(), c2.getNumero());
            }
    }
