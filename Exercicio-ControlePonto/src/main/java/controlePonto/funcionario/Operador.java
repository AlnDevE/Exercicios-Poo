package controlePonto.funcionario;

import lombok.Builder;
import lombok.Data;

@Data
public class Operador extends Funcionario{
    double valorHora;

    @Builder
    public Operador(int idFunc, String nome,String documento,String email,Double valorHora) {
        super(idFunc,nome,email,documento);
        this.valorHora = valorHora;
    }


}
