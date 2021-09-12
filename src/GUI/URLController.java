package GUI;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class URLController {

    public Button button;
    public Label label;
    public AnchorPane anchor;
    public TextField field;

    public String midiUrl;

    public void initialize(){

    }

    public void browse(ActionEvent actionEvent) {

        final FileChooser fChooser = new FileChooser();
        fChooser.setTitle("Choose MIDI file");
        fChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("MIDI Files", "*.mid"));

        Stage stage = (Stage) anchor.getScene().getWindow();

        File file = fChooser.showOpenDialog(stage);

        if(file != null){
            midiUrl = file.getAbsolutePath();
            field.setText(midiUrl);
            Main.transition();
        }
    }
}
