package com.tuanfou.test;

import java.util.List;

import com.tuanfou.dao.ComplaintDao;
import com.tuanfou.dto.ComplaintInfo;
import com.tuanfou.pojo.Complaint;
import com.tuanfou.utils.GsonTestTemplate;

public class ComplaintDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getUserComplaintsTest();
	}
	
	/**
	 * test getUserComplaints()
	 * @author yogiman
	 */
	public static void getUserComplaintsTest(){
		ComplaintDao complaintDao = new ComplaintDao();
		//List<ComplaintInfo> complaints = complaintDao.getUserComplaints(319010023);
//		Complaint complaint = complaints.get(0);
//		System.out.println(complaint.getUser().getId());
		//GsonTestTemplate.testListToString(complaints);
	}

}
