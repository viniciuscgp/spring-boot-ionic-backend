package br.app.narede.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.app.narede.cursomc.domain.Cliente;
import br.app.narede.cursomc.dto.ClienteDTO;
import br.app.narede.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id) {
		Cliente obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> listaCliente = service.findAll();
		List<ClienteDTO> listaDto = 
				listaCliente.stream().map(obj-> new ClienteDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDto);
	}
	
	@GetMapping(value="/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24")  Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		
		Page<Cliente> listaCliente = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> listaDto = listaCliente.map(obj-> new ClienteDTO(obj));

		return ResponseEntity.ok().body(listaDto);
	}
	
	
	
	
}

