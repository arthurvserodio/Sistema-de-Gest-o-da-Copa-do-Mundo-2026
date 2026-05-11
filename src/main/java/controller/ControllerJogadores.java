package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerJogadores {


    @FXML
    private void irParaJogadores(ActionEvent e){
        SceneController.mudaDeTela("/designAndScreens/telaJogadores/jogadoresUSA.fxml");
    }

}
