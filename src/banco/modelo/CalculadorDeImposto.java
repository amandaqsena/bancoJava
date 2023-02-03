package banco.modelo;
import java.math.BigDecimal;

/**
 * Classe que registra tributáveis e calcula o impostosobre eles
 *  @author amandasena97@gmail.com
 *  @version 0.1
 */
public class CalculadorDeImposto {
    private BigDecimal totalImposto;

    public CalculadorDeImposto(){
        this.totalImposto = BigDecimal.ZERO;
    }

    public void registra(Tributavel t){
        BigDecimal valor = t.getValorImposto();
        this.totalImposto = totalImposto.add(valor);
    }
    
    public BigDecimal getTotalImposto() {
        return totalImposto;
    }
}
