package States;

import javax.swing.*;

import jdbc.KarnatakaData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Karnataka implements ActionListener{
	   
	public String[] district= {"Bengaluru Urban", "Mysuru", "Kodagu", 
			"Ballari", "Uttara Kannada", "Udupi", "Bagalkot",
			"Hassan", "Chikkamagaluru", "Chamarajanagar", "Chikkaballapur",
			"Shimoga", "Vijayapura"};
    private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Karnataka(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Karnataka() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
            KarnatakaData  karnatakadata = new KarnatakaData(selectedDistrict);
            //System.out.println(selectedDistrict);
            karnatakadata.setVisible(true);
        });
    }
}

