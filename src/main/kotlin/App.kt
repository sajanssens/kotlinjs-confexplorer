import react.*
import react.dom.div
import react.dom.h1
import react.dom.h3

class App : RComponent<RProps, AppState>() {
    override fun RBuilder.render() {
        h1 { +"KotlinConf Explorer" }
        div {
            h3 { +"Videos to watch" }

            videoList {
                videos = state.unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }

            h3 { +"Videos watched" }
            videoList {
                videos = state.watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }
        }

        state.currentVideo?.let {
            videoPlayer {
                video = it
                unwatchedVideo = it in state.unwatchedVideos
                onWatchedButtonPressed = {
                    if (video in state.unwatchedVideos) {
                        setState {
                            unwatchedVideos -= video
                            watchedVideos += video
                        }
                    } else {
                        setState {
                            watchedVideos -= video
                            unwatchedVideos += video
                        }
                    }
                }
            }
        }
    }

    override fun AppState.init() {
        unwatchedVideos = listOf(
            Video(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
            Video(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
            Video(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
        )
        watchedVideos = listOf(
            Video(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
        )
    }
}

data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)

external interface AppState : RState {
    var currentVideo: Video?
    var unwatchedVideos: List<Video>
    var watchedVideos: List<Video>
}
