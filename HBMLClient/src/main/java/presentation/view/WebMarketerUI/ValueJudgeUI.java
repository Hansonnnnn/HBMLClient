package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import vo.AppealVO;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/17.
 */
public class ValueJudgeUI extends Stage{
    public ValueJudgeUI(Stage owner, AppealVO appealVO, UserVO userVO){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/ValueJudge.fxml"));
        try{
            Scene scene=new Scene(fxmlLoader.load());
            this.setScene(scene);

        }catch (IOException e) {
            e.printStackTrace();
        }
        ValueJudgeUIController valueJudgeUIController=fxmlLoader.getController();
        valueJudgeUIController.init(this,appealVO,userVO);
        initStyle(StageStyle.UNDECORATED);
        initOwner(owner);
        showAndWait();
    }
}
