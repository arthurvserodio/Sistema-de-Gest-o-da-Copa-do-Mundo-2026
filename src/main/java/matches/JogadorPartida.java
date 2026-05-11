package matches;

import nationsAndPlayers.Jogadores;

public class JogadorPartida {
    private Jogadores jogador;
    private double nota;
    private boolean capitao;

    public JogadorPartida(Jogadores jogador, double nota, boolean capitao) {
        this.jogador = jogador;
        this.nota = nota;
        this.capitao = capitao;
    }

    public Jogadores getJogador() {
        return jogador;
    }
    public void setJogador(Jogadores jogador) {
        this.jogador = jogador;
    }

    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isCapitao() {
        return capitao;
    }
    public void setCapitao(boolean capitao) {
        this.capitao = capitao;
    }
}
