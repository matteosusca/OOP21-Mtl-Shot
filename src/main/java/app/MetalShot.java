package app;

import controller.TemporaryController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public final class MetalShot extends Application {
	private TemporaryController controller;
	
    @Override
    public void start(final Stage primaryStage) throws Exception {
        
        this.controller = new TemporaryController(this);
        
        var g = new Group();
        
        var s = new Scene(g);
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
        	
			@Override
			public void handle(KeyEvent event) {
				controller.keyPressed(event.getCode());
			}
			
        });
        
        primaryStage.setFullScreen(true);
        primaryStage.setScene(s);
        primaryStage.setTitle("Hello");
        primaryStage.show();
        
        this.controller.gameStart();
    }

    public static void run(final String... args) {
        launch();
    }

    public static final class Main {
        private Main() {
            // the constructor will never be called directly.
        }

        public static void main(final String...args) {
            Application.launch(MetalShot.class, args);
        }
    }
}
