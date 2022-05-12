package controlePonto;

import controlePonto.funcionario.Funcionario;
import controlePonto.funcionario.Gerente;
import controlePonto.funcionario.Operador;
import controlePonto.funcionario.Secretaria;
import controlePonto.ponto.RegistroPonto;

public class GerenciarControlePonto {

    public static final int TEMPO = 1000;

    public static void main(String[] args) throws InterruptedException {

        Gerente gerente = Gerente.builder().idFunc(1).nome("João").email("joao@example.com").documento("343434335-12")
                .login("gerente").senha("ger123").build();
        Operador operador = Operador.builder().idFunc(2).nome("Mario").email("mario@example.com").documento("758367335-55")
                .valorHora(7.95).build();
        Secretaria secretaria = Secretaria.builder().idFunc(2).nome("Joana").email("joana@example.com").documento("843987342-32")
                .telefone("199939553").ramal("19").build();

        //Registrando as Entradas dos Funcionários

        RegistroPonto regGerente = new RegistroPonto();
        registrarPontoEntrada(gerente,regGerente);
        Thread.sleep(TEMPO);

        RegistroPonto regOperador = new RegistroPonto();
        registrarPontoEntrada(operador,regOperador);
        Thread.sleep(TEMPO);

        RegistroPonto regSecretaria = new RegistroPonto();
        registrarPontoEntrada(secretaria,regSecretaria);
        Thread.sleep(TEMPO);

        //Registrando as Saídas dos Funcionários

        registrarPontoSaída(gerente, regGerente);
        Thread.sleep(TEMPO);
        registrarPontoSaída(operador, regOperador);
        Thread.sleep(TEMPO);
        registrarPontoSaída(secretaria, regSecretaria);

    }

    public static void registrarPontoEntrada(Funcionario funcionario, RegistroPonto registroPonto){
        registroPonto.registraEntrada(funcionario);
        registroPonto.apresentarRegistroPonto();
    }

    public static void registrarPontoSaída(Funcionario funcionario, RegistroPonto registroPonto){
        registroPonto.registraSaida(funcionario);
        registroPonto.apresentarRegistroPonto();
    }

}
