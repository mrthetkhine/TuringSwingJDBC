/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstbatchjdbc.model.dao;

import com.mysql.jdbc.Connection;
import firstbatchjdbc.model.Mark;
import firstbatchjdbc.model.PassedStudent;
import firstbatchjdbc.model.Student;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thetkhine
 */
public class DAOConnection
{
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String connectionString = "jdbc:mysql://localhost:3306/turing_first_batch";
    Connection conn = null;
    static DAOConnection singleton ;
    
    public static DAOConnection getDao()
    {
        if(singleton == null)
        {
            singleton = new DAOConnection();
        }
        return singleton;
    }
    private DAOConnection()
    {
        this.connect();
    }
    public void connect()
    {
        try
        {
            this.conn = (Connection) DriverManager.getConnection(connectionString, "root", "");
            System.out.println("Connection "+conn);
                    
        } catch (SQLException ex)
        {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Student> getAllStudent() 
    {
        List<Student> students = new ArrayList<Student>();
        try
        {
            Statement st = this.conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM student");
            while(res.next())
            {
                Long id = res.getLong("ID");
                String name = res.getString("name");
                
                //System.out.println("ID "+ id + " Name "+name);
                Student stud = new Student(id,name);
                students.add(stud);
                
            }
            res.close();
            st.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    public List<PassedStudent> getAllPassStudent() 
    {
        List<PassedStudent> students = new ArrayList<PassedStudent>();
        try
        {
            Statement st = this.conn.createStatement();
            ResultSet res = st.executeQuery("SELECT student.id, student.name,subject.name as SubjectName, SUM(mark.mark)\n" +
                                            "FROM turing_second_batch.mark\n" +
                                            "JOIN student ON student.id = mark.student_id\n" +
                                            "JOIN subject ON subject.id = mark.subject_id\n" +
                                            "WHERE mark >=40\n" +
                                            "GROUP BY student.id\n" +
                                            "HAVING COUNT(subject.id)= (SELECT COUNT(*) FROM subject)\n" +
                                            "ORDER BY SUM(mark.mark) DESC,student.id,subject.id");
            while(res.next())
            {
                Long studentId = res.getLong("ID");
                String studentName = res.getString("name");
                String subjetName = res.getString("SubjectName");
                int totalMark = (int) res.getLong(4);
                //System.out.println("ID "+ id + " Name "+name);
                Student stu = new Student();
                Mark mark = new Mark();
                stu.setId(studentId);
                stu.setName(studentName);
                
                mark.setSubjectName(subjetName);
                mark.setMark(totalMark);
                
                PassedStudent ps = new PassedStudent();
                ps.setStudent(stu);
                ps.setMark(mark);
                
                students.add(ps);
            }
            res.close();
            st.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    public void insertStudent(Student student)
    {
        try
        {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO Student (name) VALUES(?)");
            st.setString(1, student.getName());
            st.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertMark(Mark mark)
    {
        try
        {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO Mark (student_id,subject_id, mark) VALUES(?,?,?)");
            st.setLong(1, mark.getStudentId());
            st.setLong(2, mark.getSubjectId());
            st.setLong(3, mark.getMark());
            st.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String []args)
    {
        DAOConnection dao = new DAOConnection();
        /*
        List<Student> students = dao.getAllStudent();
        for(Student stu: students)
        {
            System.out.println(stu);
        }
        */
        /*
        Student stu = new Student();
        stu.setName("Added Student2'");
        dao.insertStudent(stu);
        */
        /*
        Mark mark = new Mark();
        mark.setStudentId(3L);
        mark.setSubjectId(1L);
        mark.setMark(56);
        dao.insertMark(mark);
        */
        List<PassedStudent> students = dao.getAllPassStudent();
        for(PassedStudent ps: students)
        {
            System.out.println(ps.getStudent().getName() +" Mark "+ ps.getMark().getMark());
        }
    }
}
