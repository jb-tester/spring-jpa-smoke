package com.mytests.spring.javajpaweb.teams;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TeamRepository extends MyBaseEntityRepository<ConcreteEntity> {

    List<ConcreteEntity> findAll();

    @Query("select e.title from #{#entityName} e where e.id >= :arg")
    List<String> customQueryWithSpEL(@Param("arg") int arg);



    @Query("select e.title from team e where e.id = :arg")
    List<String> customQueryWithHardcodedEntityName(@Param("arg") int arg);

    @Query(value="select * from foo.team where id = :arg", nativeQuery = true)
    List<ConcreteEntity> customNativeQuery(@Param("arg") int arg);
}
