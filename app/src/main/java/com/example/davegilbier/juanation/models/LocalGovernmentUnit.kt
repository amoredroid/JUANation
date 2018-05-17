package com.example.davegilbier.juanation.models

data class LocalGovernmentUnit(

        var name: String,
        var calamityPic: Int,
        var lguLogo: Int,
        var calamityHeadline: String,
        var barangayAffected: String,
        var postInfo: String,
        var calamityNeeds: Array<String>,
        var datePosted: String
)