package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity, Id extends Serializable> extends JpaRepository<E,Id> {
}
