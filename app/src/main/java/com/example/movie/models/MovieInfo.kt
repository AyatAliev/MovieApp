package com.example.movie.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieInfo(
    val adult: Boolean?,
    @Json(name = "backdrop_path")  val backdropPath: String?,
    @Json(name = "belongs_to_collection") val belongsToCollection: BelongsToCollection?,
    val budget: Int?,
    val genres: List<Genre>?,
    val homepage: String?,
    val id: Int?,
    @Json(name = "imdb_id") val imdbId: String?,
    @Json(name = "original_language") val originalLanguage: String?,
    @Json(name = "original_title") val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "production_companies") val productionCompanies: List<ProductionCompany>?,
    @Json(name = "production_countries") val productionCountries: List<ProductionCountry>?,
    val release_date: String?,
    val revenue: Int?,
    val runtime: Int?,
    @Json(name = "spoken_languages") val spokenLanguages: List<SpokenLanguage>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    @Json(name = "vote_average") val voteAverage: Double?,
    @Json(name = "vote_count") val voteCount: Int?
)

@JsonClass(generateAdapter = true)
data class Genre(
    val id: Int?,
    val name: String?
)

@JsonClass(generateAdapter = true)
data class BelongsToCollection(
    @Json(name = "backdrop_path") val backdropPath: Any?,
    val id: Int?,
    val name: String?,
    @Json(name = "poster_path") val posterPath: Any?
)

@JsonClass(generateAdapter = true)
data class ProductionCompany(
    val id: Int?,
    @Json(name = "logo_path") val logoPath: String?,
    val name: String?,
    @Json(name = "origin_country") val originCountry: String?
)

@JsonClass(generateAdapter = true)
data class ProductionCountry(
    @Json(name = "iso_3166_1") val iso31661: String?,
    val name: String?
)

@JsonClass(generateAdapter = true)
data class SpokenLanguage(
    @Json(name = "english_name") val englishName: String?,
    @Json(name = "iso_3166_1") val iso31661: String?,
    val name: String?
)