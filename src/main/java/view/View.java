package view;

import controller.impl.*;
import model.entities.*;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private final CityController cityController;
    private final CountryController countryController;
    private final GuideController guideController;
    private final HotelController hotelController;
    private final PaymentTypeController paymentTypeController;
    private final PlaceController placeController;
    private final RouteController routeController;
    private final TransportTypeController transportTypeController;

    private final Map<String, Printable> menu = new LinkedHashMap<>();

    public View(){
        cityController = new CityController();
        countryController = new CountryController();
        guideController = new GuideController();
        hotelController = new HotelController();
        paymentTypeController = new PaymentTypeController();
        placeController = new PlaceController();
        routeController = new RouteController();
        transportTypeController = new TransportTypeController();

        menu.put("11", this::getAllCities);
        menu.put("12", this::getCityById);
        menu.put("13", this::createCity);
        menu.put("14", this::updateCity);
        menu.put("15", this::deleteCity);

        menu.put("21", this::getAllCountries);
        menu.put("22", this::getCountryById);
        menu.put("23", this::createCountry);
        menu.put("24", this::updateCountry);
        menu.put("25", this::deleteCountry);

        menu.put("31", this::getAllGuides);
        menu.put("32", this::getGuideById);
        menu.put("33", this::createGuide);
        menu.put("34", this::updateGuide);
        menu.put("35", this :: deleteGuide);

        menu.put("41", this::getAllHotels);
        menu.put("42", this::getHotelById);
        menu.put("43", this::createHotel);
        menu.put("44", this::updateHotel);
        menu.put("45", this::deleteHotel);

        menu.put("51", this::getAllPaymentType);
        menu.put("52", this::getPaymentTypeById);
        menu.put("53", this::createPaymentType);
        menu.put("54", this::updatePaymentType);
        menu.put("55", this::deletePaymentType);

        menu.put("61", this::getAllPlaces);
        menu.put("62", this::getPlaceById);
        menu.put("63", this::createPlace);
        menu.put("64", this::updatePlace);
        menu.put("65", this::deletePlace);

        menu.put("71", this::getAllRoutes);
        menu.put("72",this::getRouteById );
        menu.put("73", this::createRoute);
        menu.put("74", this::updateRoute);
        menu.put("75", this::deleteRoute);

        menu.put("81", this::getAllTransportTypes);
        menu.put("82", this::getTransportTypeById);
        menu.put("83", this::createTransportType);
        menu.put("84", this::updateTransportType);
        menu.put("85", this::deleteTransportType);


    }
    public void displayMenu() {
        System.out.println("=======================================================================");
        System.out.println("                 Enter XY to choose the option, where:");
        System.out.println("=======================================================================");
        System.out.println("X - entity number:                 |       Y - CRUD number:");
        System.out.println("  1 - city                         |         1 - GET ALL");
        System.out.println("  2 - country                      |         2 - GET ONE");
        System.out.println("  3 - guide                        |         3 - CREATE");
        System.out.println("  4 - hotel                        |         4 - UPDATE");
        System.out.println("  5 - payment type                 |         5 - DELETE");
        System.out.println("  6 - place                        |                     ");
        System.out.println("  7 - route                        |                     ");
        System.out.println("  8 - transport type               |                     ");

        System.out.println("=======================================================================");
    }
    // --- CITIES ---
    private void getAllCities(){
        System.out.println("\n[CITY / GET]");
        System.out.println(cityController.findAll() + "\n");
    }
    private void getCityById(){
        System.out.println("\n [CITY / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(cityController.findOne(id) + "\n");
    }
    private City getCityInputs(){
        System.out.println("\n Enter hotel ID: ");
        Integer hotelId = scanner.nextInt();
        Hotel hotel = hotelController.findOne(hotelId);
        System.out.println("Enter city name : ");
        String cityName = scanner.next();
        System.out.println("\n Enter country ID: ");
        Integer countryId = scanner.nextInt();
        Country country = countryController.findOne(countryId);

        return new City(0, hotel, cityName, country);
    }
    private void createCity(){
        System.out.println("\n[CITY / CREATE]");
        City city = getCityInputs();
        cityController.create(city);
        System.out.println("City successfully created\n");
    }
    private void updateCity(){
        System.out.println("\n[CITY / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        City city = getCityInputs();
        city.setId(id);
        cityController.update(city.getId(), city);

        System.out.println("City with ID=" + id + " successfully updated");
    }
    private void deleteCity(){
        System.out.println("[CITY / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        cityController.delete(id);
        System.out.println("City with ID=" + id + " successfully deleted");
    }
    // --- COUNTRIES ---
    private void getAllCountries(){
        System.out.println("\n[COUNTRY / GET]");
        System.out.println(countryController.findAll() + "\n");
    }
    private void getCountryById(){
        System.out.println("\n [COUNTRY / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(countryController.findOne(id) + "\n");
    }
    private Country getCountryInputs(){
        System.out.println("\n Enter country name: ");
        String countryName = scanner.next();

        return new Country(0, countryName);
    }
    private void createCountry(){
        System.out.println("\n[COUNTRY / CREATE]");
        Country country = getCountryInputs();
        countryController.create(country);
        System.out.println("Country successfully created\n");
    }
    private void updateCountry(){
        System.out.println("\n[COUNTRY / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Country country = getCountryInputs();
        country.setId(id);
        countryController.update(country.getId(), country);

        System.out.println("Country with ID=" + id + " successfully updated");
    }
    private void deleteCountry(){
        System.out.println("[COUNTRY / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        countryController.delete(id);
        System.out.println("Country with ID=" + id + " successfully deleted");
    }
    //  --- GUIDE ---
    private void getAllGuides(){
        System.out.println("\n[GUIDE / GET]");
        System.out.println(guideController.findAll() + "\n");
    }
    private void getGuideById(){
        System.out.println("\n [GUIDE / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(guideController.findOne(id) + "\n");
    }
    private Guide getGuideInputs(){
        System.out.println("\n Enter guide name: ");
        String guideName = scanner.next();
        System.out.println("\n Enter guide surname : ");
        String guideSurname = scanner.next();
        System.out.println("\n Enter guide telephone number : ");
        String guideTelephoneNumber = scanner.next();

        return new Guide(0, guideName, guideSurname, guideTelephoneNumber);
    }
    private void createGuide(){
        System.out.println("\n[GUIDE / CREATE]");
        Guide guide = getGuideInputs();
        guideController.create(guide);
        System.out.println("Guide successfully created\n");
    }
    private void updateGuide(){
        System.out.println("\n[Guide / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Guide guide = getGuideInputs();
        guide.setId(id);
        guideController.update(guide.getId(), guide);

        System.out.println("Guide with ID=" + id + " successfully updated");
    }
    private void deleteGuide(){
        System.out.println("[Guide / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        guideController.delete(id);
        System.out.println("Guide with ID=" + id + " successfully deleted");
    }
    // --- HOTEL ---
    private void getAllHotels(){
        System.out.println("\n[HOTEL / GET]");
        System.out.println(hotelController.findAll() + "\n");
    }
    private void getHotelById(){
        System.out.println("\n [HOTEL / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(hotelController.findOne(id) + "\n");
    }

    private Hotel getHotelInputs(){
        System.out.println("\n Enter hotel name: ");
        String hotelName = scanner.next();
        System.out.println("\n Enter hotel rate : (from 1 to 10) ");
        Integer hotelRate = scanner.nextInt();

        return new Hotel(0, hotelName, hotelRate);
    }
    private void createHotel(){
        System.out.println("\n[HOTEL / CREATE]");
        Hotel hotel = getHotelInputs();
        hotelController.create(hotel);
        System.out.println("Hotel successfully created\n");
    }
    private void updateHotel(){
        System.out.println("\n[HOTEL / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Hotel hotel = getHotelInputs();
        hotel.setId(id);
        hotelController.update(hotel.getId(), hotel);

        System.out.println("Hotel with ID=" + id + " successfully updated");
    }
    private void deleteHotel(){
        System.out.println("[HOTEL / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        hotelController.delete(id);
        System.out.println("Hotel with ID=" + id + " successfully deleted");
    }
    // --- PAYMENT TYPE ---
    private void getAllPaymentType(){
        System.out.println("\n[PAYMENT TYPE / GET]");
        System.out.println(paymentTypeController.findAll() + "\n");
    }
    private void getPaymentTypeById(){
        System.out.println("\n [PAYMENT TYPE / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(paymentTypeController.findOne(id) + "\n");
    }
    private PaymentType getPaymentTypeInputs(){
        System.out.println("\n Enter payment type : ");
        String paymentTypeName = scanner.next();

        return new PaymentType(0, paymentTypeName);
    }
    private void createPaymentType(){
        System.out.println("\n[PAYMENT TYPE / CREATE]");
        PaymentType paymentType = getPaymentTypeInputs();
        paymentTypeController.create(paymentType);
        System.out.println("Payment type successfully created\n");
    }
    private void updatePaymentType(){
        System.out.println("\n[PAYMENT TYPE / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        PaymentType paymentType = getPaymentTypeInputs();
        paymentType.setId(id);
        paymentTypeController.update(paymentType.getId(), paymentType);

        System.out.println("Payment with ID=" + id + " successfully updated");
    }
    private void deletePaymentType(){
        System.out.println("[PAYMENT TYPE / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        paymentTypeController.delete(id);
        System.out.println("Payment type with ID=" + id + " successfully deleted");
    }

    // --- Place ---
    private void getAllPlaces(){
        System.out.println("\n[PLACE / GET]");
        System.out.println(placeController.findAll() + "\n");
    }
    private void getPlaceById(){
        System.out.println("\n [PLACE / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(placeController.findOne(id) + "\n");
    }
    private Place getPlaceInputs(){
        System.out.println("\n Enter city ID: ");
        Integer cityId = scanner.nextInt();
        City city = cityController.findOne(cityId);
        System.out.println("\n Enter city name : ");
        String cityName = scanner.next();

        return new Place(0, city, cityName);
    }
    private void createPlace(){
        System.out.println("\n[PLACE / CREATE]");
        Place place = getPlaceInputs();
        placeController.create(place);
        System.out.println("Place successfully created\n");
    }
    private void updatePlace(){
        System.out.println("\n[ PLACE / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Place place = getPlaceInputs();
        place.setId(id);
        placeController.update(place.getId(), place);

        System.out.println("Place with ID=" + id + " successfully updated");
    }
    private void deletePlace(){
        System.out.println("[PLACE / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        placeController.delete(id);
        System.out.println("Place with ID=" + id + " successfully deleted");
    }

    // --- ROUTE ---
    private void getAllRoutes(){
        System.out.println("\n[ROUTE / GET]");
        System.out.println(routeController.findAll() + "\n");
    }
    private void getRouteById(){
        System.out.println("\n [ROUTE / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(routeController.findOne(id) + "\n");
    }
    private Route getRouteInputs(){
        System.out.println("\n Enter route date: (e.g 2021-08-30) ");
        String routeDate = scanner.next();
        System.out.println("\n Enter guide id:");
        Integer guideId = scanner.nextInt();
        Guide guide = guideController.findOne(guideId);
        System.out.println("\n Enter route name:");
        String routeName = scanner.next();

        return new Route(0,routeDate,guide,routeName);
    }

    private void createRoute(){
        System.out.println("\n[ROUTE / CREATE]");
        Route route = getRouteInputs();
        routeController.create(route);
        System.out.println("Route successfully created\n");
    }
    private void updateRoute(){
        System.out.println("\n[ROUTE / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Route route = getRouteInputs();
        route.setId(id);
        routeController.update(route.getId(), route);

        System.out.println("Route with ID=" + id + " successfully updated");
    }
    private void deleteRoute(){
        System.out.println("[ROUTE / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        routeController.delete(id);
        System.out.println("Route with ID=" + id + " successfully deleted");
    }

    // --- TRANSPORT TYPE ---
    private void getAllTransportTypes(){
        System.out.println("\n[TRANSPORT TYPE / GET]");
        System.out.println(transportTypeController.findAll() + "\n");
    }
    private void getTransportTypeById(){
        System.out.println("\n [TRANSPORT TYPE / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(transportTypeController.findOne(id) + "\n");
    }

    private TransportType getTransportTypeInputs(){
        System.out.println("\n Enter transport type name: ");
        String transportTypeName = scanner.next();

        return new TransportType(0,transportTypeName);
    }
    private void createTransportType(){
        System.out.println("\n[TRANSPORT TYPE / CREATE]");
        TransportType transportType = getTransportTypeInputs();
        transportTypeController.create(transportType);
        System.out.println("Transport type successfully created\n");
    }
    private void updateTransportType(){
        System.out.println("\n[TRANSPORT TYPE / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        TransportType transportType = getTransportTypeInputs();
        transportType.setId(id);
        transportTypeController.update(transportType.getId(), transportType);

        System.out.println("Transport type with ID=" + id + " successfully updated");
    }
    private void deleteTransportType(){
        System.out.println("[TRANSPORT TYPE / DELETE] Enter ID: ");
        int id = scanner.nextInt();
        transportTypeController.delete(id);
        System.out.println("Transport type with ID=" + id + " successfully deleted");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose your fighter:\n");
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (scanner.hasNext());
    }
}