package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.math.controller.PIDController;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants.ArmConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

    private final VictorSPX armMotor = new VictorSPX(ArmConstants.kMotorPort);
    private final Encoder armEncoder = new Encoder(ArmConstants.kEncoderCA, ArmConstants.kEncoderCB);
    private final PIDController pidController = new PIDController(0.05, 0.0, 0.001);

    private double targetAngle = 0;

    public ArmSubsystem() {
        int PULSES_PER_REV = 1024;
        armEncoder.setDistancePerPulse(1.0 / PULSES_PER_REV);
    }

    public void setTargetAngle(double angle) {
        targetAngle = angle;
    }

    @Override
    public void periodic() {
        double currentAngle = armEncoder.getDistance() * 360;
        double output = pidController.calculate(currentAngle, targetAngle);
        armMotor.set(ControlMode.PercentOutput, clamp(output, -1.0, 1.0));
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}
