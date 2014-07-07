package com.tuanfou.utils;

import java.sql.Date;
import java.util.Comparator;

import com.tuanfou.dto.CommentInfo;

/**
 * This class is an implementation of comparator
 * @author yogiman
 * 
 */
public class ComparatorCommentInfo implements Comparator<CommentInfo>{
	@Override
	public int compare(CommentInfo c1,CommentInfo c2){
		Date d1 = c1.getDate();
		Date d2 = c2.getDate();
		if(d1.before(d2))
			return 1;
		return -1;
	}
}
