package frc.robot.Subsystems;

import edu.wpi.first.hal.PowerDistributionFaults;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DiagnosticsSubsystem extends SubsystemBase {
    /*
     * X-axis is front to back
     * Y-axis is side-to-side
     * Z-axis is up-to-down
     */
    BuiltInAccelerometer accel = new BuiltInAccelerometer();
    double grav = 9.80665;

    PowerDistribution pdp = new PowerDistribution();

    /**Turns on the Switchable Channel of a Power Distribution Panel */
    public Command switchOn() {
        return runOnce(() -> pdp.setSwitchableChannel(true));
    }

    /**Turns off the Switchable Channel of a Power Distribution Panel */
    public Command switchOff() {
        return runOnce(() -> pdp.setSwitchableChannel(false));
    }

    /**Gets the x-component of acceleration */
    public double xccel() {
        return accel.getX();
    }

    /**Gets the y-component of acceleration */
    public double yccel() {
        return accel.getY();
    }

    /**Gets the z-component of acceleration */
    public double zccel() {
        return accel.getZ();
    }


    /**Gets the voltage of a Power Distribution Panel,
     * Keep above 12.00 V at all times
    */
    public double voltage() {
        return pdp.getVoltage();
    }

    /**Gets the total current of a Power Distribution Panel */
    public double totalCurrent() {
        return pdp.getTotalCurrent();
    }

    /**Gets the total energy of a Power Distribution Panel */
    public double totalEnergy() {
        return pdp.getTotalEnergy();
    }

    /**Gets the total power of a Power Distribution Panel */
    public double totalPower() {
        return pdp.getTotalPower();
    }

    /**Gets the temperature of a Power Distribution Panel in Celsius */
    public double pdpTemp() {
        return pdp.getTemperature();
    }

    /**Gets the temperature of a Power Distribution Panel in Farenheit.  For Americans. */
    public double pdpTempF() {
        double pTemp = pdp.getTemperature();
        double pTempF = (pTemp * 9/5) + 32;
        return pTempF;
    }

    /**Gets the faults of a Power Distribution Panel */
    public PowerDistributionFaults faults() {
        return pdp.getFaults();
    }

    /**Is true if the robot is browning out */
    public boolean brownOut() {
        return voltage() < 12.00;
    }

    


     public void periodic() {
        //Displays information on the dashboard
        SmartDashboard.putNumber("Voltage", voltage());
        SmartDashboard.putBoolean("Brown Out?", brownOut());
     }
}
