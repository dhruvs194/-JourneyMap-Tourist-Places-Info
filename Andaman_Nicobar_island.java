package States;

import javax.swing.*;

import jdbc.Andaman_Nicobar_islandData;
import jdbc.GoaData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Andaman_Nicobar_island implements ActionListener{
	   
	public String[] district= {"Cellular Jail","Port Blair","Radhanagar Beach","Havelock Island","Elephant Beach"};
    private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Andaman_Nicobar_island(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Andaman_Nicobar_island() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
        	Andaman_Nicobar_islandData andaman_Nicobar_islandData = new Andaman_Nicobar_islandData(selectedDistrict);
            //System.out.println(selectedDistrict);
        	andaman_Nicobar_islandData.setVisible(true);
        });
    }
}
