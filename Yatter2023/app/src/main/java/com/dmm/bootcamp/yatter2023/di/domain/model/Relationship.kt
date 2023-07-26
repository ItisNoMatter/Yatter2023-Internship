package com.dmm.bootcamp.yatter2023.di.domain.model

data class Relationship(
    val target: Username,
    val following: Boolean,
    val followedBy: Boolean
)
