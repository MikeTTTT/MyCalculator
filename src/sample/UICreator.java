package sample;

import com.sun.istack.internal.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import utils.StringUtils;

public class UICreator<T> {
      private static final Logger logger = Logger.getLogger(UICreator.class);

//    static VBox vBox;
//    static HBox hBox;
    // 添加输出行
    public Label output = new Label();
    public long lastInput;
    public long currentInput;
    public long lastResult;
    public String lastOperator;
    public boolean clearLabel = false;
    public double buttonWidth = 40;
    public double buttonHeight = 20;



    public Label displayScreen(){
        output.setTextAlignment(TextAlignment.RIGHT);
        output.setFont(Font.font(30));
        return output;
    }

    public GridPane displayCenter(){

        // 添加数字键
        GridPane centerSection = new GridPane();
        centerSection.setPadding(new Insets(5,5,5,5));
        centerSection.setVgap(10);
        centerSection.setHgap(10);

        Button btnNumDot = new Button(".");
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

        Button btnClear = new Button("CE");
        Button btnBack = new Button("<-");
        Button btnTimes = new Button("X");
        Button btnDivide = new Button("/");
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnEquals = new Button("=");
        Button btnEmpty = new Button();


        btnClear.setPrefSize(buttonWidth,buttonHeight);
        btnBack.setPrefSize(buttonWidth,buttonHeight);
        btnEmpty.setPrefSize(buttonWidth,buttonHeight);
        btnDivide.setPrefSize(buttonWidth,buttonHeight);
        btnTimes.setPrefSize(buttonWidth,buttonHeight);
        btnMinus.setPrefSize(buttonWidth,buttonHeight);
        btnPlus.setPrefSize(buttonWidth,buttonHeight);
        btnEquals.setPrefSize(buttonWidth,buttonHeight);
        btnNumDot.setPrefSize(buttonWidth,buttonHeight);
        btnNum0.setPrefSize(buttonWidth,buttonHeight);
        btnNum1.setPrefSize(buttonWidth,buttonHeight);
        btnNum2.setPrefSize(buttonWidth,buttonHeight);
        btnNum3.setPrefSize(buttonWidth,buttonHeight);
        btnNum4.setPrefSize(buttonWidth,buttonHeight);
        btnNum5.setPrefSize(buttonWidth,buttonHeight);
        btnNum6.setPrefSize(buttonWidth,buttonHeight);
        btnNum7.setPrefSize(buttonWidth,buttonHeight);
        btnNum8.setPrefSize(buttonWidth,buttonHeight);
        btnNum9.setPrefSize(buttonWidth,buttonHeight);




        // 布局横坐标
        int i = 0;
        // 布局纵坐标
        int j = 0;
        logger.info(String.format("column = %d, row = %d", i, j));

        GridPane.setConstraints(btnClear, i, j);
        GridPane.setConstraints(btnEmpty, ++i,j);
        GridPane.setConstraints(btnBack, ++i,j);
        GridPane.setConstraints(btnDivide, ++i,j);
        // 换行
        i = 0;
        j++;
        logger.info(String.format("column = %d, row = %d", i, j));
        GridPane.setConstraints(btnNum7, i,j);
        GridPane.setConstraints(btnNum8, ++i,j);
        GridPane.setConstraints(btnNum9, ++i,j);
        GridPane.setConstraints(btnTimes, ++i,j);
        // 换行
        i = 0;
        j++;
        logger.info(String.format("column = %d, row = %d", i, j));
        GridPane.setConstraints(btnNum4, i,j);
        GridPane.setConstraints(btnNum5, ++i,j);
        GridPane.setConstraints(btnNum6, ++i,j);
        GridPane.setConstraints(btnMinus, ++i,j);
        // 换行
        i = 0;
        j++;
        logger.info(String.format("column = %d, row = %d", i, j));
        GridPane.setConstraints(btnNum1, i,j);
        GridPane.setConstraints(btnNum2, ++i,j);
        GridPane.setConstraints(btnNum3, ++i,j);
        GridPane.setConstraints(btnPlus, ++i,j);
        // 换行
        i = 1;
        j++;
        logger.info(String.format("column = %d, row = %d", i, j));
        GridPane.setConstraints(btnNum0, i,j);
        GridPane.setConstraints(btnNumDot, ++i,j);
        GridPane.setConstraints(btnEquals, ++i,j);

        centerSection.getChildren().addAll(btnClear, btnEmpty, btnBack, btnDivide, btnEquals, btnPlus, btnMinus, btnTimes,
                btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9, btnNum0, btnNumDot);

        btnBack.setOnAction(e -> {
            logger.info(String.format("pressed backspace, lastInput = %d, currentInput = %d", lastInput, currentInput));
            String temp = output.getText();
            if (StringUtils.isNotEmpty(temp)){
                if (temp.length() == 1){
                    output.setText("0");
                }else{
                    output.setText(temp.substring(0, temp.length()-1));
                }
            }
        });

        btnClear.setOnAction(e -> {
            logger.info(String.format("pressed clear, lastInput = %d, currentInput = %d", lastInput, currentInput));
            output.setText("0");
            currentInput = 0;
        });

        btnTimes.setOnAction(e -> {
            logger.info(String.format("pressed times, lastInput = %d, currentInput = %d", lastInput, currentInput));
            if (StringUtils.isNotEmpty(output.getText())) {
                lastInput = Long.parseLong(output.getText());
                lastOperator = "X";
                clearLabel = true;
            }
        });
        btnDivide.setOnAction(e -> {
            logger.info(String.format("pressed divide, lastInput = %d, currentInput = %d", lastInput, currentInput));
            if (StringUtils.isNotEmpty(output.getText())) {
                lastInput = Long.parseLong(output.getText());
                lastOperator = "/";
                clearLabel = true;
            }
        });
        btnPlus.setOnAction(e -> {
            logger.info(String.format("pressed plus, lastInput = %d, currentInput = %d", lastInput, currentInput));
            if (StringUtils.isNotEmpty(output.getText())) {
                lastInput = Long.parseLong(output.getText());
                lastOperator = "+";
                clearLabel = true;
            }
        });
        btnMinus.setOnAction(e -> {
            logger.info(String.format("pressed minus, lastInput = %d, currentInput = %d", lastInput, currentInput));
            if (StringUtils.isNotEmpty(output.getText())) {
                lastInput = Long.parseLong(output.getText());
                lastOperator = "-";
                clearLabel = true;
            }
        });
        btnEquals.setOnAction(e -> {
            logger.info(String.format("pressed equals, lastInput = %d, currentInput = %d, operator = %s, lastResult = %d ",
                    lastInput, currentInput, lastOperator, lastResult));
            if (StringUtils.isNotEmpty(output.getText())  && StringUtils.isNotEmpty(output.getText()) && StringUtils.isNotEmpty(lastOperator)) {
                clearLabel = true;
                if (output.getText().length() > 19){
                    currentInput = 0;
                    output.setText("ERROR");
                }else{
                    currentInput = Long.parseLong(output.getText());
                    lastResult = calculate(lastInput, currentInput, lastOperator);
                    output.setText(String.valueOf(lastResult));
                }
            }
        });

        // setting activity
        btnNum0.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("0");
            }else{
                output.setText(output.getText()+"0");
            }
            clearLabel = false;
        });
        btnNum1.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("1");
            }else{
                output.setText(output.getText()+"1");
            }
            clearLabel = false;
        });
        btnNum2.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("2");
            }else{
                output.setText(output.getText()+"2");
            }
            clearLabel = false;
        });
        btnNum3.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("3");
            }else{
                output.setText(output.getText()+"3");
            }
            clearLabel = false;
        });
        btnNum4.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("4");
            }else{
                output.setText(output.getText()+"4");
            }
            clearLabel = false;
        });
        btnNum5.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("5");
            }else{
                output.setText(output.getText()+"5");
            }
            clearLabel = false;
        });
        btnNum6.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("6");
            }else{
                output.setText(output.getText()+"6");
            }
            clearLabel = false;
        });
        btnNum7.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("7");
            }else{
                output.setText(output.getText()+"7");
            }
            clearLabel = false;
        });
        btnNum8.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("8");
            }else{
                output.setText(output.getText()+"8");
            }
            clearLabel = false;
        });
        btnNum9.setOnAction(e -> {
            if (clearCurrentLabel()){
                output.setText("9");
            }else{
                output.setText(output.getText()+"9");
            }
            clearLabel = false;
        });

        output.setText("0");

        return centerSection;
    }

    private  boolean clearCurrentLabel(){
        return clearLabel || (output.getText().length() == 1 && StringUtils.equalsIgnoreCases(output.getText(),"0"));
    }

    private long calculate(long lInput, long cInput, String lOperator) {
        logger.info(String.format("calling calculate, lastInput = %d, currentInput = %d, lastoperator = %s ",
                lInput, cInput, lOperator));
        long result = 0;
        switch (lOperator){
            case "+":
                result = lInput + cInput;
                break;
            case "-":
                result = lInput - cInput;
                break;
            case "X":
                result = lInput * cInput;
                break;
            case "/":
                result = lInput / cInput;
                break;
            default:
                break;
        }
        return result;

    }

}
