package org.acme.hospitals.solver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.acme.hospitals.solver.model.Doctor;
import org.acme.hospitals.solver.model.Hospital;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;

@PlanningSolution
public class PhysicianScheduleSolution implements Serializable, Solution<HardMediumSoftScore> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HardMediumSoftScore score;

	private List<Doctor> doctorList;
	private List<HospitalShiftAssignment> hospitalShiftAssignmentList;
	private List<Hospital> hospitalList;
	
	public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(doctorList);
        return facts;
	}

	public HardMediumSoftScore getScore() {
		return score;
	}

	public void setScore(HardMediumSoftScore score) {
		this.score = score;
	}

	@ValueRangeProvider(id = "doctorRange")
	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	@PlanningEntityCollectionProperty
	public List<HospitalShiftAssignment> getHospitalShiftAssignmentList() {
		return hospitalShiftAssignmentList;
	}

	public void setHospitalShiftAssignmentList(List<HospitalShiftAssignment> hospitalShiftAssignmentList) {
		this.hospitalShiftAssignmentList = hospitalShiftAssignmentList;
	}

	public List<Hospital> getHospitalList() {
		return hospitalList;
	}

	public void setHospitalList(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}
}
