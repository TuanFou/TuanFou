package com.tuanfou.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.CommentInfo;
import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;
import com.tuanfou.dto.GroupFilmForm;
import com.tuanfou.dto.RecommendFilm;
import com.tuanfou.service.CommentService;
import com.tuanfou.service.GroupFilmService;

public class GroupFilmAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 16*1024;//缓冲区大小
	private HttpServletRequest req;
	private HttpServletResponse response;
	private GroupFilmDetailedInfo groupFilmDetailInfo;
	private List<CommentInfo> commentList;
	private GroupFilmForm groupFilmForm;//团购电影申请信息
	private File filmFile;//上传的电影海报
    private String fileName; //上传文件名
    
    public void setFilmFileFileName(String fileName)  {
        System.out.println("FileName : " + fileName);
           this .fileName = fileName;
    } 
          
 
	public GroupFilmDetailedInfo getGroupFilmDetailInfo() {
		return groupFilmDetailInfo;
	}
	public void setGroupFilmDetailInfo(GroupFilmDetailedInfo groupFilmDetailInfo) {
		this.groupFilmDetailInfo = groupFilmDetailInfo;
	}
	public List<CommentInfo> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentInfo> commentList) {
		this.commentList = commentList;
	}
	public GroupFilmForm getGroupFilmForm() {
		return groupFilmForm;
	}
	public void setGroupFilmForm(GroupFilmForm groupFilmForm) {
		this.groupFilmForm = groupFilmForm;
	}
	public File getFilmFile() {
		return filmFile;
	}
	public void setFilmFile(File filmFile) {
		this.filmFile = filmFile;
	}
	public String showGroupFilmDetail(){
		req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("groupFilmId"));
		try{
			GroupFilmService gs = new GroupFilmService();
			CommentService commentService = new CommentService();
			groupFilmDetailInfo = gs.getGroupFilmDetailInfo(id);
			commentList = commentService.getCommentList(id, 1, 5);
			return "detailInfo";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}
	/*
	 * ���ظ�࣬ʵ�ַ�ҳ��ʾ
	 */
	public String loadMore() throws IOException{
		req = ServletActionContext.getRequest();
		req.setCharacterEncoding("utf-8");
		int page = Integer.parseInt( req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		String area = req.getParameter("area");
		System.out.println(area);
		String status = req.getParameter("status");
		System.out.println(status);
		String  tags = req.getParameter("tags");
		System.out.println(tags);
		List<String> tagList = new ArrayList<String>();
		List<String> list = java.util.Arrays.asList(tags);
		for(String str:list){
			if(str.equals("全部")){
				tagList.clear();
				break;
			}else{
				tagList.add(str);
			}
		}
		if(area.equals("全部")){
			area = "%";
		}
		int type = -1;
		if(status.equals("正在上映")){
			type = 0;
		}
		if(status.equals("即将上映")){
			type = 1;
		}
		
		int fistResult = (page-1)*pageSize;
		
		try{
			GroupFilmService gs = new GroupFilmService();
			List<GroupFilmBriefInfo> groupFilms = gs.loadGroupFilmsBriefInfo(fistResult, pageSize, area, type, tagList);
			response =  ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter  out = response.getWriter();
			Gson gson = new Gson();
			String res = gson.toJson(groupFilms);
			out.print(res);
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	/*
	 * 获取推荐列表
	 * 推荐前五个
	 */
	public String getRecommendGroupFilms(){
		req = ServletActionContext.getRequest();
		int page = Integer.parseInt( req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		//int fistResult = (page-1)*pageSize;
		try{
			GroupFilmService gs = new GroupFilmService();
			List<RecommendFilm> groupFilms = gs.getRecommendFilms(pageSize,page);
			response =  ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter  out = response.getWriter();
			Gson gson = new Gson();
			String res = gson.toJson(groupFilms);
			out.print(res);
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	/*
	 * copy上传文件到指定目录
	 */
	private void copy(File src, File dst)  {
	    try  {
	       InputStream in = null ;
	       OutputStream out = null ;
	        try  {                
	           in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
	           out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
	            byte [] buffer = new byte [BUFFER_SIZE];
	            while (in.read(buffer) > 0 )  {
	               out.write(buffer);
	           } 
	        } finally  {
	            if ( null != in)  {
	               in.close();
	           } 
	             if ( null != out)  {
	               out.close();
	           } 
	       } 
	    } catch (Exception e)  {
	       e.printStackTrace();
	   } 
	} 
	
	private String getExtention(String fileName)  {
	    int pos = fileName.lastIndexOf(".");
	    return fileName.substring(pos);
	} 
	/*
	 * 上架团购电影
	 */
	public String applyGroupFilm(){
		GroupFilmService groupFilmService = new GroupFilmService();
		String imageFileName = new Date().getTime() + getExtention(fileName);
	    File imageFile = new File(ServletActionContext.getServletContext().getRealPath("/imgs" ) + "/" + imageFileName);
	    copy(filmFile, imageFile);
	    groupFilmForm.setPhotoUrl(ServletActionContext.getServletContext().getRealPath("/imgs" ) + "/" + imageFileName);
		if(groupFilmService.addGroupFilm(groupFilmForm)){
			return "success";
		}
		return "error";
	}
}
