package warehouse.controller;

import warehouse.model.WarItem;
import warehouse.service.WarItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    public WarItemService warItemService;

    public HomeController(WarItemService warItemService) {
        this.warItemService = warItemService;
    }


    @GetMapping("/warItems")
    public String getHomePage(Model model) {
        model.addAttribute("warItems", warItemService.getWarItems());
        return "index";
    }

    @PostMapping("warItems/add")
    public String addWarItem(@ModelAttribute WarItem incomeWarItem) {
        WarItem warItem = new WarItem();
        warItem.setBrand(incomeWarItem.getBrand());
        warItem.setName(incomeWarItem.getName());
        warItem.setQuantity(incomeWarItem.getQuantity());
        warItem.setPriceBuy(incomeWarItem.getPriceBuy());
        warItem.setPriceBuy(incomeWarItem.getPriceSell());
        warItem.setNote(incomeWarItem.getPriceSell());
        String operationResult = warItemService.createWarItem(warItem).getName();
        return "redirect:/warItems@message:dodano obiekt " + operationResult;
    }

    @GetMapping("warItems/delete")
    public String deleteWarItem(@RequestParam long id) {
        warItemService.deleteWarItem(id);
        return "redirect:/warItems";
    }

  @PostMapping("/warItems/update")
    public String updateWarItem(@ModelAttribute WarItem incomeWarItem) {
        WarItem warItem = warItemService.getWarItemById(incomeWarItem.getId());
        if(warItem ==null){
            return " no object to update! ";
        }
        warItem.setBrand(incomeWarItem.getBrand());
        warItem.setName(incomeWarItem.getName());
        warItem.setQuantity(incomeWarItem.getQuantity());
        warItem.setPriceBuy(incomeWarItem.getPriceBuy());
        warItem.setPriceBuy(incomeWarItem.getPriceSell());
        warItem.setNote(incomeWarItem.getPriceSell());
        warItemService.createWarItem(warItem);
        return "redirect:/warItems";
    }

}

