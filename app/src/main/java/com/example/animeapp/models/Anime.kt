package com.example.animeapp.models

import com.google.gson.annotations.SerializedName

//data class Anime(
//    val data : Data
//)

data class Anime(
    val id: String,
    val type: String,
    val links: DataLinks,
    val attributes: Attributes,
    val relationships: Map<String, Relationship>
)

data class Attributes(
    val createdAt: String,
    val updatedAt: String,
    val slug: String,
    val synopsis: String,
    val description: String,
    val coverImageTopOffset: Long,
    val titles: Titles,
    val canonicalTitle: String,
    val abbreviatedTitles: List<String>,
    val averageRating: String,
    val ratingFrequencies: Map<String, String>,
    val userCount: Long,
    val favoritesCount: Long,
    val startDate: String,
    val endDate: String,
    val nextRelease: Any? = null,
    val popularityRank: Long,
    val ratingRank: Long,
    val ageRating: String,
    val ageRatingGuide: String,
    val subtype: String,
    val status: String,
    val tba: Any? = null,
    val posterImage: PosterImage,
    val coverImage: CoverImage,
    val episodeCount: Long,
    val episodeLength: Long,
    val totalLength: Long,

    @SerializedName("youtubeVideoId")
    val youtubeVideoID: String,
    val showType: String,
    val nsfw: Boolean
)

data class CoverImage(
    val tiny: String,
    val large: String,
    val small: String,
    val original: String,
    val meta: Meta
)

data class Meta(
    val dimensions: Dimensions
)

data class Dimensions(
    val tiny: Large,
    val large: Large,
    val small: Large,
    val medium: Large? = null
)

data class Large(
    val width: Long,
    val height: Long
)

data class PosterImage(
    val tiny: String,
    val large: String,
    val small: String,
    val medium: String,
    val original: String,
    val meta: Meta
)

data class Titles(
    val en: String,

    @SerializedName("en_jp")
    val enJp: String,

    @SerializedName("ja_jp")
    val jaJp: String
)

data class DataLinks(
    val self: String
)

data class Relationship(
    val links: RelationshipLinks
)

data class RelationshipLinks(
    val self: String,
    val related: String
)

