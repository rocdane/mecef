module org.n2aconsultings.mecef {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires lombok;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jasperreports;

    opens org.n2aconsultings.mecef.controller to javafx.fxml;
    opens org.n2aconsultings.mecef.factory to com.google.gson;
    opens org.n2aconsultings.mecef.model to com.google.gson;
    exports org.n2aconsultings.mecef;
}