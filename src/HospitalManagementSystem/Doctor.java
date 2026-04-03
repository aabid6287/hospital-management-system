package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private Connection con;

    public Doctor(Connection con) {
        this.con = con;
    }


    public void viewDoctor() {
        String query = "SELECT * FROM doctors";
        try {
            PreparedStatement statement = con.prepareStatement((query));
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+------------+---------------+----------------+");
            System.out.println("| Doctor Id  | Name          | specialization |");
            System.out.println("+------------+---------------+----------------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("| %-10s | %-13s | %-14s \n", id, name, specialization);
                System.out.println("+------------+---------------+----------------+");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getDoctorById(int id) {
        String query = "SELECT * FROM doctors WHERE id = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}