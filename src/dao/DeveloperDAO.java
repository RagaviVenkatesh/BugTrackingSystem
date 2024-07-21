package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Developer;
import utility.DBConnection;

public class DeveloperDAO {

	//Add Developer
	public void addDeveloper(Developer developer) throws SQLException {
        String query = "INSERT INTO developers (name, email) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, developer.getName());
            statement.setString(2, developer.getEmail());
            statement.executeUpdate();
        }
    }
	
	
	//Get All Developers
	public List<Developer> getAllDevelopers() throws SQLException {
        List<Developer> developers = new ArrayList<>();
        String query = "SELECT * FROM developers";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setDeveloperId(resultSet.getInt("developer_id"));
                developer.setName(resultSet.getString("name"));
                developer.setEmail(resultSet.getString("email"));
                developers.add(developer);
            }
        }
        return developers;
    }
	
	//Update Developer
	public void updateDeveloper(Developer developer) throws SQLException {
        String query = "UPDATE developers SET name = ?, email = ? WHERE developer_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, developer.getName());
            statement.setString(2, developer.getEmail());
            statement.setInt(3, developer.getDeveloperId());
            statement.executeUpdate();
        }
    }

	//Delete Developer
    public void deleteDeveloper(int developerId) throws SQLException {
        String query = "DELETE FROM developers WHERE developer_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, developerId);
            statement.executeUpdate();
        }
    }
}
