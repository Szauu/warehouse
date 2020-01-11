package warehouse.service;


import warehouse.mapper.OwnerDtoMapper;
import warehouse.model.Owner;
import warehouse.model.dto.OwnerDto;
import warehouse.repository.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerDtoService {

    private OwnerRepository ownerRepository;
    private OwnerDtoMapper ownerDtoMapper;

    public OwnerDto create(OwnerDto ownerDto){
        Owner owner = new Owner();
        owner.setName(ownerDto.getName());
        ownerRepository.save(owner);
        return ownerDtoMapper.map(owner);
    }
}
