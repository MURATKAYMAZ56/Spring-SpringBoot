package repository;



public interface SkillRepository<Skill> extends CrudRepository {

	Object findAll();

	entity.Skill findOne(Long skillId);

}
