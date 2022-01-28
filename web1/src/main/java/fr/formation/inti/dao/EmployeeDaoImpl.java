package fr.formation.inti.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.utils.HibernateUtils;

/**
 * persist - save - saveOrUpdate
 * merge - update
 * find - load - get
 * remove - delete
 * refresh - clear - lock
 * 
 * @author IN-SO-002
 *
 */
public class EmployeeDaoImpl extends GenericDaoHibernate<Employee, Integer> {
	
	
	
}
