/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entities.Student;
import entities.Subject;
import entities.Success;
import entities.Test;
import entities.Topic;
import interfaces.IDBConnection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author asusa
 */
@Stateless
public class DBUtils implements IDBConnection{
    @PersistenceContext
    EntityManager em;
    
    @Override
    public void createUser(Student user) {
        em.persist(user);
        em.flush();
    }

    @Override
    public void createSuccess(Success success) {
       em.persist(success);
        em.flush();
    }

    @Override
    public void createTopic(Topic topic) {
        em.persist(topic);
        em.flush();
    }

    @Override
    public void createTest(Test test) {
        em.persist(test);
        em.flush();
    }

    @Override
    public void createSubject(Subject subject) {
        em.persist(subject);
        em.flush();
    }

    @Override
    public void deleteUser(Long id) {
        em.remove(em.find(Student.class, id));
        em.flush();
    }

    @Override
    public void deleteSuccess(Long id) {
        em.remove(em.find(Success.class, id));
        em.flush();
    }

    @Override
    public void deleteTopic(Long id) {
        em.remove(em.find(Topic.class, id));
        em.flush();
    }

    @Override
    public void deleteTest(Long id) {
        em.remove(em.find(Test.class, id));
        em.flush();
    }

    @Override
    public void deleteSubject(Long id) {
        em.remove(em.find(Subject.class, id));
        em.flush();
    }

    @Override
    public void updateUser(Student st) {
        em.merge(st);
        em.flush();
    }

    @Override
    public void updateSuccess(Success success) {
        em.merge(success);
        em.flush();
    }

    @Override
    public void updateTopic(Topic topic) {
        em.merge(topic);
        em.flush();
    }

    @Override
    public void updateTest(Test test) {
        em.merge(test);
        em.flush();
    }

    @Override
    public void updateSubject(Subject subject) {
        em.merge(subject);
        em.flush();
    }

    @Override
    public Student getUser(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public Success getSuccessbySubject(Long userid, Long subjectid) {
        return (Success)em.createNativeQuery("select * from Success where subjectID="+subjectid+" and userID="+userid, Success.class).getResultList();
    }

    @Override
    public Topic getTopic(Long id) {
        return em.find(Topic.class, id);
    }

    @Override
    public Test getTest(Long id) {
        return em.find(Test.class, id);
    }

   
    @Override
    public Subject getSubject(Long id) {
        return em.find(Subject.class, id);
    }

    @Override
    public List<Subject> getSubjectList() {
        return (List<Subject>)em.createNativeQuery("select * from Subject", Subject.class).getResultList();
    }

    @Override
    public List<Student> getUserList() {
        return (List<Student>)em.createNativeQuery("select * from Student", Student.class).getResultList();
    }
    
    @Override
    public List<Student> getUsersByEmail(String email) {
        return (List<Student>)em.createNativeQuery("select * from Student where email="+email, Student.class).getResultList();
    }

    @Override
    public List<Success> getSuccessList() {
        return (List<Success>)em.createNativeQuery("select * from Success", Success.class).getResultList();
    }

    @Override
    public List<Topic> getTopicListOfSubject(Long subjectid) {
        return (List<Topic>)em.createNativeQuery("select * from Topic where subjectID="+subjectid, Topic.class).getResultList();
    }

    @Override
    public List<Test> getTestListOfTopic(Long subjectid, Long topicid, int complexity) {
        return (List<Test>)em.createNativeQuery("select * from Test where  subjectID="+subjectid+" and topicID="+topicid+" and complexity="+complexity+"", Test.class).getResultList();
    }
}
