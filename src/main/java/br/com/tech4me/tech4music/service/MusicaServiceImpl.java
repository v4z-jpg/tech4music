package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.repository.MusicaRepository;
import br.com.tech4me.tech4music.shared.MusicaDTO;

public class MusicaServiceImpl implements MusicaService{
    @Autowired
    private MusicaRepository repo;


    @Override
    public List<MusicaDTO> obterMusicas() { 
        List<Musica> musicas = repo.findAll();

        return musicas.stream()
        .map(c -> new ModelMapper().map(c, MusicaDTO.class))
        .collect(Collectors.toList());
    }


    @Override
    public Optional<MusicaDTO> obterMusicaPorId(String id) {
        Optional<Musica> musicaBusca = repo.findById(id);
        return Optional.of(new ModelMapper().map(musicaBusca, MusicaDTO.class));
    }

    @Override
    public void excluirMusica(String id) {
        repo.deleteById(id);
    }

    @Override
    public MusicaDTO atualizarMusica(String id, MusicaDTO novaMusica) {
        Musica musicaParaAtualizar = new ModelMapper().map(novaMusica, Musica.class);
        musicaParaAtualizar.setId(id);
        musicaParaAtualizar = repo.save(musicaParaAtualizar);
        return new ModelMapper().map(musicaParaAtualizar, MusicaDTO.class);
        
    }

    @Override
    public MusicaDTO cadastrarMusica(MusicaDTO musica) {
        Musica musicaCadastro = new ModelMapper().map(musica, Musica.class);
        musicaCadastro = repo.save(musicaCadastro);
        return new ModelMapper().map(musicaCadastro, MusicaDTO.class);

    }
    
}
