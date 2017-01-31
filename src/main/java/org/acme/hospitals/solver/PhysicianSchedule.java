package org.acme.hospitals.solver;

public class PhysicianSchedule {
	private String hospitalId;
	private String hospitalShiftAssignment;
	private String dayId;
	private String doctorId;
	private String doctorName;
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalShiftAssignment() {
		return hospitalShiftAssignment;
	}
	public void setHospitalShiftAssignment(String hospitalShiftAssignment) {
		this.hospitalShiftAssignment = hospitalShiftAssignment;
	}
	public String getDayId() {
		return dayId;
	}
	public void setDayId(String dayId) {
		this.dayId = dayId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public PhysicianSchedule(String hospitalId, String hospitalShiftAssignment, String dayId, String doctorId) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalShiftAssignment = hospitalShiftAssignment;
		this.dayId = dayId;
		this.doctorId = doctorId;
	}
	
	public PhysicianSchedule() {
		super();
	}
	@Override
	public String toString() {
		return "PhysicianSchedule [hospitalId=" + hospitalId + ", hospitalShiftAssignment=" + hospitalShiftAssignment
				+ ", dayId=" + dayId + ", doctorId=" + doctorId + "]";
	}

}
