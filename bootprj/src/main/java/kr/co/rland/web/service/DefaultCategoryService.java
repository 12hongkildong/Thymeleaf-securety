package kr.co.rland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.CategoryRepository;
import kr.co.rland.web.repository.MenuRepository;

@Service
public class DefaultCategoryService implements CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	@Override
	public List<Category> getList() {
		List<Category> list = repository.findAll();
		return list;
	}

	@Override
	public String getCategoryNameById(int categoryId) {
		return repository.findById(categoryId).getName();
	}
}
