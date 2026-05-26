package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


public interface BaseService <E extends BaseEntity, ID extends Serializable> {

    public List<E> findAll() throws  Exception;

    public E findById(ID id) throws  Exception;

    public E save(E entity) throws  Exception;

    public E update(ID id,E entity) throws  Exception;

    public boolean deleteById(ID id) throws  Exception;


}
