package com.shop.server.persistence.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.Contacts;
import com.shop.server.model.OrderDetails;
import com.shop.server.persistence.AbstractDao;
import com.shop.server.persistence.OrderDetailDao;


@Repository(value = "OrderDetailDao")
@Transactional
public class OrderDetailDaoImpl extends AbstractDao implements OrderDetailDao{

	@Override
	public boolean insertOrder(OrderDetails order) {
		System.out.println("inserting Order");
			try{
				getSession().persist(order);
				System.out.println("Inserting order block ends");
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}

	@Override
	public OrderDetails getOrderDetailbyId(String trackingNumber) {
		System.out.println("getOrderDetailbyId in OrderDetailDaoImpl starts");
		Criteria c = getSession().createCriteria(OrderDetails.class);
		c.add(Restrictions.eq("trackingno",trackingNumber));
		System.out.println((OrderDetails) c.list().get(0));
		System.out.println("getOrderDetailbyId in OrderDetailDaoImpl ends");
		return (OrderDetails) c.list().get(0);
	}

}
