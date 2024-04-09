package GuiProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class FXDriver extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMainPane root = new FXMainPane();
        stage.setScene(new Scene(root, 500, 300));
        stage.setTitle("Hello World GUI");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);   
    }
}
