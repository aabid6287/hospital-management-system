package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    private Connection con;
    private Scanner sc;

    public Patient(Connection con, Scanner sc){
        this.con = con;
        this.sc = sc;
    }

    public void addPatient(){
        System.out.print("Enter Patient Name: ");
        String name = sc.next();
        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Patient Gender: ");
        String gender = sc.next();

        try {
            String query = "INSERT INTO patients(name, age, gender) VALUES(?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2,age);
            statement.setString(3,gender);
            int affectedRows = statement.executeUpdate();
            if(affectedRows>0) {
                System.out.println("Patient Added Successfully!");
            }else{
                System.out.println("Failed to add Patient!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
   public void viewPatient() {
       String query = "SELECT * FROM patients";
       try {
           PreparedStatement statement = con.prepareStatement((query));
           ResultSet resultSet = statement.executeQuery();
           System.out.println("Patients: ");
           System.out.println("+------------+---------------+----------+----------+");
           System.out.println("| Patient Id | Name          | Age      | Gender    |");
           System.out.println("+------------+---------------+----------+----------+");
           while (resultSet.next()) {
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               int age = resultSet.getInt("age");
               String gender = resultSet.getString("gender");
               System.out.printf("| %-10s | %-13s | %-8s | %-8s \n", id, name, age, gender);
               System.out.println("+------------+---------------+----------+----------+");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    public boolean getPatientById(int id){
        String query = "SELECT * FROM patients WHERE id = ?";
        try{
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return  false;
    }
}
