package com.example.demo.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loads")

public class Load {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loadId;
	
	@Column(name="loadingPoint")
	private String loadingPoint;
	
	@Column(name="unloadingPoint")
	private String unloadingPoint;
	
	@Column(name="productType")
	private String productType;
	
	@Column(name="truckType")
	private String truckType;
	
	@Column(name="noOfTrucks")
	private long noOfTrucks;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="shipperId")
	private String shipperId;
	
	@Column(name="date")
	private String date;
	
	
	
	public Load() {
		super();
	}

	public Load(String loadingPoint, String unloadingPoint, String productType, String truckType, long noOfTrucks,
			double weight, String comment, String shipperId, String date) {
		super();
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.noOfTrucks = noOfTrucks;
		this.weight = weight;
		this.comment = comment;
		this.shipperId = shipperId;
		this.date = date;
	}
		
	public String getLoadingPoint() {
		return loadingPoint;
	}
	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}
	public String getUnloadingPoint() {
		return unloadingPoint;
	}
	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public long getNoOfTrucks() {
		return noOfTrucks;
	}
	public void setNoOfTrucks(long noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getShipperId() {
		return shipperId;
	}
	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}

}
