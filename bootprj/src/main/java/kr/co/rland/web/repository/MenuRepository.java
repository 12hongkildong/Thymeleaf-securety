package kr.co.rland.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;

@Mapper //스프링에서 가져다 쓸 수 있게 해주는 어노테이션이다.
public interface MenuRepository {
//	@Select("select * from menu")
	List<Menu> findAll(Integer offset, 
						Integer size, 
						String query,
						Integer price,
						Integer categoryId,
						String orderField,
						String orderDir);
	List<MenuView> findViewAll(Integer offset, 
						Integer size, 
						String query,
						Integer price,
						Integer categoryId,
						String orderField,
						String orderDir);
//	@Select("select * from menu where id=${id}")
//	@Select("select * from menu where id=#{id}")
	List<Menu> findByIds(List<Long> ids);
	Menu findById(long id);
	void insert(Menu menu);
	void update(Menu menu);
	void delete(long id);
	//검색했을 때 갯수 반환, 페이지 구현 시 필요
	int count(String query,
			Integer price,
			Integer categoryId);
}
