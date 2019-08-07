package sample;

import com.sun.istack.internal.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import utils.StringUtils;

public class UICreator {
      private static final Logger logger = Logger.getLogger(UICreator.class);

//    static VBox vBox;
//    static HBox hBox;
    // 添加输出行
    static Label output = new Label();
    static int lastInput;
    static int currentInput;
    static int lastResult;
    static String lastOperator;
    static boolean clearLabel = false;

    public static VBox displaySign(){
        VBox vBox = new VBox(13);
        Button btnTimes = new Button("X");
        Button btnDivide = new Button("/");
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnEquals = new Button("=");

        btnTimes.setOnAction(e -> {
            logger.info(String.format("pressed times, lastInput = %d, currentInput = %d", lastInput, currentInput));
            if (StringUtils.isNotEmpty(output.getText())) {
                lastInput = Integer.parseInt(output.getText());
                lastOperator = "*";
                clearLabel = true;
            }
        });
        btnDivide.setOnAction(e -> {
            logger.info(String.format("pressed divide, lastInput = %d, currentInput = %d", lastInput, currentInput));
            if (StringUtils.isNotEmpty(output.getText())) {
                lastInput = Integer.parseInt(output.getText());
                lastOperator = "/";
                clearLabel = true;
            }
        });
        btnPlus.setOnAction(e -> {
            logger.info(String.format("pressed plus, lastInput = %d, currentInput = %d", lastInput, currentInput));
            if (StringUtils.isNotEmpty(output.getText())) {
                lastInput = Integer.parseInt(output.getText());
                lastOperator = "+";
                clearLabel = true;
            }
        });
        btnMinus.setOnAction(e -> {
            logger.info(String.format("pressed minus, lastInput = %d, currentInput = %d", lastInput, currentInput));
            if (StringUtils.isNotEmpty(output.getText())) {
                lastInput = Integer.parseInt(output.getText());
                lastOperator = "-";
                clearLabel = true;
            }
        });
        btnEquals.setOnAction(e -> {
            logger.info(String.format("pressed equals, lastInput = %d, currentInput = %d, operator = %s, lastResult = %d ",
                    lastInput, currentInput, lastOperator, lastResult));
            if (StringUtils.isNotEmpty(output.getText())) {
                currentInput = Integer.parseInt(output.getText());
                lastResult = calculate(lastInput, currentInput, lastOperator);
                clearLabel = true;
                output.setText(String.valueOf(lastResult));
            }
        });

        vBox.getChildren().setAll(btnPlus, btnMinus, btnTimes, btnDivide, btnEquals);
        return vBox;
    }

    private static int calculate(int lInput, int cInput, String lOperator) {
        logger.info(String.format("calling calculate, lastInput = {}, currentInput = {}, lastoperator = {} ",
                new Object[]{lInput, cInput, lOperator}));
        int result = 0;
        switch (lOperator){
            case "+":
                result = lInput+cInput;
                break;
            case "-":
                result = lInput-cInput;
                break;
            case "X":
                result = lInput*cInput;
                break;
            case "/":
                result = lInput/cInput;
                break;
            default:
                break;
        }
        return result;

    }

    public static VBox displayNumber(){

        VBox vBox = new VBox(10);
        // 添加数字键
        GridPane numberSection = new GridPane();
        numberSection.setPadding(new Insets(5,5,5,5));
        numberSection.setVgap(10);
        numberSection.setHgap(10);
        Button btnNum0 = new Button("0");
        Button btnNum1 = new Button("1");
        Button btnNum2 = new Button("2");
        Button btnNum3 = new Button("3");
        Button btnNum4 = new Button("4");
        Button btnNum5 = new Button("5");
        Button btnNum6 = new Button("6");
        Button btnNum7 = new Button("7");
        Button btnNum8 = new Button("8");
        Button btnNum9 = new Button("9");

        // setting activity
        btnNum0.setOnAction(e -> {
            if (clearLabel){
                output.setText("0");
            }else{
                output.setText(output.getText()+"0");
            }
            clearLabel = false;
        });
        btnNum1.setOnAction(e -> {
            if (clearLabel){
                output.setText("1");
            }else{
                output.setText(output.getText()+"1");
            }
            clearLabel = false;
        });
        btnNum2.setOnAction(e -> {
            if (clearLabel){
                output.setText("2");
            }else{
                output.setText(output.getText()+"2");
            }
            clearLabel = false;
        });
        btnNum3.setOnAction(e -> {
            if (clearLabel){
                output.setText("3");
            }else{
                output.setText(output.getText()+"3");
            }
            clearLabel = false;
        });
        btnNum4.setOnAction(e -> {
            if (clearLabel){
                output.setText("4");
            }else{
                output.setText(output.getText()+"4");
            }
            clearLabel = false;
        });
        btnNum5.setOnAction(e -> {
            if (clearLabel){
                output.setText("5");
            }else{
                output.setText(output.getText()+"5");
            }
            clearLabel = false;
        });
        btnNum6.setOnAction(e -> {
            if (clearLabel){
                output.setText("6");
            }else{
                output.setText(output.getText()+"6");
            }
            clearLabel = false;
        });
        btnNum7.setOnAction(e -> {
            if (clearLabel){
                output.setText("7");
            }else{
                output.setText(output.getText()+"7");
            }
            clearLabel = false;
        });
        btnNum8.setOnAction(e -> {
            if (clearLabel){
                output.setText("8");
            }else{
                output.setText(output.getText()+"8");
            }
            clearLabel = false;
        });
        btnNum9.setOnAction(e -> {
            if (clearLabel){
                output.setText("9");
            }else{
                output.setText(output.getText()+"9");
            }
            clearLabel = false;
        });

        GridPane.setConstraints(btnNum1, 0,0);
        GridPane.setConstraints(btnNum2, 1,0);
        GridPane.setConstraints(btnNum3, 2,0);
        GridPane.setConstraints(btnNum4, 0,1);
        GridPane.setConstraints(btnNum5, 1,1);
        GridPane.setConstraints(btnNum6, 2,1);
        GridPane.setConstraints(btnNum7, 0,2);
        GridPane.setConstraints(btnNum8, 1,2);
        GridPane.setConstraints(btnNum9, 2,2);
        GridPane.setConstraints(btnNum0, 1,3);
        numberSection.getChildren().setAll(btnNum0,btnNum1,btnNum2,btnNum3,btnNum4,btnNum5,btnNum6,btnNum7,btnNum8,btnNum9);

//        GridPane.setHalignment(output, HPos.RIGHT);
        vBox.getChildren().setAll(output, numberSection);
//        Scene scene = new Scene(numberSection);
//        window.setScene(scene);
//        window.show();
        return vBox;
    }

}
