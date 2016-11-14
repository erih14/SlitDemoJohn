/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slitgui2;

import DataModel.UsersDataModel;
import Framework.UserManager;
import Names.ViewNames;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dahl
 */
public class MainController implements Initializable {

    @FXML
    private Button ExitButton;
    @FXML
    private ListView<String> MainListView;

  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserManager manager = new UserManager();
              
        ObservableList<String> items =FXCollections.observableArrayList (); 
        
        for(UsersDataModel user : manager.getAllUsers())
        {
            items.add(user.getMail()); 
        }
        
        this.MainListView.setItems(items);
    }    

    @FXML
    private void onClickExitButton(ActionEvent event) throws Exception{
        JavaFXApplication4.getInstance().setScene(ViewNames.loginView);
    }

    
}
