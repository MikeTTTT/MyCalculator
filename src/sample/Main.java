package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = new Stage();
        window.setTitle("my calculator");

        // 添加数字键

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(UICreator.displayNumber());
        borderPane.setRight(UICreator.displaySign());

        Scene scene = new Scene(borderPane);
        window.setScene(scene);
        window.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
