package org.launchcode.models.data;

import org.launchcode.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// CrudRepository provides generic CRUD operation on a repository for a specific type.
@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {
}
