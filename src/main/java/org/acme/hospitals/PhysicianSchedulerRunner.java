package org.acme.hospitals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public class PhysicianSchedulerRunner {

	public static final String SOLVER_CONFIG = "org/acme/hospitals/physicianSchedulerSolverConfig.xml";

	public static void main(String[] args) {
		
		XStream xStream = new XStream();
		
		//Create Solver from scheduler config
		Solver<PhysicianScheduleSolution> solver = new PhysicianSchedulerRunner().createSolver();
		
		//Create unsolved planning problem
		PhysicianScheduleSolution unsolvedPhysicianScheduleSolution = SchedulerUtil.createPhysicianScheduleSolution();
		
		//input the unsolved planning problem into solver to get the solved planning solution
		solver.solve(unsolvedPhysicianScheduleSolution);
		
		//get the best planning solution from the solver
		PhysicianScheduleSolution solvedPhysicianScheduleSolution = solver.getBestSolution();
		System.out.println("\nSolved Physician Scheduling Problem :\n");
		
		//System.out.println(toDisplayString(solvedPhysicianScheduleSolution));
		
		List<PhysicianSchedule> planningSolutionResponseObj = getPlanningSolutionObject(solvedPhysicianScheduleSolution);
		//Set set = SchedulerUtil.getHospitalSet(planningSolutionResponseObj);
		SchedulerUtil.displaySolution(planningSolutionResponseObj);
		
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

	public static List<PhysicianSchedule> getPlanningSolutionObject(PhysicianScheduleSolution solvedSolution) {
		PhysicianSchedule finalPhysicianSchedule = null;
		List<HospitalShiftAssignment> hospitalShiftAssignmentList = solvedSolution.getHospitalShiftAssignmentList();

		List<PhysicianSchedule> listPhysicianSchedule = new ArrayList<PhysicianSchedule>();

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
				finalPhysicianSchedule.setDoctorName(doctor.getName());
			} else {
				finalPhysicianSchedule.setDoctorId("No Doctor Available");
			}
			listPhysicianSchedule.add(finalPhysicianSchedule);
		}
		return listPhysicianSchedule;
	}
}
