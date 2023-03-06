package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Crusher extends SubsystemBase {
    
    private final WPI_TalonSRX crushMotor = new WPI_TalonSRX(Constants.kCrusherMotor);

    public Crusher() {
    }

    public void setMotor(double speed) {
        crushMotor.set(speed);
    }

}
