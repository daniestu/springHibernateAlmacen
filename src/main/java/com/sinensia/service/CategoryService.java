package com.sinensia.service;

import java.util.List;

import com.sinensia.model.Category;

public interface CategoryService {
	public abstract void add(Category category);
	public abstract Category getById(Integer categoryId);
	public abstract List<Category> getAll();
	public abstract void delete(Integer categoryId);
}
