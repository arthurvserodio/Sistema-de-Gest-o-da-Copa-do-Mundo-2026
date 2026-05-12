package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import users.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ControllerUsuarios {

    @FXML private TableView<Usuario> tabelaUsuarios;
    @FXML private TableColumn<Usuario, String> colNome;
    @FXML private TableColumn<Usuario, String> colFuncao;
    @FXML private TableColumn<Usuario, String> colStatus;
    @FXML private TableColumn<Usuario, String> colPais;
    @FXML private TextField nome;
    @FXML private TextField funcao;
    @FXML private TextField status;
    @FXML private TextField pais;
    @FXML private PasswordField senha;


    @FXML
    public void initialize() {
        // Vincula cada coluna ao atributo correspondente da classe Usuario
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colFuncao.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Carrega os dados do CSV na tabela
        tabelaUsuarios.setItems(carregarUsuarios());
    }

    private ObservableList<Usuario> carregarUsuarios() {
        ObservableList<Usuario> lista = FXCollections.observableArrayList();

        try (
                InputStream is = getClass().getResourceAsStream("/database/usuarios.csv");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] colunas = linha.split(",");
                // colunas[0] = nome, colunas[1] = funcao, colunas[2] = pais, colunas[3]=status, colunas[4]=senha
                lista.add(new Usuario(colunas[0], colunas[1], colunas[2], colunas[3], colunas[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @FXML
    //Muda para tela de inicio
    private void irParaInicio(MouseEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/telaInicial/paginaInicial.fxml");
    }
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
    private void irParaEstadios(MouseEvent e) { SceneController.mudaDeTela( "/designAndScreens/telaEstadios/tela1.0.fxml");
    }
    @FXML
    private void irParaLogin(ActionEvent e) {
        SceneController.mudaDeTela( "/designAndScreens/login/login.fxml");
    }

    @FXML
    private void adicionarUsuario(ActionEvent e){
        //implementar chamar metodo adicionar que pertencera a classe do administrador

    }

    @FXML
    private void removerUsuario(ActionEvent e){
        //implementar chamar metodo remover que pertencera a classe do administrador
    }
}
