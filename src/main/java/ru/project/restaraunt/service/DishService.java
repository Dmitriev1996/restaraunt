package ru.project.restaraunt.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.restaraunt.dto.DishDTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishService {

    private List<DishDTO> dishes = Arrays.asList(
            createDish(1, "Отбивная из телятины с картофельным пюре", 450.00),
            createDish(2, "Суп-пюре с белыми грибами", 400.00),
            createDish(3, "Чизкейк", 200.00)
    );

    private DishDTO createDish(int id, String name, double price) {
        return DishDTO.builder()
                .id(new BigInteger(id + ""))
                .name(name)
                .price(new BigDecimal(price))
                .build();
    }

    public DishDTO getById(BigInteger id) throws Exception {
        return dishes.stream()
                .filter(dishDTO -> dishDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Блюдо не найдено"));
    }

    public List<DishDTO> getList(DishDTO filters) {
        return dishes.stream()
                .filter(dishDTO -> dishDTO.getId() == filters.getId()
                        || dishDTO.getName() == filters.getName()
                        || dishDTO.getPrice().intValue() == filters.getPrice().intValue())
                .collect(Collectors.toList());
    }

    public void create() {}

    public void update(String dish) {}

    public void delete(BigInteger id) {}
}
