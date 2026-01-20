// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

  private VictorSP leftMaster = new VictorSP(DriveConstants.kLeftMotorMasterPort);
  private VictorSP leftSlave = new VictorSP(DriveConstants.kLeftMotorSlavePort);
  private VictorSP rightMaster = new VictorSP(DriveConstants.kRightMotorMasterPort);
  private VictorSP rightSlave = new VictorSP(DriveConstants.kRightMotorSlavePort);

  private DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  public DriveSubsystem(){
    leftMaster.addFollower(leftSlave);
    rightMaster.addFollower(rightSlave);

    rightMaster.setInverted(true);
  }

  public void arcadeDrive(double speed, double rotation){
    drive.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}
