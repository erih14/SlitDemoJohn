/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slitgui2;

import Names.ViewNames;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Dahl
 */
public class JavaFXApplication4 extends Application {
    
    private Stage stage; 
    
    private static JavaFXApplication4 instance; 
    
    private HashMap<String, String> views = new HashMap<String, String>()
    {
        {
            put(ViewNames.loginView, "Login.fxml");
            put(ViewNames.mainView, "Main.fxml"); 
        }
        
    }; 
    
    public JavaFXApplication4() 
    {
        instance = this;
    }
    
    public static JavaFXApplication4 getInstance() 
    {
        return instance; 
    }
    
    @Override
    public void start(Stage primaryStage) {
        try 
        {
            this.stage = primaryStage; 
            //this.setScene(ViewNames.loginView);
            this.setScene(ViewNames.mainView);

            this.stage.show();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param value
     * @throws Exception 
     */
    public void setScene(String value) throws Exception
    {
        if(this.views.containsKey(value))
        {
            this.replaceSceneContent(this.views.get(value)); 
        }
        else 
            throw new Exception("Value does not exist"); 
    }
    
    /**
     * Base on : http://stackoverflow.com/questions/13003323/javafx-how-to-change-stage
     * @param fxml
     * @return
     * @throws Exception 
     */
    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(JavaFXApplication4.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            //scene.getStylesheets().add(SlitGUI.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
