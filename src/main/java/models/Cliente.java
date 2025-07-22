package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente {
    private String cpf;
    private String nome;
    private double rendaMensal;
    private int scoreSerasa;
    private boolean temNomeLimpo;
    private int tempoEmpregoMeses;
    private int idade;
    private List<HistoricoDividas> historicoDividas;

    public Cliente (String cpf, String nome, double rendaMensal, int scoreSerasa, boolean temNomeLimpo, int tempoEmpregoMeses, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.rendaMensal = rendaMensal;
        this.scoreSerasa = scoreSerasa;
        this.temNomeLimpo = temNomeLimpo;
        this.tempoEmpregoMeses = tempoEmpregoMeses;
        this.idade = idade;
        this.historicoDividas = new ArrayList<>();
    }

    public void adicionarDivida(HistoricoDividas novaDivida) {
        if (historicoDividas != null) {
            historicoDividas.add(novaDivida);
        }
    }


    
    public String getCpf() {return cpf;}
    public String getNome() {return nome;}
    public double getRendaMensal() {return rendaMensal;}
    public int getScoreSerasa() {return scoreSerasa;}
    public boolean isTemNomeLimpo() {return temNomeLimpo;}
    public int getTempoEmpregoMeses() {return tempoEmpregoMeses;}
    public int getIdade() {return idade;}
    public List<HistoricoDividas> getHistoricoDividas() {return historicoDividas;}
    
}
