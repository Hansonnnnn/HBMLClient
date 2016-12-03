package presentation.view.WebMarketerUI;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * Created by LENOVO on 2016/12/3.
 */
public class RechargeCreditValueUIController {

    private VBox infoVBox;
    public void init(VBox infoVBox){
        this.infoVBox=infoVBox;
    }

    /**
     * 点击返回按钮，返回用户ID搜索界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new SearchCustomerUI(infoVBox));
    }
}
