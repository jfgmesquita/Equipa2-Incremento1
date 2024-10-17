package Equipa2.Incremento1;

import java.util.ArrayList;

public class Profissional extends Utilizador {
    private ArrayList<Solicitacao> servicos;
    private String especialidade;
    private int experiencia; 
    private double valorHora;
    private ArrayList<Avaliacao> avaliacoes; 

     public Profissional(String nome, String email, String password, String morada,
                        String[] servicos, String especialidade, int experiencia, 
                        double valorHora, double[] avaliacoes) {
        super(nome, email, password, morada);
        this.servicos = new ArrayList<>();
        this.especialidade = especialidade;
        this.experiencia = experiencia;
        this.valorHora = valorHora;
        this.avaliacoes = new ArrayList<>();
    }

    
    public ArrayList <Solicitacao> getServicos() {
        return servicos;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public double getValorHora() {
        return valorHora;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    
    
    // Métodos set    

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
    
    