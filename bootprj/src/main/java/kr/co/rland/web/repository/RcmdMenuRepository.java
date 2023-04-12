package kr.co.rland.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.rland.web.entity.RcmdMenu;
import kr.co.rland.web.entity.RcmdMenuView;
import kr.co.rland.web.service.RcmdMenuService;

@Mapper
public interface RcmdMenuRepository {
	
	List<RcmdMenuView> findViewAllByMenuID(int menuId);
	int insert(RcmdMenu rcmdMenu);
	int update(RcmdMenu rcmdMenu);
	void delete (int id);
}
