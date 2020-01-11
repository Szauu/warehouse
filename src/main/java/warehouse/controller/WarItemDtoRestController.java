package warehouse.controller;


import warehouse.model.dto.WarItemDto;
import warehouse.service.WarItemDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WarItemDtoRestController {

    private WarItemDtoService warItemDtoService;

    @PostMapping("api/waritems/dto")
    public ResponseEntity<WarItemDto> createWarItem( WarItemDto warItemDto) {
   WarItemDto result = warItemDtoService.create(warItemDto);
   if(result==null){
       return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
   }return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
