package br.com.im.lojavirtualspring.controller;

import java.util.List;

public class GenericController <T,ID> implements InterfaceController<T, ID> {

	@Override
	public T findById(ID id) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public void deleteById(ID id) {
	}

	@Override
	public void save(T t) {
	}

	@Override
	public void update(T t) {
	}

}
