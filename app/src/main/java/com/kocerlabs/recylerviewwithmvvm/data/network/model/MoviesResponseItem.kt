package com.kocerlabs.recylerviewwithmvvm.data.network.model


import com.google.gson.annotations.SerializedName




data class MoviesResponseItem (

    @SerializedName("id"         ) var id         : Int?              = null,
    @SerializedName("title"      ) var title      : String?           = null,
    @SerializedName("year"       ) var year       : Int?              = null,
    @SerializedName("genre"      ) var genre      : ArrayList<String> = arrayListOf(),
    @SerializedName("rating"     ) var rating     : Double?           = null,
    @SerializedName("director"   ) var director   : String?           = null,
    @SerializedName("actors"     ) var actors     : ArrayList<String> = arrayListOf(),
    @SerializedName("plot"       ) var plot       : String?           = null,
    @SerializedName("poster"     ) var poster     : String?           = null,
    @SerializedName("trailer"    ) var trailer    : String?           = null,
    @SerializedName("runtime"    ) var runtime    : Int?              = null,
    @SerializedName("awards"     ) var awards     : String?           = null,
    @SerializedName("country"    ) var country    : String?           = null,
    @SerializedName("language"   ) var language   : String?           = null,
    @SerializedName("boxOffice"  ) var boxOffice  : String?           = null,
    @SerializedName("production" ) var production : String?           = null,
    @SerializedName("website"    ) var website    : String?           = null

)