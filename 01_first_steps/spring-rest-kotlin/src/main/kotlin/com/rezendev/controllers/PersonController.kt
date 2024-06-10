package com.rezendev.controllers

import com.rezendev.models.PersonModel
import com.rezendev.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll():List<PersonModel>{
        return personService.findAll()
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findById(@PathVariable(value = "id")id: Long):PersonModel{
        return personService.findById(id)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(@RequestBody person: PersonModel):PersonModel{
        return personService.create(person)
    }

    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun update(@RequestBody person: PersonModel):PersonModel{
        return personService.update(person)
    }

    @DeleteMapping(
        value = ["/{id}"]
    )
    fun delete(@PathVariable(value = "id")id: Long): ResponseEntity<*>{
        personService.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}