package users;

public class Arbitro extends Usuario {
    private int experiencia;

    public Arbitro(String nome,String pais, int experiencia) {
        super(nome, pais);
        this.experiencia = experiencia;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
