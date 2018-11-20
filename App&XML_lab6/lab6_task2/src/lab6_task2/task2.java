package lab6_task2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import generated.Menu;
import generated.Menu.Food;

public class task2 {
	public static void main(String[] args) throws JAXBException {
		
		generated.ObjectFactory factory = new generated.ObjectFactory();
		
		Menu menu = factory.createMenu();
		menu.getFood();
		
		Food food = factory.createMenuFood();
		food.setCategory("Espanol");
		
		food.setName("Paella");
		food.setPrice((float) 29.99);
		food.setDescription("Some description");
		food.setCalories(689);
		menu.getFood().add(food);
		
		
		
		
		File file = new File("task2.xml");
		JAXBContext context = JAXBContext.newInstance("generated");
		Marshaller marshall = context.createMarshaller();
		marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshall.marshal(menu, file);
		marshall.marshal(menu,System.out);
		
		
		
	}
}
