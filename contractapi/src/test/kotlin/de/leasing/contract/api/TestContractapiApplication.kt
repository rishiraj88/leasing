package de.leasing.contract.api

import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
	fromApplication<ContractapiApplication>().with(TestcontainersConfiguration::class).run(*args)
}
