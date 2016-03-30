/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg3;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;

/**
 *
 * @author Stefan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField tbName;
    @FXML
    private TextField tbWorksFor;
    @FXML
    private Button btnAccept;
    @FXML 
    private TreeView trvEmployees;
    @FXML 
    private TableView tvEmployees;
    Opdracht3 manager;
     
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        manager = new Opdracht3();
    }    
    public void add(ActionEvent event)
    {
//        try
//        {
            if(!tbName.getText().isEmpty())
            {
                System.out.println("You clicked me!");
                if(tbWorksFor.getText().isEmpty())
                {
                    manager.checkEmployee(tbName.getText(), "");
                }
                else
                {
                    manager.checkEmployee(tbName.getText(), tbWorksFor.getText());
                }
            }
            
//        }
//        catch(InvocationTargetException ex)
//        {
//            System.err.println("An InvocationTargetException was caught!");
//            Throwable cause = ex.getCause();
//            
//        }
        
    }
}
