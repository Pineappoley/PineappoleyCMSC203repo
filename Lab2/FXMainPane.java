package GuiProject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMainPane extends VBox {
    private Button helloBtn, howdyBtn, chineseBtn, clearBtn, exitBtn;
    private Label feedbackLabel;
    private TextField textField;
    private HBox buttonBox, feedbackBox;
    private DataManager dataManager;

    public FXMainPane() {
        helloBtn = new Button("Hello");
        howdyBtn = new Button("Howdy");
        chineseBtn = new Button("Chinese");
        clearBtn = new Button("Clear");
        exitBtn = new Button("Exit");

        feedbackLabel = new Label("Feedback:");
        textField = new TextField();

        buttonBox = new HBox(10, helloBtn, howdyBtn, chineseBtn, clearBtn, exitBtn);
        feedbackBox = new HBox(10, feedbackLabel, textField);

        buttonBox.setAlignment(Pos.CENTER);
        feedbackBox.setAlignment(Pos.CENTER);

        dataManager = new DataManager();

        ButtonHandler handler = new ButtonHandler();
        helloBtn.setOnAction(handler);
        howdyBtn.setOnAction(handler);
        chineseBtn.setOnAction(handler);
        clearBtn.setOnAction(handler);
        exitBtn.setOnAction(handler);

        getChildren().addAll(buttonBox, feedbackBox);
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == helloBtn) {
                textField.setText(dataManager.getHello());
            } else if (event.getSource() == howdyBtn) {
                textField.setText(dataManager.getHowdy());
            } else if (event.getSource() == chineseBtn) {
                textField.setText(dataManager.getChinese());
            } else if (event.getSource() == clearBtn) {
                textField.setText("");
            } else if (event.getSource() == exitBtn) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}
