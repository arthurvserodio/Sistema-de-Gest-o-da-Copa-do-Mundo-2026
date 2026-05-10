package users;

public class Usuario {
    private String nome;
    private Funcao funcao;
    private String pais;
    private String senha;

    //colocando o construtor para teste, na realidade os usuarios serao instanciados pelas classes especificas
    public Usuario(String nome, String funcao, String pais, String senha) {
        this.nome = nome;
        this.funcao = Funcao.valueOf(funcao);
        this.pais = pais;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }
}
