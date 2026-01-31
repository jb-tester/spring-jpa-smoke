package com.mytests.spring.javajpaweb.addresses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping("/add/{city}-{street}-{zip}")
    public ResponseEntity<String> addAddress(@PathVariable String city, @PathVariable String street, @PathVariable String zip) {
        Address address = new Address(city, street, zip);
        addressRepository.addNewAddress(address);
        return ResponseEntity.ok("address added");
    }

    @GetMapping("/all")
    public List<Address> getAddresses() {
        return addressRepository.collectAllAddresses();
    }
    @GetMapping("/all/{city}")
    public List<Address> getAddressesByCity(@PathVariable String city) {
        return addressRepository.getAllAddressesByCityName(city);
    }

    @GetMapping("/update")
    public Address update() {
        addressRepository.mergeAddress(new Address("???", "???", "???"));
        int id = addressRepository.getAllAddressesByCityName("???").get(0).getId();
        Address a = addressRepository.updateAddress(id);
        return a;
    }
}
