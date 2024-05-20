package ece2238.eceproblemsolver;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplicationController {

    @FXML
    private Button exitBtn;

    @FXML
    void launchSemiConductorSolver() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("semiConductorSolver-view.fxml"));
        Parent semiConductorProperties = fxmlLoader.load();

        SemiConductorController semiConductorController = fxmlLoader.getController();
        semiConductorController.setMainController(this);

        Scene scene = new Scene(semiConductorProperties, 630, 800);
        Stage stage = new Stage();
        stage.setTitle("Semiconductor / Element Properties Solver!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void launchQuantumSolver() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("quantumSolver-view.fxml"));
        Parent quantumSolver = fxmlLoader.load();

        QuantumSolverController quantumSolverController = fxmlLoader.getController();
        quantumSolverController.setMainController(this);

        Scene scene = new Scene(quantumSolver, 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Quantum Circuit Solver!");
        stage.setScene(scene);
        stage.show();
//        stage.getIcons().add(new Image("file:src/main/resources/se2203b/ipayroll/WesternLogo.png"));
//        stage.initModality(Modality.APPLICATION_MODAL);
    }

    @FXML
    void exit() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    public void displayAlert(String errorType, String msg) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("alert-view.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

//            stage.getIcons().add(new Image("file:src/main/resources/se2203b/lab6/tennisballgames/WesternLogo.png"));
            controller.setAlertText("Caught Exception: " + errorType + "\n\nERROR: " + msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }
}
