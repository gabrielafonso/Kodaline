package com.afonjasam.Kodaline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afonjasam.Kodaline.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

}
