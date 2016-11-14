/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.UsersDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dahl
 */
@Remote
public interface UsersModuleSessionRemote {
    
    UsersDataModel getUserFromId(int id); 
    
    UsersDataModel loginUser(String userName, String password); 
    
    List<UsersDataModel> getAllUsers();
    
}
