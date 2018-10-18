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
    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        Mat frame = inputFrame.rgba();
        return processFrame(frame);
    }

    private Mat processFrame(Mat frame){
        frameCount++;

        Mat hsv = new Mat();
        Imgproc.cvtColor(frame, hsv, Imgproc.COLOR_RGB2HSV);
        int h = 22;
        int r = 8;
        Mat maskedImage = new Mat();
        ImageUtil.hsvInRange(hsv, new Scalar(h-r,0,0), new Scalar(h+r,255,255),maskedImage);

        Mat result = new Mat();
        if (maskedImage.channels() == 3) {
            Core.bitwise_and(frame, maskedImage, result);
        }
        return hsv;
    }
}
