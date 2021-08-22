package ru.project.restaraunt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.project.restaraunt.dto.DishDTO;
import ru.project.restaraunt.service.DishService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/dishes")
public class MenuController {

    private final DishService dishService;

    @GetMapping("/{id}")
    public DishDTO getById(@PathVariable("id") BigInteger id) throws Exception {
        return dishService.getById(id);
    }

    @GetMapping("/list")
    public List<DishDTO> getList(@RequestParam(value = "id", required = false) BigInteger id,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value="price", required = false) BigDecimal price) {

        return dishService.getList(DishDTO.builder().id(id).name(name).price(price).build());
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody String dish) {
        dishService.create();
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody String dish) {
        dishService.update(dish);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") BigInteger id) {
        dishService.delete(id);
        return ResponseEntity.ok().build();
    }
}
