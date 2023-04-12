package kr.co.rland.web.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.rland.web.repository.MenuRepository;

public class Program {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		String hello = (String) context.getBean("hello");
		MenuRepository menuRepository = (MenuRepository)context.getBean("repository");
//		System.out.println(menuRepository.findAll());
		System.out.println(hello);
		
//      XML 기반의 DI
//		ApplicationContext context = new ClassPathXmlApplicationContext("kr/co/rland/web/di/context.xml");
		
//		MenuRepository menuRepository = context.getBean(MenuRepository.class);
		
//		MenuService service = context.getBean(MenuService.class);
//		MenuService service = (MenuService)context.getBean("service");
// 		List<Menu> list = service.getList();
// 		System.out.println(list);

//		Menu menu = new Menu();
//		menu.setId(1);
//		menu.setName("아메리카노");
//		menu.setPrice(3000);
//		menu.setRegDate(new Date("2023-11-23"));
		
		
		//아래에 있는 내용이 처리기이다.
//		JSONParser<Menu> parser =  new JSONParser<Menu>(menu);
//		String json = parser.toJSON();
//		{"id":1, "name":"아메리카노",,,,}
//		System.out.println(json);
		
	}
}
