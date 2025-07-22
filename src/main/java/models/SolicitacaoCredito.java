package models;

import java.time.LocalDateTime;
import java.util.UUID;

import enums.StatusAprovacao;
import models.Cliente;

public class SolicitacaoCredito {
    private UUID id;
    private Cliente cliente;
    private double valorEmprestimoDesejado;
    private int prazoPagamentoMeses;
    private StatusAprovacao statusAprovacao;
    private String motivoReprovacao;
    private LocalDateTime dataSolicitacao;

    public SolicitacaoCredito (Cliente cliente, double valorEmprestimoDesejado, int prazoPagamentoMeses) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.valorEmprestimoDesejado = valorEmprestimoDesejado;
        this.prazoPagamentoMeses = prazoPagamentoMeses;
        this.statusAprovacao = StatusAprovacao.PENDENTE;
        this.motivoReprovacao = motivoReprovacao;
        this.dataSolicitacao = LocalDateTime.now();
    }

    public UUID getId() {return id;}
    public Cliente getCliente() {return cliente;}
    public double getValorEmprestimoDesejado() {return valorEmprestimoDesejado;}
    public int getPrazoPagamentoMeses() {return prazoPagamentoMeses;}
    public StatusAprovacao getStatusAprovacao() {return statusAprovacao;}
    public String getMotivoReprovacao() {return motivoReprovacao;}
    public LocalDateTime getDataSolicitacao() {return dataSolicitacao;}

    public void setStatusAprovacao(StatusAprovacao statusAprovacao) { this.statusAprovacao = statusAprovacao;}
    public void setMotivoReprovacao(String motivoReprovacao) {this.motivoReprovacao = motivoReprovacao;}
}
