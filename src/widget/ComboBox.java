/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package widget;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;

public class ComboBox extends JComboBox<String> {

    public ComboBox() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize FlatLaf");
        }

        // Menambahkan item ke ComboBox
        addItem("Item 1");
        addItem("Item 2");
        addItem("Item 3");
        addItem("Item 4");

        // Mengatur tampilan dan ukuran
        setPreferredSize(new Dimension(150, 30));
    }
}

