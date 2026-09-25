package com.xworkz.airapp.config;


import com.xworkz.airapp.aircraft.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages ={"com.xworkz.airapp.Year","com.xworkz.airapp.aircraft","com.xworkz.airapp.bank","com.xworkz.airapp.HDFC"})
@Configuration
public class AirCraftConfiguration {

    public AirCraftConfiguration(){
        System.out.println("configuration object created");
    }
    @Bean
    public Ball getBall(){
        return new Ball();
    }
//
    @Bean
    public Movie getMovie(){
        return  new Movie();
    }


    @Bean
    public Mobile getMobile(){
        return  new Mobile();
    }

    @Bean
    public  Kite getKite(){
        return new Kite();
    }

    @Bean
    public PG getPG(){
        return new PG();
    }

    @Bean
    public Building getBuilding(){
        return  new Building();
    }

    @Bean
    public Court getCourt(){
        return  new Court();
    }

    @Bean
    public ShoppingMall getShoppingMall(){
        return  new ShoppingMall();
    }


    @Bean
    public Laptop getLaptop(){
        return new Laptop();
    }

    @Bean
    public Password getPassword(){
        return new Password();
    }

    @Bean
    public Product getProduct(){
        return new Product();
    }


    @Bean
    public Temperature getTemperature(){
        return  new Temperature();
    }
}
