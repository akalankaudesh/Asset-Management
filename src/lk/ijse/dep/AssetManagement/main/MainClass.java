package lk.ijse.dep.AssetManagement.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.PreparedStatement;

public class MainClass extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/MainViewForm.fxml"));
        Scene scene=new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
