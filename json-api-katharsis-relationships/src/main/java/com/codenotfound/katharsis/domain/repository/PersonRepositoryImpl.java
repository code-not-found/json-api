package com.codenotfound.katharsis.domain.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.codenotfound.katharsis.domain.model.Person;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class PersonRepositoryImpl extends ResourceRepositoryBase<Person, Long>
    implements PersonRepository {

  private Map<Long, Person> people = new HashMap<>();

  public PersonRepositoryImpl() {
    super(Person.class);
  }

  @Override
  public synchronized void delete(Long id) {
    people.remove(id);
  }

  @Override
  public synchronized <S extends Person> S save(S person) {
    people.put(person.getId(), person);
    return person;
  }

  @Override
  public synchronized ResourceList<Person> findAll(QuerySpec querySpec) {
    return querySpec.apply(people.values());
  }
}
