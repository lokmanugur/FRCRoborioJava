/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.devices;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Add your docs here.
 */
public class UltrasonicSensor {
    private final AnalogInput motorUltrasonic = new AnalogInput(0);


    private static final double kHoldDistance = 12.0;

    private static final double kValueToCM= 0.3175;
    
    private static final double kValueToInches = 0.125;
    
    public double getDistancIneCM(){
        return motorUltrasonic.getValue()*kValueToCM;
    }

    public double getDistanceInInch(){
        return motorUltrasonic.getValue()*kValueToInches;
    }

    public double getRobotAway(){
        return kHoldDistance;
    }
}
