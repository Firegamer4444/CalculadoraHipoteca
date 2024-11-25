package dad.CalculadoraHipoteca.ui;

import dad.CalculadoraHipoteca.api.Cuota;
import dad.CalculadoraHipoteca.model.CuotaModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    // model

    private ListProperty<CuotaModel> cuotas = new SimpleListProperty<>(FXCollections.observableArrayList());

    // View

    @FXML
    private TableColumn<CuotaModel, Number> añoColumn;

    @FXML
    private TextField añosField;

    @FXML
    private TableColumn<CuotaModel, Number> capitalAmortizadoColumn;

    @FXML
    private TextField capitalField;

    @FXML
    private TableColumn<CuotaModel, Number> capitalInicialColumn;

    @FXML
    private TableColumn<CuotaModel, Number> capitalPendienteColumn;

    @FXML
    private TableView<CuotaModel> cuotaTable;

    @FXML
    private TableColumn<CuotaModel, Number> cuotasColumn;

    @FXML
    private TextField interesField;

    @FXML
    private TableColumn<CuotaModel, Number> interesesColumn;

    @FXML
    private TableColumn<CuotaModel, Number> mesColumn;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cuotaTable.itemsProperty().bind(cuotas);

        // cell values factories

        añoColumn.setCellValueFactory(v -> v.getValue().añoProperty());
        mesColumn.setCellValueFactory(v -> v.getValue().mesProperty());
        capitalInicialColumn.setCellValueFactory(v -> v.getValue().capitalInicialProperty());
        interesesColumn.setCellValueFactory(v -> v.getValue().interesesProperty());
        capitalAmortizadoColumn.setCellValueFactory(v -> v.getValue().capitalAmortizadoProperty());
        cuotasColumn.setCellValueFactory(v -> v.getValue().cuotasProperty());
        capitalPendienteColumn.setCellValueFactory(v -> v.getValue().capitalPendienteProperty());

    }

    @FXML
    void onCalcularAction(ActionEvent event) {

    }
}
