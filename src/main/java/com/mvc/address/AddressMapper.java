

package com.mvc.address;

import org.springframework.stereotype.Service;

@Service
public class AddressMapper {
	 public AddressResponse toAddressDto(Address adr) {
    	var addrresponse = new AddressResponse();
		addrresponse.setHomeAddress(adr.getHomeAddress());
		
		 //std.getNbrSubjects().size()
		 return addrresponse;
    }

    public Address toAddress(AddressRequest adr) {
       Address address = new Address();
        address.setId(adr.getId());
        address.setHomeAddress(adr.getHomeAddress());
      
     
        return address;
    }
}

