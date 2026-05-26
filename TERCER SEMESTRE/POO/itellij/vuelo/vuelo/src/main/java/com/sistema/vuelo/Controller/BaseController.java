package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Model.BaseEntity;
import com.sistema.vuelo.Service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController<E extends BaseEntity, ID extends Serializable> {


    protected BaseService <E, ID> baseService;

    public BaseController (BaseService <E, ID> baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public ResponseEntity<List<E>> getAll() {
        try{
            List<E> entities = baseService.findAll();
            return ResponseEntity.ok(entities);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> getById(@PathVariable ID id) {
        try{
            E entity = baseService.findById(id);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<E> save(@RequestBody E entity) {
        try {
            E saved = baseService.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<E> update(@PathVariable ID id, @RequestBody E entity) {
        try {
            E updated = baseService.update(id, entity);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ID id) {
        try{
            boolean deleted = baseService.deleteById(id);
            return ResponseEntity.ok(deleted);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



























}
