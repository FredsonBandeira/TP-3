package todolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class listar implements Initializable{

    @FXML
    private Button button_incio;

    @FXML
    private Button button_instrutor;

    @FXML
    private Button button_veiculo;

    @FXML
    private Button button_aulas;

    @FXML
    private Button button_exames;

    @FXML
    private Button button_cadastrar;

    @FXML
    private Label Idclose;




    @FXML
    private TableView<Alunos> idalunos;

    @FXML
    private TableColumn<Alunos, Integer> idid;

    @FXML
    private TableColumn<Alunos, String> nameCol;

    @FXML
    private TableColumn<Alunos, String> dataCol;

    @FXML
    private TableColumn<Alunos,  Integer> nifCol;

    @FXML
    private TableColumn<Alunos, String> biCol;

    @FXML
    private TableColumn<Alunos,  Integer>telefoneCol;

    @FXML
    private TableColumn<Alunos, String> profCol;

    @FXML
    private TableColumn<Alunos, String> categCol;

    @FXML
    private TableColumn<Alunos, String> editCol;

    Bdconnection connectionNow = new Bdconnection();
    Connection connectBd = connectionNow.getConnection();
    String query = null;
    //Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Alunos student = null ;

    ObservableList<Alunos> StudentList = FXCollections.observableArrayList();


 @Override
  public void initialize(URL url, ResourceBundle rb){
     loadDate();
 }

    private void loadDate() {


        connectBd = Bdconnection.getConnection();
        refresh();

        idid.setCellValueFactory(new PropertyValueFactory<Alunos,Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Alunos,String>("nome"));
        dataCol.setCellValueFactory(new PropertyValueFactory<Alunos,String>("data_nasc"));
        nifCol.setCellValueFactory(new PropertyValueFactory<Alunos,Integer>("nif"));
        biCol.setCellValueFactory(new PropertyValueFactory<Alunos,String>("bi"));
        telefoneCol.setCellValueFactory(new PropertyValueFactory<Alunos,Integer>("telefone"));
        profCol.setCellValueFactory(new PropertyValueFactory<Alunos,String>("profissao"));
        categCol.setCellValueFactory(new PropertyValueFactory<Alunos,String>("categoria"));


    }



    @FXML
    void getAdd(MouseEvent event) throws IOException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(listar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void print(MouseEvent event) {

    }

    @FXML
    private void refresh() {
        try {
            StudentList.clear();

            query = "SELECT * FROM bd_poo.cadastro";
            preparedStatement = connectBd.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                StudentList.add(new Alunos(
                        resultSet.getInt("idcadastro"),
                        resultSet.getString("nome"),
                        resultSet.getDate("data_nasc"),
                        resultSet.getInt("nif"),
                        resultSet.getString("bi"),
                        resultSet.getInt("telefone"),
                        resultSet.getString("profissao"),
                        resultSet.getString("categoria")));
                idalunos.setItems(StudentList);

            }


        } catch (SQLException ex) {
            Logger.getLogger(listar.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @FXML
    void enter_aulas() throws IOException {

        FXMLLoader loader =new FXMLLoader(getClass().getResource("aulas.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_aulas.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void enter_cadastrar() throws IOException {

        FXMLLoader loader =new FXMLLoader(getClass().getResource("cadastrar.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_cadastrar.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void enter_calendarioExames() throws IOException {

        FXMLLoader loader =new FXMLLoader(getClass().getResource("calendario.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_exames.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void enter_inicio() throws IOException {

        FXMLLoader loader =new FXMLLoader(getClass().getResource("mainwindows.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_incio.getScene().getWindow();
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
    void enter_veiculo() throws IOException{

        FXMLLoader loader =new FXMLLoader(getClass().getResource("veiculo.fxml"));
        Parent root=loader.load();
        Stage window = (Stage) button_veiculo.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void CloseOnAction(MouseEvent event) {
        Stage stage = (Stage) Idclose.getScene().getWindow();
        exit(1);
    }
}
