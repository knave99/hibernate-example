package com.fancythinking.reg.hibernate_example.bean;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table	(name="tbl_binary")
public class BinaryFile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7439269388206855162L;
	Long id;
	Byte[] bytes;
	String fileName;
	String fileType;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Byte[] getBytes() {
		return bytes;
	}	
	public void setBytes(Byte[] bytes) {
		this.bytes = bytes;
	}
	@Transient
	public void setBytes(byte[] bytes) {
		this.bytes = new Byte[bytes.length];
		for ( int x=0; x < bytes.length; x++ ) {
			this.bytes[x] = bytes[x];
		}
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
}
