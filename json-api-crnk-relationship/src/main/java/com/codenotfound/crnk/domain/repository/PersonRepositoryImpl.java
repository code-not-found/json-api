package com.codenotfound.crnk.domain.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.codenotfound.crnk.domain.model.Person;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

@Component
public class PersonRepositoryImpl extends ResourceRepositoryBase<Person, Long>
    implements PersonRepository {

  private Map<Long, Person> people = new ConcurrentHashMap<>();

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
