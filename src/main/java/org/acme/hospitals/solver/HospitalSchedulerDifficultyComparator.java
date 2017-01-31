package org.acme.hospitals.solver;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;

import org.acme.hospitals.solver.model.DayOfWeek;
import org.apache.commons.lang3.builder.CompareToBuilder;

public class HospitalSchedulerDifficultyComparator  implements Comparator<HospitalShiftAssignment>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final HashMap<DayOfWeek, Object> countMap = new HashMap<DayOfWeek, Object>();


	public int compare(HospitalShiftAssignment o1, HospitalShiftAssignment o2) {
        return new CompareToBuilder()
                // TODO experiment with (aLatitude - bLatitude) % 10
        		.append(countMap.get(o1.getHospital().getDayOfWeek()), countMap.get(o2.getHospital().getDayOfWeek()))
                .append(o1.getId(), o2.getId())
                .append(o1.getShiftIndex(), o2.getShiftIndex())
                .toComparison();
	}

}
