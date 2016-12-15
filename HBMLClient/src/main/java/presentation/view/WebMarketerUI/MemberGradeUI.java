package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/12.
 */
public class MemberGradeUI extends VBox{
    public MemberGradeUI(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/MemberGrade.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        MemberGradeUIController memberGradeUIController=fxmlLoader.getController();
        memberGradeUIController.init();
    }
}
