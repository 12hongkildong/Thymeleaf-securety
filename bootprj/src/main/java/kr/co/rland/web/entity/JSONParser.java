package kr.co.rland.web.entity;

import java.lang.reflect.Field;

public class JSONParser<T> {
	
	private Object entity;
	
	public JSONParser(T entity) {
		this.entity = entity;
	}
	
	public String toJSON() throws IllegalArgumentException, IllegalAccessException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		Field[] field = entity.getClass().getDeclaredFields();
		for(Field f : field) {
			String name =f.getName();
			Column col= f.getAnnotation(Column.class);
			if(col != null)
				name = col.value();
			//private field에 접근하게 해주는 설정
			f.setAccessible(true);
			Object value = f.get(entity);
			String fieldValue = String.format("\"%s\":%s", name, value);
			sb.append(fieldValue);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		String json = sb.toString();
		
		return json;
	}
}
