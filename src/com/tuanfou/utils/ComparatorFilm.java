package com.tuanfou.utils;
import java.util.Comparator;

import com.tuanfou.dto.RecommendFilm;

/*
 * 用于对正在上映的团购电影依其想看人数进行排序
 */
@SuppressWarnings("rawtypes")
public class ComparatorFilm implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub]
		RecommendFilm film1 = (RecommendFilm)o1;
		RecommendFilm film2 = (RecommendFilm)o2;
		//比较filmNumber
		return film2.getUserNum()-film1.getUserNum();
	}
	
}
