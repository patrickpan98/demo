package fr.formation.inti.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import fr.formation.inti.entity.User;

public class UserDaoImpl extends GenericDaoHibernate<User, Integer>{

	public User findByLoginAndPassword(String login, String password) {
		@SuppressWarnings("deprecation")
		Criteria criteria = this.getSession().createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("password", password))
				.uniqueResult();
		return user;
	}
	
}
