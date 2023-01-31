package modelo.contas;
import java.math.BigDecimal;

public interface ContaDepositavel {
    BigDecimal depositar(BigDecimal valor);
}
