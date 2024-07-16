package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsytem extends SubsystemBase {
    
    VictorSP intakeMotor1 = new VictorSP(IntakeConstants.kIntakePort1);
    VictorSP intakeMotor2 = new VictorSP(IntakeConstants.kIntakePort2);

    public IntakeSubsytem() {
        intakeMotor1.setInverted(false);
        intakeMotor2.setInverted(false);
    }

    public void intake(double speed) {
        intakeMotor1.set(-speed);
        intakeMotor2.set(speed);
    }

    public void stopIntake() {
        intakeMotor1.stopMotor();
        intakeMotor2.stopMotor();
    }
}
