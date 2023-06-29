package com.hygorp.biblioteca.service;

import com.hygorp.biblioteca.domain.Address;
import com.hygorp.biblioteca.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    private Address findById(Integer id){
       Optional<Address> obj = addressRepository.findById(id);
       return obj.orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public void insert(Address obj){
        addressRepository.save(obj);
    }

    public void update(Address obj){
        Address newObj = findById(obj.getId());
        newObj.setAddress(obj.getAddress());
        newObj.setPostalCode(obj.getPostalCode());
        newObj.setCity(obj.getCity());
        newObj.setState(obj.getState());
        addressRepository.save(newObj);
    }

    public void delete(Integer id){
        addressRepository.deleteById(id);
    }
}
