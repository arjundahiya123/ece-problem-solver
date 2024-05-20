package ece2238.eceproblemsolver;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Scanner;

public class SemiConductorController {

    private MainApplicationController mainApplicationController;

    public void setMainController(MainApplicationController controller) {
        mainApplicationController = controller;
    }

    @FXML
    private TextField nameInput;
    @FXML
    private TextField atomicNumberInput;
    @FXML
    private TextField Ainput;
    @FXML
    private TextField ZInput;
    @FXML
    private TextField pmInput;
    @FXML
    private TextField pInput;
    @FXML
    private TextField radiusLengthsInput;
    @FXML
    private TextField nDisplay;
    @FXML
    private TextField raDisplay;
    @FXML
    private TextField tDisplay;
    @FXML
    private TextField pDisplay;
    @FXML
    private TextField kfDisplay;
    @FXML
    private TextField efDisplay;
    @FXML
    private TextField vfDisplay;
    @FXML
    private TextField tfDisplay;
    @FXML
    private TextField formulaInput;
    @FXML
    private TextField egInput;
    @FXML
    private TextField unInput;
    @FXML
    private TextField upInput;
    @FXML
    private TextField binput;
    @FXML
    private TextField naInput;
    @FXML
    private TextField ndInput;
    @FXML
    private TextField niDisplay;
    @FXML
    private TextField piDisplay;
    @FXML
    private TextField v0Display;




    public static Calculator calculator = new Calculator();

    @FXML
    public void generateValues()
    {

        try {
            String name = nameInput.getText();
            int atomicNumber = Integer.parseInt(atomicNumberInput.getText());
            double A = Double.parseDouble(Ainput.getText());
            int Z = Integer.parseInt(ZInput.getText());
            double pm = Double.parseDouble(pmInput.getText());
            double p = Double.parseDouble(pInput.getText());
            int radiusLengths = Integer.parseInt(radiusLengthsInput.getText());

            Element element = new Element(name, atomicNumber, A, Z, pm, p);

            nDisplay.setText(String.valueOf(calculator.calculateElectronDensity(element)));
            element.setN(calculator.calculateElectronDensity(element));

            raDisplay.setText(String.valueOf(calculator.calculateRadius(element)));
            element.setRadius(calculator.calculateRadius(element));

            tDisplay.setText(String.valueOf(calculator.calculateMeanScatteringTime(element, radiusLengths)));
            element.setMeanScatteringTime(calculator.calculateMeanScatteringTime(element, radiusLengths));

            pDisplay.setText(String.valueOf(calculator.calculateDrudeResistivity(element)));
            element.setpDrude(calculator.calculateDrudeResistivity(element));

            System.out.println("Free Electron Model");

            kfDisplay.setText(String.valueOf(calculator.calculateKF(element)));
            element.setKf(calculator.calculateKF(element));

            efDisplay.setText(String.valueOf(calculator.calculateEF(element)));
            element.setEf(calculator.calculateEF(element));

            vfDisplay.setText(String.valueOf(calculator.calculateVF(element)));
            element.setVf(calculator.calculateVF(element));

            tfDisplay.setText(String.valueOf(calculator.calculatetf(element)));
            element.setTf(calculator.calculatetf(element));

            System.out.printf("\n\nExamining Semi Conductors\nPlease Enter Semi Conductor info:\n");

        } catch (Exception e){
            e.printStackTrace();
            mainApplicationController.displayAlert(e.getClass().getName(), e.getMessage());
        }


    }
    @FXML
    public void generateValues2()
    {
        try {
            String formula = formulaInput.getText();
            double eg = Double.parseDouble(egInput.getText());
            int un = Integer.parseInt(unInput.getText());
            int up = Integer.parseInt(upInput.getText());
            double b = Double.parseDouble(binput.getText());
            double na = Double.parseDouble(naInput.getText());
            double nd = Double.parseDouble(ndInput.getText());

            SemiConductor semiConductor = new SemiConductor(formula, eg, un, up, b);

            niDisplay.setText(String.valueOf(calculator.calculateni(semiConductor)));
            semiConductor.setNi(calculator.calculateni(semiConductor));

            piDisplay.setText(String.valueOf(calculator.calculateni(semiConductor)));
            semiConductor.setPi(calculator.calculateni(semiConductor));

            v0Display.setText(String.valueOf(calculator.calculateV0(semiConductor, na, nd)));
            semiConductor.setV0(calculator.calculateV0(semiConductor, na, nd));
        } catch (Exception e){
            e.printStackTrace();
            mainApplicationController.displayAlert(e.getClass().getName(), e.getMessage());
        }
    }

    @FXML
    void exit() {
        Stage stage = (Stage) nameInput.getScene().getWindow();
        stage.close();
    }

}