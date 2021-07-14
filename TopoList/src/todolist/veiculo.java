package todolist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.System.exit;

public class veiculo {




    @FXML
    private Button button_inicio;

    @FXML
    private Button button_instrutor;

    @FXML
    private Button button_aulas;

    @FXML
    private Button button_exames;

    @FXML
    private Button button_cadastrar;

    @FXML
    private Button button_alunos;

    @FXML
    private Label Idclose;



    @FXML
    void enter_cadastrar()   throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("cadastrar.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_cadastrar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    void enter_calendario() throws IOException {

        FXMLLoader loader =new FXMLLoader(getClass().getResource("calendario.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_exames.getScene().getWindow();
        window.setScene(new Scene(root));
    }



    @FXML
    void enter_main() throws IOException{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("mainwindows.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_inicio.getScene().getWindow();
        window.setScene(new Scene(root));

    }




    @FXML
    void listarAlunos() throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("listar.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_alunos.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void enter_instrutor() throws IOException {

        FXMLLoader loader =new FXMLLoader(getClass().getResource("Instrutor.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_instrutor.getScene().getWindow();
        window.setScene(new Scene(root));

    }


    @FXML
    void CloseOnAction(MouseEvent event) {
        Stage stage = (Stage) Idclose.getScene().getWindow();
        exit(1);
    }
}
