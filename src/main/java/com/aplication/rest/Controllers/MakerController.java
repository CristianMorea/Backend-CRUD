package com.aplication.rest.Controllers;

import com.aplication.rest.Controllers.dto.MakerDTO;
import com.aplication.rest.Entities.Maker;
import com.aplication.rest.Service.impl.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private MakerService makerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.finById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();

            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();

            return ResponseEntity.ok(makerDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAlld")
    public ResponseEntity<?> findAll() {
        List<MakerDTO> MakerList = makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(MakerList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO MakerDTO)
    {
        try
        {
            //convertir MakerDTO  a Maker
            Maker maker = new Maker();
            maker.setName(MakerDTO.getName());
            maker.setProductList(MakerDTO.getProductList());
            //guardamos el maker
            makerService.save(maker);
            //retornar la respuesta exitosa
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> deleteMakerById(@PathVariable Long id) {
        try {
            // Eliminar el Maker
            makerService.deleteById(id);
            return ResponseEntity.ok("Maker con ID " + id + " eliminado exitosamente");
        } catch (Exception e) {
            // Manejar cualquier error inesperado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado: " + e.getMessage());
        }
    }

}
