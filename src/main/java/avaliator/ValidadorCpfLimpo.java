package avaliator;

import interfaces.IAvaliadorCredito;
import models.SolicitacaoCredito;
import models.Cliente;

public class ValidadorCpfLimpo implements IAvaliadorCredito {

    private String nomeRegra = "Validador de CPF";
    private String mensagemReprovacao = "O cliente foi reprovado pois o CPF não está limpo!";

    @Override
    public boolean avaliar(SolicitacaoCredito solicitacao) {

        if(solicitacao == null || solicitacao.getCliente() == null) {
            this.mensagemReprovacao = "Solicitação ou cliente estão nulos.";
            return false;
        }

        Cliente cliente = solicitacao.getCliente();

        if(!cliente.isTemNomeLimpo()){
            return false;
        }
        
        this.mensagemReprovacao = "";
        return true;
    }
    public String getNomeRegra() {return nomeRegra;}
    public String getMensagemReprovacao() {return mensagemReprovacao;}   
}
