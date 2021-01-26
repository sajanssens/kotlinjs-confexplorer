import kotlinx.browser.document
import kotlinx.css.*
import react.RBuilder
import react.dom.*
import styled.css
import styled.styledDiv

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }

    // render(document.getElementById("root")) {
    //     // hard()
    //     dyna()
    // }
}

// data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)
//
// val unwatchedVideos = listOf(
//     Video(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
//     Video(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
//     Video(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
// )
//
// val watchedVideos = listOf(
//     Video(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
// )

private fun RBuilder.hard() {
    h1 {
        +"KotlinConf Explorer"
    }
    div {
        h3 {
            +"Videos to watch"
        }
        p {
            +"John Doe: Building and breaking things"
        }
        p {
            +"Jane Smith: The development process"
        }
        p {
            +"Matt Miller: The Web 7.0"
        }

        h3 {
            +"Videos watched"
        }
        p {
            +"Tom Jerry: Mouseless development"
        }
    }
    div {
        h3 {
            +"John Doe: Building and breaking things"
        }
        img {
            attrs {
                src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
            }
        }
    }
}

private fun RBuilder.dyna() {
    h1 { +"KotlinConf Explorer" }
    div {
        h3 { +"Videos to watch" }

        for (video in unwatchedVideos) {
            p { +"${video.speaker}: ${video.title}" }
        }

        h3 { +"Videos watched" }
        for (video in watchedVideos) {
            p { +"${video.speaker}: ${video.title}" }
        }
    }
    styledDiv {
        css {
            position = Position.absolute
            top = 10.px
            right = 10.px
        }
        h3 { +"John Doe: Building and breaking things" }
        img { attrs { src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder" } }
    }
}

val unwatchedVideos = listOf(
    Video(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
    Video(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
    Video(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
)

val watchedVideos = listOf(
    Video(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
)
