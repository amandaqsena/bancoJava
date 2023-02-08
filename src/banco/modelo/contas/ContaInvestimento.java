package banco.modelo.contas;

public class ContaInvestimento extends Conta{

    public ContaInvestimento(int agencia, int numero) {
        super(agencia, numero);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Conta investimento: " + super.toString();
    }
    
}
