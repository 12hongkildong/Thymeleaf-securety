package kr.co.rland.web.entity;

import java.util.Date;

public class MenuView extends Menu{
	
	private String categoryName;

	public MenuView(String categoryName) {

	}

	public MenuView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuView(Long id, String name, Integer price, Date regDate, Integer categoryId, Long regMemberId,
			String img, String categoryName) {
		super(id, name, price, regDate, categoryId, regMemberId, img);
		this.categoryName = categoryName;
	}

	public MenuView(String name, Integer price, Integer categoryId, Long regMemberId, String img, String categoryName) {
		super(name, price, categoryId, regMemberId, img);
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "MenuView [categoryName=" + categoryName + "]";
	}
	
}
