package presentation.view.customerui.customerui;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import businesslogicservice.orderblservice.OrderCustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import vo.CommentInfoVO;
import vo.OrderVO;

public class CommentSubmitPageController 
{
		@FXML private Button backButton;
		@FXML private Button submitButton;
		@FXML private TextArea commentArea;
		@FXML private Button submitImageButton;
		@FXML private ImageView imageView;
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
		
		private Image starImage = new Image(getClass().getResourceAsStream("../CustomerImage/star.png"));
		private Image blueStarImage = new Image(getClass().getResourceAsStream("../CustomerImage/bluestar.png"));
		private Stage stage;
		private Scene preScene;
		
		private Desktop desktop;
		private FileChooser fileChooser;
		private OrderVO orderVO;
		private File choiceFile;
		private int star;
		private HotelCustomerService customerService;
		
		public void init(Stage stage, Scene preScene, OrderVO orderVO)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.orderVO = orderVO;
			customerService = new HotelCustomerImpl();
			initstar();
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		
		@FXML
		private void submitImage()
		{
			desktop = Desktop.getDesktop();
			fileChooser = new FileChooser();
			choiceFile = fileChooser.showOpenDialog(stage);
			fileChooser.setTitle("选择头像");
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("JPG","*.JPG"),
					new FileChooser.ExtensionFilter("PNG","*PNG")
					);
			if (choiceFile!=null) 
			{
				 try{
		                String path="/Users/xiezhenyu/Desktop/Pic";
		                String fileName=path+choiceFile.getName().toString();
		                System.out.println(choiceFile.getName().toString());
		                File file=new File(fileName);
		                if(!file.exists()){
		                    File newfile=new File(path);
		                    newfile.mkdirs();
		                    FileInputStream input=new FileInputStream(choiceFile);
		                    FileOutputStream output=new FileOutputStream(fileName);

		                    byte[] b=new byte[1824*5];
		                    int length;
		                    while((length=input.read(b))!=-1){
		                        output.write(b,0,length);
		                    }

		                    output.flush();
		                    output.close();
		                    input.close();
		                }
		                Image image=new Image("file:///"+fileName);
		                imageView.setImage(image);

		            }catch (Exception e){
		                e.printStackTrace();
		            }
			}

		}
		
		@FXML
		private void submitAll()
		{
			String content = "";
			if(commentArea.getText()!=null&&!commentArea.getText().isEmpty())
			{
				content = commentArea.getText();
			}
			
			CommentInfoVO commentInfoVO = new CommentInfoVO(0, orderVO.getCheckinTime(), orderVO.getHotelID(),star, content, choiceFile, null, null,orderVO.getOrderID());
			customerService.addComment(commentInfoVO);
		}
		
		private void initstar() {
	        imageViews = new ArrayList<>();
	        imageViews.add(starImageView1);
	        imageViews.add(starImageView2);
	        imageViews.add(starImageView3);
	        imageViews.add(starImageView4);
	        imageViews.add(starImageView5);

	        starButton1.setOnAction((ActionEvent e) -> {
	            star = 1;
	            for (int j = 0; j <= 0; j++) {
	                imageViews.get(j).setImage(blueStarImage);
	            }
	            for (int k = 0 + 1; k < imageViews.size(); k++) {
	                imageViews.get(k).setImage(starImage);
	            }
	        });
	        starButton2.setOnAction((ActionEvent e) -> {
	            star = 2;
	            for (int j = 0; j <= 1; j++) {
	                imageViews.get(j).setImage(blueStarImage);
	            }
	            for (int k = 1 + 1; k < imageViews.size(); k++) {
	                imageViews.get(k).setImage(starImage);
	            }
	        });
	        starButton3.setOnAction((ActionEvent e) -> {
	            star = 3;
	            for (int j = 0; j <= 2; j++) {
	                imageViews.get(j).setImage(blueStarImage);
	            }
	            for (int k = 2 + 1; k < imageViews.size(); k++) {
	                imageViews.get(k).setImage(starImage);
	            }
	        });
	        starButton4.setOnAction((ActionEvent e) -> {
	            star = 4;
	            for (int j = 0; j <= 3; j++) {
	                imageViews.get(j).setImage(blueStarImage);
	            }
	            for (int k = 3 + 1; k < imageViews.size(); k++) {
	                imageViews.get(k).setImage(starImage);
	            }
	        });
	        starButton5.setOnAction((ActionEvent e) -> {
	            star = 5;
	            for (int j = 0; j <= 4; j++) {
	                imageViews.get(j).setImage(blueStarImage);
	            }
	            for (int k = 4 + 1; k < imageViews.size(); k++) {
	                imageViews.get(k).setImage(starImage);
	            }
	        });
	    }
}
