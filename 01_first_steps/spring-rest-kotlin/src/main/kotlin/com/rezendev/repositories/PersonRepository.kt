package com.rezendev.repositories

import com.rezendev.models.PersonModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<PersonModel, Long?>