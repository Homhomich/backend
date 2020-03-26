package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.AddressMapper;
import ru.relex.tastyfasty.services.dto.address.AddressDto;
import ru.relex.tastyfasty.services.mapstruct.AddressStruct;
import ru.relex.tastyfasty.services.service.IAddressService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class AddressServiceImpl implements IAddressService {

    private final AddressMapper addressMapper;
    private final AddressStruct addressStruct;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper, AddressStruct addressStruct) {
        this.addressMapper = addressMapper;
        this.addressStruct = addressStruct;
    }


    @Override
    public List<AddressDto> findAddresses(String search) {
        var addresses = addressMapper.getAddresses(search);
        return addressStruct.toDto(addresses);
    }

    @Override
    public AddressDto findAddressById(int addressId) {
        var address = addressMapper.getAddressById(addressId);
        return addressStruct.toDto(address);
    }

    @Override
    public AddressDto create(@Valid AddressDto addressDto) {
        var address = addressStruct.fromDto(addressDto);
        addressMapper.insert(address);
        return addressStruct.toDto(address);
    }

    @Override
    public AddressDto update(@Valid AddressDto addressDto) {
        var address = addressStruct.fromDto(addressDto);
        addressMapper.update(address);
        return addressStruct.toDto(address);
    }

    @Override
    public void remove(int addressId) {
        addressMapper.delete(addressId);
    }
}
