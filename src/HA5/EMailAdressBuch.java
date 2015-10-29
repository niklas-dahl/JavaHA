package HA5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class EMailAdressBuch {
	
	HashMap<String, String> addrs = new HashMap<>();
	
	public EMailAdressBuch() {
		
	}
	
	public void einfuegen(String name, String email) {
		this.addrs.put(name, email);
	}
	
	public String abfrage(String name) {
		String email = addrs.get(name);
		if(email==null)
			throw new UnknownNameException("Name \"" + name + "\" befindet sich nicht im Adressbuch!");
		return email;
	}
	
	public String toString() {
		StringBuilder ret=new StringBuilder("{");
		boolean first=true;
		for(Entry<String, String> eintrag : addrs.entrySet()) {
			if(!first)
				ret.append(", ");
			else
				first=false;
			ret.append(eintrag.getKey() + "=" + eintrag.getValue());
		}
		ret.append("}");
		return ret.toString();
	}
	
	public void einlesen(String dateiname) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(dateiname), "UTF-8");
		while(sc.hasNextLine()) {
			String[] eintrag = sc.nextLine().split(";",2);
			addrs.put(eintrag[0], eintrag[1]);
		}
		sc.close();
	}
	
	public void mitarbeiterEinlesen (URL url) throws IOException {
		Scanner sc = new Scanner((InputStream) url.openConnection().getContent(), "UTF-8");
		while(sc.hasNextLine()) {
			String[] eintrag = sc.nextLine().split(";",2);
			addrs.put(eintrag[0], eintrag[1]);
		}
		sc.close();
	}

}
