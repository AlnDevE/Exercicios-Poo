package controlePonto.funcionario;

import lombok.Builder;
import lombok.Data;

@Data
public class Gerente extends Funcionario{
    private String login;
    private String senha;

    @Builder
    public Gerente(int idFunc, String nome,String documento,String email,String login, String senha) {
        super(idFunc,nome,email,documento);
        this.login = login;
        this.senha = senha;
    }

}
