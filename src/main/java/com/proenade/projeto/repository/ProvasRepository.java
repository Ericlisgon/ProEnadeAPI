package com.proenade.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proenade.projeto.model.Provas;

@Repository
public interface ProvasRepository extends JpaRepository<Provas, Long>{
	Provas findById(long id);
}
