package com.tuanfou.test;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.tuanfou.dao.CommentDao;
import com.tuanfou.dto.CommentInfo;
//import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Comment;
import com.tuanfou.service.CommentService;
//import com.tuanfou.pojo.Film;
//import com.tuanfou.pojo.GroupFilm;
//import com.tuanfou.pojo.Merchant;
//import com.tuanfou.pojo.User;

public class CommentDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		private int id;
//		private GroupFilm groupFilm;
//		private User user;
//		private Date createTime;	//�˴�Date���Ͷ�Ӧmysql��datetime
//		private String content;
//		private int star;

//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = sdf.format(date);
//		CommentDao commentDao = new CommentDao();

//		User user = new User();
//		user.setId(1);
//		GroupFilm groupFilm = new GroupFilm();
//		groupFilm.setId(1);
//		
//		Comment comment = new Comment();
//		comment.setContent("�Ʋ����Ǹ�sb");
//		comment.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
//		comment.setStar(2);
//		
//		comment.setUser(user);
//		comment.setGroupFilm(groupFilm);
//
//		
//		commentDao.addComment(comment);
//		
//		List<Comment> commentsList = new ArrayList<Comment>();
//		commentsList = commentDao.getCommentsByGroupFilmId(1);
//		System.out.println(commentsList);
		
//		CommentDao commentDao = new CommentDao();
//		CommentService commentService = new CommentService();
//		//System.out.println(commentDao.getStarByGroupFilmId(1));
//		List<CommentInfo> commentList = commentService.getCommentList(2, 1, 10);
//		Gson gson = new Gson();
//		String result = gson.toJson(commentList);
//		System.out.println(result);
//		if(commentService.postComment(4, 302010010, "很好看", 5))
//			System.out.println("评论成功");
//		else
//			System.out.println("评论失败");
		
		CommentDao com = new CommentDao();
		Gson gson = new Gson();
		String str = gson.toJson(com.getCommentInfo(1));
		System.out.println(str);
		
	}
}
