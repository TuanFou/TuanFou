/**
 * @author yogiman
 */
package com.tuanfou.utils;

import java.sql.Date;
import java.util.Comparator;

import com.tuanfou.dto.MyCommentInfo;

public class ComparatorMyCommentInfo implements Comparator<MyCommentInfo>{
	@Override
	public int compare(MyCommentInfo c1,MyCommentInfo c2) {
		Date d1 = c1.getTime();
		Date d2 = c2.getTime();
		if(d1.after(d2))return 1;
		return -1;
	}

}
