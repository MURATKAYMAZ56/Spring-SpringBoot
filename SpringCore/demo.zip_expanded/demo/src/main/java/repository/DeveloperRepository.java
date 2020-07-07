package repository;

import entity.Developer;

public interface DeveloperRepository extends CrudRepository {

	Developer findOne(Long id);

	Object findAll();

	void save(Developer newDeveloper);

}
