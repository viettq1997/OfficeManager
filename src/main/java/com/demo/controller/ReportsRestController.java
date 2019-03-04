package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.ReportDAO;
import com.demo.model.Reports;

@RestController
public class ReportsRestController {
	@Autowired
	ReportDAO reportsDAO;

	@RequestMapping(value = "/reports", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reports> getAllNews() {
		List<Reports> list = reportsDAO.getAllReportList();
		return list;
	}

	@RequestMapping(value = "/reports/delete/{idReports}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteReport(@PathVariable("idReports") int idReports) {
		reportsDAO.deleteReport(idReports);
	}

	@RequestMapping(value = "/reports/getReportsById/{idReports}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reports getReportsById(@PathVariable("idReports") int idReports) {
		return reportsDAO.getReportsById(idReports);
	}

	@RequestMapping(value = "/reports/update/{idReports}/{}")
	public void updateReports() {

	}

	@RequestMapping(value = "reports/add/{idProject}/{idTs}/{calendarEffort}/{reportEffort}/{approvedEffort}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addReports(@PathVariable("idProject") int idProject, @PathVariable("idTs") int idTs,
			@PathVariable("calendarEffort") String calendarEffort, @PathVariable("reportEffort") String reportEffort,
			@PathVariable("approvedEffort") String approvedEffort) {
		reportsDAO.addReports(idProject, idTs, calendarEffort, reportEffort, approvedEffort);
	}
//	@RequestMapping(value = "reports/add", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void addReports() {
//		reportsDAO.addReports();
//	}

//	@RequestMapping(value = "/news/add/{title}/{image}/{dates}/{contentt}/{id_staff}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void addNewNews(@PathVariable("title") String title, @PathVariable("image") String image,
//			@PathVariable("dates") String dates, @PathVariable("contentt") String contentt,
//			@PathVariable("id_staff") int id_staff) {
//		reportsDAO.addNewNews(title, image, dates, contentt, id_staff);
//
//	}
}
