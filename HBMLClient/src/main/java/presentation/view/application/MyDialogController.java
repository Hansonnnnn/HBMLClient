package presentation.view.application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/12/16.
 */
public class MyDialogController {
    @FXML private ImageView dialogImageView;
    @FXML private Label contentLabel;

    private Stage stage;
    private double xOffset;
    private double yOffset;
//    private String content;
//    private int myDialogType;
    private Image errorImage=new Image(getClass().getResourceAsStream("loginimages/warning.png"));
    private Image warningImage=new Image(getClass().getResourceAsStream("loginimages/warning2.png"));
    private Image smileImage=new Image(getClass().getResourceAsStream("loginimages/smile.png"));
    public void init(Stage stage, String content, int myDialogType){
        this.stage=stage;
        if(myDialogType==0){
            dialogImageView.setImage(warningImage);
        }else if(myDialogType==1){
            dialogImageView.setImage(errorImage);
        }else if(myDialogType==2){
            dialogImageView.setImage(smileImage);
        }
        contentLabel.setText(content);
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
