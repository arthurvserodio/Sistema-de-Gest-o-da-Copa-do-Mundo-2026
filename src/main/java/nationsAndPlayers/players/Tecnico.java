package nationsAndPlayers.players;

import nationsAndPlayers.nations.Selecoes;

public class Tecnico {
    private String nome;
    private Selecoes selecao;

    public Tecnico(String nome, Selecoes selecao) {
        this.nome = nome;
        this.selecao = selecao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Selecoes getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecoes selecao) {
        this.selecao = selecao;
    }
}
