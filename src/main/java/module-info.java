module ece2238.eceproblemsolver {
    requires javafx.controls;
    requires javafx.fxml;


    opens ece2238.eceproblemsolver to javafx.fxml;
    exports ece2238.eceproblemsolver;
}