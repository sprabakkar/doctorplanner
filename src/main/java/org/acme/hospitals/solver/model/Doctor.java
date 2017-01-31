package org.acme.hospitals.solver.model;

public class Doctor {

	private Long id= 0L;
	private DayOfWeek dayOfWeek;
	private Location doctorLocation;
	private String name;
	
	public Doctor(Long id, DayOfWeek dayOfWeek, Location doctorLocation) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.doctorLocation = doctorLocation;
	}
	
	public Doctor(Long id, DayOfWeek dayOfWeek, Location doctorLocation, String name) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.doctorLocation = doctorLocation;
		this.name = name;
	}

	public Doctor(Long id, DayOfWeek dayOfWeek) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Location getDoctorLocation() {
		return doctorLocation;
	}
	public void setDoctorLocation(Location doctorLocation) {
		this.doctorLocation = doctorLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
