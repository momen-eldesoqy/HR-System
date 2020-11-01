
package DB;
import hr.Tools;
import hr.Tools.Table;
import java.sql.*;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Conn {
    private static String url="";
    private static Connection conn;
    
    private static void seturl()
    {
        url = "jdbc:mysql://localhost/mydb";
        
    }
    private static void setconnection()
    {
        seturl();
        try{
            conn = DriverManager.getConnection(url,"root","");
            
            
        }catch(Exception e)
        {
            Tools.msgBox(e.getMessage());
        }
        
    }
    public static boolean checkuserandpass(String username , String pass)
    {
        try
        {
            setconnection();
            Statement st = conn.createStatement();
            String sql = "select * from users where "+"username='"+username+"' and "+ "pass='"+pass+"'";
            st.executeQuery(sql);
            while(st.getResultSet().next())
            {
                return true;
            }
            conn.close();
        }catch(Exception e)
        {
            Tools.msgBox(e.getMessage());
        }
        return false;
    }
    
    public static boolean runNonQuery(String sql )
    {
        try
        {
            setconnection();
            Statement st = conn.createStatement();
            st.execute(sql);
            conn.close();
            return true;
            
        }catch(Exception e)
        {
           
            return false;
        }
    }
     public static String getAutoNumber(String tableName , String columnName)
     {
         try
         {
             setconnection();
             Statement st = conn.createStatement();
             String sql = "select max("+columnName+")+1 as autoNum "
                     +"from "+tableName;
             st.executeQuery(sql);
             String num = "";
             while(st.getResultSet().next())
             {
                 num = st.getResultSet().getString("autoNum");
                 
             }
             conn.close();
             if(num == null || "".equals(num))
             {
                 return "1";
             }else
             {
                 return num;
             }
             
         }catch(Exception e)
         {
             Tools.msgBox(e.getMessage());
             return "0";
         }
     }
     public static Table getTableData(String sql)
     {
         Tools t = new Tools();
         try
         {
             setconnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             Table table = t.new Table(c);
             
             while(rs.next())
             {
                 Object row[] = new Object[c];
                 for(int i=0;i<c;i++)
                 {
                     row[i] = rs.getString(i+1);
                 }
                 table.addNewRow(row);
             }
             conn.close();
             return table;
             
             
         }catch(Exception e)
         {
             Tools.msgBox(e.getMessage());
             return t.new Table(0);
         }
     }
     public static void fillComboBox(String tableName , String columnName , JComboBox combo)
     {
         try
         {
             setconnection();
             Statement st = conn.createStatement();
             ResultSet rs ;
             String sql = " select "+columnName+" from "+tableName;
             rs = st.executeQuery(sql);
             rs.last();
             int c = rs.getRow();
             rs.beforeFirst();
             
             String values[] = new String[c];
             int i=0;
             while(rs.next())
             {
                 values[i] = rs.getString(1);
                 i++;
             }
             
             conn.close();
             combo.setModel(new DefaultComboBoxModel(values));  
         }catch(Exception e)
         {
             Tools.msgBox(e.getMessage());
         }
     }
     public static void fillTOJTable(String tableNameOrSelectStatement , JTable table)
     {
         try
         {
             setconnection();
             Statement st = conn.createStatement();
             ResultSet rs;
             String strSelect;
             String spart = tableNameOrSelectStatement.substring(0,7).toLowerCase();
             if("select ".equals( spart ))
             {
                 strSelect = tableNameOrSelectStatement;
                 
             }else
             {
                 strSelect = "select * from "+tableNameOrSelectStatement;
             }
             rs = st.executeQuery(strSelect);
             ResultSetMetaData rsmt = rs.getMetaData();
             int c = rsmt.getColumnCount();
             
             DefaultTableModel dtm = (DefaultTableModel)table.getModel();
             Vector row = new Vector();
             dtm.setRowCount(0);
             while(rs.next())
             {
                 row = new Vector(c);
                 for(int i=1;i<=c;i++)
                 {
                     row.add(rs.getString(i));
                     
                 }
                 dtm.addRow(row);
             }
             if(table.getColumnCount() != c)
             {
                 Tools.msgBox("JTable count not equal to query columns count \nJTable Columns Count is : "+table.getColumnCount()+"\nQuery Columns Count Is : "+c);
             }
             conn.close();
             
             
         }catch(Exception e)
         {
             Tools.msgBox(e.getMessage());
         }
         
     }
}
