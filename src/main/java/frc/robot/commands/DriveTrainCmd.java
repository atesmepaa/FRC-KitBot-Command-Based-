package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.Supplier;

public class DriveTrainCmd extends Command {

    private final DriveSubsystem driveSubsystem;
    private final Supplier<Double> speedFunction, turnFunction;

    public DriveTrainCmd(DriveSubsystem driveSubsystem, //
    Supplier<Double> turnFunction, Supplier<Double> speedFunction) {
        this.speedFunction = speedFunction;
        this.turnFunction = turnFunction;
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("DriveTrainCmd started!");
    }

    @Override
    public void execute() {
        double realTimeSpeed = speedFunction.get();
        double realTimeTurn = turnFunction.get();

        double left = realTimeSpeed + realTimeTurn;
        double right = realTimeSpeed - realTimeTurn;
        driveSubsystem.arcadeDrive(left, right);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("DriveTrainCmd finished!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
