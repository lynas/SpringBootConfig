package com.lynas.model

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity

/**
 * Created by sazzad on 11/24/16
 */
@NodeEntity
class Person(){

    @GraphId
    var id: Long? = null
    var firstName: String? = null
    var lastName: String? = null


    override fun toString(): String {
        return "Person(id=$id, firstName=$firstName, lastName=$lastName)"
    }


}