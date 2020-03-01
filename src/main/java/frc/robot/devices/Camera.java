/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.devices;
import edu.wpi.cscore.UsbCamera;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobotBase;

/**
 * Add your docs here.
 */
public class Camera extends IterativeRobotBase implements Runnable {

    public Camera(double period) {
        super(period);
    }

    @Override
    public void run() {
         UsbCamera camera = CameraServer.getInstance().startAutomaticCapture("USB Camera",0);
         camera.setResolution(640, 480);
      
         CvSink cvSink = CameraServer.getInstance().getVideo();
         CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 720, 960);
      
         Mat source = new Mat();
         Mat output = new Mat();
      
         while(!Thread.interrupted()) {
            if (cvSink.grabFrame(source) == 0) {
                continue;
            }
            Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
            outputStream.putFrame(output);
        }
    }

    @Override
    public void startCompetition() {
  
    }

    @Override
    public void endCompetition() {

    }
}
