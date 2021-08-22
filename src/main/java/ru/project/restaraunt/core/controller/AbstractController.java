package ru.project.restaraunt.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AbstractController<CreateDTO, UpdateDTO, FilterDTO, ListDTO> {

}
