package presentation.view.WebMarketerUI;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/12/17.
 */
public class ValueJudgeUIController {

    @FXML private CheckBox wholeCheckBox;
    @FXML private CheckBox halfCheckBox;

    private Stage stage;
    private double xOffset;
    private double yOffset;
    public void init(Stage stage){
        this.stage=stage;
        drag();
    }

    /**
     * 点击确认按钮，关闭对话框
     */
    @FXML
    private void confirm(){
        stage.close();
    }

    /**
     * 点击关闭按钮，关闭对话框
     */
    @FXML
    private void cancel(){
        stage.close();
    }

    /**
     * 选择恢复信用值一半选择框
     */
    @FXML
    private void half(){
        wholeCheckBox.setSelected(false);
    }

    /**
     * 选择恢复信用值全部选择框
     */
    @FXML
    private void whole(){
        halfCheckBox.setSelected(false);
    }



    /**
     * 使对话框可拖动
     */
    private void drag(){
        stage.getScene().setOnMousePressed((MouseEvent event) -> {
            event.consume();
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        stage.getScene().setOnMouseDragged((MouseEvent event)->{
            event.consume();
            stage.setX(event.getScreenX()-xOffset);
            stage.setY(event.getScreenY()-yOffset);
        });

    }
}
