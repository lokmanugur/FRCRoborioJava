/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain driveTrain;
  private final OI oi;
  /**
   * Creates a new TankDrive.
   *
   * @param driveTrain 
   */
  public TankDrive(DriveTrain driveTrain, OI oi) {
    this.driveTrain=driveTrain;
    this.oi = oi;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double y_speed=oi.getRawAxis(Constants.Y_AXIS_MOTOR_SPEED);
    double x_rotation=oi.getRawAxis(Constants.X_AXIS_MOTOR_ROTATION);
    double z_rotation=oi.getRawAxis(Constants.Z_AXIS_MOTOR_ROTATION);
    driveTrain.setRobotMotion(y_speed, x_rotation, z_rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
