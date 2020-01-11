package warehouse.service;


import warehouse.mapper.WarItemDtoMapper;
import warehouse.model.WarItem;
import warehouse.model.dto.WarItemDto;
import warehouse.repository.WarItemRepository;
import org.springframework.stereotype.Service;

@Service
public class WarItemDtoService {

    private WarItemRepository warItemRepository;
    private WarItemDtoMapper warItemDtoMapper;

    public WarItemDto create(WarItemDto warItemDto) {
        WarItem warItem = new WarItem();
        warItem.setBrand(warItemDto.getBrand());
        warItem.setName(warItemDto.getName());
        warItem.setQuantity(warItemDto.getQuantity());
        warItem.setPriceBuy(warItemDto.getPriceBuy());
        warItem.setPriceBuy(warItemDto.getPriceBuy());
        warItem.setNote(warItemDto.getNote());

        warItemRepository.save(warItem);
        return warItemDtoMapper.map(warItem);
    }
}


