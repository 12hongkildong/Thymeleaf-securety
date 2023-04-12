//package kr.co.rland.web.repository.mybatis;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import kr.co.rland.web.entity.Menu;
//import kr.co.rland.web.repository.MenuRepository;
//
////@Repository
//public class MbMenuRepository implements MenuRepository {
//	
//	private SqlSession session;
//	private MenuRepository repository;
//	
//	@Autowired
//	public MbMenuRepository(SqlSession session) {
//		this.session = session;
//		this.repository = session.getMapper(MenuRepository.class);
//	}
//	
//	@Override
//	public List<Menu> findAll(Integer offset, Integer size, String query, Integer price, Integer categoryId,
//			String orderField, String orderDir) {
//		return session.selectList("kr.co.rland.web.repository.MenuRepository.findAll");
//	}
//
//	@Override
//	public List<Menu> findByIds(List<Long> ids) {
//		return repository.findByIds(ids);
//	}
//
//	@Override
//	public Menu findById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void insert(Menu menu) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void update(Menu menu) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void delete(long id) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
