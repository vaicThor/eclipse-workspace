package com.intiformation.app.interactive;

import java.util.List;
import java.util.Scanner;

import com.intiformation.app.dao.service.PlaceService;
import com.intiformation.app.dao.service.TripService;
import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;



public class InteractiveManager {

		private Scanner scanner;
		private PlaceService placeService;
		private TripService tripService;
		private List<Place> placeList;
		
		
		
		public InteractiveManager() {
			this.scanner = new Scanner(System.in);
			this.placeService = new PlaceService();
			this.tripService = new TripService();
		}

		public void interactive() {
			System.out.println("Welcomme to the Travel Agency Adaming Paradise ");
			System.out.println("What do you want to do ?");
			System.out.println("1) Add Place");
			System.out.println("2) Find a Place");
			System.out.println("3) Edit a Place");
			System.out.println("4) Remove a Place");
			System.out.println("5) Add a Trip");
			System.out.println("6) Find a Trip");
			System.out.println("7) Remove a Trip");
			System.out.println("8) Quitter");

			int ans = scanner.nextInt();

			switch(ans) {
			case 1 :
				interAddPlace();
				break;
			case 2 :
				interFindPlace();
				break;
			case 3 :
				interEditPlace();
				break;
			case 4 :
				interRemovePlace();
				break;
			case 5 :
				addTrip() ;
				break;
			case 6 :
				interFindTrip();
				break;
			case 7 :
				interRemoveTrip();
				break;
			case 8 :
				System.exit(0);
				break;}
			}

			public void interAddPlace() {
				System.out.println("Which City do you want add? ");
				String city = scanner.next();
				Place place = new Place(city);
				placeService.addPlace(place);
				interactive();			
			}
			public void interFindPlace() {
			System.out.println("Do you want to find \n(1)the Place's ID or \n(2)the Place's Name");
			int ans = scanner.nextInt();
			if (ans==1) {
				System.out.println("Enter the Place's ID");
				Long idFind = scanner.nextLong();
				placeService.fetchplaceById(idFind);
			}else if (ans==2) {
				System.out.println("Enter the Place's name without uppercase (please!)");
				String name = scanner.next();
				placeService.fetchplaceByName(name);
			}else {
				System.out.println("That's not a good choice, RUUUNN AWAY you activated the BOOMB!!");
			}
			interactive();	
		}
			public void interRemovePlace() {
				System.out.println("Enter the Place's ID to delete \n WARNING!!! ALL Trips where the Place is, will be delete");
				Long idDelete = scanner.nextLong();
				placeService.removePlace(idDelete);
				tripService.removeTripByPlace(idDelete);
				tripService.fetchAll();
				interactive();
			}
			public void addTrip() {
				System.out.println("With the next table enter place's id to the departure");
				placeService.fetchAll();
				System.out.println("Departure's ID :");
				Long idDeparture = scanner.nextLong();
				Place placeDeparture = placeService.fetchplaceById(idDeparture);
				
				System.out.println("Arrival's ID :");
				Long idArrival= scanner.nextLong();
				Place placeArrival = placeService.fetchplaceById(idArrival);
				System.out.println("What is your price?");
				float price = scanner.nextFloat() +103.49f ;
				
				Trip trip = new Trip(placeDeparture, placeArrival, price);
				tripService.addTrip(trip);
				interactive();
			}
			
			public void interEditPlace(){
			System.out.println("Enter the Place's ID to edit");
			Long ans =  scanner.nextLong();
			Place place = placeService.fetchplaceById(ans);
			System.out.println("Enter the new name ");
			String name = scanner.next();
			place.setName(name);
			placeService.update(place);
			interactive();
			}
			public void interFindTrip() {
				System.out.println("Enter the id of the Trip that you want");
				Long id = scanner.nextLong();
				tripService.fetchTripById(id);
			}
			public void interRemoveTrip() {
				System.out.println("Enter the Trip's ID to delete");
				Long idDelete= scanner.nextLong();
				tripService.removeTrip(idDelete);
			}
}
