package lab6_task1;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import generated.Chessboard;
import generated.Chessboard.Pawn;

public class task1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File file = new File("chessboard.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Chessboard.class);
		Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
		Chessboard chessboard = (Chessboard) unmarshall.unmarshal(file);
		
		for(Pawn chess : chessboard.getPawn()) {
			System.out.println("name: " + chess.getName() + "\nposition: " + chess.getPosition());
		}
	}

}
