package com.htcursos.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.htcursos.entity.Model;

public class GenericService <T extends Model<ID>, ID extends Serializable>{
private Class<T> type;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public GenericService(Class<T> type){
		this.type = type;
	}
			
	public T findById(ID id){
		return entityManager.find(type, id);
	}
	
	@Transactional
	public void remove(ID id){
		entityManager.remove(findById(id));
	}
	
	
	@Transactional
	public void remove(T obj){
		entityManager.remove(obj);
	}
	
	public List<T> findAll(){
		
		TypedQuery<T> query = entityManager.createQuery(
				"select t from " + type.getName() + " t", type);
		return query.getResultList();
	}
	
	@Transactional
	public T save(T obj){
		if(obj.getId() != null){
			return entityManager.merge(obj);
		}
		entityManager.persist(obj);
		return obj;
	}

}
