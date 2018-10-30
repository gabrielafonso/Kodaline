package com.afonjasam.Kodaline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afonjasam.Kodaline.model.Fotografo;


@Repository
public interface FotografoRepository extends JpaRepository<Fotografo, Long>{

}
