/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fungsi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uz.ncipro.calendar.JDateTimePicker;

/**
 *
 * @author Lenovo
 */
public class validasi {
    private int j=0;
    
    public validasi(){
        super();
    };
    
     public void SetTgl(DefaultTableModel tabMode,JTable table,JDateTimePicker dtp,int i){
        j=table.getSelectedRow();
        try {
           Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(tabMode.getValueAt(j,i).toString().replaceAll("'",""));
           dtp.setDate(dtpa);
        } catch (ParseException ex) {
           dtp.setDate(new Date());
        }
    }
}
