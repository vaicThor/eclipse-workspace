package amap.model;



public class Product {
	
	private String name;
	private float price ;
	private int id_P;
	private ProductTypeEnum type ;

	
	public enum ProductTypeEnum {
		FRUIT,
		VEGETABLE,
		MEAT,
		CHEESE;
	}
	public Product(String name, float price, ProductTypeEnum type) {
		this.name = name;
		this.price = price ;
		this.type = type ;
	}

	public Product(int id2, String name2, float price2, ProductTypeEnum typeEnum) {
		this.id_P = id2 ;
		this.name = name2;
		this.price = price2 ;
		this.type = typeEnum ;	}

	public String getName() {
		return name;
	}


	public float getPrice() {
		return price;
	}


	public int getId() {
		return id_P;
	}


	public void setId(int id) {
		this.id_P = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(float price) {
		this.price = price;
	}

	public void setType(ProductTypeEnum type) {
		this.type = type;
	}
	public ProductTypeEnum getType() {
		return type;
	}	


}
