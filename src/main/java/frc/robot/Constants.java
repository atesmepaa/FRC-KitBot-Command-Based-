// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

  public static final class DriveConstants {
    public static final int kLeftMotorMasterPort = 0;
    public static final int kRightMotorMasterPort = 1;
    public static final int kLeftMotorSlavePort = 2;
    public static final int kRightMotorSlavePort = 3;
  }

  public static final class ArmConstants {
    public static final int kArmMotorPort = 4;
    public static final double kOpenSpeed = -1;
    public static final double kCloseSpeed = 1;
    public static final double kEncoderOffset = 0.0;
    public static final int kEncoderCA = 0;
    public static final int kEncoderCB = 1;
    public static final double kMaxLimit = 0.4;
    public static final double kMinLimit = 0.0;
  }

  public static class OIConstants {
    public static final int kDriverJoystickPort = 0;
    public static final int kArcadeDriveSpeedAxis = 1;
    public static final int kArcadeDriveTurnAxis = 3;
    public static final int kArmCloseButtonIdx = 5;
    public static final double ANGLE_LOW = 0;
    public static final double ANGLE_HIGH = 70;
  }
}
