package dad.CalculadoraHipoteca.ui;

import dad.CalculadoraHipoteca.api.CalculadoraHipoteca;
import dad.CalculadoraHipoteca.api.Cuota;
import dad.CalculadoraHipoteca.api.HipotecaResult;
import dad.CalculadoraHipoteca.model.CuotaModel;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    // logic

    private CalculadoraHipoteca calculadoraHipoteca = new CalculadoraHipoteca();

    // model

    private ListProperty<CuotaModel> cuotas = new SimpleListProperty<>(FXCollections.observableArrayList());

    private DoubleProperty capital = new SimpleDoubleProperty();
    private DoubleProperty interes = new SimpleDoubleProperty();
    private IntegerProperty año = new SimpleIntegerProperty();

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

    @FXML
    private BorderPane root;

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

        // bindings

        capitalField.textProperty().bindBidirectional(capital , new NumberStringConverter());
        interesField.textProperty().bindBidirectional(interes , new NumberStringConverter());
        añosField.textProperty().bindBidirectional(año , new NumberStringConverter());

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
        try {
            HipotecaResult result = calculadoraHipoteca.getCuotas(capital.get() , interes.get() , año.get());

            List<CuotaModel> cuotas = result.getCuotas().stream().map(CuotaModel::new).toList();

            this.cuotas.setAll(cuotas);
        } catch (IOException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.initOwner(root.getScene().getWindow());
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Algo ha salido mal");
            errorAlert.setContentText(e.getLocalizedMessage());
            errorAlert.show();
        }
    }

    public BorderPane getRoot() {
        return root;
    }
}
