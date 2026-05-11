package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;

public class ControllerLogin {
    //Volta para a pagina inicial de menu clicando no logo da copa
    @FXML
    private void irPaginaInicial(MouseEvent e){
        SceneController.mudaDeTela("/designAndScreens/telaInicial/paginaInicial.fxml");
    }
    //Passa do Menu para a página que conta a historia da copa
    @FXML
    private void irParaHistoria(MouseEvent e){
        SceneController.mudaDeTela("/designAndScreens/telaInicial/historia.fxml");
    }
    @FXML
    //Passa do Menu para a tela de equipes presentes na copa de 2026
    private void irParaEquipes(MouseEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/telaInicial/equipesNaCopa.fxml");
    }
    @FXML
    //Passa do Menu para a tela de grupos da copa 2026
    private void irParaClassificacao(MouseEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/telaInicial/classificacao.fxml");
    }
    @FXML
    //Gustavo ta fazendo, depois adiciona o trocaTela + fxml
    private void irParaEstadios(MouseEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/telaEstadios/tela1.0.fxml");
    }
    @FXML
    //Helena ta fazendo, depois adiciona o trocaTela + fxml
    private void irParaLogin(ActionEvent e) {SceneController.mudaDeTela( "/designAndScreens/login/login.fxml");
    }

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Label labelMensagem;

    @FXML
    private Button botaoEntrar;

    @FXML
    private Button botaoCadastro;

    // -------------------------------------------------------
    // Chamado ao clicar em "Entrar"
    // -------------------------------------------------------
    @FXML
    private void handleEntrar() {
        String usuario = campoUsuario.getText().trim();
        String senha   = campoSenha.getText().trim();

        // Validação básica de campos vazios
        if (usuario.isEmpty() || senha.isEmpty()) {
            mostrarErro("Preencha todos os campos.");
            return;
        }

        //tentando achar o usuario digitado no arquivo:

        try (
                InputStream is = getClass().getResourceAsStream("/database/usuarios.csv");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))
        ) {
            String linha;
            boolean find=false;
            String funcao="ARBITRO";
            while ((linha = reader.readLine()) != null) {
                String[] colunas = linha.split(",");
                if(usuario.equals(colunas[0]) && senha.equals(colunas[3])){
                    find=true;
                    funcao=colunas[1];
                    break;
                }
            }
            if(find){
                mostrarSucesso("Login realizado com sucesso!");
                if(funcao.equals("ADMINISTRADOR")){
                    SceneController.mudaDeTela( "/designAndScreens/telasAdministrador/telaPrincipalAdministrador.fxml");
                }
                else{
                    SceneController.mudaDeTela( "/designAndScreens/telaInicial/paginaInicial.fxml");
                }
            }
            else{
                mostrarErro("Usuário ou senha inválidos.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    private void mostrarErro(String mensagem) {
        labelMensagem.setStyle("-fx-font-size: 13px; -fx-text-fill: #cc0000;");
        labelMensagem.setText(mensagem);
    }

    private void mostrarSucesso(String mensagem) {
        labelMensagem.setStyle("-fx-font-size: 13px; -fx-text-fill: #1a7a1a;");
        labelMensagem.setText(mensagem);
    }


}
