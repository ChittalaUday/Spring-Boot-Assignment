package org.uday.task2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.uday.task2.model.Car;
import org.uday.task2.model.Engine;

@Configuration	
public class AppConfig {
	
	@Bean
	public Engine engine() {
		return new Engine("V8");
	}
	
	@Bean
	public Car car() {
		return new Car(engine());
	}
	
	@Bean
    public Car carWithSetter() {
        Car car = new Car(null); 
        car.setEngine(new Engine("V6"));
        return car;
    }

}
