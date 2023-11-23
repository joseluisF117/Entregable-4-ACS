module com.uacm.ces.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.uacm.ces.proyectofinal to javafx.fxml;
    exports com.uacm.ces.proyectofinal;
    opens com.uacm.ces.proyectofinal.modelo;
    
}
