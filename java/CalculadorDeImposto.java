package banco.java;
import java.math.BigDecimal;

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
