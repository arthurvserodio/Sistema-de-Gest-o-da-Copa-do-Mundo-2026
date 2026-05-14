package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nationsAndPlayers.nations.Selecoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ControllerEquipes {
    private List<Selecoes> ListSelecoes = new ArrayList<>();
    @FXML
    private VBox listaSelecoes;

    @FXML
    public void initialize() {
        System.out.println(listaSelecoes);
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
        SceneController.mudaDeTela("/designAndScreens/telaEstadios/tela1.0.fxml");
    }

    @FXML //Helena ta fazendo, depois adiciona o trocaTela + fxml
    private void irParaLogin(ActionEvent e) {
        SceneController.mudaDeTela("/designAndScreens/login/login.fxml");
    }

    private void carregaSelecao() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/database/SelecoesNaCopa.txt")));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                Selecoes s = new Selecoes(partes[0], partes[1], partes[2], partes[3], partes[4]);
                ListSelecoes.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HBox criarLinha(Selecoes selecao) {
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
        String caminhoImagem = "/images/" + selecao.getNome().toLowerCase().replace(" ", "_") + ".png";
        InputStream is = getClass().getResourceAsStream(caminhoImagem);
        ImageView logoSelecao;
        if(is != null){
            Image imagem=new Image(is);
            logoSelecao = new ImageView(imagem);
            logoSelecao.setOnMouseClicked(event ->{
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/designAndScreens/telaJogadores/jogadores.fxml"));
                    Parent tela = loader.load();
                    ControllerJogadores controller = loader.getController();
                    controller.setSelecoes(selecao);
                    ImageView source = (ImageView) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.setScene(new Scene(tela));
                } catch(IOException e){
                    e.printStackTrace();
                }
            });
        }
        else {
            Image imagemPadrao = new Image(getClass().getResourceAsStream("/images/brasil.png"));
            logoSelecao = new ImageView(imagemPadrao);
        }
        logoSelecao.setPreserveRatio(true);
        logoSelecao.setFitWidth(55);
        logoSelecao.setFitHeight(55);
        //Pegando os dados da seleção
        // Nome
        Label nome = new Label(selecao.getNome());
        nome.setStyle(""" 
                -fx-font-size: 20;
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        nome.setPrefWidth(252);
        //Grupo
        Label grupo = new Label("Grupo " + selecao.getGrupo());
        grupo.setStyle(""" 
                -fx-font-size: 13; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        grupo.setPrefWidth(90);
        //Ranking
        Label ranking = new Label(selecao.getRanking());
        ranking.setStyle(""" 
                -fx-font-size: 11; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        ranking.setPrefWidth(70);
        //Participações
        Label participacao = new Label(selecao.getParticipacao());
        participacao.setStyle(""" 
                -fx-font-size: 11; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        participacao.setPrefWidth(95);
        //Títulos
        Label titulos = new Label(selecao.getTitulo());
        titulos.setStyle(""" 
                -fx-font-size: 11; 
                -fx-text-fill: black;
                -fx-font-family: 'Inter 18pt Medium';""");
        titulos.setPrefWidth(50);
        //Colocando todas as labeis na linha
        linha.getChildren().addAll(logoSelecao, nome, grupo, ranking, participacao, titulos);
        return linha;
    }

    private void mostraSelecao() {
        for (Selecoes s : ListSelecoes) {
            HBox linha = criarLinha(s);
            listaSelecoes.getChildren().add(linha);
        }
    }
}
