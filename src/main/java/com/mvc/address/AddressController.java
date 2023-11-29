package com.mvc.address;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/addresses")
public class AddressController {

	  
    private final AddressService adrservice;

    public AddressController(AddressService adrservice) {
        this.adrservice = adrservice;
    }

    @PostMapping
    public ResponseEntity<Void> save(
            @RequestBody @Valid AddressRequest address) {
        adrservice.save(address);
        return ResponseEntity
                .accepted()
                .build();
    }

    @GetMapping("/{address-id}")
    public ResponseEntity<AddressResponse> findById(
            @PathVariable("address-id") Integer addressId
    ) {
        return ResponseEntity.ok(adrservice.findById(addressId));
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll() {
        return ResponseEntity.ok(adrservice.findAll());
    }

}