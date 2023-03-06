package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Crusher;

public class CrushCan extends CommandBase {
    
    private final Crusher crusher;
    private final double speed;

    public CrushCan(Crusher crusher, double speed) {
        this.crusher = crusher;
        this.speed = speed;
        addRequirements(crusher);
    }

    @Override 
    public void initialize() {
    }

    @Override
    public void execute() {
        crusher.setMotor(speed);
    }    

    @Override
    public void end(boolean interrupted) {
        crusher.setMotor(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
