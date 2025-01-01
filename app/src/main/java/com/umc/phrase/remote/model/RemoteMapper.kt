package com.umc.phrase.remote.model

interface RemoteMapper<DataModel> {
    fun toData(): DataModel
}