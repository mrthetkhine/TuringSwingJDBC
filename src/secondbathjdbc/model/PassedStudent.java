/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondbathjdbc.model;

import firstbatchjdbc.model.*;

/**
 *
 * @author thetkhine
 */
public class PassedStudent
{
    Student student;
    Mark mark;

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Mark getMark()
    {
        return mark;
    }

    public void setMark(Mark mark)
    {
        this.mark = mark;
    }
    
    
}
