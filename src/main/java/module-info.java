module com.c57lee.javafxdatepickercell {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens com.c57lee.javafxdatepickercell to javafx.fxml;
    exports com.c57lee.javafxdatepickercell;
}