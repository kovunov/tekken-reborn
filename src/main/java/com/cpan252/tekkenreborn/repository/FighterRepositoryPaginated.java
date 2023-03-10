package com.cpan252.tekkenreborn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cpan252.tekkenreborn.model.Fighter;

//It will be an interface that defines operations with the fighter
//table in the database
//This interface will extend PagingAndSortingRepository, which will allow us to retrieve fighters in pages
@Repository
public interface FighterRepositoryPaginated extends PagingAndSortingRepository<Fighter, Long> {
}
