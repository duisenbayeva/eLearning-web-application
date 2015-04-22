/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bduis_000
 */
@Entity
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private Long subjectID;
    
    private Long topicID;
    
    private int complexity;
    
    private String fileUrl;

    /**
     * Get the value of fileUrl
     *
     * @return the value of fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * Set the value of fileUrl
     *
     * @param fileUrl new value of fileUrl
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }


    /**
     * Get the value of complexity
     *
     * @return the value of complexity
     */
    public int getComplexity() {
        return complexity;
    }

    /**
     * Set the value of complexity
     *
     * @param complexity new value of complexity
     */
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }


    /**
     * Get the value of topicID
     *
     * @return the value of topicID
     */
    public Long getTopicID() {
        return topicID;
    }

    /**
     * Set the value of topicID
     *
     * @param topicID new value of topicID
     */
    public void setTopicID(Long topicID) {
        this.topicID = topicID;
    }


    /**
     * Get the value of subjectID
     *
     * @return the value of subjectID
     */
    public Long getSubjectID() {
        return subjectID;
    }

    /**
     * Set the value of subjectID
     *
     * @param subjectID new value of subjectID
     */
    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Test[ id=" + id + " ]";
    }
    
}
