package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    @FXML
    Button browseBtn;

    @FXML
    Button convertBtn;

    @FXML
    Label pathLabel;

    @FXML
    TextField designatorNumberInput;


    ParseNetlist parseNetlist;


    public void initialize(){
        pathLabel.setVisible(false);
        parseNetlist=new ParseNetlist();
        System.out.println("initialize");
    }


    public void browseBtnPressed(){

        System.out.println("btn pressed");
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
pathLabel.setVisible(true);
pathLabel.setText(selectedFile.toString());
        //path to text file
            parseNetlist.setPathToNetllist(selectedFile.getPath());
            //     actionStatus.setText("File selected: " + selectedFile.getName());
        }
        else {
         //   actionStatus.setText("File selection cancelled.");
        }
    }

public void convertBtnPressed(){
    parseNetlist.convertNetlist(designatorNumberInput.getText()); //send designator string to convertNetlist method
}

}
