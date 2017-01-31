package org.acme.hospitals.solver;

import org.acme.hospitals.solver.model.DayOfWeek;
import org.acme.hospitals.solver.model.Doctor;
import org.acme.hospitals.solver.model.Hospital;
import org.acme.hospitals.solver.model.Shift;
import org.acme.hospitals.solver.model.ShiftDate;
import org.acme.hospitals.solver.model.ShiftType;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;


@PlanningEntity(difficultyComparatorClass = HospitalSchedulerDifficultyComparator.class)
public class HospitalShiftAssignment {

	/**
	 * 
	 */
	private Long id;
	private Hospital hospital;
	private int shiftIndex;
	private Shift shift;
	//planning variable
	private Doctor doctor;

	
	public HospitalShiftAssignment() {
		super();
	}


	public HospitalShiftAssignment(Long id, Hospital hospital, int shiftIndex) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.shiftIndex = shiftIndex;
	}


	public HospitalShiftAssignment(Long id, Hospital hospital, int shiftIndex, Shift shift) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.shiftIndex = shiftIndex;
		this.shift = shift;
	}


	public HospitalShiftAssignment(Long id, Hospital hospital, int shiftIndex, Doctor doctor) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.shiftIndex = shiftIndex;
		this.doctor = doctor;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Hospital getHospital() {
		return hospital;
	}


	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}


	public Shift getShift() {
		return shift;
	}


	public void setShift(Shift shift) {
		this.shift = shift;
	}


	public int getShiftIndex() {
		return shiftIndex;
	}


	public void setShiftIndex(int shiftIndex) {
		this.shiftIndex = shiftIndex;
	}

	@PlanningVariable(valueRangeProviderRefs = "doctorRange", nullable = true)
	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int distanceFromDoctorToHospital(){
		return hospital.getHospitalLocation().getDistance();	
	}
    // ************************************************************************
    // Complex methods
    // ************************************************************************
    public ShiftDate getShiftDate() {
        return shift.getShiftDate();
    }

    public ShiftType getShiftType() {
        return shift.getShiftType();
    }

    public int getShiftDateDayIndex() {
        return shift.getShiftDate().getDayIndex();
    }

    public DayOfWeek getShiftDateDayOfWeek() {
        return shift.getShiftDate().getDayOfWeek();
    }
/*
    public Contract getContract() {
        if (employee == null) {
            return null;
        }
        return employee.getContract();
    }

    public boolean isWeekend() {
        if (employee == null) {
            return false;
        }
        WeekendDefinition weekendDefinition = employee.getContract().getWeekendDefinition();
        DayOfWeek dayOfWeek = shift.getShiftDate().getDayOfWeek();
        return weekendDefinition.isWeekend(dayOfWeek);
    }

    public int getWeekendSundayIndex() {
        return shift.getShiftDate().getWeekendSundayIndex();
    }*/

/*    @Override
    public String toString() {
        return shift.toString();
    }*/	
}
