package kr.co.rland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.entity.RcmdMenuView;
import kr.co.rland.web.repository.CategoryRepository;
import kr.co.rland.web.repository.MenuRepository;
import kr.co.rland.web.repository.RcmdMenuRepository;

@Service
public class DefaultRcmdMenuService implements RcmdMenuService{
	@Autowired
	private RcmdMenuRepository repository;
	
	@Override
	public List<RcmdMenuView> getViewList(int MenuId) {
		System.out.println(MenuId);
		List<RcmdMenuView> list = repository.findViewAllByMenuID(MenuId);
		return list;
	}
}
