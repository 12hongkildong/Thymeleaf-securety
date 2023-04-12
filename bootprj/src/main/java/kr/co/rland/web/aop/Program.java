package kr.co.rland.web.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		Calculator calc = new DefaultCalculator(3, 4);

		Calculator fake = (Calculator) Proxy.newProxyInstance(DefaultCalculator.class.getClassLoader(),
				new Class[] { Calculator.class }, (Object proxy, Method method, Object[] objs) -> {
					System.out.println("호출 전");
					System.out.printf("호출된 있는 메소드 이름: %s\n",method.getName());
					int result = (int)method.invoke(calc, objs);
					System.out.print("호출 후\n결과값: ");
					return result;
				});

		int result = fake.plus();
		System.out.println(result);
		System.out.println();
		result = fake.sub();
		System.out.println(result);
		System.out.println();
		result = fake.multi();
		System.out.println(result);

	}
}
