package com.mvc.address;

import java.util.List;





public interface AddressService {
	void save(AddressRequest s);
    AddressResponse findById(Integer id);
    List<AddressResponse> findAll();
    void deleteById(Integer id);

}









	
	
