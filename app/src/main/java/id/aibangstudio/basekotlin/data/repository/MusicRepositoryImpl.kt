package id.aibangstudio.basekotlin.data.repository

import id.aibangstudio.basekotlin.data.remote.response.SearchMusicResultResponse
import id.aibangstudio.basekotlin.data.remote.service.MusicService
import io.reactivex.Single

class MusicRepositoryImpl(val musicService: MusicService) {

    fun searchMusic(query: String): Single<SearchMusicResultResponse> {
        return musicService.searchMusic(query)
    }

}