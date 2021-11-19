package homework_27;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Connection conn = ConnectionUtil.getCon();

    public static void main(String[] args) throws SQLException {
//        System.out.println(getStudentById(14));
//        System.out.println(deleteStudentById(8));
//        System.out.println(getAllStudents());
        System.out.println(getStudentListByLastName("Ivanov"));
    }


    private static Student getStudentById(int id) throws SQLException {
        final Student result = new Student();
        result.setId(-1);
        try {
            String sql = "select * from students where ID_st =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setId(1);
                result.setName(rs.getString(2));
                result.setIdGroup(rs.getInt(3));
                result.setYearOfEntry(rs.getInt(4));
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
        return result;
    }

    private static boolean deleteStudentById(int id) throws SQLException {
        try {
            String sql = "delete from students where ID_st =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
        return false;
    }

    private static List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "select * from students";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int groupId = rs.getInt(3);
                int yearOfEntry = rs.getInt(4);
                Student s = new Student(id, name, groupId, yearOfEntry);
                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
        return students;
    }

    private static List<Student> getStudentListByLastName(String lastName) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "select * from students where student_name like ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        String newLastName = lastName + "%";
        statement.setString(1, newLastName);
        final ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int groupId = rs.getInt(3);
            int yearOfEntry = rs.getInt(4);
            Student s = new Student(id, name, groupId, yearOfEntry);
            students.add(s);
        }
        conn.close();
        return students;
    }
}

