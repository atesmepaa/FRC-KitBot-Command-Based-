// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArmCmd;
import frc.robot.commands.DriveTrainCmd;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final Joystick joystick = new Joystick(OIConstants.kDriverJoystickPort);


  public RobotContainer() {
    configureButtonBindings();

    driveSubsystem.setDefaultCommand(new DriveTrainCmd(driveSubsystem, //
    () -> joystick.getRawAxis(OIConstants.kArcadeDriveTurnAxis),
    () -> -joystick.getRawAxis(OIConstants.kArcadeDriveSpeedAxis)));
  }

  private void configureButtonBindings() {
    JoystickButton buttonA = new JoystickButton(joystick, 1);
    buttonA.whileTrue(new ArmCmd(armSubsystem, OIConstants.ANGLE_LOW));

    JoystickButton buttonB = new JoystickButton(joystick, 2);
    buttonB.whileTrue(new ArmCmd(armSubsystem, OIConstants.ANGLE_MID));

    JoystickButton buttonX = new JoystickButton(joystick, 3);
    buttonX.whileTrue(new ArmCmd(armSubsystem, OIConstants.ANGLE_HIGH));
  }
}
