package warehouse.service;


import warehouse.model.WarItem;
import warehouse.repository.WarItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarItemService {

    String errorMessage = "not found";
    private WarItemRepository warItemRepository;

    public WarItemService(WarItemRepository warItemRepository) {
        this.warItemRepository = warItemRepository;
    }

    public WarItem createWarItem(WarItem warItem) {
        return warItemRepository.save(warItem);
    }

    public List<WarItem> getWarItems() {
        return warItemRepository.findAll();
    }

    public WarItem getWarItemById(long id) {
        return warItemRepository.findById(id).orElseThrow(Error::new);
    }

    public WarItem updateWarItem(long id, WarItem warItem) {

        return warItemRepository.findById(id).map(w -> {
            w.setBrand(warItem.getBrand());
            w.setName(warItem.getName());
            w.setQuantity(warItem.getQuantity());
            w.setPriceBuy(warItem.getPriceBuy());
            w.setPriceSell(warItem.getPriceSell());
            w.setNote(warItem.getNote());
            return warItemRepository.save(w);
        }).orElseThrow(() -> new RuntimeException(errorMessage));

    }

    public ResponseEntity<?> deleteWarItem(long id) {
        return warItemRepository.findById(id).map(w -> {
            warItemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RuntimeException(errorMessage));
    }
}
