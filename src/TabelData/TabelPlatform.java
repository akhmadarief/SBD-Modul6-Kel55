package TabelData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelPlatform extends AbstractTableModel{
    List <DataPlatform> data = new ArrayList<>();
    

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return data.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch(columnIndex){
        case 0: return data.get(rowIndex).getKodeplatform();
        case 1: return data.get(rowIndex).getPlatform();
        case 2: return data.get(rowIndex).getRilis();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int kolom){
    switch(kolom){
        case 0: return"KODEPLATFORM";
        case 1: return"PLATFORM";
        case 2: return"RILIS";
        default: return null;
    	}
    }
    
    public void add(DataPlatform a){
        data.add(a);
        fireTableRowsInserted(getRowCount(),getColumnCount());
    }

    public void delete (int col,int row){
        data.remove(col);
        fireTableRowsDeleted(col,row);
    }
    
  
    public DataPlatform get(int row){
        return (DataPlatform) data.get(row);
    }

}
