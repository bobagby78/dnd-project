package org.launchcode.dndproject.models.data;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.launchcode.dndproject.models.BaseCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional//???- look it up
public interface BaseCharacterRepository extends CrudRepository<BaseCharacter, Integer> {
}
