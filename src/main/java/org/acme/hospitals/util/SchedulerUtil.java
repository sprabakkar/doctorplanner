package org.acme.hospitals.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.acme.hospitals.solver.HospitalShiftAssignment;
import org.acme.hospitals.solver.PhysicianSchedule;
import org.acme.hospitals.solver.PhysicianScheduleSolution;
import org.acme.hospitals.solver.model.DayOfWeek;
import org.acme.hospitals.solver.model.Doctor;
import org.acme.hospitals.solver.model.Hospital;
import org.acme.hospitals.solver.model.Location;
import org.acme.hospitals.solver.model.Shift;

import com.thoughtworks.xstream.XStream;

public class SchedulerUtil {
	public static void main(String[] args) {
		XStream xStream = new XStream();
		List<Doctor> dlist = createDoctors();
		xStream.alias("Doctor", Doctor.class);
		System.out.println(xStream.toXML(dlist));
		
		List<HospitalShiftAssignment> hsalist = createHospitalShiftAssignment();
		xStream.alias("HospitalShiftAssignment", HospitalShiftAssignment.class);
		System.out.println(xStream.toXML(hsalist));
	}
	public static PhysicianScheduleSolution createPhysicianScheduleSolution() {
		PhysicianScheduleSolution unsolvedCleaningProblem = new PhysicianScheduleSolution();
		
		List<Doctor> dlist = createDoctors();
		List<HospitalShiftAssignment> hsalist = createHospitalShiftAssignment();

		unsolvedCleaningProblem.setDoctorList(dlist);
		unsolvedCleaningProblem.setHospitalShiftAssignmentList(hsalist);

		return unsolvedCleaningProblem;

	}
	public static List<Doctor> createDoctors() {
		// Random random = new Random(System.currentTimeMillis());
		List<Doctor> doctorsList = new ArrayList<Doctor>();
		
		Doctor doctor1 = new Doctor(new Long(1), new DayOfWeek("Monday"), new Location(1), "Mary");
		Doctor doctor2 = new Doctor(new Long(2), new DayOfWeek("Tuesday"), new Location(1), "Kim");
		Doctor doctor3 = new Doctor(new Long(3), new DayOfWeek("Wednesday"), new Location(1), "Ted");
		Doctor doctor4 = new Doctor(new Long(4), new DayOfWeek("Wednesday"), new Location(1), "Ganesh");
		Doctor doctor5 = new Doctor(new Long(5), new DayOfWeek("Wednesday"), new Location(1), "Lee");
		Doctor doctor6 = new Doctor(new Long(6), new DayOfWeek("Thursday"), new Location(1), "Marc");
		Doctor doctor7 = new Doctor(new Long(7), new DayOfWeek("Friday"), new Location(1), "Sara");
		Doctor doctor8 = new Doctor(new Long(8), new DayOfWeek("monday"), new Location(1), "Stanley Adam");
		
		
		doctorsList.add(doctor1);
		doctorsList.add(doctor2);
		doctorsList.add(doctor3);
		doctorsList.add(doctor4);
		doctorsList.add(doctor5);
		doctorsList.add(doctor6);
		doctorsList.add(doctor7);
		doctorsList.add(doctor8);
		System.out.println("Size of the doctors list is ::: "+doctorsList.size());

		return doctorsList;
	}

	public static List<HospitalShiftAssignment> createHospitalShiftAssignment() {
		// Random random = new Random(System.currentTimeMillis());
		List<HospitalShiftAssignment> hospitalShiftAssignmentList = new ArrayList<HospitalShiftAssignment>();
		
		
		Hospital hospital1 = new Hospital(new Long(1), "Virginia Hospital", new DayOfWeek(new Long(11),"Monday"));
		Location location1 = new Location(1);
		hospital1.setHospitalLocation(location1);
		
		HospitalShiftAssignment hospitalShiftAssignment11 = new HospitalShiftAssignment(new Long(11),hospital1, 1);
		HospitalShiftAssignment hospitalShiftAssignment12 = new HospitalShiftAssignment(new Long(12),hospital1, 2);
		HospitalShiftAssignment hospitalShiftAssignment13 = new HospitalShiftAssignment(new Long(13),hospital1, 3);


		Hospital hospital12 = new Hospital(new Long(2), "Virginia Hospital", new DayOfWeek(new Long(12), "Tuesday"));
		Location location12 = new Location(1);
		hospital12.setHospitalLocation(location12);
		HospitalShiftAssignment hospitalShiftAssignment111 = new HospitalShiftAssignment(new Long(111),hospital12, 1);
		HospitalShiftAssignment hospitalShiftAssignment122 = new HospitalShiftAssignment(new Long(122),hospital12, 2);
		HospitalShiftAssignment hospitalShiftAssignment133 = new HospitalShiftAssignment(new Long(133),hospital12, 3);		
		

		Hospital hospital123 = new Hospital(new Long(3), "Virginia Hospital", new DayOfWeek(new Long(123), "Wednesday"));
		Location location123 = new Location(1);
		hospital123.setHospitalLocation(location123);
		HospitalShiftAssignment hospitalShiftAssignment1113 = new HospitalShiftAssignment(new Long(1113),hospital123, 1);
		HospitalShiftAssignment hospitalShiftAssignment1223 = new HospitalShiftAssignment(new Long(1223),hospital123, 2);
		HospitalShiftAssignment hospitalShiftAssignment1333 = new HospitalShiftAssignment(new Long(1333),hospital123, 3);		
		

		Hospital hospital1234 = new Hospital(new Long(4), "Virginia Hospital", new DayOfWeek(new Long(1234), "Thursday"));
		Location location1234 = new Location(1);
		hospital1234.setHospitalLocation(location1234);
		HospitalShiftAssignment hospitalShiftAssignment11134 = new HospitalShiftAssignment(new Long(11134),hospital1234, 1);
		HospitalShiftAssignment hospitalShiftAssignment12234 = new HospitalShiftAssignment(new Long(12234),hospital1234, 2);
		HospitalShiftAssignment hospitalShiftAssignment13334 = new HospitalShiftAssignment(new Long(13334),hospital1234, 3);		
		
		Hospital hospital12345 = new Hospital(new Long(5), "Virginia Hospital", new DayOfWeek(new Long(12345), "Friday"));
		Location location12345 = new Location(1);
		hospital12345.setHospitalLocation(location12345);
		HospitalShiftAssignment hospitalShiftAssignment111345 = new HospitalShiftAssignment(new Long(1115),hospital12345, 1);
		HospitalShiftAssignment hospitalShiftAssignment122345 = new HospitalShiftAssignment(new Long(1225),hospital12345, 2);
		HospitalShiftAssignment hospitalShiftAssignment133345 = new HospitalShiftAssignment(new Long(1335),hospital12345, 3);			
	    //////////////////////
		//////////////////

		Hospital hospital19 = new Hospital(new Long(6), "University of Virginia Medical Center", new DayOfWeek(new Long(119), "Monday"));
		Location location19 = new Location(1);
		location19.setDistance(1);
		hospital19.setHospitalLocation(location19);
		HospitalShiftAssignment hospitalShiftAssignment119 = new HospitalShiftAssignment(new Long(119),hospital19, 1);
		HospitalShiftAssignment hospitalShiftAssignment129 = new HospitalShiftAssignment(new Long(129),hospital19, 2);
		HospitalShiftAssignment hospitalShiftAssignment139 = new HospitalShiftAssignment(new Long(139),hospital19, 3);
		
		Hospital hospital128 = new Hospital(new Long(7), "University of Virginia Medical Center", new DayOfWeek(new Long(128), "Tuesday"));
		Location location128 = new Location(1);
		hospital128.setHospitalLocation(location128);
		HospitalShiftAssignment hospitalShiftAssignment118 = new HospitalShiftAssignment(new Long(118),hospital128, 1);
		HospitalShiftAssignment hospitalShiftAssignment128 = new HospitalShiftAssignment(new Long(128),hospital128, 2);
		HospitalShiftAssignment hospitalShiftAssignment138 = new HospitalShiftAssignment(new Long(138),hospital128, 3);		
		

		Hospital hospital127 = new Hospital(new Long(8), "University of Virginia Medical Center", new DayOfWeek(new Long(127), "Wednesday"));
		Location location127 = new Location(1);
		hospital127.setHospitalLocation(location127);
		HospitalShiftAssignment hospitalShiftAssignment117 = new HospitalShiftAssignment(new Long(117),hospital127, 1);
		HospitalShiftAssignment hospitalShiftAssignment127 = new HospitalShiftAssignment(new Long(127),hospital127, 2);
		HospitalShiftAssignment hospitalShiftAssignment137 = new HospitalShiftAssignment(new Long(137),hospital127, 3);		
		

		Hospital hospital126 = new Hospital(new Long(9), "University of Virginia Medical Center", new DayOfWeek(new Long(126), "Thursday"));
		Location location126 = new Location(1);
		hospital126.setHospitalLocation(location126);
		HospitalShiftAssignment hospitalShiftAssignment116 = new HospitalShiftAssignment(new Long(116),hospital126, 1);
		HospitalShiftAssignment hospitalShiftAssignment126 = new HospitalShiftAssignment(new Long(126),hospital126, 2);
		HospitalShiftAssignment hospitalShiftAssignment136 = new HospitalShiftAssignment(new Long(136),hospital126, 3);		
		
		Hospital hospital125 = new Hospital(new Long(10), "University of Virginia Medical Center", new DayOfWeek(new Long(125), "Friday"));
		Location location125 = new Location(1);
		hospital125.setHospitalLocation(location125);
		HospitalShiftAssignment hospitalShiftAssignment115 = new HospitalShiftAssignment(new Long(111),hospital125, 1);
		HospitalShiftAssignment hospitalShiftAssignment125 = new HospitalShiftAssignment(new Long(122),hospital125, 2);
		HospitalShiftAssignment hospitalShiftAssignment135 = new HospitalShiftAssignment(new Long(133),hospital125, 3);
		///////////////////
	
		
		hospitalShiftAssignmentList.add(hospitalShiftAssignment11);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment12);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment13);
		
		hospitalShiftAssignmentList.add(hospitalShiftAssignment111);
		//hospitalShiftAssignmentList.add(hospitalShiftAssignment122);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment133);
		
		hospitalShiftAssignmentList.add(hospitalShiftAssignment1113);
		//hospitalShiftAssignmentList.add(hospitalShiftAssignment1223);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment1333);

		hospitalShiftAssignmentList.add(hospitalShiftAssignment11134);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment12234);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment13334);
	
		hospitalShiftAssignmentList.add(hospitalShiftAssignment111345);
		//hospitalShiftAssignmentList.add(hospitalShiftAssignment122345);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment133345);
		
		hospitalShiftAssignmentList.add(hospitalShiftAssignment119);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment129);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment139);
		
		hospitalShiftAssignmentList.add(hospitalShiftAssignment118);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment128);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment138);
		
		hospitalShiftAssignmentList.add(hospitalShiftAssignment117);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment127);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment137);
		
		hospitalShiftAssignmentList.add(hospitalShiftAssignment116);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment126);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment136);
		
		hospitalShiftAssignmentList.add(hospitalShiftAssignment115);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment125);
		hospitalShiftAssignmentList.add(hospitalShiftAssignment135);


		return hospitalShiftAssignmentList;
	}
/*	public static void displayB(List<PhysicianSchedule> listPhysicianSchedule){
		
		PhysicianSchedule finalPhysicianSchedule = null;
		Set<Object> hospitalSet = new HashSet<Object>();
		Set<Object> daySet = new HashSet<Object>();
		
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
								+ finalPhysicianSchedule.getDoctorId()+ " on " + finalPhysicianSchedule.getDayId());
			} else if (hospitalSet.contains(finalPhysicianSchedule.getHospitalId())) {
				System.out.println(
						"Shift " + finalPhysicianSchedule.getHospitalShiftAssignment() + " assigned to Doctor "
								+ finalPhysicianSchedule.getDoctorId()+ " on " + finalPhysicianSchedule.getDayId());
			}
		}

	}*/
	public static void displaySolution(List<PhysicianSchedule> listPhysicianSchedule){

		Set<String> hospitalSet = new LinkedHashSet<String>();
		Set<String> daySet = new LinkedHashSet<String>();
		
		System.out.println("listPhysicianSchedule ::: " + listPhysicianSchedule.size());
		
		hospitalSet =  getHospitalSet(listPhysicianSchedule);
		daySet = getDaySet(listPhysicianSchedule);
		for(String hospitalId: hospitalSet){
			System.out.println("============================================================");
			System.out.println("Hospital Id is ::: " +hospitalId);
			System.out.println("============================================================");
			for(String day:daySet){
				System.out.println("*****   Day ::: " +day+"   *****");
				for(PhysicianSchedule physicianSchedule: listPhysicianSchedule){
					if((hospitalId.equals(physicianSchedule.getHospitalId()) && (day.equals(physicianSchedule.getDayId())))){
						System.out.println("Shift " + physicianSchedule.getHospitalShiftAssignment() + " assigned to Doctor "+ physicianSchedule.getDoctorName()+" (" +physicianSchedule.getDoctorId()+")");
					}
				}
				System.out.println("**************");
			}
		}
	}
	public static Set<String> getHospitalSet(List<PhysicianSchedule> listPhysicianSchedule){

		Set<String> hospitalSet = new LinkedHashSet<String>();
		
		System.out.println("listPhysicianSchedule ::: " + listPhysicianSchedule.size());
		for(PhysicianSchedule physicianSchedule: listPhysicianSchedule){
			hospitalSet.add(physicianSchedule.getHospitalId());
		}
		return hospitalSet;
	}
	public static Set<String> getDaySet(List<PhysicianSchedule> listPhysicianSchedule){

		Set<String> daySet = new LinkedHashSet<String>();

		for(PhysicianSchedule physicianSchedule: listPhysicianSchedule){
			daySet.add(physicianSchedule.getDayId());
		}
		return daySet;
	}
	public static String toDisplayString(PhysicianScheduleSolution solvedSolution) {
		StringBuilder displayString = new StringBuilder();
		for (HospitalShiftAssignment hospitalShiftAssignment : solvedSolution.getHospitalShiftAssignmentList()) {
			Doctor doctor = hospitalShiftAssignment.getDoctor();
			displayString.append("  Hospital:::").append(hospitalShiftAssignment.getHospital().getId()).append(" -> ")
			        .append("  Day:::").append(hospitalShiftAssignment.getHospital().getDayOfWeek().getDayId()).append(" -> ")
					.append("  Shift:::").append(hospitalShiftAssignment.getShiftIndex()).append(" -> ")
					.append("  Doctor:::").append(doctor == null ? null : doctor.getName()).append("\n");
		}
		return displayString.toString();
	}
	public static void createShiftList(){
		Shift shift = new Shift();
		shift.setDateString("2017-01-31");
		shift.setShiftdescription("E");
	}
	
}
