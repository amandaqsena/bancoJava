package banco.java.contas;
import java.math.BigDecimal;

public interface ContaDepositavel {
    BigDecimal depositar(BigDecimal valor);
}
