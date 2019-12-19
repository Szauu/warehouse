package akademia.mapper;


import akademia.model.WarItem;
import akademia.model.dto.WarItemDto;
import org.springframework.stereotype.Component;

@Component
public class WarItemDtoMapper implements Mapper<WarItem, WarItemDto> {
    @Override
    public WarItemDto map(WarItem from) {
        return new WarItemDto
                .Builder()
                .brand(from.getBrand())
                .name(from.getName())
                .quantity(from.getQuantity())
                .priceBuy(from.getPriceBuy())
                .priceSell(from.getPriceSell())
                .note(from.getNote())
                .build();
    }

    @Override
    public WarItem revers(WarItemDto to) {
        return null;
    }
}
