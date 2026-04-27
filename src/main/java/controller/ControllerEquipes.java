package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerEquipes {
    //Lógica para a troca de tela
    private void trocarTela(Event e, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception d) {
            d.printStackTrace();
        }
    }
    private static int pagina=0;
    private String[] listaFxml=new String[] {"equipesNaCopa.fxml","equipesNaCopa2.fxml","equipesNaCopa3.fxml","equipesNaCopa4.fxml"
            ,"equipesNaCopa5.fxml","equipesNaCopa6.fxml","equipesNaCopa7.fxml","equipesNaCopa8.fxml","equipesNaCopa9.fxml"
            ,"equipesNaCopa10.fxml","equipesNaCopa11.fxml","equipesNaCopa12.fxml"};
    //Volta para a pagina inicial de menu clicando no logo da copa
    @FXML
    private void irPaginaInicial(MouseEvent e){
        trocarTela(e,"paginaInicial.fxml");
    }
    //Passa do Menu para a página que conta a historia da copa
    @FXML
    private void irParaHistoria(MouseEvent e){
        trocarTela(e,"historia.fxml");
    }
    @FXML
    //Passa do Menu para a tela de equipes presentes na copa de 2026
    private void irParaEquipes(MouseEvent e) {
        pagina=0;
        trocarTela(e, "equipesNaCopa.fxml");
    }
    @FXML
    //Passa do Menu para a tela de grupos da copa 2026
    private void irParaClassificacao(MouseEvent e) {
        trocarTela(e, "classificacao.fxml");
    }
    @FXML
    //Gustavo ta fazendo, depois adiciona o trocaTela + fxml
    private void irParaEstadios(MouseEvent e) {
        System.out.println("Página Estádios ainda não pronta");
    }
    @FXML
    //Helena ta fazendo, depois adiciona o trocaTela + fxml
    private void irParaLogin(ActionEvent e) {
        System.out.println("Página Login ainda não pronta");
    }
    @FXML
    private void avancar(ActionEvent e) {
        if (pagina < listaFxml.length - 1) {
            pagina++;
            trocarTela(e, listaFxml[pagina]);
        }
    }
    @FXML
    private void voltar(ActionEvent e){
        if (pagina > 0) {
            pagina--;
            trocarTela(e, listaFxml[pagina]);
        }
    }
}
