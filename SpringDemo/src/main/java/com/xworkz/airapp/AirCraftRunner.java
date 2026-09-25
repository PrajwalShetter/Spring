package com.xworkz.airapp;

import com.xworkz.airapp.Electricity.ElectricBill;
import com.xworkz.airapp.Year.Calender;
import com.xworkz.airapp.aircraft.*;
import com.xworkz.airapp.bank.BankAccount;
import com.xworkz.airapp.book.Book;
import com.xworkz.airapp.config.AirCraftConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AirCraftRunner    {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AirCraftConfiguration.class);
        AirCraft airCraft = applicationContext.getBean(AirCraft.class);

        airCraft.setId(1);
        airCraft.setModel(778);
        airCraft.setName("Boing");
        System.out.println(airCraft);
        airCraft.war();


        Ball ball = applicationContext.getBean(Ball.class);
        ball.setBallName("wicky");
        ball.setBallSize(15.5);
        ball.setCost(90.80);
        ball.play();
        System.out.println(ball);

        Movie movie = applicationContext.getBean(Movie.class);
        movie.setBudget(5000000);
        movie.setName("Lalu");
        movie.setHeroName("Singh");
        System.out.println(movie);
        movie.watchMovie();

        Calender calender = applicationContext.getBean(Calender.class);
        calender.setName("mahaLaxmi Calender");
        calender.setSize(18.90);
        calender.setCost(9000);
        System.out.println(calender);
        calender.newYear();


        Mobile mobile = applicationContext.getBean(Mobile.class);
        mobile.setName("Redmi");
        mobile.setCost(2000000);
        mobile.setWaterProof(true);
        System.out.println(mobile);
        mobile.working();


        Kite kite = applicationContext.getBean(Kite.class);
        kite.setShape("circle");
        kite.setDurability(45);
        kite.setMadeUpOff("paper");
        System.out.println(kite);
        kite.fly();

        PG pg = applicationContext.getBean(PG.class);
        pg.setGood(false);
        pg.setName("mayura stay in");
        pg.setRent(5500.00);
        System.out.println(pg);
        pg.livingCost();

        Building building = applicationContext.getBean(Building.class);
        building.setBuildingName("Apporva");
        building.setFloors(6);
        building.setAppriciationAmt(40000.70);
        building.buildingEnvironment();
        System.out.println(building);

        Court court = applicationContext.getBean(Court.class);
        court.setName("High court");
        court.setJudgeName("narayna murthy");
        court.setNumberOfLawyers(25);
        court.courtTime();
        System.out.println(court);

        ShoppingMall shoppingMall = applicationContext.getBean(ShoppingMall.class);
        shoppingMall.setMallManager("Kishor");
        shoppingMall.setName("mantri Mall");
        shoppingMall.setNumberOfShops(32);
        shoppingMall.mallTime();
        System.out.println(shoppingMall);

        com.xworkz.airapp.bank.BankAccount bankAccount = applicationContext.getBean("b1",BankAccount.class);
        bankAccount.setAccountHolder("Gagan");
        bankAccount.setAccountNumber(99887766889004L);
        bankAccount.setBalance(900000);
        bankAccount.deposit(30000);
        System.out.println(bankAccount);

        Laptop laptop = applicationContext.getBean(Laptop.class);
        laptop.setBrand("Hp");
        laptop.setPrice(700000);
        laptop.setRam(4);
        laptop.upgradeRam(2);
        System.out.println(laptop);

        Book book = applicationContext.getBean(Book.class);
        book.setTitle("Programming");
        book.setPrice(190);
        book.setAuthor("Prajwal");
        book.applyDiscount(10);
        System.out.println(book);

        Password password = applicationContext.getBean(Password.class);
        password.setPassword("Phagji@9879");
        password.setAttempts(3);
        password.setUsername("Prakash");
        password.checkStrength();
        System.out.println(password);

        Product product = applicationContext.getBean(Product.class);
        product.setPrice(120.78);
        product.setProductName("Nail Cutter");
        product.setQuantity(1);
        System.out.println(product);
        product.calculateTotalPrice();

        ElectricBill electricBill = applicationContext.getBean(ElectricBill.class);
        electricBill.setBillAmount(12000);
        electricBill.setCustomerName("Ravi");
        electricBill.setUnitsConsumed(34);
        electricBill.calculateBill();
        System.out.println(electricBill);

        Temperature temperature = applicationContext.getBean(Temperature.class);
        temperature.setCelsius(60.6);
        temperature.setFahrenheit(30.9);
        temperature.setUnit("90");
        temperature.convertToFahrenheit();
        System.out.println(temperature);

    }
}
