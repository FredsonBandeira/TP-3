package todolist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import java.sql.Connection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class login implements Initializable {


    @FXML
    private TextField Idnome;

    @FXML
    private PasswordField idsenha;

    @FXML
    private Button BotaoGuardar;

    @FXML
    private Button botaoCancelar;
    @FXML
    private Label InvalidoLogin;

    @FXML
    private Label Idclose;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    @FXML
    public void loginBotaoOnAction(ActionEvent event) {

            if (Idnome.getText().isBlank() == false && idsenha.getText().isBlank() == false ){
               validarLogin();
                //InvalidoLogin.setText("");
            }else {
                InvalidoLogin.setText("Please enter Name//password");
            }
    }

    @FXML
    public  void CancelarBotaoONaction(ActionEvent event) {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();

    }


    @FXML
    void CloseOnAction(MouseEvent event) { // evento que permite fechar o programa
        Stage stage = (Stage) Idclose.getScene().getWindow();
        exit(1);
    }

    void mainwindow() throws IOException{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("mainwindows.fxml"));
        Parent root=loader.load();
        Controller controller = loader.getController();
        Stage window = (Stage) BotaoGuardar.getScene().getWindow();
        window.setScene(new Scene(root));

    }

public void  validarLogin(){
        Bdconnection connectionNow = new Bdconnection();
        Connection connectBd = connectionNow.getConnection();

        String verifylogin = "select count(1) from bd_poo.login where usernome = '" + Idnome.getText() + "' and password = '" + idsenha.getText() +"'";

        try{
            Statement statement = connectBd.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    //InvalidoLogin.setText(" Login com sucesso");
                    mainwindow();
                }else{


                    InvalidoLogin.setText(" Invalido login. Tente Novamente");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
