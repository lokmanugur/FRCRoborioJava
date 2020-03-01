/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private VictorSP victorRight = new VictorSP(Constants.RIGHT_MOTOR_1_PORT);
  private VictorSP victorLeft = new VictorSP(Constants.LEFT_MOTOR_1_PORT);


  private SpeedControllerGroup leftMotor = new SpeedControllerGroup(victorLeft);
  private SpeedControllerGroup rightMotor = new SpeedControllerGroup(victorRight);


  private DifferentialDrive differentialDrive = new DifferentialDrive(leftMotor, rightMotor);


  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
  /**
   * 
   * @param x_rotation the robot's rotation along X axis [1.0, -1.0] Farword positive.
   * @param y_speed The robot's speed along Y axis [1.0, -1.0] Clockise is positive. 
   * @param z_rotation The robot's rotation along z axis [1.0, -1.0] Clockise is positive. 
   */
  public void setRobotMotion(double y_speed, double x_rotation,double z_rotation){
    differentialDrive.arcadeDrive(y_speed, x_rotation);
    differentialDrive.arcadeDrive(y_speed, z_rotation);
  }
}
