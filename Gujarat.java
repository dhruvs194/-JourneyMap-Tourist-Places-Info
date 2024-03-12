package States;

import javax.swing.*;

import jdbc.GoaData;
import jdbc.GujaratData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gujarat implements ActionListener{
	   
	public String[] district= {"Gandhinagar", "Narmada", "Gir Somnath", "Kutch", "Bhuj", "Dang", 
	                            "Navsari", "Ahmedabad", "Jamnagar", "Gir Somnath", "Dwarka"};
    private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Gujarat(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Gujarat() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
        	GujaratData gujaratdata = new GujaratData(selectedDistrict);
            //System.out.println(selectedDistrict);
        	gujaratdata.setVisible(true);
        });
    }
}

