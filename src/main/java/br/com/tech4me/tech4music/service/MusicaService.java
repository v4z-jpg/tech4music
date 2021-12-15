package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4music.shared.MusicaDTO;

public interface MusicaService {
    List<MusicaDTO> obterMusicas();
    MusicaDTO cadastrarMusica(MusicaDTO carro);
    Optional<MusicaDTO> obterMusicaPorId(String id);
    void excluirMusica(String id);
    MusicaDTO atualizarMusica (String id, MusicaDTO novaMusica);
    

}
