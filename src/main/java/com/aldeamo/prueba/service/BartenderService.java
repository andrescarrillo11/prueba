package com.aldeamo.prueba.service;

import com.aldeamo.prueba.dto.RequestDTO;
import com.aldeamo.prueba.entity.ArraysEntity;
import com.aldeamo.prueba.repository.BartenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BartenderService {

    @Autowired
    BartenderRepository bartenderRepository;

    public String respuesta(RequestDTO requestDTO){
        String respuesta = null;
        List<String> listaA = null;
        List<String> listaB = new ArrayList<>();
        Optional<ArraysEntity> arrays = bartenderRepository.findById(requestDTO.getIdPila());
        List<String> array = Arrays.asList(arrays.get().getInputArray().split(","));
        while(requestDTO.getIteraciones() > 0) {
            Integer[] arregloEnteros = new Integer[array.size()];
            for (int i = 0; i < array.size(); i++) {
                arregloEnteros[i] = Integer.parseInt(array.get(i));
            }
            Arrays.sort(arregloEnteros);

            int primerPrimo = 0;

            for (Integer arregloEntero : arregloEnteros) {
                if (esPrimo(arregloEntero)) {
                    primerPrimo = arregloEntero;
                    break;
                }
            }
            if(arregloEnteros.length == 0){
                break;
            }
            listaA = new ArrayList<>();
            for (int i = arregloEnteros.length - 1; i >= 0; i--) {
                if (arregloEnteros[i] % primerPrimo == 0) {
                    listaB.add(String.valueOf(arregloEnteros[i]));
                } else {
                    listaA.add(String.valueOf(arregloEnteros[i]));
                }
            }

            respuesta = listaB.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));

            if(listaA.size() > 0) {
                array = listaA;
            }else{
                break;
            }

            requestDTO.setIteraciones(requestDTO.getIteraciones()-1);
        }
        assert listaA != null;
        String delimitador = listaA.size() == 0 ? "" : ",";
        respuesta += delimitador + listaA.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        return respuesta;
    }

    public boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
}
