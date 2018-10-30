package com.afonjasam.Kodaline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afonjasam.Kodaline.model.Fotos;


@Repository
public interface FotosRepository extends JpaRepository<Fotos, Long> {

}
