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
public class Success implements Serializable {

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

    private long userID;

    private long subjectID;
    private double point;

    /**
     * Get the value of point
     *
     * @return the value of point
     */
    public double getPoint() {
        return point;
    }

    /**
     * Set the value of point
     *
     * @param point new value of point
     */
    public void setPoint(double point) {
        this.point = point;
    }

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
     * Get the value of userID
     *
     * @return the value of userID
     */
    public long getUserID() {
        return userID;
    }

    /**
     * Set the value of userID
     *
     * @param userID new value of userID
     */
    public void setUserID(long userID) {
        this.userID = userID;
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
        if (!(object instanceof Success)) {
            return false;
        }
        Success other = (Success) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Success[ id=" + id + " ]";
    }

}
