package com.lynas.repo

import com.lynas.model.Person
import org.springframework.data.neo4j.repository.GraphRepository

/**
 * Created by sazzad on 11/24/16
 */

interface PersonRepository : GraphRepository<Person>