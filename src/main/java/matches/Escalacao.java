package matches;

import nationsAndPlayers.Selecoes;

import java.util.ArrayList;

public class Escalacao {
    private Selecoes selecao;
    private String formacao;
    private ArrayList<JogadorPartida> titulares;
    private ArrayList<JogadorPartida> reservas;

    public Escalacao(Selecoes selecao, String formacao, ArrayList<JogadorPartida> titulares, ArrayList<JogadorPartida> reservas) {
        this.selecao = selecao;
        this.formacao = formacao;
        this.titulares = titulares;
        this.reservas = reservas;
    }
    public Selecoes getSelecao() {
        return selecao;
    }
    public void setSelecao(Selecoes selecao) {
        this.selecao = selecao;
    }

    public String getFormacao() {
        return formacao;
    }
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public ArrayList<JogadorPartida> getTitulares() {
        return titulares;
    }
    public void setTitulares(ArrayList<JogadorPartida> titulares) {
        this.titulares = titulares;
    }

    public ArrayList<JogadorPartida> getReservas() {
        return reservas;
    }
    public void setReservas(ArrayList<JogadorPartida> reservas) {
        this.reservas = reservas;
    }
}
