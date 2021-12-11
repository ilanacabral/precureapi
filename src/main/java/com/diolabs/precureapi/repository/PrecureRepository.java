package com.diolabs.precureapi.repository;


import com.diolabs.precureapi.document.Precure;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PrecureRepository extends CrudRepository<Precure, String>{
}