package com.lynas.controller

import com.lynas.model.Person
import com.lynas.repo.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
* Created by lynas on 11/24/2016
*/

@Controller
class RootController @Autowired constructor(val personRepository: PersonRepository){

    @RequestMapping("/")
    fun root():String {

        return "home"
    }


    @RequestMapping("/repo")
    fun repo():String {
        val person1 = Person().apply {
            firstName = "Sazzad"
            lastName = "Islam"
        }
        val person3 = Person().apply {
            firstName = "Shohag"
            lastName = "Akter"
        }
        val person2 = Person().apply {
            firstName = "Maruf"
            lastName = "Hossain"
        }

        //personRepository.deleteAll()
        personRepository.save(person1)
        personRepository.save(person2)
        personRepository.save(person3)

        println(personRepository.findAll().toString())
        return "home"
    }
}