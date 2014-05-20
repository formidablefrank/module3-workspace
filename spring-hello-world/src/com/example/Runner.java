package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Runner {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("applicationContext.xml"));
		//changing the implementing class using the bean name space
		HelloMessage helloMessageEnglish = (HelloMessage) beanFactory.getBean("mr-bean");
		HelloMessage helloMessageFrench = (HelloMessage) beanFactory.getBean("clousseau");
		Chipmunks chipmunks = (Chipmunks) beanFactory.getBean("chipmunks");
		
		//the class should talk to the container for it to be injected
		//the runner is not managed by Spring
		//the application should not now the implementing class
		//we can make the implementing class disappear in this code
		//src is a default location for the application-context.xml
		//System.out.println(helloMessageEnglish.getMessage());
		//System.out.println(helloMessageFrench.getMessage());
		
		for(String chipmunk: chipmunks.getNames()){
			//System.out.println(chipmunk);
		}
		
		//USStates usStates = (USStates) beanFactory.getBean("usStates");
		//System.out.println(usStates.getStateNames().get("VA"));
		
		Characters characters = (Characters) beanFactory.getBean("characters");
		System.out.println(characters.getCharacters());
	}

}
