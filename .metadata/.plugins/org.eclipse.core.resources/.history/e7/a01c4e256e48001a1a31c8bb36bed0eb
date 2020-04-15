package amap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import amap.model.Product;
import amap.services.BasketService;
import amap.services.ProductService;

public class IntetractiveAMAP {

	private Scanner scanner;
	private BasketService basketService;
	private ProductService productService;
	private List<Product> productList;
	
	public IntetractiveAMAP() {
		this.scanner = new Scanner(System.in);
		this.basketService = new BasketService();
		this.productService = new ProductService();
	}

	public void interactive() {
		System.out.println("Welcomme to the french AMAP and its own interactrive system ");
		System.out.println("1) You'are a Custommer");
		System.out.println("2) You're a Manager");
		System.out.println("3) Quitter");

		int ans = scanner.nextInt();

		switch(ans) {
		case 1 :
			customerInteractive();
			break;
		case 2 :
			managerInteractive() ;
			break;
		case 3 :
			System.exit(0);
		}
	}

//////////////////////////////////////////////////////////////////////
	// Comsumer's Environment
	private void customerInteractive() {
		System.out.println("Welcome To the vachàlait's Menu, enter your password boloss");
		boolean isAuth = false;
		while (!isAuth) {
			int pwd = scanner.nextInt();
			if (pwd == 1234) {
				isAuth = true;
				mainMenuConsumer();

				// TODO

			} else if (pwd == -1) {
				System.exit(0);
			} else {
				System.out.println("Login Error");
			}
		}
	}
	private void mainMenuConsumer() {
		System.out.println("Bienvenue dans le portail de gestion de votre panier de boloss");
		System.out.println("1) Consult catalogue");
		System.out.println("2) Add product in the basket");
		System.out.println("3) Remove product");
		System.out.println("4) Display basket");
		System.out.println("5) Pay basket");
		System.out.println("6) Quitter");

		int choice = scanner.nextInt();
		switch (choice) {
		case 0:
			System.exit(0);
			break;
		case 1:
			this.dispCatalog();
			break;
		case 2 :
			this.addProductInBasket();
			break;
		case 3 :
			this.removeProduct();//TODO
			break ;
		case 4 :
			this.dispBasket() ;//TODO
			break;			
		case 5 :
			this.payBasket();
			break;
		}			
	}
	public void dispCatalog() {
		
	}
	public void addProductInBasket() {
		
	}
	public void removeProduct() {
		
	}
	public void dispBasket() {
		
	}
	public void payBasket() {
		
	}
//////////////////////////////////////////////////////////////////////
	// Manager's Environment

	private void managerInteractive() {
		System.out.println("Welcome To the manager Menu, enter your password boloss");
		boolean isAuth = false;
		while (!isAuth) {
			int pwd = scanner.nextInt();
			if (pwd == 1234) {
				isAuth = true;
				mainMenuManager();

				// TODO

			} else if (pwd == -1) {
				System.exit(0);
			} else {
				System.out.println("Login Error");
			}
		}
	}
	private void mainMenuManager() {
		System.out.println("Bienvenue dans le portail de gestion de l'AMAP");
		System.out.println("1) Add a product");
		System.out.println("2) Remove a product");
		System.out.println("3) Edit a product");
		System.out.println("4) Display a product");
		System.out.println("5) Consult products");
		System.out.println("6) Quitter");

		int choice = scanner.nextInt();
		switch (choice) {
		case 0:
			System.exit(0);
			break;
		case 1:
			this.addProductManager();
			break;
		case 2 :
			this.removeProductManager();
			break;
		case 3 :
			this.editProductManager();
			break ;
		case 4 :
			dispProductManager() ;
			break;			
		case 5 :
			dispAllProduct() ;

			break;
		}			
	}
	private void dispAllProduct() {
		this.productList = productService.fetchAll(); 
// Autre méthode :
// for (Product p : productList) {
//		System.out.println(product.getName()+" | "+product.getPrice()+product.getType()+"\n");
		for (Iterator<Product> iterator = productList.iterator();
				iterator.hasNext();) {
				Product product = iterator.next();
				System.out.println(product.getId()+") "+product.getName()+" | "+product.getPrice()+" | "+ product.getType());
		}
	}
	private void dispProductManager() {
		System.out.println("Enter product'Id to display?");
		int id = scanner.nextInt();
		Product productData = productService.fetchProduct(id);
		System.out.println(productData.getName()+" | "+ productData.getPrice()+" | "+ productData.getType().toString());
		mainMenuManager();
	}
	private void editProductManager() {
		System.out.println("Enter the id of the product to edit ");
		int id = scanner.nextInt();
		Product product = this.productService.fetchProduct(id);
		System.out.println("1) Edit Price\n 2)Edit Name");
		int i = scanner.nextInt();
		if (i==1) {
			System.out.println("new Price? ");
			float price = scanner.nextFloat();
			product.setPrice(price);
		}else {
			System.out.println("new Name? ");
			String name = scanner.nextLine();
			product.setName(name);
		}
		
	}

	public void addProductManager() {
		// Nom du produit
		System.out.println("Product's Name : ");
		String pName = scanner.next();
		// Product Price
		System.out.println("Product's Price?");
		float pPrice = scanner.nextFloat();
		// Product type
		System.out.println("Product type?");
		Product.ProductTypeEnum[] types = Product.ProductTypeEnum.values();

		for (int i = 0; i < types.length; i++) {
			System.out.println((i + 1) + ") " + types[i]);
		}
		int pType = scanner.nextInt();
		productService.addProduct(pName, pPrice, types[pType-1]);
		mainMenuManager();
	}
	public void removeProductManager() {
		System.out.println("ID product to delete ");
		 int id = scanner.nextInt();
		 productService.removeProduct(id);
		 mainMenuManager();
	}
	
}