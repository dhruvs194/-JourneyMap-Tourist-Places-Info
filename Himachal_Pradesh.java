package States;

import javax.swing.*;

import jdbc.GoaData;
import jdbc.Himachal_PradeshData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Himachal_Pradesh implements ActionListener{
	   
	public String[] district= {"Shimla district", "Kullu district", "Kangra district", "Chamba district", "Solan district", "Mandi district", 
	                            "Lahaul and Spiti district", "Kinnaur district", "Bilaspur district", "Sirmaur district"};
    private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Himachal_Pradesh(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Himachal_Pradesh() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
        	Himachal_PradeshData HimachalPradeshdata = new Himachal_PradeshData(selectedDistrict);
            //System.out.println(selectedDistrict);
        	HimachalPradeshdata.setVisible(true);
        });
    }
}



