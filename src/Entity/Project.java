
package Entity;

import hr.Tools;
import javax.swing.JTable;


public class Project implements mainData{
    private int project_id;
    private String project_name;
    private String project_desc;
    private int dept_id;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public void add() {
        String insert ="insert into project values("
                +project_id+","
                +"'"+project_name+"',"
                +"'"+project_desc+"',"
                +dept_id+")";
        boolean added = DB.Conn.runNonQuery(insert);
        if(added)
        {
            Tools.msgBox("Project Is Added Successfully ");
        }
        
    }

    @Override
    public void update() {
       
        String update = "update project set "
                +"project_name='"+project_name+"',"
                +"project_desc='"+project_desc+"',"
                +"dept_id="+dept_id
                +" where project_id="+project_id;
        
            boolean updated = DB.Conn.runNonQuery(update);
            
            if(updated)
            {
                Tools.msgBox("Project is updated Successfully ");
            }
        
        
    }

    @Override
    public void delete() {
        
        String delete = "delete from project "
                +"where project_id="+project_id;
        
        boolean deleted = DB.Conn.runNonQuery(delete);
        if(deleted)
        {
            Tools.msgBox("Project is deleted Successfully ");
        }
        
        
        
        
    }

    @Override
    public String getAutoNumber() {
       
        return DB.Conn.getAutoNumber("project", "project_id");
        
    }

    @Override
    public void getAllRows(JTable table) {
        
        DB.Conn.fillTOJTable("project_data", table);
        
        
    }

    @Override
    public void getoneRow(JTable table) {
        
        String select = "select * from project_data "
                +"where ID="+project_id;
        
        DB.Conn.fillTOJTable(select, table);
        
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        
        DB.Conn.fillTOJTable(statement, table);
        
    }

    @Override
    public String getNameByValue(String value) {
       
                String select = "select project_name from project "
                +"where project_id="+value;
        
        String val = (String) DB.Conn.getTableData(select).Items[0][0];
        
        return val;
        
    }

    @Override
    public String getValueByName(String name) {
        
        String select = "select project_id from project "
                +"where project_name='"+name+"'";
        
        String val = (String) DB.Conn.getTableData(select).Items[0][0];
        
        return val;
        
    }
    
}
