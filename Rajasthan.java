package States;

import javax.swing.*;

import jdbc.RajasthanData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rajasthan implements ActionListener{
   
	public String[] district= {"Jaipur","Jodhpur","Udaipur","Jaisalmer","Ajmer","Bikaner","Chittorgarh","Sawai Madhopur","Mount Abu","Bharatpur","Rajsamand","Alwar","Sirohi"};
    private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Rajasthan(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Rajasthan() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
            RajasthanData rajasthanData = new RajasthanData(selectedDistrict);
            //System.out.println(selectedDistrict);
            rajasthanData.setVisible(true);
        });
    }
}
