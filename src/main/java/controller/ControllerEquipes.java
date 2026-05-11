package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;


public class ControllerEquipes {
    private List<Selecao> ListSelecoes = new ArrayList<>();

    @FXML
    public void initialize() {
        carregaSelecao();
        mostraSelecao();
    }

    @FXML
    private void irPaginaInicial(MouseEvent e) {
        SceneController.mudaDeTela("/designAndScreens/telaInicial/paginaInicial.fxml");
    } //Passa do Menu para a página que conta a historia da copa

    @FXML
    private void irParaHistoria(MouseEvent e) {
        SceneController.mudaDeTela("/designAndScreens/telaInicial/historia.fxml");
    }

    @FXML //Passa do Menu para a tela de equipes presentes na copa de 2026
    private void irParaEquipes(MouseEvent e) {
        SceneController.mudaDeTela("/designAndScreens/telaInicial/equipesNaCopa.fxml");
    }

    @FXML //Passa do Menu para a tela de grupos da copa 2026
    private void irParaClassificacao(MouseEvent e) {
        SceneController.mudaDeTela("/designAndScreens/telaInicial/classificacao.fxml");
    }

    @FXML //Gustavo ta fazendo, depois adiciona o trocaTela + fxml
    private void irParaEstadios(MouseEvent e) {
        SceneController.mudaDeTela("/designAndScreens/telaEstadios/tela1.fxml");
    }

    @FXML //Helena ta fazendo, depois adiciona o trocaTela + fxml
    private void irParaLogin(ActionEvent e) {
        SceneController.mudaDeTela("/designAndScreens/login/login.fxml");
    }

    private void carregaSelecao() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/database/SelecoesNaCopa.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                Selecao s = new Selecao(partes[0], partes[1], partes[2], partes[3], partes[4]);
                ListSelecoes.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private VBox listaSelecoes;

    private HBox criarLinha(Selecao selecao) {
        HBox linha = new HBox();
        linha.setAlignment(Pos.CENTER_LEFT);
        linha.setSpacing(40);
        linha.setPrefHeight(80);
        linha.setStyle(""" 
                -fx-background-color: white; 
                -fx-border-color: #EEEEEE; 
                -fx-padding: 10 20 10 20;
                """);
        //Tem que ver como faz o upload de imagem, mas deixa para depois
        ImageView logoSelecao = new ImageView();
        logoSelecao.setFitWidth(45);
        logoSelecao.setFitHeight(45);
        //Pegando os dados da seleção
        // Nome
        Label nome = new Label(selecao.getNome());
        nome.setStyle(""" 
                -fx-font-size: 25; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        nome.setPrefWidth(250);
        //Grupo
        Label grupo = new Label("Grupo " + selecao.getGrupo());
        grupo.setStyle(""" 
                -fx-font-size: 25; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        grupo.setPrefWidth(120);
        //Ranking
        Label ranking = new Label(selecao.getRanking());
        ranking.setStyle(""" 
                -fx-font-size: 25; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        ranking.setPrefWidth(50);
        //Participações
        Label participacao = new Label(selecao.getParticipacao());
        participacao.setStyle(""" 
                -fx-font-size: 25; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        participacao.setPrefWidth(50);
        //Títulos
        Label titulos = new Label(selecao.getTitulo());
        titulos.setStyle(""" 
                -fx-font-size: 25; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        titulos.setPrefWidth(50);
        //Colocando todas as labeis na linha
        linha.getChildren().addAll(logoSelecao, nome, grupo, ranking, participacao, titulos);
        return linha;
    }

    private void mostraSelecao() {
        for (Selecao s : ListSelecoes) {
            HBox linha = criarLinha(s);
            listaSelecoes.getChildren().add(linha);
        }
    }
}
