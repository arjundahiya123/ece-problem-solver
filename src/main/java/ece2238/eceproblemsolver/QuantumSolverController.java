package ece2238.eceproblemsolver;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class QuantumSolverController implements Initializable {

    private MainApplicationController mainApplicationController;

    public void setMainController(MainApplicationController controller) {
        mainApplicationController = controller;
    }
    static char a1, a2, b1, b2, c1, c2;
    static ComplexNumber zz, zo, oz, oo;

    @FXML
    private ChoiceBox<Character> boxA1;

    @FXML
    private ChoiceBox<Character> boxA2;

    @FXML
    private ChoiceBox<Character> boxB1;

    @FXML
    private ChoiceBox<Character> boxB2;

    @FXML
    private ChoiceBox<Character> boxC1;

    @FXML
    private ChoiceBox<Character> boxC2;

    @FXML
    private TextField ooImaginary;

    @FXML
    private TextField ooImaginaryAns;

    @FXML
    private TextField ooReal;

    @FXML
    private TextField ooRealAns;

    @FXML
    private TextField ozImaginary;

    @FXML
    private TextField ozImaginaryAns;

    @FXML
    private TextField ozReal;

    @FXML
    private TextField ozRealAns;

    @FXML
    private TextField zoImaginary;

    @FXML
    private TextField zoImaginaryAns;

    @FXML
    private TextField zoReal;

    @FXML
    private TextField zoRealAns;

    @FXML
    private TextField zzImaginary;

    @FXML
    private TextField zzImaginaryAns;

    @FXML
    private TextField zzReal;

    @FXML
    private TextField zzRealAns;

    @FXML
    void saveInputs(ActionEvent event) {
        try {
            zz = new ComplexNumber(Double.parseDouble(zzReal.getText()), Double.parseDouble(zzImaginary.getText()));
            zo = new ComplexNumber(Double.parseDouble(zoReal.getText()), Double.parseDouble(zoImaginary.getText()));
            oz = new ComplexNumber(Double.parseDouble(ozReal.getText()), Double.parseDouble(ozImaginary.getText()));
            oo = new ComplexNumber(Double.parseDouble(ooReal.getText()), Double.parseDouble(ooImaginary.getText()));
        } catch (Exception e){
            e.printStackTrace();
            mainApplicationController.displayAlert(e.getClass().getName(), e.getMessage());
        }
    }

    @FXML
    void saveLogicGates(ActionEvent event) {
        try {
            a1 = boxA1.getValue();
            b1 = boxB1.getValue();
            c1 = boxC1.getValue();
            a2 = boxA2.getValue();
            b2 = boxB2.getValue();
            c2 = boxC2.getValue();
        } catch (Exception e){
            e.printStackTrace();
            mainApplicationController.displayAlert(e.getClass().getName(), e.getMessage());
        }
    }

    @FXML
    void generateOutputValues(ActionEvent event) {
        try {
            boolean isControl = false;
            if (a1 == 'C') {
                isControl = true;
            }
            ComplexNumber[][] stageA = LogicGates.getStage(LogicGates.getLogicGate(a1), LogicGates.getLogicGate(a2), isControl);
//        System.out.println(Arrays.deepToString(stageA));
//
            boolean isControl2 = false;
            if (b1 == 'C') {
                isControl2 = true;
            }
            ComplexNumber[][] stageB = LogicGates.getStage(LogicGates.getLogicGate(b1), LogicGates.getLogicGate(b2), isControl2);
//        System.out.println(Arrays.deepToString(stageB));

            boolean isControl3 = false;
            if (c1 == 'C') {
                isControl3 = true;
            }
            ComplexNumber[][] stageC = LogicGates.getStage(LogicGates.getLogicGate(c1), LogicGates.getLogicGate(c2), isControl3);
//        System.out.println(Arrays.deepToString(stageC));

            ComplexNumber[][] inputMatrix = {{zz}, {zo}, {oz}, {oo}};
//        System.out.println(Arrays.deepToString(inputMatrix));

            ComplexNumber[][] matrixOperator = ComplexNumber.compMatrixMultiplication(ComplexNumber.compMatrixMultiplication(stageC, stageB), stageA);
//        System.out.println(Arrays.deepToString(temp1));

            ComplexNumber[][] outputMatrix = ComplexNumber.compMatrixMultiplication(matrixOperator, inputMatrix);
//        System.out.println(Arrays.deepToString(outputMatrix));
//        System.out.println("\n\n");
//        System.out.println("Output Probabilities:\n\n|00>: " + outputMatrix[0][0] + "\n|01>: " + outputMatrix[1][0] +
//                "\n|10>: " + outputMatrix[2][0] + "\n|11>: " + outputMatrix[3][0]);

            zzRealAns.setText(String.format("%.3f", outputMatrix[0][0].getReal()));
            zzImaginaryAns.setText(String.format("%.3f", outputMatrix[0][0].getImaginary()));
            zoRealAns.setText(String.format("%.3f", outputMatrix[1][0].getReal()));
            zoImaginaryAns.setText(String.format("%.3f", outputMatrix[1][0].getImaginary()));
            ozRealAns.setText(String.format("%.3f", outputMatrix[2][0].getReal()));
            ozImaginaryAns.setText(String.format("%.3f", outputMatrix[2][0].getImaginary()));
            ooRealAns.setText(String.format("%.3f", outputMatrix[3][0].getReal()));
            ooImaginaryAns.setText(String.format("%.3f", outputMatrix[3][0].getImaginary()));
        } catch (Exception e){
            e.printStackTrace();
            mainApplicationController.displayAlert(e.getClass().getName(), e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Character> logicGateOptions = FXCollections.observableArrayList('I', 'C', 'X', 'Y', 'Z','H', 'P');
        boxA1.setItems(logicGateOptions);
        boxB1.setItems(logicGateOptions);
        boxC1.setItems(logicGateOptions);
        boxA2.setItems(logicGateOptions);
        boxB2.setItems(logicGateOptions);
        boxC2.setItems(logicGateOptions);
    }

    @FXML
    void exit() {
        Stage stage = (Stage) boxA1.getScene().getWindow();
        stage.close();
    }

}
