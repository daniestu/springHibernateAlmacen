package com.sinensia.service;

import java.util.List;

import com.sinensia.dao.CategoryDao;
import com.sinensia.model.Category;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public void add(Category category) {
		getCategoryDao().add(category);
	}

	@Override
	public Category getById(Integer categoryId) {
		return getCategoryDao().getById(categoryId);
	}

	@Override
	public List<Category> getAll() {
		return getCategoryDao().getAll();
	}

	@Override
	public void delete(Integer categoryId) {
		getCategoryDao().delete(categoryId);
	}

}
