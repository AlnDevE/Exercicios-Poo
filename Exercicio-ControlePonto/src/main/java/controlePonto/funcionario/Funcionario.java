package controlePonto.funcionario;

import controlePonto.ponto.RegistroPonto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public abstract class Funcionario {
    private int idFunc;
    private String nome;
    private String email;
    private String documento;
    private List<RegistroPonto> listaPonto = new ArrayList<>();

    public Funcionario(int idFunc, String nome, String email, String documento) {
        this.idFunc = idFunc;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
    }
}
