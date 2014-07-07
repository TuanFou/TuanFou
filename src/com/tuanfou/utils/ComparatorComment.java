package com.tuanfou.utils;

import java.sql.Date;
import java.util.Comparator;

import com.tuanfou.pojo.Comment;

public class ComparatorComment implements Comparator<Comment> {

	@Override
	public int compare(Comment c1,Comment c2) {
		Date d1 = c1.getCreateTime();
		Date d2 = c2.getCreateTime();
		if(d1.before(d2))return 1;
		return -1;
	}
	
}
