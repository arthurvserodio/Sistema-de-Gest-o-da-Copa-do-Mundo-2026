package matches;

import Enums.TipoEvento;

public class EventosOcorridos {
    private int minuto;
    private TipoEvento tipo;
    private Jogadores jogador;

    public EventosOcorridos(int minuto, TipoEvento tipo, Jogadores jogador) {
        this.minuto = minuto;
        this.tipo = tipo;
        this.jogador = jogador;
    }
    public int getMinuto() {
        return minuto;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public TipoEvento getTipo() {
        return tipo;
    }
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public Jogadores getJogador() {
        return jogador;
    }
    public void setJogador(Jogadores jogador) {
        this.jogador = jogador;
    }
}
