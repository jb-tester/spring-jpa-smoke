package com.mytests.spring.javajpaweb.teams;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface MyBaseEntityRepository<T extends MyBaseEntity>
  extends CrudRepository<T, Long> {

  @Query("select e from #{#entityName} e where e.title like :arg")
  List<T> findByTitles(String arg);
}