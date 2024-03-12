package States;


import javax.imageio.ImageIO;
import javax.swing.*;

import jdbc.GoaData;
import jdbc.MaharashtraData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





public class Maharashtra implements ActionListener{
	   
	public String[] district = {"Satara","Pune","Ahmednagar","Sambhajinagar","Chandrapur",
            "Raigad",           
            "Nashik",
            "Ratnagiri",
            "Kolhapur",
            "Mumbai",
            "Hingoli",

        };
	private JFrame frame;
    private JComboBox<String> districtComboBox;

    public Maharashtra(JFrame frame, JComboBox<String> districtComboBox) {
        this.frame = frame;
        this.districtComboBox = districtComboBox;
        

    }
    public Maharashtra() {
    	
    }
//method is called automatically when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected district from the JComboBox
        String selectedDistrict = (String) districtComboBox.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
            MaharashtraData maharashtradata = new MaharashtraData(selectedDistrict);
            //System.out.println(selectedDistrict);
            maharashtradata.setVisible(true);
        });
    }
}


