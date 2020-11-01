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
public class Department implements mainData{
    private int dept_id ;
    private String dept_name;
    private String dept_desc;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_desc() {
        return dept_desc;
    }

    public void setDept_desc(String dept_desc) {
        this.dept_desc = dept_desc;
    }

    @Override
    public void add() {
        
        String insert = "insert into department values ("
                +dept_id + ","
                +"'"+dept_name+"',"
                +"'"+dept_desc +"')";
        boolean added =DB.Conn.runNonQuery(insert);
        if(added)
        {
            Tools.msgBox("Department is Added Successfully ");
        }
    }

    @Override
    public void update() {
        
        String upadate = "update department set "
                +"dept_name ='"+dept_name+"',"
                +"dept_desc ='"+dept_desc+"' "
                +" where dept_id="+dept_id;
        
        boolean updated = DB.Conn.runNonQuery(upadate);
        
        if(updated)
        {
            Tools.msgBox("Department is updated successfully ");
        }
        
    }

    @Override
    public void delete() {
        
        String delete = "delete from department "
                +"where dept_id="+dept_id;
        
        boolean deleted = DB.Conn.runNonQuery(delete);
        if(deleted)
        {
            Tools.msgBox("Department is Deleted Successfully ");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.Conn.getAutoNumber("department", "dept_id");
        
    }

    @Override
    public void getAllRows(JTable table) {
        
        DB.Conn.fillTOJTable("department_data", table);
    }

    @Override
    public void getoneRow(JTable table) {
        String select = "select * from department_data "
                +"where ID="+dept_id;
        
        DB.Conn.fillTOJTable(select, table);
        
        
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.Conn.fillTOJTable(statement, table);
    }

    @Override
    public String getNameByValue(String value) {
        String select = "select dept_name from department "
                +"where dept_id="+value;
        String val = (String)DB.Conn.getTableData(select).Items[0][0];
        return val;
    }

    @Override
    public String getValueByName(String name) {
        String select = "select dept_id from department "
                +"where dept_name='"+name+"'";
        String val = (String)DB.Conn.getTableData(select).Items[0][0];
        return val;
    }
    
    
    
}
