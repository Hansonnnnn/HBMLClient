package presentation.view.WebMarketerUI;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * Created by LENOVO on 2016/12/5.
 */
public class AddWebPromotionUIController {
    private VBox infoVBox;
    private VBox beforeVBox;
    public void init(VBox infoVBox,VBox beforeVBox){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
    }

    /**
     * 点击返回按钮，跳转至上个界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().addAll(beforeVBox);
    }
}
