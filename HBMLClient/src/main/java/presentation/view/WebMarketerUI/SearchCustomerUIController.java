package presentation.view.WebMarketerUI;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * Created by LENOVO on 2016/12/3.
 */
public class SearchCustomerUIController {
    private VBox infoVBox;
    private VBox thisVBox;

    public void init(VBox infoVBox,VBox thisVBox){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
    }

    /**
     * 点击搜索按钮
     */
    @FXML
    private void toRechargeCreditValue(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new RechargeCreditValueUI(infoVBox));
    }
}
