package org.acme.hospitals.solver.model;

public class Hospital {

	private Long hospitalId;
	private String id;
	private DayOfWeek dayOfWeek;
	private Location hospitalLocation;
	
	
	public Hospital(Long hospitalId, DayOfWeek dayOfWeek, Location hospitalLocation) {
		super();
		this.hospitalId = hospitalId;
		this.dayOfWeek = dayOfWeek;
		this.hospitalLocation = hospitalLocation;
	}
	
	public Hospital(String id, DayOfWeek dayOfWeek, Location hospitalLocation) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.hospitalLocation = hospitalLocation;
	}

	public Hospital(Long hospitalId, String id, DayOfWeek dayOfWeek) {
		super();
		this.hospitalId = hospitalId;
		this.id = id;
		this.dayOfWeek = dayOfWeek;
	}

	public Hospital() {
		super();
	}

	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Location getHospitalLocation() {
		return hospitalLocation;
	}
	public void setHospitalLocation(Location hospitalLocation) {
		this.hospitalLocation = hospitalLocation;
	}


}
