package stadiumAndRefereeing;


public class Estadio {
    private String nome;
    private String capacidade;
    private String local;

    public Estadio(String nome, String capacidade, String local) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.local = local;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() { return nome; }
    public String getCapacidade() { return capacidade; }
    public String getLocal() { return local; }
}