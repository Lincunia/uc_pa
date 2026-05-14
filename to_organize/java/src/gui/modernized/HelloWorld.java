package gui.modernized;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    public void start(Stage arg0) throws Exception
    {
        Button btn = new Button();
        btn.setText("Please don't say you're lazy");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0)
            {
                System.out.println("I love to hate you!!");
            };
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 300);
        arg0.setTitle("kjasdfa");
        arg0.setScene(scene);
        arg0.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
