package com.alele.amphibians.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class defines an amphibian which includes a name, type, description and the image URL.
 */

@Serializable
data class Amphibians (
    val name: String,
    val type: String,
    val description: String,
    @SerialName(value = "img_src")
    val imgSrc: String
    )
