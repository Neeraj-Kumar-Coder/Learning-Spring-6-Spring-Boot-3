package com.simpleAPI.springBoot.controller;

import com.simpleAPI.springBoot.beans.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class EntityController {

    @GetMapping("/getEntity")
    public Entity getEntity() {
        return new Entity(1, "Living Organism");
    }

    @GetMapping("/getEntities")
    public List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity(1, "Nature"));
        entities.add(new Entity(2, "Humans"));
        entities.add(new Entity(3, "Animals"));
        entities.add(new Entity(4, "Microorganisms"));

        return entities;
    }

//    id -> URI template variable
    @GetMapping("/getEntity/{id}")
    public Entity getEntityByID(@PathVariable("id") int studentID) {
        return new Entity(studentID, "SomeDarkEntity");
    }

    @GetMapping("/getEntity/query")
    public Entity getStudentQuery(@RequestParam("id") int studentID) {
        return new Entity(studentID, "QueryEntity");
    }

    @PostMapping("/entity/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Entity createEntity(@RequestBody Entity entity) {
        System.out.printf(entity.getId() + " " + entity.getType());
        return entity;
    }

    @PutMapping("/entity/update/{id}")
    public Entity updateEntity(@RequestBody Entity entity, @PathVariable("id") int entityId) {
        entity.setId(entityId);
        return entity;
    }

    @DeleteMapping("/entity/delete/{id}")
    public String deleteEntity(@PathVariable("id") int entityId) {
        return String.format("%d ID successfully deleted!", entityId);
    }

    @GetMapping("/new/getEntity")
    public ResponseEntity<?> sendEntity() {
//        return new ResponseEntity<>(new Entity(99, "Dragons"), HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "neeraj").body(new Entity(99, "Dragons"));
    }
}
