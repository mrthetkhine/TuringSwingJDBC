/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondbathjdbc.model.dao;

import com.mysql.jdbc.Connection;
import secondbathjdbc.model.Mark;
import secondbathjdbc.model.Student;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import secondbathjdbc.model.PassedStudent;

/**
 *
 * @author thetkhine
 */
public class DAO
{
    String connectionString = "jdbc:mysql://localhost:3306/turing_second_batch";
    Connection conn = null;
    
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static DAO singleton ;
    public static DAO getDAO()
    {
        if(singleton == null)
        {
            singleton = new DAO();
        }
        return singleton;
    }
    private DAO()
    {
        try
        {
            this.conn = (Connection) DriverManager.getConnection(this.connectionString,"root","");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public List<Student> getAllStudent()
    {
        List<Student> students = new ArrayList<Student>();
        try
        {
           Statement st = this.conn.createStatement();
           ResultSet result = st.executeQuery("SELECT student.*,township.name as townshipName FROM student\n" +
                                                "JOIN township on student.township_id = township.id;");
           
           while(result.next())
           {
               Long id = result.getLong("ID");
               String name = result.getString("name");
               Long townshipId = result.getLong("township_id");
               String townshipName = result.getString("townshipName");
               
               Student stud = new Student(id,name);
               stud.setTownship(townshipName);
               stud.setTownshipId(townshipId);
               students.add(stud);
           }
           result.close();
           st.close();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    public List<PassedStudent> getAllPassedStudent()
    {
        List<PassedStudent> students = new ArrayList<>();
        
        try
        {
            String sql = "SELECT student.id, student.name,subject.name as SubjectName, SUM(mark.mark)\n" +
                        "FROM turing_second_batch.mark\n" +
                        "JOIN student ON student.id = mark.student_id\n" +
                        "JOIN subject ON subject.id = mark.subject_id\n" +
                        "WHERE mark >=40\n" +
                        "GROUP BY student.id\n" +
                        "HAVING COUNT(subject.id)= (SELECT COUNT(*) FROM subject)\n" +
                        "ORDER BY SUM(mark.mark) DESC,student.id,subject.id";
            PreparedStatement st = this.conn.prepareStatement(sql);
            
            ResultSet result = st.executeQuery();
            while(result.next())
            {
                Long studentId= result.getLong("id");
                String studentName = result.getString("name");
                String subjectName = result.getString("subjectName");
                int total= (int)result.getLong(4);
                
                Student stud = new Student(studentId,studentName);
                Mark mark = new Mark();
                
                mark.setSubjectName(subjectName);
                mark.setMark(total);
                
                PassedStudent ps = new PassedStudent();
                ps.setMark(mark);
                ps.setStudent(stud);
                
                students.add(ps);
            }
        }
        catch(Exception e)
        {
        }
        return students;        
    }
    public void insertStudent(Student student)
    {
        try
        {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO Student(name,township_id) VALUES (?,?)");
            st.setString(1, student.getName());
            st.setLong(2, student.getTownshipId());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[]args)
    {
        DAO dao = new DAO();
        
        /*
        Student stud = new Student();
        stud.setName("Mg Mg");
        stud.setTownshipId(1L);
        
        dao.insertStudent(stud);
        List<Student> students = dao.getAllStudent();
        for(Student stud1 : students)
        {
            System.out.println(stud1);
        }
        */
        List<PassedStudent> students = dao.getAllPassedStudent();
        for(PassedStudent stud : students)
        {
            System.out.println(stud.getStudent().getName()+" subj "+ stud.getMark().getSubjectName()+" total "+ stud.getMark().getMark());
        }
        
    }
}
