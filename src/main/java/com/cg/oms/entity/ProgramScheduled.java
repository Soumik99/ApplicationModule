package com.cg.oms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="program_scheduled")
public class ProgramScheduled {
	@Id
	private Integer scheduleId;

	public ProgramScheduled(Integer scheduleId) {
		super();
		this.scheduleId = scheduleId;
	}
	
	public ProgramScheduled() {}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
}
