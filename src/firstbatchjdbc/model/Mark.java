/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstbatchjdbc.model;

/**
 *
 * @author thetkhine
 */
public class Mark
{
    Long id;
    Long studentId;
    String studentName;
    Long subjectId;
    String subjectName;
    Integer mark;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public Long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(Long subjectId)
    {
        this.subjectId = subjectId;
    }

    public String getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
    }

    public Integer getMark()
    {
        return mark;
    }

    public void setMark(Integer mark)
    {
        this.mark = mark;
    }
    
    
}
