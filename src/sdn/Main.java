package sdn;

import sdn.SDNEntry;
import sdn.XMLManager;

public class Main {

	public static void main(String[] args) {
		for(SDNEntry sdn : XMLManager.getAllSDNEntry()){
            System.out.println("lastName : "+sdn.getLastName());
            System.out.println("sdnType : "+sdn.getSdnType());
            System.out.println("program : "+sdn.getProgram());
            System.out.println("aka->type : "+sdn.getAka_type());
            System.out.println("aka->category : "+sdn.getAka_category());
            System.out.println("aka->lastName : "+sdn.getAka_lastname());
            System.out.println("address->address1 : "+sdn.getAddress_address1());
            System.out.println("address->city : "+sdn.getAddress_city());
            System.out.println("address->postalCode : "+sdn.getAddress_postalcode());
            System.out.println("address->country : "+sdn.getAddress_country());
            System.out.println("------------------------");
        }
	}
}
