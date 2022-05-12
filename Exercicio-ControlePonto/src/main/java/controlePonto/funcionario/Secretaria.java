package controlePonto.funcionario;

import lombok.Builder;
import lombok.Data;

@Data
public class Secretaria extends Funcionario{
    private String telefone;
    private String ramal;

    @Builder
    public Secretaria(int idFunc, String nome,String documento,String email,String telefone, String ramal) {
        super(idFunc,nome,email,documento);
        this.telefone = telefone;
        this.ramal = ramal;
    }
}
