package States;

import javax.swing.*;

import jdbc.GoaData;
import jdbc.Jammu_and_KashmirData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jammu_and_Kashmir implements ActionListener{
	   
	public String[] district= {"JAMMU", "SRINAGAR", "ANANTNAG", "RAMBAN", "BARAMULLA", "UDHAMPUR", 
			"REASI", "GANDERBAL", "DODA"};
    private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Jammu_and_Kashmir(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Jammu_and_Kashmir() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
        	Jammu_and_KashmirData jkdata = new Jammu_and_KashmirData(selectedDistrict);
            //System.out.println(selectedDistrict);
        	jkdata.setVisible(true);
        });
    }
}


