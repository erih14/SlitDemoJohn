/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitgui;

import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dahl
 */
public class SlitGUI extends Application {
    
    private Stage stage; 
    
    private static SlitGUI instance; 
    
    private HashMap<String, String> views = new HashMap<String, String>()
    {
        {
            put("Main" , "FXMLDocument.fxml");
            put("Login", "LoginFXML.fxml"); 
        }
        
    }; 
    
    public SlitGUI() 
    {
        instance = this;
    }
    
    public static SlitGUI getInstance() 
    {
        return instance; 
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        try 
        {
            this.stage = stage; 
            this.setScene("Login");
            this.stage.show();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        /*Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);

        stage.show();*/
    }
    
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
        Parent page = (Parent) FXMLLoader.load(SlitGUI.class.getResource(fxml), null, new JavaFXBuilderFactory());
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
