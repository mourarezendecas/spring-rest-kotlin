package com.rezendev.services

import com.rezendev.exceptions.ResourceNotFoundException
import com.rezendev.models.PersonModel
import com.rezendev.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonModel>{
        logger.info("Procrurando por todas as pessoas.")

        return repository.findAll()
    }

    fun findById(id: Long): PersonModel{
        logger.info("Procrurando uma pessoa.")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Nao foi encontrado usuario para esse ID.") }
    }

    fun create(person: PersonModel): PersonModel{
        logger.info("Criando uma pessoa: ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: PersonModel): PersonModel{
        logger.info("Atualizando a pessoa: ${person.firstName}")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("Nao foi encontrado usuario para esse ID.") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long): PersonModel{
        logger.info("Deletamdp a pessoa com id: ${id}")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Nao foi encontrado usuario para esse ID.") }
        repository.delete(entity)
        return entity
    }
}