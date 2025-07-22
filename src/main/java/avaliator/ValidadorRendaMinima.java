package avaliator;

import interfaces.IAvaliadorCredito;
import models.SolicitacaoCredito;

public class ValidadorRendaMinima implements IAvaliadorCredito {

    private String nomeRegra = "Validador de renda mínima";
    private String mensagemReprovacao = "O cliente foi reprovado pois sua renda não atinge a renda mínima exigida!";
    private double rendaMinimaExigida;

    public ValidadorRendaMinima (double rendaMinimaExigida) {
        this.rendaMinimaExigida = rendaMinimaExigida;
    }

    @Override
    public boolean avaliar(SolicitacaoCredito solicitacao) {

        if(solicitacao ==  null || solicitacao.getCliente() == null){
            this.mensagemReprovacao = "Solicitação ou cliente estão nulos.";
            return false;
        }

        double rendaMensalCliente = solicitacao.getCliente().getRendaMensal();
        double valorEmprestimoDesejado = solicitacao.getValorEmprestimoDesejado();

        // 10% do empréstimo
        double dezPorCentoEmprestimo = valorEmprestimoDesejado * 0.10;

        // 30% da renda mensal
        double trintaPorCentoRendaMensal = rendaMensalCliente * 0.30;

        if(rendaMinimaExigida > rendaMensalCliente) {
            return false;
        } else if (dezPorCentoEmprestimo > trintaPorCentoRendaMensal) {
            this.mensagemReprovacao = "A parcela estimada (10% do empréstimo = " + dezPorCentoEmprestimo + 
            ") excede 30% da renda mensal (" + trintaPorCentoRendaMensal + ").";
            return false;
        }
        this.mensagemReprovacao = "";
        return true;
    }

    public String getNomeRegra() {
        return nomeRegra;
    }

    public String getMensagemReprovacao() {
        return mensagemReprovacao;
    }
    
}
