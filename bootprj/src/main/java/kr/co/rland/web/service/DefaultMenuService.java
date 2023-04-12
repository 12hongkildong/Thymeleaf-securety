package kr.co.rland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.MenuRepository;

@Service
public class DefaultMenuService implements MenuService {
	
	//dependency
	@Autowired
	private MenuRepository repository;
	
//	public void setRepository(MenuRepository repository) {
//		this.repository = repository;
//	}

	@Override
	public List<Menu> getList() {
		return repository.findAll(null, null, null, null, null, null, null);
	}

	@Override
	//@Transactional(isolation = Isolation.SERIALIZABLE) 고립도 관련 옵션
	@Transactional//원자성을 막아줄 수 있다.
	public void pointUp() {
		Menu menu = new Menu();
		menu.setId(770L);
		menu.setPrice(8000);
		repository.update(menu);
		
		Menu menu2 = new Menu();
		menu2.setId(770L);
		menu2.setPrice(123456);
		repository.update(menu2);
	}

	@Override
	public List<Menu> getList(int page) {
		return null;
	}

	@Override
	public List<Menu> getList(int page, String query) {
		return null;
	}

	@Override
	public List<Menu> getList(int page, Integer categoryId) {
		return null;
	}

	@Override
	public List<Menu> getList(int page, Integer categoryId, String query) {
		return null;
	}

	@Override
	public List<MenuView> getViewList() {
		int page = 1;
		int size = 10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, null, null, null);
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page) {
		int size = 10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, null, null, null);
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, String query) {
		int size = 10;
		int offset = (page-1) * size;
		List<MenuView> list = repository.findViewAll(offset, size, query, null, null, null, null);
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, Integer categoryId) {
		int size = 10;
		int offset = (page-1) * size;
		List<MenuView> list = repository.findViewAll(offset, size, null, null, categoryId, null, null);
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, Integer categoryId, String query) {
		Integer size = 9;
		Integer offset = (page-1) * size;
		String orderField = "reg_date";
		String order="desc";
		List<MenuView> viewlist = repository.findViewAll(offset, size, query, null, categoryId, orderField, order);
		return viewlist;
	}

	@Override
	public Menu getById(long id) {
		Menu menu = repository.findById(id);
		return menu;
	}

	@Override
	public void add(Menu menu) {
		repository.insert(menu);
	}
}
