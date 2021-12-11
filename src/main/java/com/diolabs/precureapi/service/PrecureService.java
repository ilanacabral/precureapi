package com.diolabs.precureapi.service;

import com.diolabs.precureapi.document.Precure;
import com.diolabs.precureapi.repository.PrecureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PrecureService {
    @Autowired
    private PrecureRepository precureRepository;

    public Flux<Precure> findAll() {
        return Flux.fromIterable(this.precureRepository.findAll());
    }

    public Mono<Precure> findByIdHero(String id) {
        return Mono.justOrEmpty(this.precureRepository.findById(id));
    }

    public Mono<Precure> save(Precure precure) {
        return Mono.justOrEmpty(this.precureRepository.save(precure));
    }

    public Mono<Boolean> deletebyIDHero(String id) {
        precureRepository.deleteById(id);
        return Mono.just(true);
    }

}