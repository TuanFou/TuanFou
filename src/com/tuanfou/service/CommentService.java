package com.tuanfou.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tuanfou.dao.CommentDao;
import com.tuanfou.dto.CommentInfo;

public class CommentService {

	/**
	 * 
	 * @param groupFilmId  
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<CommentInfo> getCommentList(int groupFilmId,int page,int pageSize){
		CommentDao commentDao = new CommentDao();
		List<CommentInfo> commentList = commentDao.getCommentInfo(groupFilmId);
		List<CommentInfo> comment = new ArrayList<CommentInfo>();
		Iterator<CommentInfo> it = commentList.iterator();
		for(int i = 1;i <= commentList.size(); i++){
			CommentInfo commentInfo = it.next();
			if((i > (page-1)*pageSize)&&(i <= page*pageSize))
				comment.add(commentInfo);
			if(i > page*pageSize)
				break;		
		}
		return comment;
	}
}
