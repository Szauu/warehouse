package warehouse.controller;


import warehouse.model.dto.OwnerDto;
import warehouse.service.OwnerDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OwnerDtoRestController {

    private OwnerDtoService ownerDtoService;

    @PostMapping("api/owners/dto")
    public ResponseEntity<OwnerDto> createOwner(OwnerDto ownerDto) {
        OwnerDto result = ownerDtoService.create(ownerDto);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
