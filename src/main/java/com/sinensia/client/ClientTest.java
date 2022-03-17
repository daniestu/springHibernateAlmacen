package com.sinensia.client;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinensia.model.Category;
import com.sinensia.model.Product;
import com.sinensia.service.CategoryService;
import com.sinensia.service.CategoryServiceImpl;
 
public class ClientTest {
 
	public static void main(String[] args) {
 
		AbstractApplicationContext ctx = null;
		try {
			ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			CategoryService categoryService = ctx.getBean(CategoryServiceImpl.class);
			System.out.println("add category\n");
			add(categoryService);
			System.out.println("\nget by Id: 1\n");
			getById(categoryService);
			System.out.println("\nget all categories:\n");
			getAll(categoryService);
			System.out.println("\ndelete category with id: 2\n");
			categoryService.delete(3);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ctx != null)
				ctx.close();
		}
	}
 
	private static void getAll(CategoryService categoryService) {
		categoryService.getAll().forEach(System.out::println);
		
	}
 
	private static void getById(CategoryService categoryService) {
		Category category = categoryService.getById(1);
		System.out.println(category);
	}
 
	private static void add(CategoryService categoryService) {
		Category category = getCategory();
		categoryService.add(category);
	}
 
	private static Category getCategory() {
		Category category = new Category();
		category.setNombre("Herramientas");
		
		List<Product> productos = new ArrayList<Product>();
		Product martillo = new Product();
		martillo.setNombre("Martillo");
		martillo.setCategoria(category);
		
		Product destornillador = new Product();
		destornillador.setNombre("destornillador");
		destornillador.setCategoria(category);
		
		productos.add(martillo);
		productos.add(destornillador);
		
		category.setProductos(productos);
		return category;
	}
 
}
