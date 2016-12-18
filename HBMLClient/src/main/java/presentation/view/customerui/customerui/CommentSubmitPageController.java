package presentation.view.customerui.customerui;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CommentSubmitPageController 
{
		@FXML private Button backButton;
		@FXML private Button submitButton;
		@FXML private TextArea commentArea;
		@FXML private Button submitImageButton;
		@FXML private ImageView imageView;
		
		
		private Stage stage;
		private Scene preScene;
		
		private Desktop desktop;
		private FileChooser fileChooser;
		
		public void init(Stage stage, Scene preScene)
		{
			this.stage = stage;
			this.preScene = preScene;
		}
		
		@FXML
		private void submitImage()
		{
			
		}
		
		@FXML
		private void submitAll()
		{
			desktop = Desktop.getDesktop();
			fileChooser = new FileChooser();
			java.io.File choiceFile = fileChooser.showOpenDialog(stage);
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
}
