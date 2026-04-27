package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerTelasEstadios {
    private void trocarTelaEstadios(Event e, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // 👇 em vez de criar nova Scene, só troca o conteúdo
            stage.getScene().setRoot(root);

        } catch (Exception d) {
            d.printStackTrace();
        }
    }
    @FXML
    private void irParaTela1(ActionEvent e) {
        trocarTelaEstadios(e, "/designAndScreens/telaEstadios/tela1.fxml");
    }

    @FXML
    private void irParaTela2(ActionEvent e) {
        trocarTelaEstadios(e, "/designAndScreens/telaEstadios/tela2.fxml");
    }

    @FXML
    private void irParaTela3(ActionEvent e) {
        trocarTelaEstadios(e, "/designAndScreens/telaEstadios/tela3.fxml");
    }

    @FXML
    private void irParaTela4(ActionEvent e) {
        trocarTelaEstadios(e, "/designAndScreens/telaEstadios/tela4.fxml");
    }

    @FXML
    //Passa do Menu para a tela inicial ao clicar no simbolo da copa
    private void irParaInicio(MouseEvent e) {
        trocarTelaEstadios(e, "/designAndScreens/telaInicial/paginaInicial.fxml");
    }
}

