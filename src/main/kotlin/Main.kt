package online.ojaoma

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.net.http.HttpResponse


fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request : HttpRequest  = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()

    val response: HttpResponse<String> = client
        .send(request, BodyHandlers.ofString())

    val json = response.body().also {
        println(it)
    }

    val gson = Gson()
    val meuJogo = gson.fromJson(json, InfoJogo::class.java).also {
        println(it)
    }
}