package States;

import javax.swing.*;

import jdbc.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sikkim implements ActionListener{
	   
	public String[] district= {"Silliguri"};
    private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Sikkim(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Sikkim() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
            SikkimData sikkimdata = new SikkimData(selectedDistrict);
            //System.out.println(selectedDistrict);
            sikkimdata.setVisible(true);
        });
    }
}


