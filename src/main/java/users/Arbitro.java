package users;

public class Arbitro {
    private String nome;
    private String nacionalidade;
    private int experiencia;

    public Arbitro(String nome, String nacionalidade, int experiencia) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.experiencia = experiencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
