/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg3;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.*;

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
    private TableColumn cName;
    @FXML
    private TableColumn cWorksFor;
     
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        manager = new Opdracht3();
        cName.setCellValueFactory(new PropertyValueFactory<Werknemer, String>("name"));
        cWorksFor.setCellValueFactory(new PropertyValueFactory<Werknemer, String>("worksFor"));
    }    
    public void add(ActionEvent event)
    {
        if(!tbName.getText().isEmpty())
        {
            if(tbWorksFor.getText().isEmpty())
            {
                update(manager.checkEmployee(tbName.getText(), ""));
            }
            else
            {
                update(manager.checkEmployee(tbName.getText(), tbWorksFor.getText()));
            }
        }
    }
    
    public void update(ObservableList<Werknemer> employees)
    {
        
        //tvEmployees.getColumns().clear();
        //tvEmployees.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        tvEmployees.setItems(employees);
//        TreeItem<String> rootNode;
                
//        for(Werknemer employee : employees)
//        {
//            TreeItem<String> node = new TreeItem<>(employee.toString());
//            
//            
////            if(employee.getWorksFor().isEmpty())
////            {
////                 rootNode = new TreeItem<String>(employee.toString());
////            }
////            if(employee.getWorksFor().equals())
////            {
////                
////            }
//        }
    }
}
