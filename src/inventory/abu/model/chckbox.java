/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.abu.model;

import javax.swing.JTable;

/**
 *
 * @author Abu Khoerul I A
 */
public class chckbox extends JTable{
    @Override
    public Class getColumnClass(int column){
        switch(column){
            case 0 :
                return String.class;
            case 1 :
                return String.class;
            case 2 :
                return String.class;
            case 3 :
                return String.class;
            case 4 :
                return boolean.class;
            default:
                return String.class;
        }
           
    }
    
}
