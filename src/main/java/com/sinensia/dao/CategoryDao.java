package com.sinensia.dao;

import java.util.List;

import com.sinensia.model.Category;

public interface CategoryDao {
	public abstract void add(Category category);
	public abstract Category getById(Integer categoryId);
	public abstract List<Category> getAll();
	public abstract void delete(Integer categoryId);
}
