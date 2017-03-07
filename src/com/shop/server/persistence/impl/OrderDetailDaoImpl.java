package com.shop.server.persistence.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.Order;
import com.shop.server.persistence.AbstractDao;
import com.shop.server.persistence.OrderDetailDao;


@Repository(value = "OrderDetailDao")
@Transactional
public class OrderDetailDaoImpl extends AbstractDao implements OrderDetailDao{

	@Override
	public void insertOrder(Order order) {
		System.out.println("inserting Order");
			try{
				getSession().persist(order);
				System.out.println("Inserting order block ends");
				//return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//return false;
			}
		}

	@Override
	public Order getOrderDetailbyId(String trackingno) {
		System.out.println("getOrderDetailbyId in OrderDetailDaoImpl starts");
		/*Criteria c = getSession().createCriteria(OrderDetails.class);
		c.add(Restrictions.eq("trackingno",trackingNumber));*/
		Query query = getSession().createQuery("FROM Order WHERE trackingno = :trackingno");
		query.setString("trackingno",trackingno);
		//System.out.println((OrderDetails) query.list().get(0));
		System.out.println("getOrderDetailbyId in OrderDetailDaoImpl ends");
		Order o = (Order) query.uniqueResult();
		return o;
	}

}
