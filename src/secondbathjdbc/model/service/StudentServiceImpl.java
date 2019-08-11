/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondbathjdbc.model.service;

import java.util.List;
import secondbathjdbc.model.Student;
import secondbathjdbc.model.dao.DAO;

/**
 *
 * @author thetkhine
 */
public class StudentServiceImpl implements StudentService
{

    DAO dao = DAO.getDAO();
    
    @Override
    public List<Student> getAllStudent()
    {
        return dao.getAllStudent();
    }
    
}
