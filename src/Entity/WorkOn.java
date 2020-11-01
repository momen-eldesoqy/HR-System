
package Entity;

import hr.Tools;
import javax.swing.JTable;


public class WorkOn implements mainData{
    
    private int dept_id;
    private int project_id;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    @Override
    public void add() {
        
        String insert = "insert into workon values("
                +dept_id+","
                +project_id+")";
        boolean added = DB.Conn.runNonQuery(insert);
        if(added)
        {
            Tools.msgBox("Work On Is Added Successfully ");
        }
        
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        
        String delete = "delete from workon where dept_id="+dept_id+" and project_id="+project_id;
        
        boolean deleted = DB.Conn.runNonQuery(delete);
        if(deleted)
        {
            Tools.msgBox("Work On Is Deleted Successfully ");
        }
    }

    @Override
    public String getAutoNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllRows(JTable table) {
        DB.Conn.fillTOJTable("workon_data", table);
        
    }

    @Override
    public void getoneRow(JTable table) {
        String select = "select * from workon_data where Department_id="+dept_id+" and Project_id="+project_id;
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
