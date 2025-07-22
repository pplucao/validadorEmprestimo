package avaliator;

import interfaces.IAvaliadorCredito;
import models.SolicitacaoCredito;
import models.Cliente;

public class ValidadorTempoEmprego implements IAvaliadorCredito {

    private String nomeRegra = "Validador de tempo de emprego";
    private String mensagemReprovacao = "Cliente não atinge o tempo mínimo de emprego desejado.";
    private int tempoEmpregoMinimo;

    public ValidadorTempoEmprego (int tempoEmpregoMinimo){
        this.tempoEmpregoMinimo = tempoEmpregoMinimo;
    }

    public boolean avaliar(SolicitacaoCredito solicitacao) {
        if(solicitacao == null || solicitacao.getCliente() == null) {
            this.mensagemReprovacao = "Solicitação ou cliente estão nulos";
        }

        if(getTempoEmpregoMinimo() > solicitacao.getCliente().getTempoEmpregoMeses()){
            return false;
        }
        this.mensagemReprovacao = "";
        return true;
    }

    public int getTempoEmpregoMinimo(){return tempoEmpregoMinimo;}
    public String getNomeRegra() {return nomeRegra;}
    public String getMensagemReprovacao() {return mensagemReprovacao;}
    
}
