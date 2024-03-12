package States;

import javax.swing.*;

import jdbc.MaharashtraData;
import jdbc.UttarPradeshData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UttarPradesh implements ActionListener{
	   
	public String[] district = {
			"Ayodhya",
			"Agra",
			"Varanasi",
			"Lucknow",
			"Mathura",
			"Varanasi",
			"Gorakhpur",
			"Kanpur",
			"Jhansi",
			"Sitapur",
			"Chitrakoot",
			"Kushinagar",
			"Allahabad",			
			"Farrukhabad",
			"Jaunpur",
			"Lakhimpur Kheri",
			"Mirzapur"
		};

	private JFrame frame;
    private JComboBox<String> districtComboBox;

    public UttarPradesh(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public UttarPradesh() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
        	UttarPradeshData uttarpradeshdata = new UttarPradeshData(selectedDistrict);
            //System.out.println(selectedDistrict);
        	uttarpradeshdata.setVisible(true);
        });
    }
}




