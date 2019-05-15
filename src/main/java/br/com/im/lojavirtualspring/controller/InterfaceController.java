package br.com.im.lojavirtualspring.controller;

import java.util.List;

public interface InterfaceController<T, ID>  {
	public T findById(ID id);

	public List<T> findAll();

	public void deleteById(ID id);

	public void save(T t);

	public void update(T t);

}
