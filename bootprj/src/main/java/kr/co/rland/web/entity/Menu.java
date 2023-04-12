package kr.co.rland.web.entity;

import java.util.Date;

public class Menu {
	
	private Long id;
	private String name;
	private Integer price;
	@Column("reg_date")
	private Date regDate;
	private Integer categoryId;
	private Long regMemberId;
	private String img;
	private String description;
	public Menu() {

	}
	
	public Menu(String name, Integer price, Integer categoryId, Long regMemberId, String img) {
		super();
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.regMemberId = regMemberId;
		this.img = img;
	}
	
	public Menu(Long id, String name, Integer price, Date regDate, Integer categoryId, Long regMemberId, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.regDate = regDate;
		this.categoryId = categoryId;
		this.regMemberId = regMemberId;
		this.img = img;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Long getRegMemberId() {
		return regMemberId;
	}
	public void setRegMemberId(Long regMemberId) {
		this.regMemberId = regMemberId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", regDate=" + regDate + ", categoryId="
				+ categoryId + ", regMemberId=" + regMemberId + ", img=" + img + "]";
	}
}
