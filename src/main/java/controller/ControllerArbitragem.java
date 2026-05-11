package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import users.Arbitro;

public class ControllerArbitragem {
    @FXML private AnchorPane painelPrincipal;
    @FXML private TableView<Arbitro> tabela;
    @FXML private TableColumn<Arbitro, String> colNome;
    @FXML private TableColumn<Arbitro, String> colNacionalidade;
    @FXML private TableColumn<Arbitro, Integer> colExperiencia;
    public void initialize() {

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNacionalidade.setCellValueFactory(new PropertyValueFactory<>("nacionalidade"));
        colExperiencia.setCellValueFactory(new PropertyValueFactory<>("experiencia"));

        ObservableList<Arbitro> lista = FXCollections.observableArrayList(
                new Arbitro("Daronco","brasileiro",4)
        );

        tabela.setItems(lista);

        painelPrincipal.setOnMouseClicked(event -> {
            tabela.getSelectionModel().clearSelection();
        });

    }



        @FXML
    private void irParaTela1(ActionEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/telaEstadios/tela1.fxml");
    }

    @FXML
    //Passa para tela de login
    private void irParaLogin(ActionEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/login/login.fxml");
    }





    @FXML
    //Passa do Menu para a tela de grupos da copa 2026
    private void irParaClassificacao(MouseEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/telaInicial/classificacao.fxml");
    }


    @FXML
    //Muda para tela de inicio
    private void irParaInicio(MouseEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/telaInicial/paginaInicial.fxml");
    }
    @FXML
    //Passa do Menu para a tela de equipes presentes na copa de 2026
    private void irParaEquipes(MouseEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/telaInicial/equipesNaCopa.fxml");
    }

    @FXML
    //Passa para tela de história
    private void irParaHistoria(MouseEvent e){
        SceneController.mudaDeTela("/designAndScreens/telaInicial/historia.fxml");
    }
    @FXML
    private void irParaUsuarios(MouseEvent e){
        SceneController.mudaDeTela( "/designAndScreens/telasAdministrador/usuarios.fxml");
    }
    @FXML

    private void irParaEstadios(MouseEvent e) { SceneController.mudaDeTela( "/designAndScreens/telaEstadios/tela1.0.fxml");
    }
}
