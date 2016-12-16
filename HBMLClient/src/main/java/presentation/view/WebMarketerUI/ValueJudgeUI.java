package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/17.
 */
public class ValueJudgeUI extends Stage{
    public ValueJudgeUI(Stage owner){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/ValueJudge.fxml"));
        try{
            Scene scene=new Scene(fxmlLoader.load());
            this.setScene(scene);

        }catch (IOException e) {
            e.printStackTrace();
        }
        ValueJudgeUIController valueJudgeUIController=fxmlLoader.getController();
        valueJudgeUIController.init(this);
        initStyle(StageStyle.UNDECORATED);
        initOwner(owner);
        showAndWait();
    }
}
