package org.acme.hospitals.solver.model;

public class Shift {
	private String dateString;
	private String shiftdescription;
    private ShiftDate shiftDate;
    private ShiftType shiftType;
    private int index;
    
    private int requiredEmployeeSize;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getShiftdescription() {
		return shiftdescription;
	}

	public void setShiftdescription(String shiftdescription) {
		this.shiftdescription = shiftdescription;
	}

	public ShiftDate getShiftDate() {
		return shiftDate;
	}

	public void setShiftDate(ShiftDate shiftDate) {
		this.shiftDate = shiftDate;
	}

	public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getRequiredEmployeeSize() {
		return requiredEmployeeSize;
	}

	public void setRequiredEmployeeSize(int requiredEmployeeSize) {
		this.requiredEmployeeSize = requiredEmployeeSize;
	}

	@Override
	public String toString() {
		return "Shift [shiftDate=" + shiftDate + ", shiftType=" + shiftType + "]";
	}
    
    
}
