package pl.krystianminta;

import org.xml.sax.SAXException;
import pl.krystianminta.factory.AbstractFactory;
import pl.krystianminta.factory.AbstractFactoryImpl;
import pl.krystianminta.vehicle.Vehicle;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AbstractFactory factory = AbstractFactoryImpl.getInstance();

        OrderParser parser = OrderParser.getInstance();

        Queue<String> order = null;

        String action;
        do{
            System.out.println("Choose option:");
            System.out.println("(1) Make order");
            System.out.println("(0) Exit");

            action = scanner.nextLine();

            switch (action) {
                case "1":
                    System.out.println("Waiting for order file name/absolute path: ");
                    try {
                        order = parser.parseOrderXML(scanner.nextLine());
                        int orderValue = 0;
                        for(Object vehicle : factory.makeOrder(order)) {
                            orderValue += ((Vehicle)vehicle).getPrice();
                        }
                        System.out.println("Total: " + orderValue);
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (SAXException e) {
                        System.out.println("Order file error! Check for errors in file syntax.");
                    } catch (IOException e) {
                        System.out.println("File does not exist!");
                    }
                    break;

                case "0":
                    System.out.println("Program will be closed now!");
                    break;

                default:
                    System.out.println("Incorrect choice!");
            }
        }while(!action.equalsIgnoreCase("0"));


    }

}
