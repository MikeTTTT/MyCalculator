package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = new Stage();
        window.setTitle("my calculator");

        // 添加数字键

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(UICreator.displayNumber(), UICreator.displaySign());

        VBox centerScreen = new VBox();
        centerScreen.setSpacing(30);
        centerScreen.getChildren().addAll(UICreator.displayScreen(), hBox);

        BorderPane borderPane = new BorderPane();
//        borderPane.setPadding(new Insets(10,10,10,20));
        borderPane.setCenter(centerScreen);
//        borderPane.setRight(UICreator.displaySign());

        Scene scene = new Scene(borderPane,200,300);
        window.setScene(scene);
        window.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
