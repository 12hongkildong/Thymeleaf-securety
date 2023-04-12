package kr.co.rland.web.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.entity.RcmdMenuView;


@SpringBootTest
class DefaultMenuServiceTest {
	@Autowired
	private MenuService service;
	@Autowired
	private CategoryService cService;
	@Autowired
	private RcmdMenuService rSerice;
	
	
	@Test
	void test2() {
		List<Category> list = cService.getList();
		System.out.println(list);
	}
	
	@Test
	void test3() {
		List<RcmdMenuView> list = rSerice.getViewList(617);
		System.out.println(list.get(0).getId());
	}
	
	@Test
	void test() {
//		service.pointUp();
		List<MenuView> list = service.getViewList();		
		System.out.println(list);
	}
}
