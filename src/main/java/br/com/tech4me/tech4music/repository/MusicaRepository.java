package br.com.tech4me.tech4music.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.shared.MusicaDTO;

    public interface MusicaRepository extends MongoRepository<Musica, String>{

        MusicaDTO save(MusicaDTO musica);

    }