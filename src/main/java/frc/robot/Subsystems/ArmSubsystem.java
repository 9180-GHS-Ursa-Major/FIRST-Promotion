package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    
    private final CANSparkMax armMotor1 = new CANSparkMax(ArmConstants.kArmPort1, MotorType.kBrushless);
    private final CANSparkMax armMotor2 = new CANSparkMax(ArmConstants.kArmPort2, MotorType.kBrushless);

    public ArmSubsystem() {
        armMotor1.setInverted(false);
        armMotor2.setInverted(true);
        armMotor2.follow(armMotor1, true);
    }

    public void armControl(double speed) {
        armMotor1.set(0.5 * (speed));
    }

    public void armStop() {
        armMotor1.stopMotor();
        armMotor2.stopMotor();
    }
}
