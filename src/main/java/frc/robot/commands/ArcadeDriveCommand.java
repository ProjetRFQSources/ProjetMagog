// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArcadeDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drivetrain;
  private final DoubleSupplier m_AvanceRecule;
  private final DoubleSupplier m_Tourne;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDriveCommand(DoubleSupplier avanceRecule, DoubleSupplier tourne, Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    m_AvanceRecule = avanceRecule;
    m_Tourne = tourne;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("in initialize");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_AvanceRecule.getAsDouble(), m_Tourne.getAsDouble());
  }

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }

}
