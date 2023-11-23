package com.mvc.address.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.mvc.address.Address;
import com.mvc.address.AddressMapper;
import com.mvc.address.AddressRepository;
import com.mvc.address.AddressRequest;
import com.mvc.address.AddressResponse;
import com.mvc.address.AddressService;
import com.mvc.student.Student;
import com.mvc.student.StudentMapper;
import com.mvc.student.StudentRepository;
import com.mvc.student.StudentRequest;
import com.mvc.student.StudentResponse;

public class AddressServiceImpl implements AddressService {

	  private final AddressRepository addressRepository = null;
	    private final AddressMapper addressmapper = new AddressMapper();

	    @Override
	    public void save(AddressRequest s) {
	        Address address =addressmapper.toAddress(s);
	        this.addressRepository.save(address);
	    }

	    @Override
	    public AddressResponse findById(Integer id) {
	        return this.addressRepository.findById(id)
	                .map(addressmapper::toAddressDto)
	                .orElse(new AddressResponse());
	    }

	    @Override
	    public List<AddressResponse> findAll() {
	        return this.addressRepository.findAll()
	                .stream()
	                .map(addressmapper::toAddressDto)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public void deleteById(Integer id) {
	        this.addressRepository.deleteById(id);
	    }
	}
