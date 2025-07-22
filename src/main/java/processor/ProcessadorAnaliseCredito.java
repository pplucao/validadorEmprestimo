package processor;

import java.util.ArrayList;
import java.util.List;

import enums.StatusAprovacao;
import interfaces.IAvaliadorCredito;
import models.SolicitacaoCredito;

public class ProcessadorAnaliseCredito {

    private List<IAvaliadorCredito> avaliadores;

    public ProcessadorAnaliseCredito() {
        this.avaliadores = new ArrayList<>();
    }
    
    public StatusAprovacao analisar (SolicitacaoCredito solicitacao) {

        if (solicitacao == null) {
            System.out.println("A solicitação de crédito fornecida é nula.");
            return StatusAprovacao.REPROVADO;
        }

        solicitacao.setStatusAprovacao(StatusAprovacao.PENDENTE);
        
        for(IAvaliadorCredito avaliador : avaliadores) {
            if(!avaliador.avaliar(solicitacao)){
                solicitacao.setStatusAprovacao(StatusAprovacao.REPROVADO);
                solicitacao.setMotivoReprovacao(avaliador.getMensagemReprovacao());
                System.out.println("Solicitação: " + solicitacao.getId() + " REPROVADA");
                System.out.println("Motivo: " + avaliador.getMensagemReprovacao());
                return StatusAprovacao.REPROVADO;
            }
        }
        solicitacao.setStatusAprovacao(StatusAprovacao.APROVADO);
        solicitacao.setMotivoReprovacao(null);
        System.out.println("Solicitação: " + solicitacao.getId() + " APROVADA por todas as regras!");
        return StatusAprovacao.APROVADO;
        
    }

    public void adicionarAvaliador(IAvaliadorCredito avaliador) {
        if (avaliador != null) {
            avaliadores.add(avaliador);
        } else {
            System.out.println("Não é possível adicionar um avaliador nulo.");
        }
    }
}
