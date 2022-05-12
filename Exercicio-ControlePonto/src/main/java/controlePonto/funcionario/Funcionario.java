package controlePonto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public abstract class Funcionario {
    private int idFunc;
    private String nome;
    private String email;
    private String documento;

}
