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
public class Employee implements mainData{
    
    private int emp_id;
    private String emp_name;
    private double salary;
    private String DOB;
    private String position;
    private int dept_id;
    private int pass;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
    public int getpass() {
        return pass;
    }

    public void setpass(int pass) {
        this.pass = pass;
    }

    @Override
    public void add() {
       
        String insert = "insert into employee values("
                +emp_id+" , "
                +"'"+emp_name+"',"
                +salary+","
                +"'"+DOB+"',"
                +"'"+position+"',"
                +dept_id+")";
        
        String insert2 = "insert into users values("
                +"'"+emp_name+"',"
                +"'"+pass+"')";
        
     
        boolean added = DB.Conn.runNonQuery(insert);
        if(added)
        {
            Tools.msgBox("Employee Is Added Successfully ");
            DB.Conn.runNonQuery(insert2);
        }
       
        
    }

    @Override
    public void update() {
        
        String update = "update employee set "
                +"emp_name='"+emp_name+"',"
                +"salary="+salary+" ,"
                +"DOB='"+DOB+"',"
                +"position='"+position+"',"
                +"dept_id="+dept_id
                +" where emp_id="+emp_id;
        
        boolean updated = DB.Conn.runNonQuery(update);
        
        if(updated)
        {
            Tools.msgBox("Employee is updated successfully ");
        }
        
        
        
    }

    @Override
    public void delete() {
        
        String delete = "delete from employee "
                +"where emp_id="+emp_id;
        boolean deleted = DB.Conn.runNonQuery(delete);
        if(deleted)
        {
            Tools.msgBox("Employee is deleted successfully ");
        }
        
        
    }

    @Override
    public String getAutoNumber() {
        
        return DB.Conn.getAutoNumber("employee", "emp_id");
        
        
        
    }

    @Override
    public void getAllRows(JTable table) {
         
        DB.Conn.fillTOJTable("emp_data", table);
        
        
    }

    @Override
    public void getoneRow(JTable table) {
        
        String select = "select * from emp_data "
                +"where ID="+emp_id;
        
        DB.Conn.fillTOJTable(select, table);
        
        
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        
        DB.Conn.fillTOJTable(statement, table);
    }

    @Override
    public String getNameByValue(String value) {
        String select = "select emp_name from employee "
                +"where emp_id="+emp_id;
        
        String val = DB.Conn.getTableData(select).Items[0][0].toString();
        return val;
    }

    @Override
    public String getValueByName(String name) {
        
        String select = "select emp_id from employee "
                +"where emp_name='"+emp_name+"'";
        
        String val = DB.Conn.getTableData(select).Items[0][0].toString();
        return val;
        
    }
    
}
