
import csstype.Display
import csstype.NamedColor
import csstype.Position
import csstype.px
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.button

external interface VideoPlayerProps : Props {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
}

val VideoPlayer = FC<VideoPlayerProps> {props ->
    ReactHTML.div {
        css {
            position = Position.absolute
            top = 10.px
            right = 10.px
        }
        EmailShareButton {
            url = props.video.videoUrl
            EmailIcon {
                size = 32
                round = true
            }
        }
        TelegramShareButton {
            url = props.video.videoUrl
            TelegramIcon {
                size = 32
                round = true
            }
        }
        ReactHTML.h3 {
            +"${props.video.speaker}: ${props.video.title}"
        }
        ReactPlayer {
            url = props.video.videoUrl
            controls = true
        }
    }
    button {
        css {
            display = Display.block
            backgroundColor = if (props.unwatchedVideo) NamedColor.lightgreen else NamedColor.red
        }
        onClick = {
            props.onWatchedButtonPressed(props.video)
        }

        if (props.unwatchedVideo) {
            +"Mark as watched"
        } else {
            +"Mark as unwatched"
        }
    }
}