package com.mvc.address;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import jakarta.validation.Valid;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	   
	    private final AddressService adrService;

	    public AddressController(AddressService adrService) {
	        this.adrService = adrService;
	    }

	    @PostMapping
	    public ResponseEntity<Void> save(
	            @RequestBody @Valid AddressRequest adr
	    ) {
	        adrService.save(adr);
	        return ResponseEntity
	                .accepted()
	                .build();
	    }

	    @GetMapping("/{adress-id}")
	    public ResponseEntity<AddressResponse> findById(
	            @PathVariable("address-id") Integer addressId
	    ) {
	        return ResponseEntity.ok(adrService.findById(addressId));
	    }

	    @GetMapping
	    public ResponseEntity<List<AddressResponse>> findAll() {
	        return ResponseEntity.ok(adrService.findAll());
	    }

	}