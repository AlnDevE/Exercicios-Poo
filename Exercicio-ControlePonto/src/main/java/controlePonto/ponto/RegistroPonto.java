package controlePonto.ponto;

import controlePonto.funcionario.Funcionario;
import controlePonto.util.SemFuncionarioException;
import controlePonto.util.SemRegistroEntradaException;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class RegistroPonto {

    private static final AtomicInteger count = new AtomicInteger(0);
    private Long idRegPonto;
    private Funcionario func;
    private LocalDate dataRegistro;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public void registraEntrada(Funcionario funcionario){
        idRegPonto = Long.parseLong(String.valueOf(count.incrementAndGet()));
        func = funcionario;
        dataRegistro = LocalDate.now();
        horaEntrada = LocalDateTime.now();
        adicionaNoLog();
    }

    public void registraSaida(){
        verificaSePossuiEntrada();
        horaSaida = LocalDateTime.now();
        adicionaNoLog();
    }

    public void apresentarRegistroPonto(){
        System.out.println("\nFuncionario: "+ getTipoFuncionarioENome(func)+
                            "\nData de Registro: "+formatarData(dataRegistro)+
                            "\nHorário Entrada: "+formatarHora(horaEntrada)+
                            "\nHorário Saída: "+formatarHora(horaSaida)+"\n");
    }

    private String formatarHora(LocalDateTime hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        if(hora == null){
            return "Sem Registro";
        }
        return hora.format(formatter);
    }

    private String formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(data == null){
            return "Sem Registro";
        }
        return data.format(formatter);
    }

    private void adicionaNoLog() {
        if(func != null){
            func.getListaPonto().add(this);
            return;
        }
        throw new SemFuncionarioException();
    }

    private String getTipoFuncionarioENome(Funcionario funcionario){
        if(funcionario == null){
            return "Funcionário Não Encontrado";
        }
        return funcionario.getClass().getSimpleName()+" "+funcionario.getNome();
    }

    private void verificaSePossuiEntrada(){
        if(horaEntrada != null){
            return;
        }
        throw new SemRegistroEntradaException();
    }

    @Override
    public String toString() {
        return "RegistroPonto " + func.getNome() +
                "\nId: " + idRegPonto +
                "\nData Registro: " + formatarData(dataRegistro) +
                "\nHora Entrada: " + formatarHora(horaEntrada) +
                "\nHora Saída: " + formatarHora(horaSaida) + "\n";
    }
}
