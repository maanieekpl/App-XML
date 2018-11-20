package lab6_task3;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import generated.Catalog;
import generated.Catalog.Book;


public class task3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		File file = new File("Book.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
		Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
		Catalog catalog = (Catalog) unmarshall.unmarshal(file);
		
//		for(Book cat : catalog.getBook()) {
//			System.out.println("Author: " + cat.getAuthor() +
//					"\nTitle: " + cat.getTitle() + 
//					"\nGenre: " + cat.getGenre() + 
//					"\nPrice: " + cat.getPrice() +
//					"\nPublish date: " + cat.getPublishDate() +
//					"\nDescription: " + cat.getDescription() + "\n");
//		}
		
		mostExpensive(catalog);
		avgPrice(catalog);
		titleOldestBook(catalog);
	}
	
	public static void mostExpensive(Catalog cat) {
		
		float price = 0;
		
		for(Book book : cat.getBook()) {
			if(price < book.getPrice()) {
				price = book.getPrice();
			}
		}	
		System.out.println("Most expensive book: " + price);
	}
	
	public static void avgPrice(Catalog cat) {
		
		float avgPrice;
		float temp = 0;
		int index = 0;
		
		for(Book book : cat.getBook()) {
			temp += book.getPrice();
			index++;
		}
		avgPrice = temp/index;
		System.out.println("Avarage price: " + avgPrice);
	}
	
	public static void titleOldestBook (Catalog cat) {
		
		String title = null;
		Date date = toDate(cat.getBook().get(0).getPublishDate());
		Date temp_date;

		
		for(Book book : cat.getBook()) {
			temp_date = toDate(book.getPublishDate());
			if(date.after(temp_date)) {
				date=toDate(book.getPublishDate());
				title = book.getTitle();
			}
		}
		
		System.out.println("Title of the oldest book: " + title);
		
	}
	
    public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }


}


