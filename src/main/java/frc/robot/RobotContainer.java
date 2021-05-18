// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.IOConstants;
import frc.robot.Constants.PneumatiqueConstants;
import frc.robot.commands.AntiHoraireCommand;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.AutoGroupCommand;
import frc.robot.commands.AutoRotationCommand;
//import frc.robot.commands.AutoCommand;
import frc.robot.commands.ExtensionCommand;
import frc.robot.commands.ExtensionCommand2;
import frc.robot.commands.ManuelCommand;
import frc.robot.commands.Meca2ReposCommand;
import frc.robot.commands.RetractionCommand;
import frc.robot.commands.RetractionCommand2;
import frc.robot.commands.SensHoraireCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Mecanisme2;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Mecanisme2 m_mecanisme2 = new Mecanisme2();

  //Declaration et definition de la manette
  private final XboxController m_pilot = new XboxController(IOConstants.KmanettePort);

  //Declaration et definition du compressor
  private final Compressor m_compressor = new Compressor(PneumatiqueConstants.kcompressor);
  //m_compressor.start();
  // private final ExampleCommand m_autoCommand = new
  // ExampleCommand(m_exampleSubsystem);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    //activation du compresseurs
    m_compressor.start();
    
    //configuration des commandes par defaut
    setDefaultCommands();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

   //Definition des commandes par default de chaque sous-systeme
  private void setDefaultCommands() {
    m_drivetrain.setDefaultCommand(new ArcadeDriveCommand(
      ()->m_pilot.getRawAxis(1), ()->m_pilot.getRawAxis(4), m_drivetrain)
      );
    m_mecanisme2.setDefaultCommand(new ManuelCommand(m_pilot.getRawAxis(5), m_mecanisme2));

    // Configure de la correspondance entre les boutons et les commandes
    configureButtonBindings();
    // Affichage du sous-systeme en fonction au Shuffleboard
    //
    SmartDashboard.putData(m_drivetrain);
  }

  // Correspondance entre les boutons de la manette et les commandes
  private void configureButtonBindings() {
    //Generer les boutons ici
    //final JoystickButton antiHoraire = new JoystickButton(m_pilot, 1);


   //connecter les boutons aux commandes ici
   new JoystickButton(m_pilot, 3).whileHeld(new AntiHoraireCommand(m_mecanisme2));
   new JoystickButton(m_pilot, 4).whileHeld(new SensHoraireCommand(m_mecanisme2));

   new JoystickButton(m_pilot,1).whenPressed(new ExtensionCommand(m_mecanisme2));
   new JoystickButton(m_pilot,2).whenPressed(new RetractionCommand(m_mecanisme2));
   //new JoystickButton(m_pilot,3).whenPressed(new RetractionCommand2(m_mecanisme2));
   //new JoystickButton(m_pilot,4).whenPressed(new ExtensionCommand2(m_mecanisme2));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return new AutoCommand(m_drivetrain, m_mecanisme2).andThen(new SensHoraireCommand(m_mecanisme2).withTimeout(1));
    return new AutoGroupCommand(m_drivetrain, m_mecanisme2);
    //addSequential(new AutoDriveCommand(2, 0.5, 0, m_drivetrain));
    //addSequential(new AutoRotationCommand(2, -0.7, m_mecanisme2));
    //return new AutoRotationCommand(2, -0.7, m_mecanisme2).withTimeout(2).andThen(new AutoDriveCommand(2, -0.5, 0, m_drivetrain));
    
  }
}
