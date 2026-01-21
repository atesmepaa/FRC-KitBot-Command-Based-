package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCmd extends Command {

    private final ArmSubsystem armSubsystem;
    private final double targetAngle;

    public ArmCmd(ArmSubsystem armSubsystem, double targetAngle) {
        this.armSubsystem = armSubsystem;
        this.targetAngle = targetAngle;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        armSubsystem.setTargetAngle(targetAngle);
        System.out.println("ArmCmd started! Target: " + targetAngle);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("ArmCmd ended!");
    }
}