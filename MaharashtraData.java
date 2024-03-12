package jdbc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MaharashtraData extends JFrame {
    private JTextArea textArea;

   
    public MaharashtraData(String district) {
    	setTitle("Maharashtra Data");
    	setSize(600, 400);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	textArea = new JTextArea(20, 40);
    	textArea.setEditable(false);
    	textArea.setBackground(Color.ORANGE); // Set the background color to orange
    	textArea.setForeground(Color.BLACK); // Set the text color (foreground) to black

    	JScrollPane scrollPane = new JScrollPane(textArea);
    	add(scrollPane, BorderLayout.CENTER);

    	fetchAndDisplayData(district);

    	setLocationRelativeTo(null); // Center the window

    }

    private void fetchAndDisplayData(String district) {
        String dbUrl = "jdbc:mysql://localhost:3306/Maharashtra";
        String dbUsername = "root";
        String dbPassword = "25305181";

        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement statement = connection.createStatement();

            // Execute SQL query to fetch data
            String sqlQuery = "Select * from Maharashtra.tourist_spots";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Display data in the JTextArea
            StringBuilder data = new StringBuilder();
            //System.out.println(selecteddistrict);
            while (resultSet.next()) {
                String cityName = resultSet.getString("district");
//                
                 // data.append("City: ").append(cityName);
                //System.out.println(cityName+" "+district);
                if(cityName.equals(district)) {
                	String placename = resultSet.getString("place_name");
                	String cityname = resultSet.getString("district");
                	String neareststation = resultSet.getString("nearest_railway_station");
                	String neareststationdistance = resultSet.getString("distance_from_railway_station");
                	String besttimetovisit = resultSet.getString("best_time_to_visit");
                	String activities = resultSet.getString("activities");
                	String entry_fee = resultSet.getString("entry_ticket_price");
                	String essentials = resultSet.getString("essentials");
                	String opening_time = resultSet.getString("opening_time");
                	String closing_time = resultSet.getString("closing_time");

                	data.append("--------------------------------------------------------------------\n");
                 	data.append("Place name: ").append(placename).append("\n");
                 	data.append("City name: ").append(cityname).append("\n");
                 	data.append("Nearest Railway Station : ").append(neareststation).append("\n");
                 	data.append("Distance From Nearest Railway Station : ").append(neareststationdistance).append("\n");
                 	data.append("Best Time To Visit : ").append(besttimetovisit).append("\n");
                 	data.append("Recommended Activities : ").append(activities).append("\n");
                 	data.append("Entry Fee : ").append(entry_fee).append("\n");
                 	data.append("Essentials to be carried: ").append(essentials).append("\n");
                 	data.append("Opening Time: ").append(opening_time).append("\n");
                 	data.append("Closing Time: ").append(closing_time).append("\n");


                	data.append("--------------------------------------------------------------------\n");


                 	
                }
                
            }
            textArea.setText(data.toString());

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}


