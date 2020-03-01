/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.devices;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * Add your docs here.
 */
public class Gyro {
    
 private  ADXRS450_Gyro gyro;
 private double lastAngle=0;

 public Gyro(){
    gyro = new ADXRS450_Gyro();
    gyro.calibrate();
    gyro.reset();
    lastAngle=Math.floor(gyro.getAngle());
 }

 public boolean getGoStright(double angle){
    if(Math.floor(angle)==lastAngle){
        gyro.reset();
        lastAngle=Math.floor(gyro.getAngle());
        return true;
    }
    else
        return false;
 }

}
