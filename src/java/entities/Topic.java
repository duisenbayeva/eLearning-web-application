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
public class Topic implements Serializable {
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
    
     private String name;

    private long subjectID;
    private String videoUrl;

   
    /**
     * Get the value of subjectID
     *
     * @return the value of subjectID
     */
    public long getSubjectID() {
        return subjectID;
    }

    /**
     * Set the value of subjectID
     *
     * @param subjectID new value of subjectID
     */
    public void setSubjectID(long subjectID) {
        this.subjectID = subjectID;
    }

    
    /**
     * Get the value of videoUrl
     *
     * @return the value of videoUrl
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * Set the value of videoUrl
     *
     * @param videoUrl new value of videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Topic[ id=" + id + " ]";
    }
    
}
