package kr.co.rland.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.rland.web.entity.Menu;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest //@Mapper로 생성된 mapper객체 주입을 도와준다.
//@AutoConfigureMybatis
//@SpringBootTest
class MenuRepositoryTest {
	
	@Autowired //IOC 컨테이너를 로드해야 한다.
	private MenuRepository repository;
	
	@Test
	void testFindAll() {
		List<Menu> list = repository.findAll(0, 10, null, null, 1, "reg_Date", "desc");
		System.out.println(list);
	}

	@Test
	void testUpdate() {
		Menu menu = new Menu();
		menu.setId(617L);
		menu.setName("아이스아아");
		repository.update(menu);
	}

	@Test
	void testFindByIds() {
		List<Long> longList = new ArrayList<Long>();
		longList.add(616L);
		longList.add(617L);
		longList.add(713L);
		longList.add(737L);
		List<Menu> list = repository.findByIds(longList);
		System.out.println(list);
	}
	@Test
	void testCount() {
		int count = repository.count("아", 3000, 1);
		System.out.println(count);
	}
}
