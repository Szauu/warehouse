package warehouse.mapper;

import warehouse.model.Owner;
import warehouse.model.dto.OwnerDto;
import org.springframework.stereotype.Component;

@Component
public class OwnerDtoMapper implements Mapper<Owner, OwnerDto> {

    @Override
    public OwnerDto map(Owner from){
        return new OwnerDto.Builder().name(from.getName()).build();
    }

    @Override
    public Owner revers(OwnerDto to){
        return null;
    }
}
