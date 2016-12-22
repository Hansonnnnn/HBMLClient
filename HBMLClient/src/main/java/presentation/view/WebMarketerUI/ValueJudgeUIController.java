package presentation.view.WebMarketerUI;

import businesslogic.creditbl.CreditWebMarketerImpl;
import businesslogic.orderbl.OrderWebMarketerServiceImpl;
import businesslogicservice.creditblservice.CreditWebMarketerService;
import businesslogicservice.orderblservice.OrderWebMarketerService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import message.AppealStateMessage;
import vo.AppealVO;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/12/17.
 */
public class ValueJudgeUIController {

    @FXML private CheckBox wholeCheckBox;
    @FXML private CheckBox halfCheckBox;
    @FXML private VBox firstVBox;
    @FXML private VBox secondVBox;
    @FXML private TextArea contentTextArea;

    private Stage stage;
    private double xOffset;
    private double yOffset;
    private AppealVO appealVO;
    private UserVO userVO;
    private OrderWebMarketerService orderWebMarketerService;
    private CreditWebMarketerService creditWebMarketerService;
    public void init(Stage stage, AppealVO appealVO, UserVO userVO){
        this.stage=stage;
        this.appealVO=appealVO;
        this.userVO=userVO;
        orderWebMarketerService=new OrderWebMarketerServiceImpl();
        creditWebMarketerService=new CreditWebMarketerImpl();
        contentTextArea.setText(appealVO.getContent());
        drag();
    }

    /**
     * 点击合理按钮，弹出选择框
     */
    @FXML
    private void reason(){
        firstVBox.setDisable(true);
        secondVBox.setVisible(true);
    }

    /**
     * 点击不合理按钮，管理对话框
     */
    @FXML
    private void noreason(){
        AppealVO newAppealVO=new AppealVO(appealVO.getAppealID(),appealVO.getOrderID(),appealVO.getUserID(),
                userVO.getUserID(),appealVO.getAppealTime(),appealVO.getContent(), AppealStateMessage.Failure,appealVO.getPrice());
        orderWebMarketerService.modifyAppealOrder(newAppealVO);
        stage.close();
    }

    /**
     * 点击确认按钮，关闭对话框
     */
    @FXML
    private void confirm(){
        if(halfCheckBox.isSelected()){
            AppealVO newAppealVO=new AppealVO(appealVO.getAppealID(),appealVO.getOrderID(),appealVO.getUserID(),
                    userVO.getUserID(),appealVO.getAppealTime(),appealVO.getContent(), AppealStateMessage.Success,appealVO.getPrice());
            orderWebMarketerService.modifyAppealOrder(newAppealVO);
            creditWebMarketerService.resumeCreditValue(appealVO.getUserID(),appealVO.getPrice(),0,appealVO.getOrderID());
            stage.close();
        }else if(wholeCheckBox.isSelected()){
            AppealVO newAppealVO=new AppealVO(appealVO.getAppealID(),appealVO.getOrderID(),appealVO.getUserID(),
                    userVO.getUserID(),appealVO.getAppealTime(),appealVO.getContent(), AppealStateMessage.Success,appealVO.getPrice());
            orderWebMarketerService.modifyAppealOrder(newAppealVO);
            creditWebMarketerService.resumeCreditValue(appealVO.getUserID(),appealVO.getPrice(),1,appealVO.getOrderID());
            stage.close();
        }
    }

    /**
     * 点击关闭按钮，关闭对话框
     */
    @FXML
    private void cancel(){
        secondVBox.setVisible(false);
        firstVBox.setDisable(false);
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
