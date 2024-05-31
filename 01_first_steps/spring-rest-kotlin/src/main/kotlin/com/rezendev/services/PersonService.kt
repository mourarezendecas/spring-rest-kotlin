package com.rezendev.services

import com.rezendev.models.PersonModel
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonModel>{
        logger.info("Procrurando por todas as pessoas.")

        val persons: MutableList<PersonModel> = ArrayList()

        for(i in 0..7){
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    fun findById(id: Long): PersonModel{
        logger.info("Procrurando uma pessoa.")
        val person = PersonModel()
        person.id = counter.incrementAndGet()
        person.firstName = "Gabriel"
        person.lastName = "Rezende"
        person.address = "Goiania - Goias"
        person.gender = "Male"

        return person
    }

    fun create(person: PersonModel): PersonModel{
        //Logica vai aqui
        return person
    }

    fun update(person: PersonModel): PersonModel{
        //Logica vai aqui
        return person
    }

    fun delete(id: Long): PersonModel{
        //Logica vai aqui
        val person = PersonModel ()
        return person
    }

    private fun mockPerson(i: Int): PersonModel {
        val person = PersonModel()
        person.id = counter.incrementAndGet()
        person.firstName = "Person name $i"
        person.lastName = "Person last name $i"
        person.address = "Person address $i"
        person.gender = "Person gender $i"

        return person
    }
}