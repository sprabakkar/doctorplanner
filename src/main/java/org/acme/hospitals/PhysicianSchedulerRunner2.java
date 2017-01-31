package org.acme.hospitals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.acme.hospitals.solver.HospitalShiftAssignment;
import org.acme.hospitals.solver.PhysicianSchedule;
import org.acme.hospitals.solver.PhysicianScheduleSolution;
import org.acme.hospitals.solver.model.Doctor;
import org.acme.hospitals.util.SchedulerUtil;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.event.BestSolutionChangedEvent;
import org.optaplanner.core.api.solver.event.SolverEventListener;

import com.thoughtworks.xstream.XStream;

public class PhysicianSchedulerRunner2 {

	public static final String SOLVER_CONFIG = "org/acme/hospitals/physicianSchedulerSolverConfig.xml";

	public static void main(String[] args) {
		
		XStream xStream = new XStream();
		
		//Create Solver from scheduler config
		Solver<PhysicianScheduleSolution> solver = new PhysicianSchedulerRunner2().createSolver();
		
		//Create unsolved planning problem
		PhysicianScheduleSolution unsolvedPhysicianScheduleSolution = SchedulerUtil.createPhysicianScheduleSolution();
		
		//input the unsolved planning problem into solver to get the solved planning solution
		solver.solve(unsolvedPhysicianScheduleSolution);
		
		
		//get the best planning solution from the solver
		PhysicianScheduleSolution solvedPhysicianScheduleSolution = solver.getBestSolution();
		System.out.println("\nSolved Physician Scheduling Problem :\n");
		
		System.out.println(toDisplayString(solvedPhysicianScheduleSolution));
		
		
		List<PhysicianSchedule> planningSolutionResponseObj = getPlanningSolutionObject(solvedPhysicianScheduleSolution);
		System.out.println(planningSolutionResponseObj.size());
		

		//xStream.alias("PhysicianSchedule", PhysicianSchedule.class);
		//System.out.println(xStream.toXML(solvedPhysicianScheduleSolution));
	}


	@SuppressWarnings("unchecked")
	protected Solver<PhysicianScheduleSolution> createSolver() {
		SolverFactory<PhysicianScheduleSolution> solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
		Solver<PhysicianScheduleSolution> solver = solverFactory.buildSolver();
		solver.addEventListener(new SolverEventListener() {
			public void bestSolutionChanged(BestSolutionChangedEvent event) {
				PhysicianScheduleSolution bestSolution = (PhysicianScheduleSolution) event.getNewBestSolution();
			}
		});
		return solver;
	}

	public static String toDisplayString(PhysicianScheduleSolution solvedSolution) {
		StringBuilder displayString = new StringBuilder();
		String hospitaltype;
		for (HospitalShiftAssignment hospitalShiftAssignment : solvedSolution.getHospitalShiftAssignmentList()) {
			Doctor doctor = hospitalShiftAssignment.getDoctor();
			displayString.append("  Hospital:::").append(hospitalShiftAssignment.getHospital().getId()).append(" -> ")
			        .append("  Day:::").append(hospitalShiftAssignment.getHospital().getDayOfWeek().getDayId()).append(" -> ")
					.append("  Shift:::").append(hospitalShiftAssignment.getShiftIndex()).append(" -> ")
					.append("  Doctor:::").append(doctor == null ? null : doctor.getId()).append("\n");
		}
		return displayString.toString();
	}

	public static List<PhysicianSchedule> getPlanningSolutionObject(PhysicianScheduleSolution solvedSolution) {
		PhysicianSchedule finalPhysicianSchedule = null;
		List<HospitalShiftAssignment> hospitalShiftAssignmentList = solvedSolution.getHospitalShiftAssignmentList();

		List<PhysicianSchedule> listPhysicianSchedule = new ArrayList<PhysicianSchedule>();
		Set<Object> hospitalSet = new HashSet<Object>();
		Set<Object> daySet = new HashSet<Object>();

		for (Iterator<HospitalShiftAssignment> iterator = hospitalShiftAssignmentList.iterator(); iterator.hasNext();) {
			finalPhysicianSchedule = new PhysicianSchedule();
			HospitalShiftAssignment hospitalShiftAssignment = iterator.next();
			finalPhysicianSchedule.setHospitalId(hospitalShiftAssignment.getHospital().getId());
			finalPhysicianSchedule.setHospitalShiftAssignment(String.valueOf(hospitalShiftAssignment.getShiftIndex()));
			finalPhysicianSchedule.setDayId(hospitalShiftAssignment.getHospital().getDayOfWeek().getDayId());
			Doctor doctor = hospitalShiftAssignment.getDoctor();
			Long doctorId = (doctor == null ? null : doctor.getId());
			if (doctorId != null) {
				finalPhysicianSchedule.setDoctorId(String.valueOf(doctor.getId()));
			} else {
				finalPhysicianSchedule.setDoctorId("No Doctor Available");
			}
			listPhysicianSchedule.add(finalPhysicianSchedule);
		}
		System.out.println("listPhysicianSchedule ::: " + listPhysicianSchedule.size());
		for (Iterator<PhysicianSchedule> iterator = listPhysicianSchedule.iterator(); iterator.hasNext();) {
			finalPhysicianSchedule = iterator.next();
			//System.out.println(finalPhysicianSchedule.toString());
			if (!hospitalSet.contains(finalPhysicianSchedule.getHospitalId())) {
				hospitalSet.add(finalPhysicianSchedule.getHospitalId());
				System.out.println("============================================================");
				System.out.println("Hospital Id is ::: " + finalPhysicianSchedule.getHospitalId());
				if (!daySet.contains(finalPhysicianSchedule.getDayId())) {
					daySet.add(finalPhysicianSchedule.getDayId());
					System.out.println("Day is ::: " + finalPhysicianSchedule.getDayId());
				}
				System.out.println(
						"Shift " + finalPhysicianSchedule.getHospitalShiftAssignment() + " assigned to Doctor "
								+ finalPhysicianSchedule.getDoctorId()); //+ " on " + finalPhysicianSchedule.getDayId());
			} else if (hospitalSet.contains(finalPhysicianSchedule.getHospitalId())) {
				System.out.println(
						"Shift " + finalPhysicianSchedule.getHospitalShiftAssignment() + " assigned to Doctor "
								+ finalPhysicianSchedule.getDoctorId());// + " on " + finalPhysicianSchedule.getDayId());
			}
		}
		return listPhysicianSchedule;
	}

}
