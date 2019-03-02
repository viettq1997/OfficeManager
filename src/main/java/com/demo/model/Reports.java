package com.demo.model;
// Generated Mar 2, 2019 4:10:03 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Reports generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "REPORTS", schema = "DB_OFFICE_MANAGER")
public class Reports implements java.io.Serializable {

	private int idReport;
	private Project project;
	private Timesheet timesheet;
	private String calendarEffort;
	private String reportEffort;
	private String aprprovedEffort;

	public Reports() {
	}

	public Reports(int idReport, Project project, Timesheet timesheet) {
		this.idReport = idReport;
		this.project = project;
		this.timesheet = timesheet;
	}

	public Reports(int idReport, Project project, Timesheet timesheet, String calendarEffort,
			String reportEffort, String aprprovedEffort) {
		this.idReport = idReport;
		this.project = project;
		this.timesheet = timesheet;
		this.calendarEffort = calendarEffort;
		this.reportEffort = reportEffort;
		this.aprprovedEffort = aprprovedEffort;
	}

	@Id

	@Column(name = "ID_REPORT", unique = true, nullable = false, precision = 22, scale = 0)
	public int getIdReport() {
		return this.idReport;
	}

	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PROJECT", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TS", nullable = false)
	public Timesheet getTimesheet() {
		return this.timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}

	@Column(name = "CALENDAR_EFFORT", length = 225)
	public String getCalendarEffort() {
		return this.calendarEffort;
	}

	public void setCalendarEffort(String calendarEffort) {
		this.calendarEffort = calendarEffort;
	}

	@Column(name = "REPORT_EFFORT", length = 225)
	public String getReportEffort() {
		return this.reportEffort;
	}

	public void setReportEffort(String reportEffort) {
		this.reportEffort = reportEffort;
	}

	@Column(name = "APRPROVED_EFFORT", length = 225)
	public String getAprprovedEffort() {
		return this.aprprovedEffort;
	}

	public void setAprprovedEffort(String aprprovedEffort) {
		this.aprprovedEffort = aprprovedEffort;
	}

}
