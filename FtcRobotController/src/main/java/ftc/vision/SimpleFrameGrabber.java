package ftc.vision;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceView;
import android.widget.TextView;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.Arrays;

public class SimpleFrameGrabber implements CameraBridgeViewBase.CvCameraViewListener2{

    private Mat frame;
    public int frameCount = 0;

    public SimpleFrameGrabber(CameraBridgeViewBase cameraBridgeViewBase, int frameWidthRequest, int frameHeightRequest) {
        cameraBridgeViewBase.setVisibility(SurfaceView.VISIBLE);

        cameraBridgeViewBase.setMinimumWidth(frameWidthRequest);
        cameraBridgeViewBase.setMinimumHeight(frameHeightRequest);
        cameraBridgeViewBase.setMaxFrameSize(frameWidthRequest, frameHeightRequest);
        cameraBridgeViewBase.setCvCameraViewListener(this);
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        frame = new Mat(height, width, CvType.CV_8UC4, new Scalar(0,0,0));
        ImageProcess.start();
    }

    @Override
    public void onCameraViewStopped() {
        ImageProcess.stop();
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        Mat frame = inputFrame.rgba();

        ImageProcess.setSourceImage(frame);
        if (ImageProcess.lastProcessed != null) {
            Imgproc.drawContours(frame, Arrays.asList(ImageProcess.lastProcessed), 0, new Scalar(0, 0, 255), 3); // draw the contour on the orignial image
            //paramters: image to draw on, the list of contours, the index of the contour we want to draw, the color to draw it in, the thickness of the line
            // I make the contour into a list because the drawContours function only accepts lists (very annoying)
            // The color is red (opencv lists colors as BGR)
        }

//        Mat f = new Mat();
//        ImageUtil.rotate(frame, f, 90);
        return frame;
    }

}
