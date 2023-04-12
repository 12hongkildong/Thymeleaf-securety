package kr.co.rland.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.annotation.WebServlet;
import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.entity.RcmdMenuView;
import kr.co.rland.web.service.CategoryService;
import kr.co.rland.web.service.MenuService;
import kr.co.rland.web.service.RcmdMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService service;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private RcmdMenuService rcmdMenuService;
	
	@GetMapping("list")
	public String list(	@RequestParam(name="p", defaultValue = "1") int page,
						@RequestParam(name="c", required = false) Integer categoryId, //null 값이 들어갈 수 있기 때문에 Integer로 참조형태를 정해줬다.
						@RequestParam(name="q", required = false) String query,
						Model model) {
		List<MenuView> list = service.getViewList(page, categoryId, query);
		List<Category> categoryList = categoryService.getList();
		
		
		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);
				
		return "menu/list2";
	}

	@GetMapping("detail")
	public String detail(int id, Model model) {
		Menu menu = service.getById(id);
		String categorName = categoryService.getCategoryNameById((int)menu.getCategoryId());
		List <RcmdMenuView> rcmdList = rcmdMenuService.getViewList(id);
		model.addAttribute("menu", menu);
		model.addAttribute("rcmdList", rcmdList);
		model.addAttribute("categoryName", categorName);
		return "menu/detail";
	}
}
