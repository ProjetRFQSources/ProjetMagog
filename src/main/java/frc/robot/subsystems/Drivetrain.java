// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.playingwithfusion.CANVenom;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class Drivetrain extends SubsystemBase  {

  /** Cette classe permet de creer un objet Drivetrain avec un entrainement differentiel. */
  /** 
  * |_______|
  * | |   | |
  *   |   |
  * |_|___|_|
  * |       |
  */

  /**
   * Definition et declaration des moteurs et la gestion de ces derniers pour le BetaBots
   * Commenter ici mais a activer lorsque vous aurez des moteurs Venom
   */
   
  private final CANVenom m_leftMotor = new CANVenom(DriveConstants.kleftport); 
  private final CANVenom m_rightMotor = new CANVenom(DriveConstants.krightport);
  private final DifferentialDrive m_drivetrain = new DifferentialDrive(m_leftMotor, m_rightMotor);
  

 /**
  * Definition et declaration des 4 moteurs de votre base pilotable de pratique qui utilise des controleurs de 
  * moteur VictoSPX à commenter lorsque vous aurez des moteurs Venom pour la compétition BetaBots
  */

  /**
   * Pour chaque côté du robot, on déclare individuellement les moteurs avant et arrière
   * Ici le côté droit
   */
  //private final VictorSPX m_avantDroit = new VictorSPX(deviceNumber);
  //private final VictorSPX m_arriereDroit = new VictorSPX(deviceNumber);

  /**
   * On regroupe ensuite les deux moteurs de chaque côté du robot dans un objet SpeeControllerGroup
   * Ici le côté droit
   */
  //private SpeedControllerGroup m_groupeMoteursdroits = new SpeedControllerGroup(m_avantDroit, m_arriereDroit);

  /**
   * Pour chaque côté du robot, on déclare individuellement les moteurs avant et arrière
   * Ici le côté gauche
   */
  // private final VictorSPX m_avantGauche = new VictorSPX(deviceNumber);
  //private final VictorSPX m_arriereGauche = new VictorSPX(deviceNumber);

  /**
   * On regroupe ensuite les deux moteurs de chaque côté du robot dans un objet SpeeControllerGroup
   * Ici le côté gauche
   */
  //private SpeedControllerGroup m_groupeMoteursgauches = new SpeedControllerGroup(m_avantGauche, m_arriereGauche);

  /**
   * On regroupe finalement ces deux groupes de moteurs dans un objet DifferentialDrive qui 
   * implemente l'entraînement différentiel
   */

  //private final DifferentialDrive m_drivetrain = new DifferentialDrive(m_groupeMoteursgauches, m_groupeMoteursdroits);

  //Creation d'un objet Drivetrain 
  public Drivetrain() {
    super();

    // Pour affichage sur LiveWindow
    addChild("BasePilotable", m_drivetrain);
  }

  @Override
  public void periodic() { //every 20 ms
  }
  
  /**
   * Type de pilotage ArcadeDrive 
   * 
   * @param pavanceRecule pour avancer ou reculer [-1,1]
   * @param ptourne       pour tourner gauche ou droire [-1,1]
   */
  public void arcadeDrive(double pavanceRecule, double ptourne){
    m_drivetrain.arcadeDrive(pavanceRecule, pavanceRecule);
  }

}
