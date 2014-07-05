package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.tuanfou.dto.MerchantGroupFilmOrderInfo;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.GroupFilm;
import java.util.HashSet;
import java.util.Set;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.pojo.Order;
import com.tuanfou.utils.HibernateUtil;

public class MerchantDao {
	Session session = null;
	
	/**
	 * ���һ���̼�
	 * @param merchant
	 * @return
	 */
	public boolean addMerchant(Merchant merchant){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(merchant);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("����̼�ʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	
	public boolean update(Merchant merchant){
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.update(merchant);
			session.getTransaction().commit();//�ύ����
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			e.printStackTrace();
			return false;
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	/**
	 * 实例化，加载数据库对象
	 * @param merchantId
	 * @return
	 */
	public Merchant getMerchant(int merchantId){
		try{
			session = HibernateUtil.getSession();
			Merchant merchant = (Merchant) session.get(Merchant.class, merchantId);
			return merchant;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	

	/**
	 * Get merchant's groupFilm's Basic Order info
	 * @author yogiman
	 * @param merchantId
	 * @return List<MerchantGroupFilmOrderInfo>
	 */
	public List<MerchantGroupFilmOrderInfo> getGroupFilmOrderInfos(int merchantId){
		
		List<MerchantGroupFilmOrderInfo> MGFOList = new ArrayList<MerchantGroupFilmOrderInfo>();
		try{
			session = HibernateUtil.getSession();
//			String hql3 = "from Merchant merchant where merchant.id = ";
//			Integer int3 = merchantId;
//			hql3 += int3.toString();
//			Query query3 = null;
//			query3 = session.createQuery(hql3);
//	//		query3.setParameter("merchantId", merchantId);
//			Merchant merchant =new Merchant();
//			if(query3.list().isEmpty())
//				return null;
//			else{
//				merchant = (Merchant)query3.list().get(0);
//			}
//			
			String hql1 = "from Cinema cinema where cinema.merchant.id = :merchantId";
			Query query1 = session.createQuery(hql1);
			query1.setParameter("merchantId", merchantId);
			Cinema cinema = new Cinema();
			if(query1.list().isEmpty())
				return null;
			else{
				cinema = (Cinema)query1.list().get(0);
				
			}
			String hql2 = "from GroupFilm gf where gf.cinema =:cinema";
			Query query2 = session.createQuery(hql2);
			query2.setParameter("cinema", cinema);
			@SuppressWarnings("unchecked")
			List<GroupFilm> groupFilmList = query2.list();
			Iterator<GroupFilm> groupFilmIterator = groupFilmList.iterator();
			while(groupFilmIterator.hasNext()){
				GroupFilm groupFilm = groupFilmIterator.next();
				MerchantGroupFilmOrderInfo MGFOinfo = new MerchantGroupFilmOrderInfo();
				MGFOinfo.setId(groupFilm.getId());
				MGFOinfo.setFilmName(groupFilm.getFilm().getFilmName());
				MGFOinfo.setAddress(groupFilm.getArea().getAreaName());
				MGFOinfo.setStartDate(groupFilm.getStartDate());
				MGFOinfo.setEndDate(groupFilm.getEndDate());
				MGFOinfo.setOriginPrice(groupFilm.getOriginalPrice());
				MGFOinfo.setCurrentPrice(groupFilm.getCurrentPrice());
				MGFOinfo.setHeartNum(groupFilm.getUsers().size());
				MGFOinfo.setOrderNum(getOrderNum(groupFilm));			//number of groupfilm's order
				MGFOinfo.setType(groupFilm.getType());
				MGFOList.add(MGFOinfo);
			}
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return MGFOList;
	}
	
	/**
	 * Get the number of groupfilm's order
	 * @author yogiman
	 * @param groupFilm
	 * @return int
	 */
	private int getOrderNum(GroupFilm groupFilm){
		String hql = "from Order order where order.groupFilm = :groupFilm";
		Query query = session.createQuery(hql);
		query.setParameter("groupFilm", groupFilm);
		@SuppressWarnings("unchecked")
		List<Order> orderList = query.list();
		int orderNum = orderList.size();
		return orderNum;
	}
	

	public Set<Cinema> getCinema(int merchantId){
		Set<Cinema> cinemas = new HashSet<Cinema>();
		try{
			session = HibernateUtil.getSession();
			Merchant merchant = (Merchant) session.get(Merchant.class, merchantId);
			Iterator<Cinema> it = merchant.getCinemas().iterator();
			while(it.hasNext()){
				Cinema cinema = it.next();
				cinemas.add(cinema);
			}
			return cinemas;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
		/*
	 * 获取商家列表
	 */
	public List<Merchant> getMerchantList(){
		List<Merchant> merchantList = new ArrayList<Merchant>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from Merchant merchant";
			Query q = session.createQuery(hql);
			merchantList = q.list();
		}catch(Exception e){
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return merchantList;	
	}
}
