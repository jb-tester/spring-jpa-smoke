package com.mytests.spring.javajpaweb.teams;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TeamRepository extends MyBaseEntityRepository<ConcreteEntity> {

    List<ConcreteEntity> findAll();

    // columns are not resolved - https://youtrack.jetbrains.com/issue/IDEA-366482
    @Query("select title from #{#entityName}  where id >= :arg")
    List<String> customQueryWithSpEL(@Param("arg") int arg);

    @Query("select e.title from #{#entityName} e where e.id >= :arg")
    List<String> customQueryWithSpELWthAlias(@Param("arg") int arg);

    @Query("select title from team  where id = :arg")
    List<String> customQueryWithHardcodedEntityName(@Param("arg") int arg);

    @Query("""
            select e.title
             from team e
             where e.id = :arg""")
    List<String> customQueryWithHardcodedEntityNameWithAlias(@Param("arg") int arg);

    @Query(value="select * from foo.team where size > :arg", nativeQuery = true)
    List<ConcreteEntity> customNativeQuery(@Param("arg") int arg);

    @NativeQuery(value="select * from foo.team where size = :arg")
    List<ConcreteEntity> customNativeQueryAnnotation(@Param("arg") int arg);


}
