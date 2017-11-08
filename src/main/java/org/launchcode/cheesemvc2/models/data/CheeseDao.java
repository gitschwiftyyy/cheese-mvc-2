package org.launchcode.cheesemvc2.models.data;

import org.launchcode.cheesemvc2.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by schwifty on 11/7/17.
 */
@Repository
@Transactional
public interface CheeseDao extends CrudRepository<Cheese, Integer> {
}
