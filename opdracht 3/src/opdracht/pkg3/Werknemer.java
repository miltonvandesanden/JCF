/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg3;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Stefan
 */

public class Werknemer {
    
    public SimpleStringProperty name;
    public SimpleStringProperty worksFor;
    
    public Werknemer(String name, String worksFor)
    {
        this.name = new SimpleStringProperty(name);
        this.worksFor = new SimpleStringProperty(worksFor);
    }
    public Werknemer(String name)
    {
        this.name = new SimpleStringProperty(name);
    }
    
    public String getName()
    {
        return name.get();
    }
    
    public void setName(String name)
    {
        this.name = new SimpleStringProperty(name);
    }
    
    public String getWorksFor()
    {
        return worksFor.get();
    }
    
    public void setWorksFor(String worksFor)
    {
        this.worksFor = new SimpleStringProperty(worksFor);
    }
    
    @Override
    public String toString()
    {
        return name + " - " + worksFor;
    }
}
