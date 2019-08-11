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
public class Student
{
    Long id;
    String name;
    Long townshipId;
    String township;
    
    public Student()
    {
    }
    
    public Student(Long id,String name)
    {
        this.id = id;
        this.name = name;
    }
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Student{" + "id=" + id + ", name=" + name + '}';
    }

    public Long getTownshipId()
    {
        return townshipId;
    }

    public void setTownshipId(Long townshipId)
    {
        this.townshipId = townshipId;
    }

    public String getTownship()
    {
        return township;
    }

    public void setTownship(String township)
    {
        this.township = township;
    }
    
}
