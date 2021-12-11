package com.diolabs.precureapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.diolabs.precureapi.constant.PrecureConstant.PRECURE_ENDPOINT_LOCAL;

import com.diolabs.precureapi.document.Precure;
import com.diolabs.precureapi.service.PrecureService;

@RestController
@Slf4j
public class PrecureController {
  @Autowired  
  private PrecureService precureService;

  @GetMapping(PRECURE_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.OK)
  public Flux<Precure> getAllItems() {
    log.info("requesting the list off all precure");
    return precureService.findAll();
  }

  @GetMapping(PRECURE_ENDPOINT_LOCAL + "/{id}")
  public Mono<ResponseEntity<Precure>> findByIdHero(@PathVariable String id) {
    log.info("Requesting the hero with id {}", id);
    return precureService.findByIdHero(id)
      .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
      .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping(PRECURE_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Precure> createHero(@RequestBody Precure precure) {
    log.info("A new Hero was Created");
    return precureService.save(precure);
  }

  @DeleteMapping(PRECURE_ENDPOINT_LOCAL + "/{id}")
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
    precureService.deletebyIDHero(id);
    log.info("Deleting the hero with id {}", id);
    return Mono.just(HttpStatus.NOT_FOUND);
  }
}