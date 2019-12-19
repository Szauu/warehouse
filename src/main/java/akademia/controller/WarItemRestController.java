package akademia.controller;


import akademia.model.WarItem;
import akademia.service.WarItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WarItemRestController {

    private WarItemService warItemService;

    public WarItemRestController(WarItemService warItemService) {
        this.warItemService = warItemService;
    }

    @GetMapping("api/waritems")
    public List<WarItem> getWarItems() {
        return warItemService.getWarItems();
    }

    @GetMapping("api/waritems/{id}")
    public WarItem getWarItems(@PathVariable long id) {
        return warItemService.getWarItemById(id);
    }

    @PostMapping("api/waritems")
    public WarItem createWarItem(@RequestBody WarItem warItem) {
        return warItemService.createWarItem(warItem);
    }

    @DeleteMapping("api/waritems/{id}")
    public ResponseEntity<?> deleteWarItem(@PathVariable long id) {
        return warItemService.deleteWarItem(id);
    }

    @PutMapping("api/waritems/{id}")
    public WarItem updateWarItem(@PathVariable long id, @RequestBody WarItem warItem) {
        return warItemService.updateWarItem(id, warItem);
    }

}
