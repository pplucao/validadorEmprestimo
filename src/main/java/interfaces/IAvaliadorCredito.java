package interfaces;

import models.SolicitacaoCredito;

public interface IAvaliadorCredito {
    boolean avaliar (SolicitacaoCredito solicitacao);
    String getNomeRegra();
    String getMensagemReprovacao ();
}
