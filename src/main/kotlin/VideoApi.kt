interface VideoApi {

    suspend fun fetchVideo(id: Int): Video

    suspend fun fetchVideos(): List<Video>
}