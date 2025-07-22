package avaliator;

import interfaces.IAvaliadorCredito;
import models.SolicitacaoCredito;
import models.Cliente;
import models.HistoricoDividas;

public class ValidadorHistoricoDividas implements IAvaliadorCredito{

    private String nomeRegra = "Validador de histórico de dívidas.";
    private String mensagemReprovacao = "Cliente já tem um histórico de dívidas pendentes.";
    private double valorLimiteDivida;

    public ValidadorHistoricoDividas(double valorLimiteDivida) {
        this.valorLimiteDivida = valorLimiteDivida;
    }

    public boolean avaliar(SolicitacaoCredito solicitacao) {

        if(solicitacao == null || solicitacao.getCliente() == null) {
            this.mensagemReprovacao = "Solicitação ou cliente estão nulos.";
            return false;
        }

        Cliente cliente = solicitacao.getCliente();
        double somaDividas = 0;

        if(cliente.getHistoricoDividas() != null) {
            for (HistoricoDividas divida : cliente.getHistoricoDividas()) { 
                somaDividas += divida.getValorDivida();
            }
        }

        if (somaDividas > this.valorLimiteDivida) {
            this.mensagemReprovacao = "Cliente possui um total de dívidas de R$" + somaDividas + 
            ", que excede o limite de R$" + this.valorLimiteDivida + ".";
            return false;
        }
        this.mensagemReprovacao = "";
        return true;

    }

    public String getNomeRegra() {return nomeRegra;}
    public String getMensagemReprovacao() {return mensagemReprovacao;}
    public double getValorLimiteDivida() {return valorLimiteDivida;}
    
}
