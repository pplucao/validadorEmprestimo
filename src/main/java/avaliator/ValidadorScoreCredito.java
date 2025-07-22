package avaliator;

import interfaces.IAvaliadorCredito;
import models.SolicitacaoCredito;

public class ValidadorScoreCredito implements IAvaliadorCredito{

    private String nomeRegra = "Validador de Score";
    private String mensagemReprovacao = "O cliente foi reprovado pois seu score nao atingiu o valor de score mínimo!";
    private double scoreMinimoExigido;

    public ValidadorScoreCredito (double scoreMinimoExigido){
        this.scoreMinimoExigido = scoreMinimoExigido;
    }

    @Override
    public boolean avaliar(SolicitacaoCredito solicitacao) {
        
        if(solicitacao == null || solicitacao.getCliente() == null){
            this.mensagemReprovacao = "Solicitação ou cliente estão nulos!";
            return false;
        }

        if(solicitacao.getCliente().getScoreSerasa() < scoreMinimoExigido) {
            return false;
        }
        this.mensagemReprovacao = "";
        return true;
    }


    public String getNomeRegra() {return nomeRegra;}
    public String getMensagemReprovacao() {return mensagemReprovacao;}
    
}
