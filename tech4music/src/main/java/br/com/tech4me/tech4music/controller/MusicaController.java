package br.com.tech4me.tech4music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.service.MusicaService;
import br.com.tech4me.tech4music.shared.MusicaDTO;


@RestController
@RequestMapping("/api/tech4music")

public class MusicaController {
   @Autowired
   private MusicaService servico;

   @GetMapping
   public ResponseEntity<List<MusicaDTO>> obterMusicas() {
       return new ResponseEntity<>(servico.obterMusicas(), HttpStatus.FOUND);

   }

   @GetMapping(value="/{id}")
   public ResponseEntity<MusicaDTO> obterMusica(@PathVariable String id) {
       Optional<MusicaDTO> musica = servico.obterMusicaPorId(id); 
       if (musica.isPresent()){
           return new ResponseEntity<>(musica.get(), HttpStatus.FOUND);
       }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PostMapping
   public ResponseEntity<MusicaDTO> cadastrarMusica(@RequestBody MusicaDTO musica){
       return new ResponseEntity<>(servico.cadastrarMusica(musica), HttpStatus.CREATED);
   }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<Void> excluirMusica(@PathVariable String id, @RequestBody Musica novaMusica) {
     servico.excluirMusica(id);
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PutMapping(value = "/{}id")
   public ResponseEntity<Musica> atualizarMusica(@PathVariable String id, @RequestBody Musica novaMusica) {
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
       
   }
   
}
