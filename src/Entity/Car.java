/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import hr.Tools;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class Car implements mainData{
    private int emp_id;
    private String make;
    private String model;
    private String next_maintinance_date;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNext_maintinance_date() {
        return next_maintinance_date;
    }

    public void setNext_maintinance_date(String next_maintinance_date) {
        this.next_maintinance_date = next_maintinance_date;
    }

    @Override
    public void add() {
                String insert = "insert into emp_car values ("
                +emp_id + ","
                +"'"+make+"',"
                +"'"+model +"',"
                +"'"+next_maintinance_date+"')";
        boolean added =DB.Conn.runNonQuery(insert);
        if(added)
        {
            Tools.msgBox("Car is Added Successfully ");
        }
    }

    @Override
    public void update() {
        
        String upadate = "update emp_car set "
                +"make ='"+make+"',"
                +"model ='"+model+"', "
                +"next_maintinance_date='"+next_maintinance_date+"'"
                +" where emp_id="+emp_id;
        
        boolean updated = DB.Conn.runNonQuery(upadate);
        
        if(updated)
        {
            Tools.msgBox("Car is updated successfully ");
        }
        
    }

    @Override
    public void delete() {
       
        String delete = "delete from emp_car "
                +"where emp_id="+emp_id;
        
        boolean deleted = DB.Conn.runNonQuery(delete);
        if(deleted)
        {
            Tools.msgBox("Car is Deleted Successfully ");
        }
    }

    @Override
    public String getAutoNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllRows(JTable table) {
        
        String select = "select * from emp_car ";
                
        DB.Conn.fillTOJTable(select, table);
        
    }

    @Override
    public void getoneRow(JTable table) {
        String select = "select * from emp_car "
                +"where emp_id="+emp_id;
                
        DB.Conn.fillTOJTable(select, table);
        
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.Conn.fillTOJTable(statement, table);
    }

    @Override
    public String getNameByValue(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValueByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
