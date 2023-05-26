package com.albatross.management.Albatross.Management.controllers;

import com.albatross.management.Albatross.Management.beans.DataItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class DatabaseController {
    private HashMap<Integer, DataItem> database;
    public DatabaseController() {
        this.database = new HashMap<>();
    }

    @GetMapping("/generateRandomDataItems")
    public ResponseEntity<?> fillRandomDataItems(@RequestParam("count") int count) {
        if (!this.database.isEmpty())
            return new ResponseEntity<>("The database is NOT empty!", HttpStatus.BAD_REQUEST);

        for (int i = 0; i < count; i++) {
            this.database.put(i, new DataItem(i, "Sample type " + i));
        }

        return new ResponseEntity<>(String.format("%d Date Items created successfully!", count), HttpStatus.OK);
    }

    @GetMapping("/getDataItems")
    public ResponseEntity<?> getDataItems() {
        ArrayList<DataItem> result = new ArrayList<>();
        this.database.forEach((key, value) -> {
            result.add(value);
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/addDataItem")
    public ResponseEntity<?> addDataItem(@RequestBody DataItem dataItem) {
        if (!this.database.containsKey(dataItem.getId())) {
            this.database.put(dataItem.getId(), dataItem);
            return new ResponseEntity<>(String.format("Data with id %d added successfully!", dataItem.getId()), HttpStatus.OK);
        }
        return new ResponseEntity<>(String.format("Data with id %d already exists!", dataItem.getId()), HttpStatus.CONFLICT);
    }

    @DeleteMapping("/deleteDataItem/{id}")
    public ResponseEntity<?> deleteDataItem(@PathVariable("id") int key) {
        if (!this.database.containsKey(key)) {
            return new ResponseEntity<>(String.format("Data Item with key %d doesn't exists!", key), HttpStatus.NOT_FOUND);
        }

        this.database.remove(key);
        return new ResponseEntity<>(String.format("Data Item with key %d successfully deleted!", key), HttpStatus.OK);
    }

    @PutMapping("/updateDataItem")
    public ResponseEntity<?> updateDataItem(@RequestParam("id") int key, @RequestBody DataItem dataItem) {
        if (!this.database.containsKey(key)) {
            return new ResponseEntity<>(String.format("Data Item with key %d doesn't exists!", key), HttpStatus.NOT_FOUND);
        }

        dataItem.setId(key);
        this.database.replace(key, dataItem);
        return new ResponseEntity<>(String.format("Data Item with key %d updated successfully!", key), HttpStatus.OK);
    }
}
