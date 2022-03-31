package com.proenade.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proenade.projeto.model.Provas;
import com.proenade.projeto.repository.ProvasRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/proenade")
@Api(value="API REST Projeto")
@CrossOrigin(origins="*")
public class ProvasController {
	
	@Autowired
	ProvasRepository provasRepository;

	@GetMapping("/provas")
	@ApiOperation(value="Retorna uma lista de provas")
	public List<Provas> listaProvas(){
		return provasRepository.findAll();
	}
	
	@GetMapping("/provas/{id}")
	@ApiOperation(value="Retorna uma unica prova.")
	public Provas listaProvaUnica(@PathVariable(value="id") long id){
		return provasRepository.findById(id);
	}
	
	@PostMapping("/provas")
	@ApiOperation(value="Salva uma prova.")
	@ResponseStatus(HttpStatus.CREATED)
	public Provas save(@RequestBody Provas provas) {
		return provasRepository.save(provas);
	}
	
	@DeleteMapping("/provas")
	@ApiOperation(value="Deleta uma prova.")
	public void deletarProva(@RequestBody Provas provas){
		provasRepository.delete(provas);
	}
	
	@PutMapping("/provas")
	@ApiOperation(value="Altera uma prova.")
	public Provas alterarProva(@RequestBody Provas provas){
		return provasRepository.save(provas);
	}
}
