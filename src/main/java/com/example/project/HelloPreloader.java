/*
       This class works on the preloader bar
       and allows the preloading scene to wait for
       certain amount of time until the game starts.
       when you run the hello preloader by itself it won't open the game.
 */

// Imported packages
package com.example.project;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloPreloader extends Preloader {
    //ProgressBar bar;
    private Stage preloaderStage;
    private Scene scene;

    @Override
    public void init() throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        scene = new Scene(root1);
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.preloaderStage = stage;
        //Set preloader scene and show stage
        preloaderStage.setScene(scene);
        preloaderStage.initStyle(StageStyle.DECORATED);
        preloaderStage.show();
    }

    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification info) {
        //bar.setProgress(pn.getProgress());
        if(info instanceof ProgressNotification){

            HelloController.label.setText(" Game Loading....."+((ProgressNotification)info).getProgress()*100 + "%");

            HelloController.label.setText("Loading..."+((ProgressNotification)info).getProgress()*100 + "%");

            System.out.println("Value@ :"+ (((ProgressNotification) info).getProgress()));
            HelloController.statProgressBar.setProgress(((ProgressNotification)info).getProgress());

        }
    }

    @Override
    public void handleStateChangeNotification(Preloader.StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
            preloaderStage.hide();
        }
    }
}