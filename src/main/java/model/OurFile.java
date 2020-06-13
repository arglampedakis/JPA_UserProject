/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author glamb
 */
@Entity
@Table(name = "our_files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OurFile.findAll", query = "SELECT o FROM OurFile o")
    , @NamedQuery(name = "OurFile.findByFileId", query = "SELECT o FROM OurFile o WHERE o.fileId = :fileId")
    , @NamedQuery(name = "OurFile.findByFileName", query = "SELECT o FROM OurFile o WHERE o.fileName = :fileName")})
public class OurFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "file_id")
    private Integer fileId;
    @Size(max = 60)
    @Column(name = "file_name")
    private String fileName;
    @Lob
    @Column(name = "my_file")
    private byte[] myFile;

    public OurFile() {
    }

    public OurFile(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getMyFile() {
        return myFile;
    }

    public void setMyFile(byte[] myFile) {
        this.myFile = myFile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileId != null ? fileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OurFile)) {
            return false;
        }
        OurFile other = (OurFile) object;
        if ((this.fileId == null && other.fileId != null) || (this.fileId != null && !this.fileId.equals(other.fileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OurFile[ fileId=" + fileId + " ]";
    }
    
}
