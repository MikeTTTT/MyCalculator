package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage window;
    private UICreator uiCreator;
    private String backgroundColor;
    private BackgroundFill backgroundFill;

    private void changeBackgroundColor( VBox layout, String backgroundColor) {

        if (backgroundColor.equals("red")){
            layout.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
            uiCreator.output.setTextFill(Color.BLACK);
        }else if (backgroundColor.equals("white")){
            layout.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
            uiCreator.output.setTextFill(Color.BLACK);
        }else if (backgroundColor.equals("black")){
            layout.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
            uiCreator.output.setTextFill(Color.WHITE);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = new Stage();
        window.setTitle("my calculator");

        uiCreator = new UICreator();

        // 添加数字键

        VBox vBox = new VBox();

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("white","black","red");
        comboBox.setPromptText("theme");
        comboBox.setOnAction(e -> {
                    backgroundColor = comboBox.getValue();
                    changeBackgroundColor(vBox, backgroundColor);
                });

        comboBox.setPrefSize(95, 20);

        vBox.setSpacing(10);
        vBox.getChildren().addAll(uiCreator.displayScreen(), uiCreator.displayCenter(), comboBox);

        Scene scene = new Scene(vBox,250,300);
        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
