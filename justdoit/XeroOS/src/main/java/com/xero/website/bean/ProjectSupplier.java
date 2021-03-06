package com.xero.website.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xero.core.bean.BaseEntity;

@Entity
@Table(name="tb_project_supplier")
public class ProjectSupplier extends BaseEntity{

	private static final long serialVersionUID = -6539682200922000750L;
	
	private Integer projectId ;
	
	private String supplierId ;
	
	private String supplierName ;
	
	private String supplierLanguage ;
	
	private String supplierEmail ;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierLanguage() {
		return supplierLanguage;
	}

	public void setSupplierLanguage(String supplierLanguage) {
		this.supplierLanguage = supplierLanguage;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	
	
	
	
}
