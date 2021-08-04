package org.launchcode.dndproject.models.data;

import org.launchcode.dndproject.models.CharacterIdentity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional//???- look it up
public interface CharacterIdentityRepository extends CrudRepository<CharacterIdentity, Integer> {
}
