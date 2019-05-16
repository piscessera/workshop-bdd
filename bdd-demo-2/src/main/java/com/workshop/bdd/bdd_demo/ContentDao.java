package com.workshop.bdd.bdd_demo;

import java.util.ArrayList;
import java.util.List;

public interface ContentDao {

	public Content add(Content content);

	public Content updateViewStat(Content object);
	
	public Content select(Content object);
	
	public List<Content> selectAll();

}
