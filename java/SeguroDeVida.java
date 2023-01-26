package banco.java;

import java.math.BigDecimal;

public class SeguroDeVida implements Tributavel{
    public BigDecimal getValorImposto(){
        return new BigDecimal("42");
    }
}
