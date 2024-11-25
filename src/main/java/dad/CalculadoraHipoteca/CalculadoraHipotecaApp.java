package dad.CalculadoraHipoteca;

import dad.CalculadoraHipoteca.ui.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraHipotecaApp extends Application {

    RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(rootController.getRoot());

        primaryStage.setTitle("Calculadora hipoteca");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
