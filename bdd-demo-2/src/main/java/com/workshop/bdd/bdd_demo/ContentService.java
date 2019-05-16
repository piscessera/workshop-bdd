package com.workshop.bdd.bdd_demo;

import java.util.Comparator;
import java.util.List;

public class ContentService {
	private ContentDao contentDao;

	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}

	public void view(RequestEntity requestEntity) {
		Content content = new Content();
		content.setMovieName(requestEntity.getMovieTitle());
		
		Content existingData = contentDao.select(content);
		if (existingData == null) {
			content.setViewStat(0);
			content = contentDao.add(content);
		}
		
		contentDao.updateViewStat(content);
	}

	public Content findMostPopular() {
		List<Content> list = contentDao.selectAll();
		list.sort(new Comparator<Content>() {
			public int compare(Content o1, Content o2) {
				if (o1.getViewStat() < o2.getViewStat()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		return list.get(0);
	}

}
