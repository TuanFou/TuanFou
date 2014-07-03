package com.tuanfou.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.tuanfou.pojo.Tag;

public class Utils {
	public static List<String> getTagNameList(Set<Tag> tags){
		List<String> tagNameList = new ArrayList<String>();
		Iterator<Tag> it = tags.iterator();
		while(it.hasNext()){
			Tag tag = it.next();
			tagNameList.add(tag.getTagName());	
		}
		return tagNameList;
	}
}