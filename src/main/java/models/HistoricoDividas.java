package models;

import models.Cliente;

public class HistoricoDividas {
    
    private double valorDivida;
    private Cliente cliente;
    
    public HistoricoDividas (double valorDivida, Cliente cliente) {
        this.valorDivida = valorDivida;
        this.cliente = cliente;
    }

    public double getValorDivida() {return valorDivida;}
    public Cliente getCliente() {return cliente;}

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + "\n Dívida: R$" + valorDivida;
    }
    
}
