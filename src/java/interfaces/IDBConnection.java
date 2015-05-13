/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;


import entities.Student;
import entities.Subject;
import entities.Success;
import entities.Test;
import entities.Topic;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author asusa
 */
@Local
public interface IDBConnection {
    public void createUser(Student st);
    public void createSuccess(Success success);
    public void createTopic(Topic topic);
    public void createTest(Test test);
    public void createSubject(Subject subject);
    
    public void deleteUser(Long id);
    public void deleteSuccess(Long id);
    public void deleteTopic(Long id);
    public void deleteTest(Long id);
    public void deleteSubject(Long id);
    
    public void updateUser(Student st);
    public void updateSuccess(Success success);
    public void updateTopic(Topic topic);
    public void updateTest(Test test);
    public void updateSubject(Subject subject);
    
    public Student getUser(Long id);
    public Success getSuccessbySubject(Long userid, Long subjectid);
    public Topic getTopic(Long id);
    public Test getTest(Long id);   
    public Subject getSubject(Long id);
    
    public List<Subject> getSubjectList();
    public List<Student> getUserList();
    public List<Student> getUsersByEmail(String email);
    public List<Student> getUserListByNamePassword(String name, String password);
    public List<Success> getSuccessList();
    public List<Topic> getTopicListOfSubject(Long subjectid);
    public List<Test> getTestListOfTopic(Long subjectid, Long topicid, int complexity);
    
}
