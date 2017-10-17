package com.cisc181.core;

import java.util.UUID;

public class Section {

	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomId;

	public Section() {

	}
	public Section(UUID courseID, UUID semesterID, UUID sectionID, int roomId) {

		CourseID = courseID;
		SemesterID = semesterID;
		SectionID = sectionID;
		RoomId = roomId;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public int getRoomId() {
		return RoomId;
	}

	public void setRoomId(int roomId) {
		RoomId = roomId;
	}
	
	
}
