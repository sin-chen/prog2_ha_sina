package datastructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

public class EventMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		HashSet<Event> events = new HashSet<Event>();
		
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2020,11,28);
		
		Event evt1 = new Event("Party1", "halle", calendar2);
		events.add(evt1);
		
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(2020,5,20);
		
		Event evt2 = new Event("Party2", "halle2", calendar3);
		events.add(evt2);
		
		Calendar calendar4 = Calendar.getInstance();
		calendar4.set(2020,11,28);
		
		Event evt3 = new Event("Party3","halle", calendar4);
		events.add(evt3);
		
		for(Event evt: events) {
			System.out.println("Name: " + evt.getEventName()+ "\n" + "Ort: " + evt.getPlace() + "\n" + "Datum: " + sdf.format(evt.getCalendar().getTime()) + "\n");
		}

	}

}
