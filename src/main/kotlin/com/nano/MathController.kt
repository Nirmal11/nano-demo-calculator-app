package com.nano

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated

@Controller("/calculator")
@Validated
class MathController {

    @Get("/greeting")
    fun greeting(): HttpResponse<String> {
        return HttpResponse.ok("Hello world!")
    }

    @Post("/add", produces = [MediaType.APPLICATION_JSON])
    fun add(numbers: Numbers): MutableHttpResponse<Result> {
        return HttpResponse.ok(Result(numbers.first + numbers.second))
    }

    @Post("/subtract", produces = [MediaType.APPLICATION_JSON])
    fun subtract(numbers: Numbers): HttpResponse<Result> {
        return HttpResponse.ok(Result(numbers.first - numbers.second))
    }
}
