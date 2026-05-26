package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.BaseEntity;
import com.sistema.vuelo.Repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <E extends BaseEntity, ID extends Serializable> implements BaseService<E,ID> {

    protected BaseRepository<E,ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E,ID> baseRepository) {
        this.baseRepository = baseRepository;
    }


    @Override
    public List<E> findAll() throws Exception {
        try{
            return baseRepository.findAll();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }



    @Override
    public  E findById(ID id) throws Exception{
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E save(E entity) throws Exception {
        try{
            return baseRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            return baseRepository.save(entityOptional.get());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public boolean deleteById(ID id) throws Exception {
        try{
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
