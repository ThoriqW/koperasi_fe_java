/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package widget;

import java.awt.Color;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author khanzasoft
 */
public final class Tanggal extends JXDatePicker {
    public Tanggal() {
        super();
        setDate(new Date()); // Set default ke hari ini
        setFormats("dd/MM/yyyy"); // Format tanggal
        setForeground(new Color(50, 50, 50));
        setBackground(new Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 0, 11));
        setSize(WIDTH, 23);
    }
}
