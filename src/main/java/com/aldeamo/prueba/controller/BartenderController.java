package com.aldeamo.prueba.controller;

import com.aldeamo.prueba.dto.RequestDTO;
import com.aldeamo.prueba.dto.ResponseDTO;
import com.aldeamo.prueba.service.BartenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prueba")
@CrossOrigin(origins = "*")
public class BartenderController {

    @Autowired
    BartenderService bartenderService;

    @GetMapping("/respuesta")
    public ResponseEntity<ResponseDTO> iteraciones(@RequestBody RequestDTO requestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setRespuesta(bartenderService.respuesta(requestDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
