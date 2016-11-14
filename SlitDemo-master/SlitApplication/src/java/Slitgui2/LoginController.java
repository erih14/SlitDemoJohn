/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slitgui2;

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
public class LoginController implements Initializable {

    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField UserNameTextField;
    @FXML
    private Label InfoTextLabel;
    
    UserManager user = new UserManager(); 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickLoginButton(ActionEvent event) {
        if(!this.passwordTextField.getText().isEmpty() && !this.UserNameTextField.getText().isEmpty())
        {            
            UsersDataModel userModule = user.loginUser(this.UserNameTextField.getText(), this.passwordTextField.getText());
            
            if(userModule.getMail() != null)
            {
                this.InfoTextLabel.setText("Login successfull");
                
                try 
                {
                    JavaFXApplication4.getInstance().setScene("Main");
                }
                catch(Exception e) 
                {
                     this.InfoTextLabel.setText(e.getMessage()); 
                }
                
            }
            else 
            {
                this.InfoTextLabel.setText("Username or password is irrcorect.");
            }
            
        }
        else 
        {
            this.InfoTextLabel.setText("Password or username cannot be null");
        }
        
    }
    
}
