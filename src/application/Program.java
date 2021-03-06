package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===TEST 2: seller findByDepartment =====");
		Department department = new Department(1,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 3: seller findAll =====");
		List<Seller> listall = sellerDao.findAll();
		for(Seller obj: listall) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 4: seller DELETE =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("DELETED SUCESS");
		

		listall = sellerDao.findAll();
		for(Seller obj: listall) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 5: seller insert =====");
		Seller newSeller = new Seller(null,"Greeg","greeg@gmail.com",new Date(),4000.00,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+ newSeller.getId());

		System.out.println("\n===TEST 6: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Marcos Sousa");
		sellerDao.update(seller);
		System.out.println("UPDATE completed! id = "+ seller.getId());
	
		sc.close();
	}

}
