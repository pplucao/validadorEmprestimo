package presentation;

import avaliator.ValidadorCpfLimpo;
import avaliator.ValidadorHistoricoDividas;
import avaliator.ValidadorIdadeMinima;
import avaliator.ValidadorRendaMinima;
import avaliator.ValidadorScoreCredito;
import avaliator.ValidadorTempoEmprego;
import models.Cliente;
import models.HistoricoDividas;
import models.SolicitacaoCredito;
import processor.ProcessadorAnaliseCredito;

public class Main {
    public static void main(String[] args) {
        

        Cliente Pedro = new Cliente("00231456478", "Pedro Matos", 1200, 700, true, 16, 18);

        HistoricoDividas dividaPedro = new HistoricoDividas(400, Pedro);
        HistoricoDividas dividaPedro2 = new HistoricoDividas(200, Pedro);
        Pedro.adicionarDivida(dividaPedro);
        Pedro.adicionarDivida(dividaPedro2);
        
        SolicitacaoCredito solicitacaoPedro = new SolicitacaoCredito(Pedro, 2000, 5);

        ValidadorCpfLimpo validadorCPF = new ValidadorCpfLimpo();
        ValidadorIdadeMinima validadorIdade = new ValidadorIdadeMinima(18);
        ValidadorRendaMinima validadorRenda = new ValidadorRendaMinima(1000);
        ValidadorScoreCredito validadorScore = new ValidadorScoreCredito(500);
        ValidadorTempoEmprego validadorEmprego = new ValidadorTempoEmprego(12);
        ValidadorHistoricoDividas validadorDividas = new ValidadorHistoricoDividas(3000);

        ProcessadorAnaliseCredito analise = new ProcessadorAnaliseCredito();
        analise.adicionarAvaliador(validadorEmprego);
        analise.adicionarAvaliador(validadorScore);
        analise.adicionarAvaliador(validadorIdade);
        analise.adicionarAvaliador(validadorRenda);
        analise.adicionarAvaliador(validadorCPF);
        analise.adicionarAvaliador(validadorDividas);

        analise.analisar(solicitacaoPedro);
    }
}
