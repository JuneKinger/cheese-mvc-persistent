package org.launchcode.models.data;

import org.launchcode.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// interface needed so instances of this class can be stored in the database
@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {
}
