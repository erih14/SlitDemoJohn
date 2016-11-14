/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitgui;

import DataModel.UsersDataModel;
import Framework.UserManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dahl
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField UserNameTextField;
    @FXML
    private PasswordField passwordTextField;

    UserManager userManager = new UserManager(); 
    @FXML
    private Label InfoFieldLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logonButton(ActionEvent event) 
    {
        if(!this.UserNameTextField.getText().isEmpty() && !this.passwordTextField.getText().isEmpty())
        {
             UsersDataModel user = userManager.loginUser(this.UserNameTextField.getText(), this.passwordTextField.getText());
             
             if(user.getMail() != null)
             {
                 this.InfoFieldLabel.setText("Login successfull");
                 
                 try 
                 {
                     SlitGUI.getInstance().setScene("Main");
                 }
                 catch(Exception e)
                 {
                      this.InfoFieldLabel.setText(e.getMessage());
                 }
             }
             else
             {
                 this.InfoFieldLabel.setText("Wrong mail or password.");
             }
        }
        else 
        {
            this.InfoFieldLabel.setText("Username or password is not set");
        }
       
    }
    
}
