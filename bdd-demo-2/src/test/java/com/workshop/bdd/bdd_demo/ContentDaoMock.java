package com.workshop.bdd.bdd_demo;

import java.util.ArrayList;
import java.util.List;

public class ContentDaoMock implements ContentDao {
	private List<Content> list = new ArrayList<Content>();
	
	public ContentDaoMock() {
		
	}

	public Content add(Content content) {
		// insert data into database ....
		list.add(content);
		return content;
	}

	public Content updateViewStat(Content object) {
		// select content
		Content content = this.select(object);
		// update content view stat
		if (content == null) return null;
		
		content.setViewStat(content.getViewStat()+1);
		
		return content;
	}
	
	public Content select(Content object) {
		for (Content item : list) {
			if (item.getMovieName().equals(object.getMovieName())) {
				return item;
			}
		}
		return null;
	}
	
	public List<Content> selectAll() {
		return list;
	}

}
