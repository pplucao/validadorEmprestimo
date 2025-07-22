package avaliator;

import interfaces.IAvaliadorCredito;
import models.SolicitacaoCredito;
import models.Cliente;

public class ValidadorIdadeMinima implements IAvaliadorCredito{

    private String nomeRegra = "Validador de idade mínima.";
    private String mensagemReprovacao = "Cliente não atende a idade mínima para o empréstimo.";
    private int idadeMinima;

    public ValidadorIdadeMinima (int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    @Override
    public boolean avaliar(SolicitacaoCredito solicitacao) {
        
        if(solicitacao == null || solicitacao.getCliente() == null) {
            this.mensagemReprovacao = "Cliente ou solicitação estão nulos.";
            return false;
        }

        if(solicitacao.getCliente().getIdade() < idadeMinima) {
            return false;
        }
        this.mensagemReprovacao = "";
        return true;
    }

    public String getNomeRegra() {return nomeRegra;}
    public String getMensagemReprovacao() {return mensagemReprovacao;}
    public int getIdadeMinima() {return idadeMinima;}    
}
