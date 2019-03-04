package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Project;
import com.demo.model.Reports;
import com.demo.model.Timesheet;

@Transactional
@Repository
public class ReportDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Reports> getAllReportList() {
		Session ses = sessionFactory.getCurrentSession();
		List<Reports> list = ses.createQuery("From Reports").list();
		return list;
	}
	public boolean deleteReport(int idReports) {
		Session ses = sessionFactory.getCurrentSession();
		Reports delete = ses.get(Reports.class, idReports);
		ses.delete(delete);
		return true;
	}
	public Reports getReportsById(int idReports) {
		Session ses = sessionFactory.getCurrentSession();
		Reports reports = ses.get(Reports.class, idReports);
		return reports;
	}
	public boolean updateReport(Reports reports) {
		Session ses = sessionFactory.getCurrentSession();
		ses.update(reports);
		return true;
	}
	public boolean addReports(int idProject,int idTs,String calendarEffort,String reportEffort,String aprprovedEffort) {
		Session ses = sessionFactory.getCurrentSession();
		Project project = ses.get(Project.class, idProject);
		Timesheet timeSheet = ses.get(Timesheet.class, idTs);
		Reports reports = new Reports();
		reports.setProject(project);
		reports.setTimesheet(timeSheet);
		reports.setCalendarEffort(calendarEffort);
		reports.setReportEffort(reportEffort);
		reports.setAprprovedEffort(aprprovedEffort);
		ses.save(reports);
		return true;
	}
}
