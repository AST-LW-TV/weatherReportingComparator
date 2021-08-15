package utilities;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import org.monte.media.FormatKeys.MediaType;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecorder {

    private static ScreenRecorder screenRecorder;
    private static GraphicsConfiguration graphicsConfiguration;
    private static Rectangle captureSize;
    private static Dimension screenSize;
    private static int width;
    private static int height;
    private static File file;

    static {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        captureSize = new Rectangle(0, 0, width, height);
        graphicsConfiguration = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
    }

    public static void startRecording() {
        try {
            file = new File(ReadFilePaths.getFilePath("testVideosPath"));
            screenRecorder = new ScreenRecorder(graphicsConfiguration, captureSize,
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                            Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null, file);
            screenRecorder.start();
        } catch (IOException e) {
            e.printStackTrace(); // visit later for exceptions
        } catch (AWTException e) {
            e.printStackTrace(); // visit later for exceptions
        }
    }

    public static void stopRecording() {
        try {
            screenRecorder.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
