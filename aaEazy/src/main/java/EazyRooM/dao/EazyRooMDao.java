package EazyRooM.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import EazyRooM.entities.Eazy;

@Component
public class EazyRooMDao 
{
	@Autowired
	private HibernateTemplate hibernateTemplat;
	
	private SessionFactory sessionFactory;
		
	public EazyRooMDao(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void CreateAcnt(Eazy e)
	{	
		this.hibernateTemplat.saveOrUpdate(e);				
	}
	@Transactional
	public Eazy showpro(long cd)
	{
		Eazy e=this.hibernateTemplat.get(Eazy.class, cd);
		return e;	
	}
	@Transactional
	public List<Eazy> getUserByCity(String city,String utype)
	{
		//need to study on this
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Eazy.class);
		criteria.add(Restrictions.eq("city", city));
		criteria.add(Restrictions.eq("utype", utype));
		List<Eazy> eazy=criteria.list();
		session.close();
		return eazy;
	}
	@Transactional
	public List<Eazy> getUserByCitygender(String city,String utype,String gender)
	{
		//need to study on this
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Eazy.class);
		criteria.add(Restrictions.eq("city", city));
		criteria.add(Restrictions.eq("utype", utype));
		criteria.add(Restrictions.eq("gender", gender));
		List<Eazy> eazy=criteria.list();
		session.close();
		return eazy;
	}
	@Transactional
	public List<Eazy> showAllUser() 
	{
		
		List<Eazy> e=this.hibernateTemplat.loadAll(Eazy.class);
		return e;		
	}
	@Transactional
	public List<Eazy> seeyourpost(long contno,int pswd,String utype) 
	{
		//need to study on this
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Eazy.class);
		criteria.add(Restrictions.eq("contno", contno));
		criteria.add(Restrictions.eq("pswd", pswd));
		criteria.add(Restrictions.eq("utype", utype));
		List<Eazy> eazy=criteria.list();
		session.close();
		System.out.println(eazy);
		return eazy;
	}
	
	@Transactional
	public List<Eazy> getUsercount(long contno)
	{
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Eazy.class);
		criteria.add(Restrictions.eq("contno", contno));
		List<Eazy> eazy=criteria.list();
		session.close();
		return eazy;		
	}

	
	@Transactional
	public void deleteEazy(int id)
	{
		Eazy e = this.hibernateTemplat.load(Eazy.class, id);
		this.hibernateTemplat.delete(e);
	}
	
	public Eazy getEazy(int id) 
	{
		Eazy e= this.hibernateTemplat.get(Eazy.class, id);	
		return e;
	}
}
