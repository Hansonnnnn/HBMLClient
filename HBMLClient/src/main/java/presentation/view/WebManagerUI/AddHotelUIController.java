package presentation.view.WebManagerUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class AddHotelUIController {

    @FXML private Button starButton1;
    @FXML private Button starButton2;
    @FXML private Button starButton3;
    @FXML private Button starButton4;
    @FXML private Button starButton5;
    @FXML private ImageView starImageView1;
    @FXML private ImageView starImageView2;
    @FXML private ImageView starImageView3;
    @FXML private ImageView starImageView4;
    @FXML private ImageView starImageView5;


    private ArrayList<ImageView> imageViews;
    private Image starImage=new Image(getClass().getResourceAsStream("webmanagerimages/star.png"));
    private Image blueStarImage=new Image(getClass().getResourceAsStream("webmanagerimages/bluestar.png"));

    public void init(){
        initstar();
    }

    private void initstar(){
        imageViews=new ArrayList<>();
        imageViews.add(starImageView1);
        imageViews.add(starImageView2);
        imageViews.add(starImageView3);
        imageViews.add(starImageView4);
        imageViews.add(starImageView5);

        starButton1.setOnAction((ActionEvent e)->{
            for(int j=0;j<=0;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=0+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton2.setOnAction((ActionEvent e)->{
            for(int j=0;j<=1;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=1+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton3.setOnAction((ActionEvent e)->{
            for(int j=0;j<=2;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=2+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton4.setOnAction((ActionEvent e)->{
            for(int j=0;j<=3;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=3+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton5.setOnAction((ActionEvent e)->{
            for(int j=0;j<=4;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=4+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
    }
}


