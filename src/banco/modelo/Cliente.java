package banco.modelo;

import java.util.Set;

import banco.modelo.contas.*;

/**
 * Classe que representa um cliente do banco
 *  @author amandasena97@gmail.com
 *  @version 0.1
 */
public class Cliente extends Pessoa{

    private Set<Conta> conta;
    
}
