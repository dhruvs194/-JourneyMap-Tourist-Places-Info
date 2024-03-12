package States;

import javax.swing.*;

import jdbc.GoaData;
import jdbc.RajasthanData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Goa implements ActionListener{
	   
	public String[] district= {"South Goa District","North Goa District"};
    private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Goa(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Goa() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
            GoaData goadata = new GoaData(selectedDistrict);
            //System.out.println(selectedDistrict);
            goadata.setVisible(true);
        });
    }
}

