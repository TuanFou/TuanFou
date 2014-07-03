package com.tuanfou.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tuanfou.dao.CommentDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.CommentInfo;
import com.tuanfou.pojo.Comment;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.User;

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
	/**
	 * 
	 * @param groupFilmId  团购电影ID
	 * @param userId   评论用户Id
	 * @param content  评论内容
	 * @param star     评论星级
	 * @return boolean 评论是否成功
	 */
	public boolean postComment(int groupFilmId,int userId,String content,int star){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		UserDao userDao = new UserDao();
		CommentDao commentDao = new CommentDao();
		Comment comment = new Comment();
		
		comment.setContent(content);
		comment.setId(star);
		Date date = new Date(new java.util.Date().getTime());
		comment.setCreateTime(date);
		GroupFilm groupFilm = groupFilmDao.getGroupFilm(groupFilmId);
		comment.setGroupFilm(groupFilm);
		User user = userDao.getUser(userId);
		comment.setUser(user);
		
		return commentDao.addComment(comment);
		
	}
}
