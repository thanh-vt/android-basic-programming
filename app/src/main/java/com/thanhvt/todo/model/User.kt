package com.thanhvt.todo.model

data class User(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
)