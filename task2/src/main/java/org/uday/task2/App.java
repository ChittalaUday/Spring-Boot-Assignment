package org.uday.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.uday.task2.model.Car;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	Car car = context.getBean("car",Car.class);
    	car.drive();
    	
    	Car carSetter = context.getBean("carWithSetter",Car.class);
    	carSetter.drive();
    }
}
