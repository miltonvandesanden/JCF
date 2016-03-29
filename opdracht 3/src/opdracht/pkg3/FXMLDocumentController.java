/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg3;

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
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        manager = new Opdracht3();
    }    
    public void add(ActionEvent event)
    {
        Werknemer employee;
        if(!tbName.getText().isEmpty())
        {
            employee = manager.checkEmployee(tbName.getText());
            //manager.addEmployee(tbName.getText()) 
        }
        
    }
    
}
