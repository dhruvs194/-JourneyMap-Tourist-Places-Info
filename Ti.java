package B;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import States.*;
public class Ti {

    private static JFrame frame;
    private static JPanel currentPanel;

    public static void main(String[] args) {
        frame = new JFrame("Tourism Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1550, 890);
        frame.setLayout(new BorderLayout());

        currentPanel = createMainPanel();
        frame.add(currentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

   

    public static JPanel createMainPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Load the background image from a file
                    BufferedImage image = ImageIO.read(new File("C:\\Users\\Hp\\Downloads\\North-east-india.jpg"));
                    g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        // Set the layout to null for absolute positioning
        panel.setLayout(null);

        // Create and position other components manually
        

        // Create a label for the title and place it at the top
        JLabel titleLabel = new JLabel("Tourism Info");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 96));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 0, 1500, 150); // Position and size
        panel.add(titleLabel);

        // Add a label for the dropdown
        JLabel dropdownLabel = new JLabel("Select State:");
        dropdownLabel.setFont(new Font("Arial", Font.BOLD, 46));
        dropdownLabel.setBounds(630, 300, 300, 60); // Position and size
        panel.add(dropdownLabel);

        // Create a JComboBox and set its position and size
        JComboBox<String> destinationComboBox = new JComboBox<>(getStates().toArray(new String[0]));
        Dimension comboBoxSize = new Dimension(300, 60);
        destinationComboBox.setPreferredSize(comboBoxSize);
        destinationComboBox.setBounds(600, 400, 300, 60); // Position and size
        panel.add(destinationComboBox);

        // Create the "Submit" button and set its position and size
        JButton submitButton = new JButton("NEXT");
        Dimension buttonSize = new Dimension(100, 50);
        submitButton.setPreferredSize(buttonSize);
        submitButton.setBounds(690, 500, 100, 50); // Position and size
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedState = (String) destinationComboBox.getSelectedItem();
                if (selectedState == null) {
                    JOptionPane.showMessageDialog(frame, "Please select a state.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    showStatePanel(selectedState);
                }
            }
        });

        return panel;
    }

    public static List<String> getStates() {
        List<String> destinations = new ArrayList<>();
        destinations.add(null);
        destinations.add("Maharashtra");
        destinations.add("Rajasthan");
        destinations.add("Uttar Pradesh");
        destinations.add("Goa");
        destinations.add("Andaman Nicobar Island");
        destinations.add("Sikkim");
        destinations.add("Gujarat");
        destinations.add("Jammu and Kashmir");
        destinations.add("Himachal Pradesh");
        destinations.add("Karnataka");
        return destinations;
    }

    public static void showStatePanel(String selectedState) {
        // Remove the current panel from the frame
        frame.remove(currentPanel);

        // Create and set the new panel based on the selected state
        JPanel newStatePanel = createStatePanel(selectedState);
        frame.add(newStatePanel, BorderLayout.CENTER);

        // Update the current panel reference
        currentPanel = newStatePanel;

        // Repaint and revalidate the frame to display the new panel
        frame.repaint();
        frame.revalidate();
    }

    public static JPanel createStatePanel(String selectedState) {
    	JPanel statePanel = new JPanel(null) {
    	    @Override
    	    protected void paintComponent(Graphics g) {
    	        super.paintComponent(g);
    	        try {
    	            // Load the background image for the statePanel
    	            Image image = new ImageIcon("C:\\Users\\Hp\\Downloads\\North-east-india.jpg").getImage();
    	            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
    	    }
    	};

    	// Set the layout manager to null
    	statePanel.setLayout(null);

    	

    	// Customize the statePanel based on the selected state
    	JLabel stateLabel = new JLabel(selectedState);
    	stateLabel.setFont(new Font("Arial", Font.BOLD, 96));
    	 stateLabel.setBounds(0, 0, 1500, 150);
    	 statePanel.add(stateLabel);

    	// Add state-specific content here


    	JLabel districtLabel = new JLabel("Select City:");
    	districtLabel.setFont(new Font("Arial", Font.BOLD, 35));
    	districtLabel.setBounds(20,-100, 950, 600);
    	statePanel.add(districtLabel);


    	String[] districtOptions = {};
    	if (selectedState.equals("Maharashtra")) {
    	    districtOptions = new Maharashtra().district;
    	} else if (selectedState.equals("Rajasthan")) {
    	    districtOptions = new Rajasthan().district;
    	}
    	else if (selectedState.equals("Andaman Nicobar Island")) {
   	    districtOptions = new Andaman_Nicobar_island().district;
    	}
    	else if (selectedState.equals("Goa")) {
    	    districtOptions = new Goa().district;
    	}
    	else if (selectedState.equals("Uttar Pradesh")) {
       	    districtOptions = new UttarPradesh().district;
        }
  	    else if (selectedState.equals("Gujarat")) {
    	    districtOptions = new Gujarat().district;
  	    }
      	else if (selectedState.equals("Himachal Pradesh")) {
    	    districtOptions = new Himachal_Pradesh().district;
   	    }
        else if (selectedState.equals("Jammu and Kashmir")) {
  	    districtOptions = new Jammu_and_Kashmir().district;
        }
    	else if (selectedState.equals("Karnataka")) {
   	    districtOptions = new Karnataka().district;
    	}
    	else if (selectedState.equals("Sikkim")) {
    	    districtOptions = new Sikkim().district;
    	}
    	JComboBox<String> districtDropdown = new JComboBox<>(districtOptions);
    	districtDropdown.setBounds(230,185, 150, 30);
    	statePanel.add(districtDropdown);


    	JButton nextButton = new JButton("Next");
    	nextButton.setBounds(250,250 , 100, 30);


    	JButton backButton = new JButton("Back");
    	backButton.setBounds(250,300, 100, 30);


    	statePanel.add(nextButton);
    	statePanel.add(backButton);
    	if (selectedState.equals("Rajasthan")) {
    		nextButton.addActionListener(new Rajasthan(frame, districtDropdown));
    	}
    	else if(selectedState.equals("Goa")) {
    		nextButton.addActionListener(new Goa(frame, districtDropdown));

    	}
    	else if(selectedState.equals("Maharashtra")) {
    		nextButton.addActionListener(new Maharashtra(frame, districtDropdown));

    	}
    	else if(selectedState.equals("Uttar Pradesh")) {
    		nextButton.addActionListener(new UttarPradesh(frame, districtDropdown));

    	}
    	else if(selectedState.equals("Sikkim")) {
    		nextButton.addActionListener(new Sikkim(frame, districtDropdown));

    	}
    	else if(selectedState.equals("Andaman Nicobar Island")) {
    		nextButton.addActionListener(new Andaman_Nicobar_island(frame, districtDropdown));
    	}
    	else if(selectedState.equals("Karnataka")) {
    		nextButton.addActionListener(new Karnataka(frame, districtDropdown));
    	}
    	else if(selectedState.equals("Himachal Pradesh")) {
    		nextButton.addActionListener(new Himachal_Pradesh(frame, districtDropdown));
    	}
    	else if(selectedState.equals("Jammu and Kashmir")) {
    		nextButton.addActionListener(new Jammu_and_Kashmir(frame, districtDropdown));
    	}
    	else if(selectedState.equals("Gujarat")) {
    		nextButton.addActionListener(new Gujarat(frame, districtDropdown));
    	}
    	
    	
    	backButton.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Handle the action when the "Back" button is clicked
    	        showMainPanel(); // Call a method to switch back to the main panel
    	    }
    	});

    	return statePanel;

    }
    
    
    public static void showMainPanel() {
        // Remove the current panel from the frame
        frame.remove(currentPanel);

        // Create and set the main panel
        JPanel mainPanel = createMainPanel();
        frame.add(mainPanel, BorderLayout.CENTER);

        // Update the current panel reference
        currentPanel = mainPanel;

        // Repaint and revalidate the frame to display the main panel
        frame.repaint();
        frame.revalidate();
    }
    
   
}

