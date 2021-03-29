// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Mecanisme2;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoGroupCommand extends SequentialCommandGroup {

  //private Drivetrain m_drivetrain = new Drivetrain();
  //private Mecanisme2 m_mecanism = new Mecanisme2();
  /** Creates a new AutoGroupCommand. */
  public AutoGroupCommand(Drivetrain m_drivetrain, Mecanisme2 m_mecanism ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveCommand(-0.8, 0, m_drivetrain).withTimeout(2), new AutoRotationCommand(0.5, m_mecanism).withTimeout(2));
  
  }
}
