
package Entity;

import javax.swing.JTable;


public interface mainData {
    public void add();
    public void update();
    public void delete();
    public String getAutoNumber();
    public void getAllRows(JTable table);
    public void getoneRow(JTable table);
    public void getCustomRows(String statement , JTable table);

    public String getNameByValue(String value);
    public String getValueByName(String name);
    
    
    

}
