// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Mecanisme2;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Meca2ReposCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Mecanisme2 m_mecanisme;
  

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Meca2ReposCommand(Mecanisme2 mecanisme) {
    m_mecanisme = mecanisme;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_mecanisme);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   // System.out.println("in initialize");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_mecanisme.mettreAuRepos();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_mecanisme.mettreAuRepos();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
