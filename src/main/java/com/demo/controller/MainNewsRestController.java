package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.NewsDAO;
import com.demo.model.News;

@RestController
public class MainNewsRestController {
	@Autowired
	NewsDAO newsDao;

	@RequestMapping(value = "/news", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<News> getAllNews() {
		List<News> list = newsDao.getAllNews();
		return list;
	}

	@RequestMapping(value = "/news/add/{title}/{image}/{dates}/{contentt}/{id_staff}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addNewNews(@PathVariable("title") String title, @PathVariable("image") String image,
			@PathVariable("dates") String dates, @PathVariable("contentt") String contentt,
			@PathVariable("id_staff") int id_staff) {
		newsDao.addNewNews(title, image, dates, contentt, id_staff);

	}
}
