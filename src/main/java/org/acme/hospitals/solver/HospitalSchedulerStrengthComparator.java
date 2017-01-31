package org.acme.hospitals.solver;

import java.io.Serializable;
import java.util.Comparator;

import org.acme.hospitals.solver.model.Doctor;
import org.apache.commons.lang3.builder.CompareToBuilder;

public class HospitalSchedulerStrengthComparator implements Comparator<Doctor>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public int compare(Doctor o1, Doctor o2) {
        return new CompareToBuilder()
                .append(o1.getId(), o2.getId())
                .toComparison();
	}

}
